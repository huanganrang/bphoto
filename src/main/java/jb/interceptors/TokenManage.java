package jb.interceptors;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import jb.absx.UUID;
import jb.pageModel.SessionInfo;

public class TokenManage {
	
	public static String TOKEN_FIELD = "tokenId";
	
	private ConcurrentHashMap<String, TokenWrap> tokenMap = new ConcurrentHashMap<String, TokenWrap>();
	
	/**
	 * 数据源回收，空闲期
	 */
	private long freeTime = 1000*60*60*24;
	
		
	
	public void init(){
		new Thread("token 回收"){
			public void run(){
				while(true){
					try {
						sleep(10*1000);
						try {
							collection();
						} catch (Exception e) {
							e.printStackTrace();
						}						
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		}.start();
	}
	
	public boolean validToken(String tid){
		return tokenMap.get(tid)==null?false:true;
	}
	
	public String getName(String tid){
		TokenWrap token = tokenMap.get(tid);
		String name = null;
		if(token!=null){
			name = token.getName(); 
		}
		return name;
	}
	
	public String getUid(String tid){
		TokenWrap token = tokenMap.get(tid);
		String uid = null;
		if(token!=null){
			uid = token.getUid(); 
		}
		return uid;
	}
	
	public SessionInfo getSessionInfo(HttpServletRequest request){
		String tokenId = request.getParameter(TokenManage.TOKEN_FIELD);	
		TokenWrap token = tokenMap.get(tokenId);
		if(token == null) return null;
		SessionInfo s = new SessionInfo();		
		s.setId(token.getUid());
		s.setName(token.getName());
		return s;		
	}
	
	
	public String buildToken(String uid,String name){
		String tokenId = UUID.uuid();
		TokenWrap wrap = new TokenWrap(tokenId,uid,name);
		wrap.retime();
		tokenMap.putIfAbsent(tokenId, wrap);
		return tokenId;
	}
	class TokenWrap{
		private String tokenId;
		private String name;
		private String uid;
		private long ctime;//上一次使用时间
		public TokenWrap(String tokenId,String uid,String name){
			this.tokenId = tokenId;
			this.uid = uid;
			this.name = name;
		}
		public void retime(){
			ctime = System.currentTimeMillis();
		}				
		public String getTokenId() {
			return tokenId;
		}
		public long getCtime() {
			return ctime;
		}
		public String getName() {
			return name;
		}
		public String getUid() {
			return uid;
		}
		
		
	}
	
	/**
	 * 回收空闲数据源
	 */
	private void collection(){
		synchronized (TokenManage.class) {
			long ntime = System.currentTimeMillis();
			Iterator<String> iter = tokenMap.keySet().iterator();
			String key = null;
			TokenWrap ds = null;
			while (iter.hasNext()) {
				key = iter.next();
				ds = tokenMap.get(key);
				if (ds != null) {
					if (ntime - ds.getCtime() > freeTime) {
						tokenMap.remove(key);
						iter.remove();
					}
				}
			}
		}
	}
}
