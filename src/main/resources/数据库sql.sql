CREATE TABLE `bshoot` (
  `id` varchar(36) NOT NULL,
  `bs_title` varchar(256) NOT NULL COMMENT '标题',
  `bs_topic` varchar(64) DEFAULT NULL COMMENT '主题',
  `bs_icon` varchar(256) DEFAULT NULL COMMENT 'icon',
  `bs_stream` varchar(256) DEFAULT NULL COMMENT '视频文件',
  `bs_collect` int(10) DEFAULT NULL COMMENT '收藏数',
  `bs_praise` int(10) DEFAULT NULL COMMENT '赞数',
  `bs_type` varchar(4) DEFAULT NULL COMMENT '类别',
  `bs_comment` varchar(10) DEFAULT NULL COMMENT '评论数',
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户ID',
  `bs_description` varchar(512) DEFAULT NULL COMMENT '描述',
  `bs_remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_person` varchar(36) DEFAULT NULL COMMENT '创建人',
  `update_person` varchar(36) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bshoot_collect` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户ID',
  `bshoot_id` varchar(36) DEFAULT NULL COMMENT '视频',
  `collect_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bshoot_praise` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户ID',
  `bshoot_id` varchar(36) DEFAULT NULL COMMENT '视频',
  `praise_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bshoot_comment` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户ID',
  `bshoot_id` varchar(36) DEFAULT NULL COMMENT '视频',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '父节点',
  `bs_comment_text` varchar(256) DEFAULT NULL COMMENT '评论内容',
  `comment_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_attention` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '关注人',
  `att_user_id` varchar(36) DEFAULT NULL COMMENT '被关注人',
  `attention_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_message` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户ID',
  `um_type` varchar(4) DEFAULT NULL COMMENT '消息类型',
  `um_message` varchar(512) DEFAULT NULL COMMENT '消息',
  `um_remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_person` varchar(36) DEFAULT NULL COMMENT '创建人',
  `update_person` varchar(36) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;