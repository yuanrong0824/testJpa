/*
  当前页，外键约束解除
 */
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `t_user`;

create table `t_user` (
  `t_id` int(11) not null AUTO_INCREMENT COMMENT '编号',
  `t_name` varchar(30) default  null COMMENT '名称',
  `t_age` int(10) default null COMMENT '年龄',
  `t_address` varchar(100) default null COMMENT '家庭住址',
  primary key (`t_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 default CHARSET=latin1



/**

SET FOREIGN_KEY_CHECKS=0;
- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `t_name` varchar(30) DEFAULT NULL COMMENT '名称',
  `t_age` int(10) DEFAULT NULL COMMENT '年龄',
  `t_address` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  PRIMARY KEY (`t_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

 */
