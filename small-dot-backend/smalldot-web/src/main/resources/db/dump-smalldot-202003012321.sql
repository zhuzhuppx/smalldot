
DROP TABLE IF EXISTS `t_soft_category`;
DROP TABLE IF EXISTS `t_soft_data`;
DROP TABLE IF EXISTS `t_soft_img`;
-- smalldot.t_soft_category definition

CREATE TABLE `t_soft_category` (
  `REVISION` varchar(64) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `id` varchar(64) NOT NULL COMMENT 'id',
  `category_name` varchar(32) DEFAULT NULL COMMENT 'category_name',
  `category_desc` varchar(512) DEFAULT NULL COMMENT 'category_desc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='类别表 ';


-- smalldot.t_soft_data definition

CREATE TABLE `t_soft_data` (
  `REVISION` varchar(64) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `ID` varchar(64) NOT NULL COMMENT 'ID',
  `soft_name` varchar(32) DEFAULT NULL COMMENT 'soft_name',
  `soft_desc` varchar(512) DEFAULT NULL COMMENT 'soft_desc',
  `website` varchar(3072) DEFAULT NULL COMMENT 'website',
  `url` varchar(3072) DEFAULT NULL COMMENT 'url',
  `icon` varchar(3072) DEFAULT NULL COMMENT 'icon',
  `category_id` varchar(64) DEFAULT NULL COMMENT 'category_id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_soft_data 软件信息表';


-- smalldot.t_soft_img definition

CREATE TABLE `t_soft_img` (
  `REVISION` varchar(64) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `id` varchar(64) NOT NULL COMMENT 'id',
  `img_url` varchar(3072) DEFAULT NULL COMMENT 'img_url',
  `soft_id` varchar(64) DEFAULT NULL COMMENT 'soft_id',
  `img_desc` varchar(512) DEFAULT NULL COMMENT 'img_desc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_soft_img 软件图片表';