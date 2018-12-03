USE `appoint`;


DROP TABLE IF EXISTS `t_appoint_setting`;

CREATE TABLE `t_appoint_setting` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `time_frame` varchar(64) NOT NULL,
  `doctor_id` bigint(11) NOT NULL,
  `user_num` int(4) NOT NULL COMMENT '放号量',
  `surplus_num` int(4) NOT NULL COMMENT '剩余号数量',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0 禁止  1 可用',
  `update_time` datetime NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_appointment`;

CREATE TABLE `t_appointment` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `depart_id` bigint(11) NOT NULL,
  `doctor_id` bigint(11) NOT NULL,
  `appoint_date` date NOT NULL COMMENT '预约日期',
  `appoint_time` varchar(32) NOT NULL COMMENT '预约时间段',
  `user_id` bigint(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0 取消预约  1 预约成功 2 已销号',
  `remark` varchar(1024) DEFAULT NULL COMMENT '病情简述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `depart_name` varchar(64) NOT NULL,
  `depart_remark` varchar(1024) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '1 启用 0 冻结  默认 0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_doctor`;

CREATE TABLE `t_doctor` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(64) NOT NULL,
  `professional` varchar(32) DEFAULT NULL,
  `doctor_bref` varchar(1024) DEFAULT NULL,
  `doctor_img` varchar(127) DEFAULT NULL,
  `doctor_age` int(4) DEFAULT NULL,
  `doctor_sex` int(1) DEFAULT NULL COMMENT '0 女 1 男',
  `doctor_phone` varchar(16) DEFAULT NULL,
  `depart_id` bigint(11) NOT NULL COMMENT '科室表主键',
  `status` int(1) DEFAULT NULL COMMENT '0 休息  1 出诊',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL,
  `user_day` varchar(32) DEFAULT NULL COMMENT '出生年月日 格式：1990-12-27',
  `user_age` int(4) DEFAULT NULL COMMENT '用户年龄 自动计算得出',
  `user_sex` int(1) DEFAULT NULL,
  `user_phone` varchar(16) NOT NULL,
  `open_id` varchar(64) NOT NULL,
  `update_time` datetime NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

