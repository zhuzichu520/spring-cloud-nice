CREATE database if NOT EXISTS `nice_config` default character set utf8mb4 collate utf8mb4_general_ci;
USE `nice_config`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

/******************************************/
/*   数据库全名 = nice_config   */
/*   表名称 = sys_admin   */
/******************************************/
CREATE TABLE `sys_admin` (
                               `id` bigint(20) NOT NULL COMMENT 'id',
                               `username` varchar(50) NOT NULL COMMENT '用户名',
                               `password` varchar(500) NOT NULL COMMENT 'md5密码',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统管理员表';


INSERT INTO sys_admin (id, username, password) VALUES ('1527868114097377280', 'admin', '21232f297a57a5a743894a0e4a801fc3');
