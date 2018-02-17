drop database vote;
create database vote;
use vote;
-- show variables like 'SQL_SAFE_UPDATES';
-- SET SQL_SAFE_UPDATES = 0; 修改下数据库模式
-- MySql运行在safe-updates模式下，该模式会导致非主键条件下无法执行update或者delete命令

-- set foreign_key_check=1;
-- Mysql中如果表和表之间建立的外键约束，则无法删除表及修改表结构。
-- 解决方法是在Mysql中取消外键约束:  SET FOREIGN_KEY_CHECKS=0;  
-- 然后将原来表的数据导出到sql语句，重新创建此表后，再把数据使用sql导入，
-- 然后再设置外键约束: SET FOREIGN_KEY_CHECKS=1; 
-- 
DROP TABLE IF EXISTS `v_project`;
create table v_project (
	vp_id varchar(64) comment '工程表id',					-- 主表
    project_title varchar(32) not null comment '项目标题',
    project_description varchar(300) comment '项目描述',
    project_start_time datetime comment '项目起始时间',
	project_end_time datetime  comment '项目结束时间',
    project_location varchar(32) comment '项目发起地点',
    project_special varchar(10) comment '项目分类：公开项目or特定群组项目',
    g_id varchar(64)  comment '群组id，',
    isGroup varchar(4) default '0' comment '如果为1，则为群组关系，要维护user grouop。如果为0，则为公开关系(默认)',
    isMulti  varchar(4) default '0' comment '如果为0，则为单选(默认)。如果为1，则为多选，要维护有多少张选票',
    isAnonymous  varchar(4) default '0' comment '如果为0，则为非匿名(默认)。如果为1，则为匿名',
    primary key(vp_id) 
   );

DROP TABLE IF EXISTS `v_user`;
create table v_user(											-- 主表
	vu_id varchar(64) comment '用户表id--对应着link的tbl_useruserId',
    user_name varchar(32) comment '用户名',
    user_phone varchar(32) comment '用户手机号',
    user_email varchar(32) comment '用户email',
    user_picture varchar(128) comment '头像',
    primary key(vu_id)
);
-- insert into v_user values("12","ew","we","we","https://www.bingolink.biz/uam/ui/upload?action=download&filepath=Avatar/c8bebb2e-ab8c-45fd-8658-ae845587f53a.jpg");

DROP TABLE IF EXISTS `v_option_type`;
create table v_option_type(
	vot_id varchar(64) comment '选项形式表id',					-- 主表
    option_type int comment '选项形式 1:有结果 2：有简介、结果的 3：有简介、图片、结果的',
    primary key(vot_id)
); 

DROP TABLE IF EXISTS `v_group`;
create table v_group(										-- 副表
	vg_id varchar(64) comment '群组表id',
    p_id varchar(64) comment '工程id',
    group_name varchar(32) comment '群组名字',
    group_leader varchar(64) comment '创建者',
    up_id varchar(64) comment '用户_project id',-- 副表
    primary key(vg_id),
    constraint group_project_fk foreign key(p_id) references v_project(vp_id)-- -- 用户创建插入数据，依据v_project表
);

-- 
DROP TABLE IF EXISTS `v_user_project`;
create table v_user_project(								-- 副表
	vup_id varchar(64) comment '用户工程表id',
    u_id varchar(64) comment '用户id',
    p_id varchar(64) comment '工程id',
    participation int  comment '用户参与情况',
    is_create_item int  comment '是否可以新增项目',
    primary key(vup_id),
	constraint userproject_user_fk foreign key(u_id) references v_user(vu_id),-- 用户创建插入数据，依据v_user表
    constraint userProject_project_fk foreign key(p_id) references v_project(vp_id)-- 用户创建插入数据，依据v_project表
);


DROP TABLE IF EXISTS `v_option`;
create table v_option(
	vo_id varchar(64) comment '项目选项表id',						-- 副表
	p_id varchar(64) comment '项目id',		--  -------p_id
	ot_id varchar(64) comment '选项形式id',
    primary key(vo_id),
    constraint option_optionType_fk foreign key(ot_id) references v_option_type(vot_id),-- 用户创建插入数据，依据v_option_type表
    constraint option_Project_fk foreign key(p_id) references v_project(vp_id)-- 用户创建插入数据，依据v_Project表
    
);


DROP TABLE IF EXISTS `v_option_introduction_three`;
-- 此选项是公司奖项、地点选择类选项模板，没有再链接到结果表
create table v_option_introduction_three(								-- 副表
	voi_id varchar(64) comment '选项详情表id  简介、图片4、结果：是否',
    title varchar(32) comment '选项标题', 
    content varchar(64) comment '选项简介',
    content2 varchar(64) comment '选项简介',
    content3 varchar(64) comment '选项简介',
    picture1 mediumblob comment '选项图片',
    picture2 mediumblob comment '选项图片',
    picture3 mediumblob comment '选项图片',
    picture4 mediumblob comment '选项图片',
    or_id varchar(64) comment '结果id',
    ot_id varchar(64) comment '选项形式id',
    o_id varchar(64) comment '项目选项表id',
    primary key(voi_id),
	constraint optionIntroductionThree_optionType_fk foreign key(ot_id) references v_option_type(vot_id),-- 用户创建插入数据，依据v_option_type表
	constraint optionIntroductionThree_option_fk foreign key(o_id) references v_option(vo_id)-- 用户创建插入数据，依据v_option_type表

);


