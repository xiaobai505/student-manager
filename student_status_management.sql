/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-2ze7hrkqw885t3696mo.mysql.rds.aliyuncs.com:3306
 Source Schema         : student_status_management

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 22/12/2022 14:46:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `graduate` int(2) unsigned zerofill DEFAULT NULL COMMENT '获得的学分',
  `course_teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程老师',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `time_table` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '每周上课时间',
  `stock` int(11) NOT NULL COMMENT '库存（剩余座位数量）',
  `sale` int(11) NOT NULL DEFAULT '0' COMMENT '占座数量',
  `is_must` varchar(1) NOT NULL COMMENT '是否必修',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  `vetsion` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁版本号',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `tid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Records of tb_course
-- ----------------------------
BEGIN;
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (1, 'Python(A)', 05, '张三2', '2021-12-15 16:00:00', '2022-01-25 16:00:00', '星期二,星期四', 50, 2, '0', '2022-05-13 01:42:23', 'admin', 'admin', '2022-10-07 10:04:03', 'yier', 'yier', 0, 39);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (2, '数据库系统', 04, '张三3', '2021-12-16 15:56:54', '2022-01-25 16:00:00', '星期二,星期四', 3, 1, '0', '2022-05-13 01:42:26', 'admin', 'admin', '2022-10-07 00:42:05', 'admin', '管理员', 0, 10);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (3, 'Java程序设计', 03, '张三', '2021-12-16 15:56:57', '2022-01-18 16:00:00', '星期二,星期四', 2, 0, '1', '2022-05-13 01:42:30', 'admin', 'admin', '2022-10-07 00:41:28', 'admin', '管理员', 0, 2);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (5, 'C#程序设计', 02, '张三', '2021-12-16 15:57:02', '2022-01-25 16:00:00', '星期二,星期四', 1, 1, '0', '2022-05-13 01:42:33', 'admin', 'admin', '2022-10-07 10:01:53', 'student', '李四2', 0, 10);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (6, 'C语言程序设计(A)', 01, '张三', '2021-12-16 15:58:28', '2022-01-10 16:00:00', '星期二,星期四', 1, 0, '0', '2022-05-13 01:42:37', 'admin', 'admin', '2022-10-06 22:47:05', 'student', '李四2', 0, 5);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (7, 'C++面向对象(A)', 02, '张三', '2021-12-16 15:58:32', '2022-01-09 16:00:00', '星期二,星期四', 1, 0, '0', '2022-05-13 01:42:40', 'admin', 'admin', '2022-10-06 22:07:05', 'student', '李四2', 0, 4);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (8, '高等数学A1', 01, '张三', '2021-12-16 15:58:34', '2022-01-09 16:00:00', '星期二,星期四', 1, 0, '0', '2022-05-13 01:42:53', 'admin', 'admin', '2022-10-06 22:26:30', 'student', '李四2', 0, 5);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (9, '高等数学A2', 01, '张三', '2021-12-16 15:58:36', '2022-01-17 16:00:00', '星期五', 1, 0, '1', '2022-05-13 01:42:56', 'admin', 'admin', NULL, 'admin', 'admin', 0, 0);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (10, '所属', 02, '等等', '2021-12-15 16:00:00', '2021-12-15 16:00:00', '星期二,星期四', 22, 0, '0', '2022-10-07 00:11:38', 'admin', '管理员', '2022-10-07 00:35:34', 'admin', '管理员', 1, 0);
INSERT INTO `tb_course` (`id`, `course_name`, `graduate`, `course_teacher`, `start_time`, `end_time`, `time_table`, `stock`, `sale`, `is_must`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`, `vetsion`) VALUES (11, '新媒体', 01, '董国宇', '2021-12-15 16:00:00', '2021-12-15 16:00:00', '星期二,星期四', 33, 0, '0', '2022-10-07 00:14:30', 'admin', '管理员', '2022-10-07 00:15:55', 'admin', '管理员', 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for tb_course_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_course_user`;
CREATE TABLE `tb_course_user` (
  `id` varchar(50) NOT NULL COMMENT 'id主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `course_id` bigint(20) NOT NULL COMMENT '课程ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`,`user_id`,`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户课程关系表';

-- ----------------------------
-- Records of tb_course_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_course_user` (`id`, `user_id`, `course_id`, `create_time`) VALUES ('12cfdfa59ee69de024f26147395f6f77', 7, 1, '2022-10-07 10:04:03');
INSERT INTO `tb_course_user` (`id`, `user_id`, `course_id`, `create_time`) VALUES ('b68ad896811350fce6b89a96250a6a30', 2, 2, '2022-10-06 22:47:13');
INSERT INTO `tb_course_user` (`id`, `user_id`, `course_id`, `create_time`) VALUES ('d265ed8a4d2ac2e9760686a50a1e023f', 2, 5, '2022-10-07 10:01:53');
INSERT INTO `tb_course_user` (`id`, `user_id`, `course_id`, `create_time`) VALUES ('eb212cd62ffd9e4f42659561c136c0d5', 2, 1, '2022-10-07 10:01:24');
COMMIT;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据字典id',
  `name` varchar(255) NOT NULL COMMENT '公司名字',
  `parentId` int(10) NOT NULL COMMENT '父id',
  `ancestors` varchar(50) NOT NULL COMMENT '1 公司 2 分公司 3 部门',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `leaderUserId` bigint(20) NOT NULL COMMENT '负责人id',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责任手机',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人邮箱',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`,`leaderUserId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='分校部门表';

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
BEGIN;
INSERT INTO `tb_dept` (`id`, `name`, `parentId`, `ancestors`, `sort`, `leaderUserId`, `phone`, `email`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (101, '北京邮电大学', 0, '0', 1, 1, '137777777', '33@23.com', 0, 'yyy', '2022-07-07 21:22:18', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dept` (`id`, `name`, `parentId`, `ancestors`, `sort`, `leaderUserId`, `phone`, `email`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (103, '北京市海淀区西土城路10号', 101, '0,101', 2, 1, '15888888', '332@qq.com', 0, 'jjjj', '2022-07-08 00:55:19', 'admin', 'admin', '2022-09-04 23:56:44', 'admin', '管理员', 0);
INSERT INTO `tb_dept` (`id`, `name`, `parentId`, `ancestors`, `sort`, `leaderUserId`, `phone`, `email`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (104, '北京市昌平区北七家镇郑各庄村', 101, '0,101', 3, 1, '15888888111', '332@qq.com', 0, 'jjjj', '2022-07-08 00:55:19', 'admin', 'admin', '2022-09-04 14:06:41', 'admin', '管理员', 0);
INSERT INTO `tb_dept` (`id`, `name`, `parentId`, `ancestors`, `sort`, `leaderUserId`, `phone`, `email`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (105, '北京市昌平区南丰路与高教园南三街', 101, '0,101', 4, 1, '15888888111', '3322@qq.com', 0, 'jjjj', '2022-07-08 00:55:19', 'admin', 'admin', '2022-09-05 00:05:47', 'admin', '管理员', 0);
INSERT INTO `tb_dept` (`id`, `name`, `parentId`, `ancestors`, `sort`, `leaderUserId`, `phone`, `email`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (106, '测试部门', 104, '0,101,104', 5, 8, '13935356556', '2@q.com', 0, '专门测试使用', '2022-09-05 00:10:00', 'admin', '管理员', '2022-10-07 09:40:46', 'admin', '管理员', 0);
INSERT INTO `tb_dept` (`id`, `name`, `parentId`, `ancestors`, `sort`, `leaderUserId`, `phone`, `email`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (108, '财务部门', 105, '0,101,105', 2, 3, '13832143214', '222@qq.com', 0, '222', '2022-10-07 00:52:01', 'admin', '管理员', NULL, NULL, NULL, 0);
INSERT INTO `tb_dept` (`id`, `name`, `parentId`, `ancestors`, `sort`, `leaderUserId`, `phone`, `email`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (109, '人力资源部', 103, '0,101,103', 1, 3, '13333334444', '11@222.com', 0, '无', '2022-10-07 01:30:18', 'admin', '管理员', '2022-10-07 09:40:57', 'admin', '管理员', 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_dict
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict`;
CREATE TABLE `tb_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据字典id',
  `parentId` int(10) NOT NULL COMMENT '父id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名字(大类)',
  `model` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of tb_dict
-- ----------------------------
BEGIN;
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, 0, '状态', 'sex', '无', '2022-07-20 23:10:20', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (2, 1, '服务状态', 'st', 'dd', '2022-07-23 21:18:54', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (3, 1, '在线状态', 'st1', 'dd', '2022-07-23 21:18:54', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (4, 0, '基础字段', 'base', '无', '2022-07-20 23:10:20', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (5, 4, '性别', 'sex', '男女', '2022-07-20 23:10:20', 'admin', 'admin', '2022-09-29 15:50:12', 'admin', '管理员', 0);
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (10, 0, '课程字典', 'course', '无', '2022-07-31 10:48:17', 'admin', '管理员', '2022-10-07 09:41:54', 'admin', '管理员', 0);
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (11, 10, '是否必修', 'isMust', '必修，选修', '2022-07-31 10:49:00', 'admin', '管理员', '2022-09-29 15:49:21', 'admin', '管理员', 0);
INSERT INTO `tb_dict` (`id`, `parentId`, `name`, `model`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (13, 4, '角色类型', 'roleType', '内置，自定义', '2022-08-11 01:58:08', 'admin', '管理员', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_dict_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict_config`;
CREATE TABLE `tb_dict_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据字典id',
  `dict_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '数据字典目录Id',
  `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段（用户可以手动操作数据顺序时用到）',
  `dict_display` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典显示',
  `dict_value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典实际值',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='字典详细表';

-- ----------------------------
-- Records of tb_dict_config
-- ----------------------------
BEGIN;
INSERT INTO `tb_dict_config` (`id`, `dict_id`, `order_num`, `dict_display`, `dict_value`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, 1, 1, '启用', '1', '启用', '2022-07-24 23:42:37', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict_config` (`id`, `dict_id`, `order_num`, `dict_display`, `dict_value`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (2, 1, 0, '禁用', '0', '禁用', '2022-07-24 23:42:37', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict_config` (`id`, `dict_id`, `order_num`, `dict_display`, `dict_value`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (3, 9, 1, '在职', 'A', '在职', '2022-07-24 23:42:37', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict_config` (`id`, `dict_id`, `order_num`, `dict_display`, `dict_value`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (4, 9, 1, '离职', 'I', '离职', '2022-07-24 23:42:37', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict_config` (`id`, `dict_id`, `order_num`, `dict_display`, `dict_value`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (5, 11, 1, '必修', '1', '必修', '2022-07-24 23:42:37', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_dict_config` (`id`, `dict_id`, `order_num`, `dict_display`, `dict_value`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (6, 11, 1, '选修', '0', '选修', '2022-07-24 23:42:37', 'admin', 'admin', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_graduate
-- ----------------------------
DROP TABLE IF EXISTS `tb_graduate`;
CREATE TABLE `tb_graduate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `must_score` int(11) NOT NULL COMMENT '必修课总分',
  `select_score` int(11) NOT NULL COMMENT '选修课分数',
  `graduate` varchar(20) NOT NULL COMMENT '毕业设计',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='累计学分表';

-- ----------------------------
-- Records of tb_graduate
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_history`;
CREATE TABLE `tb_history` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `log_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `course_id` int(18) DEFAULT NULL,
  `log_data` json DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='历史记录表';

-- ----------------------------
-- Records of tb_history
-- ----------------------------
BEGIN;
INSERT INTO `tb_history` (`id`, `log_type`, `course_id`, `log_data`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (86, NULL, NULL, '{\"pwd\": \"asdasd\", \"user\": \"root\"}', NULL, NULL, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_job
-- ----------------------------
DROP TABLE IF EXISTS `tb_job`;
CREATE TABLE `tb_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of tb_job
-- ----------------------------
BEGIN;
INSERT INTO `tb_job` (`id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`, `concurrent`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', '2022-08-31 20:54:11', 'admin', 'admin', '2022-08-31 20:54:41', NULL, NULL, 0);
INSERT INTO `tb_job` (`id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`, `concurrent`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', '2022-08-31 20:54:15', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_job` (`id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`, `concurrent`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', '2022-08-31 20:54:17', 'admin', 'admin', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_job_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_job_log`;
CREATE TABLE `tb_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of tb_job_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `tb_logininfor`;
CREATE TABLE `tb_logininfor` (
  `id` varchar(255) NOT NULL COMMENT '访问ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of tb_logininfor
-- ----------------------------
BEGIN;
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('01bb1f445dd2b35c52103bccf7852bc4', 'teacher', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-06 22:33:42');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('02a3f0999af562275f2f9dbdf7ceb7e0', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-06 00:57:02');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('02fe0ba4b8d887453456cbad09053085', 'student', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-06 21:55:56');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('030b649f79c76e692e34c660f0194e96', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 02:04:56');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('03e849c8180ad9e48391070d295e336e', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 20:19:12');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0423e7b8a9aef05a0da645a38180a887', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:12:23');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('045c6bbfdddf4fce9fdafc94de8b9b4c', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-05 22:43:54');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('04d72b255bd4cb0df0d79a7e95fa1521', 'yier', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-07 10:03:11');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0759a1a37485e6cc7647064c55ca64c3', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 00:49:12');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('076cf29ff00a5adeaf2c62537f3ff3af', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 14:37:50');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('07f27a4ed1b841702f91c78897a91ba0', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 00:15:09');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('08c175d8de80aa310345a2592967cda1', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-11-14 00:44:50');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0903089e62b17c7bed077cef3761b285', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 00:52:28');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0980f92cb188f3eae1afee67f0cc7045', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:28:06');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0a0b3d287ebe7c9026e47ff91cafded6', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-11-14 00:43:41');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0bc3e9123f2c6e7e508b986d0bd284a4', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 01:16:09');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0d40179be17645d0d1aaa335d4fd7b63', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-11-14 00:35:22');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('0da9a031babc16058edd84c3b91d0860', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 14:00:14');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('10836589ed75314449444f9ab4d52490', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-21 22:16:40');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('11166a985d127ad63a6c243cbd3c0952', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:56:52');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('11eb815a6ecc42aaa0e44d3c524ba7cf', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 10:05:20');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('12bf66aa45f3f7debcb7d927f8f83882', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 14:36:11');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('13fcd1eee16242b7090a9d9daded70d4', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-19 00:10:55');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('150351ad4c58cbe0b4004ad5f5667ea9', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:45:56');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('150fe951a9a1451be615903bac781c50', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-11-27 23:13:04');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('16afa6fa8e52ad720ea2023870a0b677', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-05 23:49:01');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('172f3d1673e0ac1fe5d37350bfd41373', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-17 22:28:34');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('18ccdd926105f57820817e164a0e63c7', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-02 01:41:53');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('18d3e4e3fa66b877804834c30f0f4e5c', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-20 23:49:32');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('19531a7bb53c6291156281f659868fd6', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-03 10:54:22');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('1a3517a366f4397e1e6865e99ade686f', 'admin2', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 12:12:08');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('1be5a613bc8d507674d888f1a511ec1d', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-15 02:29:19');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('1e4f569e27ae72a3a257e5f16742acce', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:26:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('1e7f2dd828dc9f69047b13383067c957', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-05 23:55:56');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('1f0ae5911c1c1b5cd1778bfc5551c9c9', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-02 03:03:12');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('203e0a0ddcf778f54ccbb22f7ecece22', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 02:27:17');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('20c4f8145917a8cee6c3d6823c9d4349', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:30:15');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('217bb33773f66bf05d7c644b2702b447', 'student', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-07 10:00:49');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('21fdd82abd5a76a46610eed5457e6726', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-06 15:07:40');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('2208ceaeec8fbdb02303a7c05d18bd4a', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 17:28:16');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('253b62884aa99aa17c50d0442d05a9b3', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-10 01:26:47');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('2607685304ef13f84248c4b847f6b2b0', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 09:11:41');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('269f2513bf72390dce88f55ab63ab48d', 'teacher', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-06 22:56:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('272b8a5c354ce763d87588c99af4d5a1', 'lisi', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-03 15:20:57');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('273b441ed390ba2122c78fded3baf7ff', 'lisi', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-02 19:29:00');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('277b57ec6cddb0e3449c625ef9f08410', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-21 15:56:31');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('2c5e399bd092caf3fae3f57308cee38f', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 21:34:43');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('2cd87a1df91373a92bc609b27d25b41c', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:47:54');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('2e799aaab682c1ab65da532941861247', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:52:05');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('2fbf4661cbb8a1cfa35fc29368f42f2e', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 00:10:13');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('30f6749131c6a60228df33b6f42d2360', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3295c4ea84288e415b99c0adc02a4d0b', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-17 21:52:32');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('33c895e00a17b1038a3d19b9b6f5d754', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 02:11:14');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3557c6c567363edfeffa0f88e3d38c9e', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-20 13:54:44');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('35bd08bbd008f07ff74aa8ca762bbf42', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:27:12');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('387588585ee83bfefd02fa2a7239e7a7', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 01:24:57');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('392bad33d4cf64e127e7181f56a44036', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-19 03:51:01');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3a4579e7eccf3c87ab327d5e23a367a8', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 00:06:19');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3a8945bfbe4b9cedb5400127dcc47f79', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 22:46:33');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3afc3044434c934c5bee6b355bdf6b6e', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 19:48:57');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3b62b974fad3d59a1d8fa1e92acca4d2', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:42:02');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3c8ba0f3d6fcfade14f1b0282a664e2e', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:54:00');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3d21f766f32d59781de158ed31dbfda8', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 20:09:54');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3d2695006db8c5f434af7326bd98e968', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:11');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3e21f5446aa5bc5561ac5622fe30d58d', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 18:52:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3f6f4ecd88a6d40c76a91ec58cf3fe1e', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 17:45:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('3fedcffc49b12bb234436b7129dbc976', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 20:19:53');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('42bfa01edbeea828f265f68c4a0f1ea0', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 21:53:15');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('43983f9558c9d058a0f4df63c4f50b4a', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 21:47:29');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('460898f2af1d5c85b56aaf3c18629ba8', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 21:25:00');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('46cfe2f409ebca2d8d66aecc44333da1', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:37');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('48a0319e48edad89d336ba53870b587f', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 14:37:33');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('49330b05d52a765b9bb40891c287b1d8', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 00:09:34');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4a9c19fdcb54b2306eb55efbfd8e3100', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 02:22:49');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4ac4f83b40e66ebe3740623dadc42995', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-07 23:00:23');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4b31f784c9679896132a02d503dbab4f', 'admin2', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 11:36:30');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4b8aafb19ed7e0ff70ccedaf3b177957', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 21:50:46');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4cf48d42477b3dacf5816d0674343bd7', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 14:48:46');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4d0e4a75f4fba0886645e7e3d89f8874', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-03 23:38:53');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4de936fec02dc99dab6014028dada431', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-05 23:50:10');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4e37e03cbb8c09966a6afea33732cfac', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 10:03:56');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4e8e69f5e6a6ea8507953e911edf8d4b', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-13 21:45:35');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('4f862de44d8c33f483d4e58b745a2590', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-11-14 00:34:23');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('502e77ffa117814633fe88d8feb19f2a', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-07 09:49:21');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('51a28dd0acb674fe2e70b00f446657d6', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:49:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('525486ef9d447378b6a11ddd8ae1aaa9', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-15 08:50:12');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('52b5e122e64ac959fb4033df4a466b52', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-07 10:02:41');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('52cb310c9c4cc33152f41877bc085469', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 00:10:33');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('5360a201a6ebebecb142cc7d62e323a5', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 18:53:26');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('55354b8008533116bd7cb71bf04b23b5', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:34:07');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('57d5401fe5950d50943ae7e5515ae770', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 03:03:21');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('59052725be0315c6153d950b05e764be', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 17:36:52');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('5c72df279aba6a68c4c33a7ab2ec1c0d', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 02:07:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('5d3d348dd9c5b5c673ae1a9f028dd539', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:29:37');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('5f614e33fe79d22d52086a16adb27d89', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-13 21:56:22');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('602eed85cc093e779cd216229dda7c95', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 14:37:31');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('60db5108849245a4c9909da0495ee96f', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-19 23:09:04');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6117d301f7a5dd0b66f4a7f84a1b6f77', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-05 23:56:28');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6173ff16536ed63b1c583a0dfb24f873', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 14:37:32');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('62a1b76a15241f5e5c904a4017bc4c35', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:32:00');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('644d655aaccedbeccb4ba419c900db07', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:17');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6537b6687a2cb7ab3bae748406c7049a', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 10:07:35');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('65e5b10c4410e62da968f5cc4d4df2b2', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 15:24:53');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('667c469ffcc7da57381f81d0cc7bf1d1', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-07 09:58:06');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('683acb5aa782548f4f4e3a1e79b1893b', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-07 20:44:18');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6936d9ab4c67670440167952f69c3cc7', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 09:22:41');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6b92e5a647418586469d06511e2709f2', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-05 23:57:15');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6d25dbb16c22f350c0193209af6725e2', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 14:08:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6f0f85e883458477332d0fecf9a4f21e', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:54:35');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('6fc61d1c15d19ed13d12fec648ee8beb', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 18:03:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('70523a6f77eaccdb6ba814ff9b3c0fe2', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:33:24');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('724df8c4001e51c3a520a10979c6cece', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 00:25:37');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('739ad914476efdbe35026bd56c8800cc', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 12:49:02');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('73b0a3eb7bc2b2bf665a13ad66b33514', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-21 15:45:19');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('74737ff200a57c2dbeb23a3effdb0dfe', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:46:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('74a5f3f8903388dd39a6ce43f7df5b3b', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-14 23:28:04');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('7752295d6be655c80c599142eb385f17', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:28:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('7856b187fe9d71c615687c485ce85d64', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-17 22:37:10');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('796f07c60aededa753e1adae1248940a', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:25');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('79d0f1bf447d4815133e226ebb3cda75', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-13 21:44:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('7a344a856fd5986b84f2b27c592fc633', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 01:10:42');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('7d8c3030dd1b376d10e457a66a993fe6', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:36:14');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('7f40642807b21a28a3583d04f46dfb65', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-11-14 00:33:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('7f4294348f9fa25fd91bbc4853214c70', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 21:36:42');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('80b02cca09003ea71301bafd59fb82d8', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 17:38:09');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('82be6f2eed0657738ac40b00acb2f5e1', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-17 22:33:11');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('82da5b8b5b4c6aafc44739c0664f1480', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-19 23:11:39');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('83101030f819e66053d19a94270da922', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 00:21:34');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('856ce787e0c6e7781608e58d47447ceb', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-14 00:01:17');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('894fc384036fc28dd62f320a048e6189', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 21:38:49');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('8c2f9bc902e66689b4f6edc6f437af28', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-11-14 00:29:43');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('8f1ea91824cbd1f9607e290306e28bb2', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:57:27');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('932ce2c01423384cc7a6491318823923', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 02:11:45');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('953ee48a9c508e38e550b40e3ac67b6c', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 02:27:44');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9678b5865156ef01c96bbc125a3e30bc', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 17:57:47');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('96d8891610ffad9b821bcffe0d26c9a9', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:32:42');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('97205510be0634425cb64fb1a24745e7', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-19 15:45:33');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('988ce0d0127d12d9baa150022258bac6', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:32:21');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9924cdceedc95e5b6d897d9891bca112', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-105.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-12 08:58:38');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('99ebab4f16d24f4410776588cfa24f75', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-11-14 00:29:11');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9b71896576f533980770174c3ee0fa11', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 00:08:00');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9bb523d93a72e5b4ea928c0d4e6913ed', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:20:53');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9ce48b6e44a626f488a8928659f0cc7d', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 21:37:14');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9de029f945c6c19823b8f9300447a79a', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 16:47:50');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9ec104b61d6a73ae9be7875b2edcc3bf', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 09:10:34');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('9ec1b0b8ab82a64c63fceb08965a3acc', 'admin2', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 15:01:57');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a2be08e8de6a1bfe5dbd6d2c3544eec3', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:55:28');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a37f4ee9ea3e9ae9c2537bc9609b7a9c', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-21 22:18:34');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a452c7366c39510b2558c5463876c7f8', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-17 23:37:38');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a5a5ff2d4d235a13cac55b0c57a69c67', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 18:51:43');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a5fcde48277edb7a5825132d742866f9', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-19 04:17:22');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a6422cd56aed1ecfd4afb7f63a1431aa', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:34:51');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a6e27fedad1e40f11d08e1659de29001', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-14 14:20:42');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a74759cb397dca129ead1bf42bac97ab', 'admin', '36.110.18.171', '中国省-北京市-北京县', 'Chrome 10-106.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-20 09:04:14');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a74e9e9e33946be8e8fa05e67bf35fa4', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-17 21:34:54');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a906e0742f1c3e5903ed9d3ee8f8bc90', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 11:32:11');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('a9d99a2282fdb762b5306c909dbbb933', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 00:49:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('aa1d91606b899209b6ab80a7ba2ae027', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:48:51');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ae41ba4a94400a74fbbedc537c48b52e', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 23:08:35');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ae939a119d298d81ffd60c7a56e951e7', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-14 00:17:02');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('af584cebb3680385c3dbd34ef4542b13', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-29 17:27:40');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b080984d3bdcd0b9259d091c650e1b72', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:58:41');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b08ef7811d595f19469a8bb77ccef6ea', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-14 00:19:01');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b3ad4eb61b164b662071f7ac61a33161', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-05 23:57:28');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b445245f09e8e8bad52655458308453d', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 14:00:44');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b597eb2263ffae85d3f2ee6e0bdcbe14', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-04 02:10:03');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b66990f22ef0d1f565648a15b5df2078', 'test', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-19 04:19:24');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b6e91429b44a998ec2a3a48c4727366a', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-29 17:27:54');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('b8eb641339c8be1fcedaefc11ad09c0e', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-14 14:19:24');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ba1bb2ee0d0214d0fac2dd913c0a7c90', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 01:30:38');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ba9d43365fbcee820fe16326cf5d5945', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 00:05:08');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('bee6e304236531c87163474afcf87eab', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-11-14 00:31:00');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('c0160fdc981e01ae171c32325a20775d', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 17:56:36');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('c56d49892a8c843082db4d3179cd0dbf', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:23');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('c65f34ccf06529085dc593cdfa181418', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 21:39:10');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('c911e3813ba918a16fb24daef909e842', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-14 23:30:57');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('c9338aa8b04aec6190374c0afe34fe8d', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 03:08:27');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('c9443372fe3e79f4ae34d7cb2a078a86', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-20 14:02:24');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('cf458d03434635e07e72c6ff985aa534', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-11-27 23:33:22');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('cf5aaf6f842b300044219e9349ee8856', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 17:27:45');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('cf730d03eae4a65e381b599fff4afd76', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 12:57:55');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('cf8323fa4dc017957b6189785c0d2437', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-15 23:38:35');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('d1069e1a5645c5637ca8596f5eb15626', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 10:04:24');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('d279251cbb14c4d5c740ded8c6cc935d', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-10 02:05:07');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('d2e685fee87a7fdfd614d12376923470', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-14 00:09:11');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('d4b7ddb6a73e88fca8da7fb5074ea4d1', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:57');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('d52fdcec7ab22399e0c9ac1034c3a0dc', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 14:10:04');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('d65b3cb2d6864137ad37c97ab4f5658a', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-15 23:43:47');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('d91d0036132f6ddab71eb34997dfc117', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:20:00');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('dac0471c50177765dc6af7860d8ee0ee', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-13 23:54:09');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('dc2b44503082219845d28b59ad9ab51a', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 12:49:33');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('dc44f4220e7371b5533cf077969d44f3', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-21 22:18:05');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('dcbf26acfce9527884b5d8208fe55ca3', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:41:10');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ddce5619145584cd83da6c6930aedf99', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:41:01');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('df1e9db614414ab78a875ed339f253ff', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-18 18:56:44');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('e48a6a1b65ff78e4fe5e532de0d57ac8', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-17 21:36:12');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ea164ae19b5f5eacb7bf40b3bda18378', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-06 21:29:28');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('eec6aa959bf1afca63650cabc3249f22', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 23:13:20');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ef73fc194b76737392b07a5e76746b71', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 13:55:24');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ef9e7ea50fcd59756c7296dce8918a62', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-15 08:40:29');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('f2d38717f956932058ea578d95de187f', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 17:49:07');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('f3cea4b185e0c395edc4f8a5e47b021d', '***', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '1', '登录失败', '2022-10-13 23:58:38');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('f4fc04a60ef5d38b71dc93c42188bfc1', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-13 21:43:49');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('f5a245b07c6717108f286ffce32cdd81', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 01:25:48');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('f75a1ac51c082d624c51532fb2af8fbc', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-17 02:29:07');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('f7b6943928408ca55500a20f0c76bc9f', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-107.0.0.0', 'Mac OS X', '0', '登录成功', '2022-10-30 12:11:31');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('f89b2455e4ed7f52feecd6af26e6a1b0', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-20 21:53:49');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('fcf2a5c64c9209307027562c9764d36a', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:56:08');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('fe529914389244bda8ec4045ea3af708', '***', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '1', '登录失败', '2022-12-13 02:22:14');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ffb045b8ff2cff92c5947ff4d2eaee99', 'admin', '127.0.0.1', '内网IP', 'Chrome 10-108.0.0.0', 'Mac OS X', '0', '登录成功', '2022-12-21 23:03:29');
INSERT INTO `tb_logininfor` (`id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES ('ffb5b40e1d9991230058fbd7c3438a38', 'admin', '127.0.0.1', '内网IP', 'Unknown-null', 'Unknown', '0', '登录成功', '2022-10-14 00:17:02');
COMMIT;

-- ----------------------------
-- Table structure for tb_major
-- ----------------------------
DROP TABLE IF EXISTS `tb_major`;
CREATE TABLE `tb_major` (
  `id` int(18) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `School` varchar(20) DEFAULT NULL COMMENT '学校分院',
  `major` varchar(20) DEFAULT NULL COMMENT '专业',
  `major_code` varchar(255) NOT NULL COMMENT '班级code',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`),
  KEY `tid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='班级表';

-- ----------------------------
-- Records of tb_major
-- ----------------------------
BEGIN;
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, '上海市虹桥分院', '网络技术21', '2101', '2021-12-16 18:13:37', 'admin', 'admin', '2021-12-16 18:13:41', 'admin', 'admin', 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (2, '北京通州分院', '哲学', '2102', '2021-12-16 18:13:37', 'admin', 'admin', '2021-12-16 18:13:41', 'admin', 'admin', 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (10, '广州大学分院', '生物', '2201', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (11, '广州大学分院', '网络安全', '2207', NULL, NULL, NULL, '2022-09-27 17:45:56', 'admin', '管理员', 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (12, '山东大学分院', '机电', '2205', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (13, '浙江大学分院', '数控', '2301', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (14, '清华大学', 'java', '2233', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (15, '天津天河分院', '数据治理', '2201', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (18, '黑龙江交通大学', '交通管理', '2201', '2022-05-02 00:52:45', 'admin', '管理员', NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (19, 'dgy123', '123', '2203', '2022-06-27 15:22:34', 'xb', 'xb', '2022-09-27 16:29:57', 'admin', '管理员', 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (20, '天津师范学院', '计算机科学', '2202', '2022-07-24 10:45:08', 'admin', '管理员', NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (21, '黑龙江工业大学', '生物', '2022', '2022-07-24 11:04:22', 'admin', '管理员', NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (22, '河南农业大学', '农业', '2205', '2022-08-17 22:07:52', 'admin', '管理员', NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (23, '等等', '等等', '2222', '2022-08-18 00:36:05', 'admin', '管理员', '2022-09-05 16:36:13', 'admin', '管理员', 1);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (24, '吃菜菜', '吃菜菜', '2232', '2022-08-18 00:38:11', 'admin', '管理员', NULL, NULL, NULL, 0);
INSERT INTO `tb_major` (`id`, `School`, `major`, `major_code`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (25, '北京国语大学', '俄罗斯语', '2206', '2022-10-06 23:50:42', 'admin', '管理员', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_major_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_major_course`;
CREATE TABLE `tb_major_course` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `major_id` bigint(20) NOT NULL COMMENT '部门ID',
  `course_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业课程关联表';

-- ----------------------------
-- Records of tb_major_course
-- ----------------------------
BEGIN;
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031313822404609, 24, 1);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031313826598914, 24, 2);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031313830793217, 24, 3);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031334034755585, 22, 3);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031334038949889, 22, 5);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031334038949890, 22, 6);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031370474868738, 20, 1);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031370479063041, 20, 2);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031370483257345, 20, 3);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031370487451650, 20, 5);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031370487451651, 20, 6);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031370487451652, 20, 7);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031370487451653, 20, 8);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031407309246465, 11, 1);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031407317635073, 11, 2);
INSERT INTO `tb_major_course` (`id`, `major_id`, `course_id`) VALUES (1575031407317635074, 11, 9);
COMMIT;

-- ----------------------------
-- Table structure for tb_major_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_major_user`;
CREATE TABLE `tb_major_user` (
  `id` varchar(30) NOT NULL COMMENT 'id',
  `major_id` bigint(20) NOT NULL COMMENT '专业id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of tb_major_user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) NOT NULL COMMENT '父id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `path` varchar(50) NOT NULL COMMENT '路径',
  `component` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '组件路径',
  `name` varchar(50) DEFAULT NULL COMMENT '页面name，作为一种规范',
  `meta` json NOT NULL COMMENT '排序/名字/图表/是否缓存\nmeta: {\n  icon: "setting",\n  title: "menus.hssysManagement",\n  rank: 11\n  keepAlive：true\n},',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1116667 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
BEGIN;
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (100, 0, '系统管理', '/system', NULL, '', '{\"icon\": \"setting\", \"rank\": 12, \"roles\": [\"admin\"], \"title\": \"menus.hssysManagement\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (101, 100, '用户菜单', '/system/user/index', NULL, 'User', '{\"icon\": \"flUser\", \"roles\": [\"admin\"], \"title\": \"menus.hsUser\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (102, 100, '权限列表', '/system/role/index', NULL, 'Role', '{\"icon\": \"role\", \"roles\": [\"admin\"], \"title\": \"menus.hsRole\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (103, 100, '部门列表', '/system/dept/index', NULL, 'Dept', '{\"icon\": \"role\", \"roles\": [\"admin\"], \"title\": \"menus.hsDept\"}', '2022-08-06 19:16:02', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (104, 100, '字典列表', '/system/dict/index', NULL, 'Dict', '{\"icon\": \"dict\", \"roles\": [\"admin\"], \"title\": \"menus.hsDict\", \"keepAlive\": true}', '2022-08-06 19:16:02', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (105, 100, '菜单列表', '/system/meun/index', NULL, 'Meun', '{\"icon\": \"node-tree\", \"roles\": [\"admin\"], \"title\": \"menus.hsMeun\"}', '2022-08-06 19:16:02', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (106, 100, '菜单列表', '/system/log/index', NULL, 'Log', '{\"icon\": \"node-tree\", \"roles\": [\"admin\"], \"title\": \"menus.hsLog\"}', '2022-08-06 19:16:02', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (200, 0, '权限管理', '/permission', NULL, 'Permission Manage', '{\"icon\": \"lollipop\", \"rank\": 11, \"title\": \"menus.permission\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (201, 200, '权限管理', '/permission/page/index', NULL, 'PermissionPage', '{\"title\": \"menus.permissionPage\", \"authority\": []}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (202, 200, '权限管理', '/permission/button/index', NULL, 'PermissionButton', '{\"title\": \"menus.permissionButton\", \"authority\": []}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (300, 0, '外部页面', '/iframe', NULL, 'External Page', '{\"icon\": \"monitor\", \"rank\": 10, \"title\": \"menus.hsExternalPage\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (301, 300, 'external', '/external', NULL, 'https://yiming_chang.gitee.io/pure-admin-doc', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.externalLink\"}', '2022-12-21 22:41:13', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (302, 300, 'FramePure', '/iframe/pure', NULL, 'FramePure', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hsPureDocument\", \"frameSrc\": \"https://pure-admin-doc.vercel.app\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (303, 300, 'FrameEp', '/iframe/ep', NULL, 'FrameEp', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hsEpDocument\", \"frameSrc\": \"https://element-plus.org/zh-CN/\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (304, 300, 'FrameVue', '/iframe/vue3', NULL, 'FrameVue', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hsVueDocument\", \"frameSrc\": \"https://cn.vuejs.org/\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (305, 300, 'FrameVite', '/iframe/vite', NULL, 'FrameVite', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hsViteDocument\", \"frameSrc\": \"https://cn.vitejs.dev/\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (306, 300, 'FramePinia', '/iframe/pinia', NULL, 'FramePinia', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hsPiniaDocument\", \"frameSrc\": \"https://pinia.vuejs.org/zh/index.html\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (307, 300, 'FrameRouter', 'iframe/vue-router', NULL, 'FrameRouter', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hsRouterDocument\", \"frameSrc\": \"https://router.vuejs.org/zh/\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (308, 300, 'FrameTailwindcss', '/iframe/tailwindcss', NULL, 'FrameTailwindcss', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hsTailwindcssDocument\", \"frameSrc\": \"https://tailwindcss.com/docs/installation\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (309, 300, '外部页面', '/external', NULL, 'https://pure-admin-doc.vercel.app', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.externalLink\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (400, 0, '标签页操作', '/tabs', NULL, 'Tabs Operate', '{\"icon\": \"IF-team-icontabs\", \"rank\": 14, \"roles\": [\"admin\", \"common\"], \"title\": \"menus.hstabs\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (401, 400, '标签页操作', '/tabs/index', NULL, 'Tabs', '{\"roles\": [\"admin\", \"common\"], \"title\": \"menus.hstabs\"}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (402, 400, '标签页操作', '/tabs/query-detail', NULL, 'TabQueryDetail', '{\"roles\": [\"admin\", \"common\"], \"showLink\": false}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (403, 400, '标签页操作', '/tabs/params-detail/:id', 'params-detail', 'TabParamsDetail', '{\"roles\": [\"admin\", \"common\"], \"showLink\": false}', '2022-08-06 18:59:14', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (700, 0, 'PPT', '/ppt', NULL, 'PPT', '{\"icon\": \"ppt\", \"rank\": 17, \"title\": \"PPT\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (701, 700, 'PPT', '/ppt/index', NULL, 'FramePpt', '{\"title\": \"PPT\", \"frameSrc\": \"https://pipipi-pikachu.github.io/PPTist/\", \"extraIcon\": {\"svg\": true, \"name\": \"team-iconxinpin\"}, \"frameLoading\": false}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (800, 0, '表单', '/formDesign', NULL, 'Form Design', '{\"icon\": \"terminalWindowLine\", \"rank\": 15, \"title\": \"menus.hsFormDesign\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (801, 800, '表单设计器', '/formDesign/index', NULL, 'FormDesign', '{\"title\": \"menus.hsFormDesign\", \"frameSrc\": \"https://haixin-fang.github.io/starfish-vue3-lowcode/playground/index.html#/\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (900, 0, '编辑器', '/editor', NULL, 'Editor', '{\"icon\": \"edit\", \"rank\": 18, \"title\": \"menus.hseditor\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (901, 900, '编辑器', '/editor/index', NULL, 'Editor', '{\"rank\": 5, \"title\": \"menus.hseditor\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1000, 0, '流程图', '/flowChart', NULL, 'Flow Chart', '{\"icon\": \"setUp\", \"rank\": 16, \"title\": \"menus.hsflowChart\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1001, 1000, '流程图', '/flow-chart/index', NULL, 'FlowChart', '{\"title\": \"menus.hsflowChart\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1100, 0, '列表', '/list', NULL, 'List Page', '{\"icon\": \"listCheck\", \"rank\": 10, \"title\": \"menus.hsList\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1101, 1100, '列表', '/list/card', '\"@/views/list/card/index.vue\"', 'ListCard', '{\"icon\": \"card\", \"title\": \"menus.hsListCard\", \"showParent\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1200, 0, '引导页', '/guide', NULL, 'Guide', '{\"icon\": \"guide\", \"rank\": 19, \"title\": \"menus.hsguide\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1201, 1200, '引导页', '/guide/index', NULL, 'Guide', '{\"title\": \"menus.hsguide\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1300, 0, '结果页面', '/result', NULL, 'Result', '{\"icon\": \"checkboxCircleLine\", \"rank\": 8, \"title\": \"menus.hsResult\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1301, 1300, '成功', '/result/success', NULL, 'Success', '{\"title\": \"menus.hsSuccess\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1302, 1300, '失败', '/result/fail', NULL, 'Fail', '{\"title\": \"menus.hsFail\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1400, 0, '错误页', '/error', NULL, '403', '{\"icon\": \"informationLine\", \"rank\": 9, \"title\": \"menus.hsabnormal\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1401, 1400, '错误页', '/error/403', NULL, '403', '{\"title\": \"menus.hsfourZeroOne\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1402, 1400, '错误页', '/error/404', NULL, '404', '{\"title\": \"menus.hsfourZeroFour\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1403, 1400, '错误页', '/error/500', NULL, '500', '{\"title\": \"menus.hsFive\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1500, 0, '关于', '/about', NULL, 'About', '{\"rank\": 20, \"title\": \"menus.hsAbout\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1501, 1500, '关于', '/about/index', NULL, 'About', '{\"rank\": 20, \"title\": \"menus.hsAbout\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1600, 0, '多级菜单', '/nested', NULL, 'Menu', '{\"icon\": \"histogram\", \"rank\": 7, \"title\": \"menus.hsmenus\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1601, 1600, '一级菜单', '/nested/menu1', NULL, 'Menu1', '{\"title\": \"menus.hsmenu1\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1602, 1601, '二级菜单', '/nested/menu1/menu1-1', NULL, 'Menu1-1', '{\"title\": \"menus.hsmenu1-1\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1603, 1601, '二级菜单', '/nested/menu1/menu1-2', NULL, 'Menu1-2', '{\"title\": \"menus.hsmenu1-2\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1604, 1603, '三级菜单', '/nested/menu1/menu1-2/menu1-2-1', NULL, 'Menu1-2-1', '{\"title\": \"menus.hsmenu1-2-1\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1605, 1603, '三级菜单', '/nested/menu1/menu1-2/menu1-2-2', NULL, 'Menu1-2-2', '{\"title\": \"menus.hsmenu1-2-2\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1606, 1601, '二级菜单', '/nested/menu1/menu1-3', NULL, 'Menu1-3', '{\"title\": \"menus.hsmenu1-3\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1607, 1600, '一级菜单', '/nested/menu2', NULL, 'Menu2', '{\"title\": \"menus.hsmenu2\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1700, 0, '组件', '/components', NULL, 'Components', '{\"icon\": \"menu\", \"rank\": 4, \"title\": \"menus.hscomponents\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1701, 1700, '视频组件', '/components/video', NULL, 'Video', '{\"title\": \"menus.hsvideo\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1702, 1700, '地图组件', '/components/map', NULL, 'Map', '{\"title\": \"menus.hsmap\", \"keepAlive\": true, \"transition\": {\"name\": \"fade\"}}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1703, 1700, '拖拽组件', '/components/draggable', NULL, 'Draggable', '{\"title\": \"menus.hsdraggable\", \"transition\": {\"enterTransition\": \"animate__zoomIn\", \"leaveTransition\": \"animate__zoomOut\"}}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1704, 1700, '切割组件', '/components/split-pane', NULL, 'SplitPane', '{\"title\": \"menus.hssplitPane\", \"extraIcon\": {\"svg\": true, \"name\": \"team-iconxinpinrenqiwang\"}}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1705, 1700, '按钮组件', '/components/button', NULL, 'Button', '{\"title\": \"menus.hsbutton\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1706, 1700, '选择器组件', '/components/cropping', NULL, 'Selector', '{\"title\": \"menus.hsselector\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1707, 1700, '无缝组件', '/components/seamless-scroll', NULL, 'SeamlessScroll', '{\"title\": \"menus.hsseamless\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1708, 1700, '右键菜单', '/components/contextmenu', NULL, 'ContextMenu', '{\"title\": \"menus.hscontextmenu\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1709, 1700, 'Typeit', '/components/typeit', NULL, 'typeit', '{\"title\": \"menus.hstypeit\"}', '2022-10-29 17:06:47', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1710, 1700, 'jsonEditor', '/components/jsonEditor', NULL, 'jsonEditor', '{\"title\": \"menus.hsjsoneditor\"}', '2022-10-29 17:11:39', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1800, 0, '组件', '/ableRouter', NULL, 'Components', '{\"icon\": \"ubuntuFill\", \"rank\": 5, \"title\": \"menus.hsAble\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1801, 1800, '组件', '/able/watermark', NULL, 'WaterMark', '{\"title\": \"menus.hsWatermark\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1802, 1800, '组件', '/able/print', NULL, 'Print', '{\"title\": \"menus.hsPrint\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1803, 1800, '组件', '/able/icon-select', NULL, 'IconSelect', '{\"title\": \"menus.hsIconSelect\", \"keepAlive\": true}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1804, 1800, '组件', '/able/timeline', NULL, 'TimeLine', '{\"title\": \"menus.hsTimeline\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1805, 1800, '组件', '/able/menu-tree', NULL, 'MenuTree', '{\"title\": \"menus.hsMenuTree\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1806, 1800, '组件', '/able/line-tree', NULL, 'LineTree', '{\"title\": \"menus.hsLineTree\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1807, 1800, 'Download', '/able/download', NULL, 'Download', '{\"title\": \"menus.hsDownload\"}', '2022-12-20 23:10:39', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1810, 1800, '组件', '/able/debounce', NULL, 'Debounce', '{\"title\": \"menus.hsDebounce\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1811, 1800, '组件', '/able/barcode', NULL, 'BarCode', '{\"title\": \"menus.hsBarcode\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1812, 1800, '组件', '/able/qrcode', NULL, 'QrCode', '{\"title\": \"menus.hsQrcode\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1813, 1800, '组件', '/able/cascader', NULL, 'Cascader', '{\"title\": \"menus.hsCascader\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1814, 1800, '组件', '/able/swiper', NULL, 'Swiper', '{\"title\": \"menus.hsSwiper\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1815, 1800, '组件', '/able/virtual-list', NULL, 'VirtualList', '{\"title\": \"menus.hsVirtualList\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1816, 1800, '组件', '/able/pdf', NULL, 'Pdf', '{\"title\": \"menus.hsPdf\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1817, 1800, '组件', '/able/execl', NULL, 'Execl', '{\"title\": \"menus.hsExecl\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
INSERT INTO `tb_menu` (`id`, `parent_id`, `remark`, `path`, `component`, `name`, `meta`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1818, 1800, '组件', '/able/infinite-scroll', NULL, 'InfiniteScroll', '{\"title\": \"menus.hsInfiniteScroll\"}', '2022-09-21 23:49:21', 'dgy', 'dgy', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_meun_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_meun_role`;
CREATE TABLE `tb_meun_role` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `meun_id` bigint(20) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`,`meun_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单角色关联表';

-- ----------------------------
-- Records of tb_meun_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 100);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 101);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 103);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 104);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 105);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 106);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 200);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 201);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 202);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 203);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 300);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 301);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 302);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 303);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 304);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 305);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 306);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 307);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 308);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 309);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 400);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 401);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 402);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (1, 403);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 100);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 101);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 102);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 103);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 104);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 105);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 106);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 200);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 201);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 202);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 300);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 301);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 302);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 303);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 400);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 401);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 402);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 403);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 700);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 701);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 800);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 801);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 900);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 901);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1000);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1001);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1100);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1101);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1200);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1201);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1300);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1301);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1302);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1303);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1400);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1401);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1402);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1403);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1500);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1501);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1600);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1601);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1602);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1603);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1604);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1605);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1606);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1607);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1700);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1701);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1702);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1703);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1704);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1705);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1706);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1707);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1708);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1709);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1800);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1801);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1802);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1803);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1804);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1805);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1806);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1807);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1808);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1809);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1810);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1811);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1812);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1813);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1814);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1815);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1816);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1817);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1818);
INSERT INTO `tb_meun_role` (`role_id`, `meun_id`) VALUES (11, 1819);
COMMIT;

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_oper_log`;
CREATE TABLE `tb_oper_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of tb_oper_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_post
-- ----------------------------
DROP TABLE IF EXISTS `tb_post`;
CREATE TABLE `tb_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of tb_post
-- ----------------------------
BEGIN;
INSERT INTO `tb_post` (`id`, `post_code`, `post_name`, `post_sort`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, 'ceo', '校长', 0, '1', NULL, '2022-08-27 00:50:34', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_post` (`id`, `post_code`, `post_name`, `post_sort`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (2, 'se', '教导主任', 0, '1', NULL, '2022-08-27 00:50:34', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_post` (`id`, `post_code`, `post_name`, `post_sort`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (3, 'hr', '老师', 0, '1', NULL, '2022-08-27 00:50:34', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_post` (`id`, `post_code`, `post_name`, `post_sort`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (4, 'user', '普通员工', 0, '1', NULL, '2022-08-27 00:50:34', 'admin', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `tb_post` (`id`, `post_code`, `post_name`, `post_sort`, `status`, `remark`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (5, 'student', '学生', 0, '1', NULL, '2022-08-27 00:50:34', 'admin', 'admin', NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_result
-- ----------------------------
DROP TABLE IF EXISTS `tb_result`;
CREATE TABLE `tb_result` (
  `id` int(18) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `course_id` bigint(20) NOT NULL COMMENT '课程id',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名',
  `result` bigint(20) unsigned zerofill DEFAULT NULL COMMENT '成绩',
  `is_reset` int(2) unsigned zerofill DEFAULT NULL COMMENT '补考标记',
  `graduate` bigint(10) unsigned zerofill DEFAULT NULL COMMENT '获得的学分',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`),
  KEY `tid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='成绩表';

-- ----------------------------
-- Records of tb_result
-- ----------------------------
BEGIN;
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, 1, 1, 'java', 00000000000000000034, 00, 0000000000, '2022-05-02 05:59:09', '1', '1', '2022-10-06 21:21:24', 'teacher', '王五', 00000000001);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (10, 2, 1, 'Python(A)', NULL, NULL, NULL, '2022-10-06 22:29:39', 'student', '李四2', NULL, NULL, NULL, 00000000001);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (11, 2, 2, '数据库系统', NULL, NULL, NULL, '2022-10-06 22:30:24', 'student', '李四2', NULL, NULL, NULL, 00000000001);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (12, 2, 1, 'Python(A)', 00000000000000000050, NULL, NULL, '2022-10-06 22:31:36', 'student', '李四2', '2022-10-06 22:33:12', 'teacher', '王五', 00000000001);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (13, 2, 5, 'C#程序设计', 00000000000000000090, NULL, NULL, '2022-10-06 22:31:46', 'student', '李四2', '2022-10-06 22:33:06', 'teacher', '王五', 00000000001);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (14, 2, 6, 'C语言程序设计(A)', 00000000000000000088, NULL, NULL, '2022-10-06 22:31:52', 'student', '李四2', '2022-10-06 22:34:12', 'teacher', '王五', 00000000001);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (15, 2, 1, 'Python(A)', 00000000000000000022, 00, 0000000004, '2022-10-06 22:47:11', 'student', '李四2', '2022-10-07 08:48:25', 'teacher', '王五', 00000000001);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (16, 2, 2, '数据库系统', 00000000000000000099, 00, 0000000002, '2022-10-06 22:47:13', 'student', '李四2', '2022-10-07 08:48:30', 'teacher', '王五', 00000000000);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (18, 2, 1, 'Python(A)', NULL, NULL, 0000000005, '2022-10-07 10:01:24', 'student', '李四2', NULL, NULL, NULL, 00000000000);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (19, 2, 5, 'C#程序设计', NULL, NULL, 0000000002, '2022-10-07 10:01:53', 'student', '李四2', NULL, NULL, NULL, 00000000000);
INSERT INTO `tb_result` (`id`, `user_id`, `course_id`, `course_name`, `result`, `is_reset`, `graduate`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (20, 7, 1, 'Python(A)', NULL, NULL, 0000000005, '2022-10-07 10:04:03', 'yier', 'yier', NULL, NULL, NULL, 00000000000);
COMMIT;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `role_sort` int(10) NOT NULL COMMENT '显示顺序',
  `role_type` int(1) NOT NULL DEFAULT '1' COMMENT '角色类型（0：内置  1：自定义）',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常 1：删除）',
  PRIMARY KEY (`id`,`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tb_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_role` (`id`, `role_name`, `role_code`, `role_sort`, `role_type`, `data_scope`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, '管理员', 'ROLE_ADMIN', 1, 0, NULL, 1, '2022-02-10 18:17:21', 'admin', 'admin', '2022-09-06 15:55:14', 'admin', '管理员', 0);
INSERT INTO `tb_role` (`id`, `role_name`, `role_code`, `role_sort`, `role_type`, `data_scope`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (2, '学生用户', 'ROLE_STUDENT', 2, 0, NULL, 1, '2021-12-16 15:28:10', 'admin', 'admin', '2022-10-07 09:39:21', 'admin', '管理员', 0);
INSERT INTO `tb_role` (`id`, `role_name`, `role_code`, `role_sort`, `role_type`, `data_scope`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (3, '计算机老师', 'ROLE_TEACHER', 3, 1, NULL, 1, '2021-12-16 15:27:37', 'admin', 'admin', '2022-09-06 17:10:53', 'admin', '管理员', 0);
INSERT INTO `tb_role` (`id`, `role_name`, `role_code`, `role_sort`, `role_type`, `data_scope`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (4, '数学老师', 'ROLE_SX', 4, 1, NULL, 1, '2021-12-16 15:27:37', 'admin', 'admin', '2022-10-07 00:46:38', 'admin', '管理员', 0);
INSERT INTO `tb_role` (`id`, `role_name`, `role_code`, `role_sort`, `role_type`, `data_scope`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (5, '生物老师', 'ROLE_SW', 5, 1, NULL, 1, '2022-09-06 16:03:54', 'admin', '管理员', '2022-09-29 15:43:07', 'admin', '管理员', 0);
INSERT INTO `tb_role` (`id`, `role_name`, `role_code`, `role_sort`, `role_type`, `data_scope`, `status`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (6, '其他测试', 'ROLE_OTHER', 5, 1, NULL, 1, '2022-09-06 16:03:54', 'admin', '管理员', '2022-09-29 15:43:07', 'admin', '管理员', 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_dept`;
CREATE TABLE `tb_role_dept` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of tb_role_dept
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_role_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_user`;
CREATE TABLE `tb_role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of tb_role_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (1, 1, 1, '管理员');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (2, 2, 2, '学生');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (3, 3, 3, '计算机老师');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (4, 4, 4, '数学老师');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (5, 5, 1, '管理员');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (6, 5, 3, '计算机老师');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (7, 6, 4, '数学老师');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (8, 7, 2, '学生');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (9, 8, 2, '学生');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (10, 33, 2, '学生');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (11, 34, 2, '学生');
INSERT INTO `tb_role_user` (`id`, `user_id`, `role_id`, `role_name`) VALUES (15, 24, 3, '计算机老师');
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '性别，1男，2女',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码，加密存储',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册手机号',
  `is_mobile_check` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '手机是否验证 （0否  1是）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册邮箱',
  `is_email_check` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '邮箱是否检测（0否  1是）',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `head_pic` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像地址',
  `account_balance` decimal(10,0) DEFAULT NULL COMMENT '账户余额',
  `address` varchar(50) DEFAULT NULL COMMENT '联系地址',
  `user_level` int(11) DEFAULT NULL COMMENT '会员等级',
  `points` int(11) DEFAULT NULL COMMENT '积分',
  `experience_value` int(11) DEFAULT NULL COMMENT '经验值',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后登录IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人标识',
  `create_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `update_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人标识',
  `update_by_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人姓名',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常，1：删除）',
  PRIMARY KEY (`id`,`username`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE COMMENT '用户名唯一',
  UNIQUE KEY `phone` (`phone`) USING BTREE COMMENT '手机唯一',
  UNIQUE KEY `email` (`email`) USING BTREE COMMENT '邮箱唯一'
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (1, '管理员', '管理员', '0', 'admin', 'admin123', 101, 1, '1232', '0', '223@112.com', '0', '1111', NULL, NULL, '山西2', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:02:51', 'admin', 'admin', '2022-12-18 19:02:51', 'admin', '管理员', 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (2, '李', '李四2', '0', 'test', 'admin123', 103, 1, '13811112222', '0', '11@22.com', '0', '4445', NULL, NULL, '2223', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:02:55', 'admin', 'admin', '2022-12-18 19:02:55', 'student', '李四2', 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (3, '王', '王五', '0', 'admin2', 'admin123', 104, 1, NULL, '0', NULL, '0', NULL, NULL, NULL, '44', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:02:57', 'admin', 'admin', '2022-12-18 19:02:57', NULL, NULL, 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (4, '赵', '赵柳', '0', 'zhaoliu', '123123', 105, 1, NULL, '0', NULL, '0', NULL, NULL, NULL, 'ook', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:00', 'admin', 'admin', '2022-12-18 19:03:00', NULL, NULL, 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (5, '孙', '孙琪', '0', 'sunqi', '123123', 101, 1, '321', '0', '123', '0', '222', NULL, NULL, '552', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:04', 'admin', 'admin', '2022-12-18 19:03:04', 'admin', '管理员', 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (6, '贾', '贾某', '0', 'jiayi', '123123', 101, 1, NULL, '0', NULL, '0', NULL, NULL, NULL, '666', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:06', 'admin', 'admin', '2022-12-18 19:03:06', NULL, NULL, 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (7, 'yi', 'yier', '0', 'yier', 'admin123', 101, 1, '22', '0', '31', '0', '11111', NULL, NULL, '5454', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:09', 'admin', 'admin', '2022-12-18 19:03:09', 'xb', 'xb', 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (8, '张', '张三', '1', 'zhangsan', '123123', 101, 1, '1233', '0', '321a@qq.', '0', '140321199509090099', NULL, NULL, '2222', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:11', 'admin', 'admin', '2022-12-18 19:03:11', 'xb', 'xb', 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (33, 'dd', '测试3', '1', 'baba', '123123', 101, 1, '22222', '0', '22@22.cc', '0', '22111', NULL, NULL, '3322', NULL, NULL, NULL, NULL, NULL, NULL, '2021-12-28 01:13:02', 'admin', 'admin', '2021-12-28 01:13:02', 'xb', 'xb', 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (34, '久久', '久久5', '1', '99', '123123', 103, 1, '13811111', '0', '2@2.co', '0', NULL, NULL, NULL, '3222', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:14', 'admin', 'admin', '2022-12-18 19:03:14', 'admin', '管理员', 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (36, '成成', '成成', '0', 'chenchen', '123123', 103, 1, NULL, '0', NULL, '0', NULL, NULL, NULL, '丹丹的d', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:17', 'admin', 'admin', '2022-12-18 19:03:17', NULL, NULL, 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (37, '撒爸', '撒爸爸', '1', 'bdbd', '123123', 103, 1, NULL, '0', NULL, '0', NULL, NULL, NULL, '丹丹的', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:20', 'admin', 'admin', '2022-12-18 19:03:20', NULL, NULL, 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (38, '大司马', '大司马', '1', 'ddds', 'admin123', 103, 1, NULL, '0', NULL, '0', NULL, NULL, NULL, '丹丹的', NULL, NULL, NULL, NULL, NULL, NULL, '2022-12-18 19:03:23', 'admin', 'admin', '2022-12-18 19:03:23', NULL, NULL, 0);
INSERT INTO `tb_user` (`id`, `nick_name`, `name`, `sex`, `username`, `password`, `dept_id`, `status`, `phone`, `is_mobile_check`, `email`, `is_email_check`, `qq`, `head_pic`, `account_balance`, `address`, `user_level`, `points`, `experience_value`, `birthday`, `last_login_ip`, `last_login_time`, `create_time`, `create_by`, `create_by_name`, `update_time`, `update_by`, `update_by_name`, `del_flag`) VALUES (42, '测试', '测试', '1', 'ceshi', 'admin123', 103, 1, NULL, '0', NULL, '0', NULL, NULL, NULL, '北京', NULL, NULL, NULL, NULL, NULL, NULL, '2022-08-15 22:40:50', 'wangwu', 'admin', '2022-08-15 22:40:50', NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_user_post
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_post`;
CREATE TABLE `tb_user_post` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of tb_user_post
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
