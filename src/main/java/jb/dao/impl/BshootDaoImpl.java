package jb.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jb.dao.BshootDaoI;
import jb.model.Tbshoot;
import jb.util.PathUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BshootDaoImpl extends BaseDaoImpl<Tbshoot> implements BshootDaoI {
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String,Object>> executeNearby(final int page, final int rows,final double lgx,final double lgy) {
		
		List<Map<String,Object>> result = jdbcTemplate.execute(new CallableStatementCreator() {   
	        public CallableStatement createCallableStatement(Connection con) throws SQLException {   
	        	String centStr = "POINT("+lgx+" "+lgy+")";
	            String storedProc = "{call bshootnearby (?,?,?)}";// 调用的sql   
	            CallableStatement cs = con.prepareCall(storedProc);   
	            cs.setString(1, centStr);// 设置输入参数的值   
	            cs.setInt(2, (page-1)*rows);
	            cs.setInt(3, rows);
	            return cs;   
	         }   
	      },  new CallableStatementCallback() {   
		        public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {   
		            cs.execute();   
		            ResultSet rs = cs.getResultSet();  
		            ResultSetMetaData rsmd = rs.getMetaData();
		            Map<String,Object>  temp = null;
		            List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		            String key = null;
		            while(rs.next()){
		            	temp = new HashMap<String,Object>();
		            	for(int i =1;i<=rsmd.getColumnCount();i++){
		            		key = rsmd.getColumnName(i);
		            		temp.put(key, rs.getObject(i));
		            	}
		            	
		            	temp.put("bs_stream", PathUtil.getBshootPath((String)temp.get("bs_stream")));
		            	temp.put("bs_icon", PathUtil.getBshootPath((String)temp.get("bs_icon")));
		            	result.add(temp);
		            }
		            return result;// 获取输出参数的值   
		        } } );
		return result;
	}

}