DROP TABLE IF EXISTS `v_option_introduction_two`;
-- 评分类
create table v_option_introduction_two(								-- 副表
	voi_id varchar(64) comment '选项详情表id  简介、结果：等级',
	title varchar(64) comment '选项简介',
    or_id varchar(64) comment '结果id',
    ot_id varchar(64) comment '选项形式id',
    o_id varchar(64) comment '项目选项表id',
    primary key(voi_id),
	constraint optionIntroductionTwo_optionType_fk foreign key(ot_id) references v_option_type(vot_id),-- 用户创建插入数据，依据v_option_type表
	constraint optionIntroductionTwo_option_fk foreign key(o_id) references v_option(vo_id)-- 用户创建插入数据，依据v_option_type表
);



DROP TABLE IF EXISTS `v_option_introduction_one`;
create table v_option_introduction_one(								-- 副表
	voi_id varchar(64) comment '选项详情表id',
	or_id varchar(64) comment '结果id',
    ot_id varchar(64) comment '选项形式id',
    o_id varchar(64) comment '项目选项表id',
    primary key(voi_id),
	constraint optionIntroductionOne_optionType_fk foreign key(ot_id) references v_option_type(vot_id),-- 用户创建插入数据，依据v_option_type表
	constraint optionIntroductionOne_option_fk foreign key(o_id) references v_option(vo_id)-- 用户创建插入数据，依据v_option_type表

);


DROP TABLE IF EXISTS `v_option_result`;
create table v_option_result(									-- 副表
	vor_id varchar(64) comment '选项结果表id ',
    result varchar(64) comment '选项结果结果',
	u_id varchar(64) comment '用户id',
    oi_id varchar(64) comment '选项详情id',--  
    primary key(vor_id),
     constraint optionResult_user_fk foreign key(u_id) references v_user(vu_id)-- 用户创建插入数据，依据v_user表,考虑到报名类表单，可重选
	-- constraint optionResult_option_fk foreign key(ot_id) references v_option(vo_id)-- 用户创建插入数据，依据v_option_*表
);


DROP TABLE IF EXISTS `tbl_user`;
create table tbl_user(									-- 副表
	id int,
    name varchar(32) ,
    sex varchar(32) 
   );
   insert into tbl_user values(1 ,'tiger' ,'女');
   insert into tbl_user values(2 ,'bob' ,'男');
   insert into tbl_user values(3 ,'snake' ,'女');

-- 每种情况-project表都有
-- 根据选项表的选项形式字段-来选择组合，分门别类
-- ----------------
-- 选项形式表初始化


-- -----------------------------------------------------------
-- 评分类：v_project、v_user、v_option_type、v_option、v_user_project、v_option_introduction_three     	v_option_introduction_two、v_option_result
insert into v_option_type (vot_id,option_type) values('pingfen',1);
-- 地点类：v_project、v_user、v_option_type、v_option、v_user_project                                  	v_option_introduction_three 、v_option_result
insert into v_option_type (vot_id,option_type) values('didian',2);
-- 举个手：v_project、v_user、v_option_type、v_option、v_user_project、v_option_introduction_three     	v_option_result
insert into v_option_type (vot_id,option_type) values('jushou',3);
-- 奖项类：v_project、v_user、v_option_type、v_option、v_user_project、v_option_introduction_three    	v_option_result
insert into v_option_type (vot_id,option_type) values('jiangxiang',4);
-- 单选：v_project、v_user、v_option_type、v_option、v_user_project										v_option_introduction_two、v_option_result
insert into v_option_type (vot_id,option_type) values('danxuan',5);
-- 多选：v_project、v_user、v_option_type、v_option、v_user_project										v_option_introduction_two、v_option_result 
insert into v_option_type (vot_id,option_type) values('duoxuan',6);
-- 单选、多选：多个result对应一个v_option_introduction_two
-- 

-- 用户信息初始化
insert into v_user(vu_id,user_name,user_phone,user_email)values('gy15765593421','甘逸','15765593421','849061491@qq.com');
insert into v_user(vu_id,user_name,user_phone,user_email)values('hlr18717480330','何立然','18717480330','helr@bingosoft.net');
insert into v_user(vu_id,user_name,user_phone,user_email)values('ck18819345930','初坤','18819345930','chukun@bingosoft.net');
insert into v_user(vu_id,user_name,user_phone,user_email)values('wsz18829345923','王世展','18829345923','wangshizhan@bingosoft.net');
insert into v_user(vu_id,user_name,user_phone,user_email)values('wlx18820429391','王立夏','18820429391','wanglx@bingosoft.net');
insert into v_user(vu_id,user_name,user_phone,user_email)values('yzf15625787114','颜志丰','15625787114','yanzf@bingosoft.net');


-- 初始化组群，id为0的，默认为公开投票, leader 字段在公开投票中没用
insert into v_project(vp_id,project_title)values('0','0');
insert into v_group(vg_id,p_id,group_name,group_leader,up_id) values('0','0','0','0','0');

