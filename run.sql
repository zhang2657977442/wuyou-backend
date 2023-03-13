DROP TABLE IF EXISTS industry;
CREATE TABLE industry(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    name VARCHAR(50) NOT NULL   COMMENT '名称' ,
    icon VARCHAR(255)    COMMENT '图标地址' ,
    p_id CHAR(8)    COMMENT '父级id' ,
    enable_status BOOLEAN NOT NULL  DEFAULT true COMMENT '启用状态' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    update_time DOUBLE(13,3) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '行业信息';

DROP TABLE IF EXISTS position;
CREATE TABLE position(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    name VARCHAR(50) NOT NULL   COMMENT '名称' ,
    icon VARCHAR(255)    COMMENT '图标地址' ,
    p_id CHAR(8)    COMMENT '父级id' ,
    enable_status BOOLEAN NOT NULL  DEFAULT true COMMENT '启用状态' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    update_time DOUBLE(13,3) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '职位信息';

DROP TABLE IF EXISTS welfare;
CREATE TABLE welfare(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    name VARCHAR(50) NOT NULL   COMMENT '名称' ,
    icon VARCHAR(255)    COMMENT '图标地址' ,
    enable_status BOOLEAN NOT NULL  DEFAULT true COMMENT '启用状态' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    update_time DOUBLE(13,3) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '福利信息';

DROP TABLE IF EXISTS user;
CREATE TABLE user(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    open_id VARCHAR(255)    COMMENT '微信用户id' ,
    username VARCHAR(50) NOT NULL   COMMENT '用户名' ,
    password VARCHAR(255)    COMMENT '密码' ,
    mobile CHAR(11)    COMMENT '手机号码' ,
    avatar VARCHAR(255) NOT NULL  DEFAULT 'https://pan.whiteones.cn/d/PicGo/wuyou/avatar_def.jpg' COMMENT '头像地址' ,
    role SMALLINT(1) NOT NULL  DEFAULT false COMMENT '用户角色' ,
    company_id CHAR(8)    COMMENT '公司id' ,
    enable_status BOOLEAN NOT NULL  DEFAULT true COMMENT '账号状态' ,
    auth_id CHAR(8)    COMMENT '认证id' ,
    register_date DOUBLE(13,3) NOT NULL   COMMENT '注册时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户信息';

DROP TABLE IF EXISTS company;
CREATE TABLE company(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    name VARCHAR(50) NOT NULL   COMMENT '简称' ,
    full_name VARCHAR(50) NOT NULL   COMMENT '全称' ,
    logo VARCHAR(255) NOT NULL  DEFAULT 'https://pan.whiteones.cn/d/PicGo/wuyou/company_icon.png' COMMENT 'logo地址' ,
    industry_id CHAR(8) NOT NULL   COMMENT '行业id' ,
    nature SMALLINT(1) NOT NULL   COMMENT '公司性质' ,
    staff_size VARCHAR(255) NOT NULL   COMMENT '公司规模' ,
    introduce VARCHAR(500) NOT NULL   COMMENT '公司简介' ,
    address VARCHAR(255) NOT NULL   COMMENT '地址详情' ,
    auth_id CHAR(8)    COMMENT '认证id' ,
    work_time VARCHAR(255) NOT NULL   COMMENT '工作时间' ,
    rest_time VARCHAR(255) NOT NULL   COMMENT '休息时间' ,
    work_overtime VARCHAR(255) NOT NULL   COMMENT '加班情况' ,
    enable_status BOOLEAN NOT NULL  DEFAULT false COMMENT '生效状态' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    update_time DOUBLE(13,3) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '公司信息';

DROP TABLE IF EXISTS job;
CREATE TABLE job(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    company_id CHAR(8) NOT NULL   COMMENT '公司id' ,
    post_id CHAR(8) NOT NULL   COMMENT '职位id' ,
    enable_status BOOLEAN NOT NULL  DEFAULT false COMMENT '生效状态' ,
    exp_require SMALLINT(1) NOT NULL   COMMENT '经验要求' ,
    min_education SMALLINT(1)    COMMENT '最低学历' ,
    salary SMALLINT(1) NOT NULL   COMMENT '薪资范围' ,
    job_type SMALLINT(1) NOT NULL   COMMENT '工作类型' ,
    skill VARCHAR(500) NOT NULL   COMMENT '技能要求' ,
    create_time DOUBLE NOT NULL   COMMENT '创建时间' ,
    update_time DOUBLE NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '工作招聘信息';

DROP TABLE IF EXISTS company_welfare;
CREATE TABLE company_welfare(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    company_id CHAR(8) NOT NULL   COMMENT '公司id' ,
    welfare_id CHAR(8) NOT NULL   COMMENT '福利id' ,
    enable_status BOOLEAN NOT NULL  DEFAULT true COMMENT '生效状态' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    update_time DOUBLE(13,3) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '公司福利信息';

DROP TABLE IF EXISTS user_auth;
CREATE TABLE user_auth(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    identity CHAR(18) NOT NULL   COMMENT '身份证号码' ,
    auth_status SMALLINT(1) NOT NULL  DEFAULT 1 COMMENT '认证状态' ,
    failure_reason VARCHAR(255)    COMMENT '失败原因' ,
    submit_time DOUBLE(13,3) NOT NULL   COMMENT '提交时间' ,
    finished_time DOUBLE(13,3) NOT NULL   COMMENT '审核时间' ,
    PRIMARY KEY (id)
)  COMMENT = '实名认证信息';

DROP TABLE IF EXISTS company_auth;
CREATE TABLE company_auth(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    legal_person VARCHAR(50) NOT NULL   COMMENT '法人姓名' ,
    credit_code CHAR(18) NOT NULL   COMMENT '统一社会信用代码' ,
    auth_status SMALLINT(1) NOT NULL  DEFAULT 1 COMMENT '认证状态' ,
    failure_reason VARCHAR(255)    COMMENT '失败原因' ,
    submit_time DOUBLE(13,3) NOT NULL   COMMENT '提交时间' ,
    finished_time DOUBLE(13,3) NOT NULL   COMMENT '审核时间' ,
    PRIMARY KEY (id)
)  COMMENT = '企业认证信息';

DROP TABLE IF EXISTS resume;
CREATE TABLE resume(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    user_id CHAR(8) NOT NULL   COMMENT '用户id' ,
    birthday VARCHAR(255)    COMMENT '出生日期' ,
    name VARCHAR(50) NOT NULL   COMMENT '姓名' ,
    gender SMALLINT(1) NOT NULL   COMMENT '性别' ,
    education SMALLINT(1)    COMMENT '最高学历' ,
    experience SMALLINT(1)    COMMENT '工作经验' ,
    skill VARCHAR(500)    COMMENT '个人特长' ,
    job_status SMALLINT(1)    COMMENT '求职状态' ,
    salary SMALLINT(1)    COMMENT '期望薪资' ,
    post_id CHAR(8)    COMMENT '期望职位' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    PRIMARY KEY (id)
)  COMMENT = '简历信息';

DROP TABLE IF EXISTS apply;
CREATE TABLE apply(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    user_id CHAR(8) NOT NULL   COMMENT '用户id' ,
    data_id CHAR(8) NOT NULL   COMMENT '数据id' ,
    type SMALLINT(1) NOT NULL   COMMENT '应聘类型' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    PRIMARY KEY (id)
)  COMMENT = '应聘信息';

DROP TABLE IF EXISTS browse;
CREATE TABLE browse(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    user_id CHAR(8) NOT NULL   COMMENT '用户id' ,
    data_id CHAR(8) NOT NULL   COMMENT '数据id' ,
    type SMALLINT(1) NOT NULL   COMMENT '浏览类型' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    PRIMARY KEY (id)
)  COMMENT = '浏览信息';

DROP TABLE IF EXISTS collect;
CREATE TABLE collect(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    user_id CHAR(8) NOT NULL   COMMENT '用户id' ,
    data_id CHAR(8) NOT NULL   COMMENT '数据id' ,
    type SMALLINT(1) NOT NULL   COMMENT '收藏类型' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    PRIMARY KEY (id)
)  COMMENT = '收藏信息';

DROP TABLE IF EXISTS cms;
CREATE TABLE cms(
    id CHAR(8) NOT NULL   COMMENT '主键' ,
    text VARCHAR(1000) NOT NULL   COMMENT '内容' ,
    type SMALLINT(1) NOT NULL   COMMENT '内容类型' ,
    create_time DOUBLE(13,3) NOT NULL   COMMENT '创建时间' ,
    PRIMARY KEY (id)
)  COMMENT = '系统内容信息';

INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0031a478', '互联网产品经理', NULL, '843c32b8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0041a9ff', '信贷专员', NULL, 'a5793137', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('01f76575', '物业经理', NULL, '988bb6e1', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('03dcc359', '工程造价', NULL, '1ea00499', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('05127dcd', '服装导购', NULL, '62446ed8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('08d63267', '美工', NULL, '8229aae5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('091cefbb', '化妆师', NULL, '92e9bde7', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0bd1ac7a', '制片人', NULL, '0c906321', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0c906321', '影视媒体', NULL, '8316c048', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0de239ce', '客户经理', NULL, 'a5793137', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0e3c74a3', '地产中介', NULL, '62446e8d', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('11cecdf0', '职业培训', NULL, 'da622418', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1498de76', '教师', NULL, 'fd96b7ef', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('14ec0dee', '总裁/CEO', NULL, '1b9967bc', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1576abb0', 'Java开发', NULL, '62446f6c', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('16621e35', '自动化测试', NULL, '62446fc8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('17cf767b', '教学管理', NULL, 'dc872f8f', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('192f415e', '美容师', NULL, '92e9bde7', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1a230e57', '助教', NULL, 'fd96b7ef', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1a79380b', '证券/基金', NULL, 'c990d22a', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1b06b828', '汽车维修', NULL, '29c64e83', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1b9967bc', '高级管理职位', NULL, 'd23ebd1d', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1bd54b2a', '客服专员', NULL, '6a8386c9', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1c9a03ee', '汽车配件销售', NULL, '62446ef2', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1db89baa', '运营/客服', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1ea00499', '工程管理', NULL, '3079d866', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('1edb5ee8', '其他产品经理', NULL, 'e1a80b48', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('22c5cd44', '用户研究经理', NULL, 'f9c83146', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('23ea540b', '保险理赔', NULL, '61f6f6a7', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2781705f', '摄影/摄像', NULL, '0c906321', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('29c64e83', '汽车服务', NULL, 'b4f90626', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2a1b26bc', '副总裁/VP', NULL, '1b9967bc', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2b33739d', '全栈工程师', NULL, '62446f6c', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2b3eea33', '地产招投标', NULL, '6c43e275', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2cd730be', '广告销售', NULL, '62446efb', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2e236363', '律师顾问', NULL, '62446f53', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2f0049fc', '基金经理', NULL, '1a79380b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('30054462', '测试工程师', NULL, '62446fc8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('3079d866', '房地产/建筑', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('309454bb', '直播运营', NULL, 'a5335b5d', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('35b656bb', '宠物美容', NULL, 'afe9d3e5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('36b9e041', '电工', NULL, '47371b78', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('37e0814e', '硬件产品经理', NULL, 'e1a80b48', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('38d56bf6', '洗车工', NULL, '29c64e83', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('38dcddbc', '系统策划', NULL, 'bbeb2063', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('43a280a6', '量化研究员', NULL, '1a79380b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('45d1a305', '后勤', NULL, '62446f49', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('45eea2e6', '物业管理员', NULL, '988bb6e1', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('47371b78', '建筑装修工人', NULL, '3079d866', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('4997c261', '地产项目管理', NULL, '6c43e275', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('4d76fa8a', '法务经理/主管', NULL, '62446f53', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('4dedcd7c', '保姆', NULL, 'fd0cf55b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('53d43c0c', '游泳教练', NULL, 'c859a788', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('55f21175', '行政经理/主管', NULL, '62446f49', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('5cebe21b', '保安', NULL, '988bb6e1', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('5d62c161', '发型师', NULL, '92e9bde7', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('61f6f6a7', '保险', NULL, 'c990d22a', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623c31db', '销售', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623c31eb', '销售行政/商务', NULL, '623c31db', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623f0bc3', '人力资源助理', NULL, '62446f20', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446cd3', '人事/行政/法务', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446e8d', '房地产销售/招商', NULL, '623c31db', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446ed8', '服务业销售', NULL, '623c31db', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446ef2', '汽车销售', NULL, '623c31db', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446efb', '广告/会展销售', NULL, '623c31db', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446f20', '人力资源', NULL, '62446cd3', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446f49', '行政', NULL, '62446cd3', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446f53', '法务', NULL, '62446cd3', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446f62', 'IT互联网技术', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446f6c', '后端开发', NULL, '62446f62', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446fa5', '移动开发', NULL, '62446f62', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('62446fc8', '测试', NULL, '62446f62', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('624c525f', '生产制造', NULL, '66c4d212', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('624c5275', '包装', NULL, '624c525f', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('624c52a7', '喷漆', NULL, '624c525f', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('624c52ae', '打磨', NULL, '624c525f', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6253ebb0', '平车', NULL, '624c525f', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6298d022', '家具设计', NULL, 'c226c2ce', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('66c4d212', '市场', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('674594bf', '培训师', NULL, '11cecdf0', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('68379503', '游戏策划', NULL, 'bbeb2063', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6a8386c9', '客服', NULL, '1db89baa', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6bd6a810', 'IOS开发', NULL, '62446fa5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6c43e275', '房地产规划开发', NULL, '3079d866', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6d57231b', '材料员', NULL, '1ea00499', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('711064f7', '商务专员', NULL, '623c31eb', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('716d4eb8', '会展活动销售', NULL, '62446efb', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('73e4f70e', 'HRBP', NULL, '62446f20', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7518ee4b', '网络推广', NULL, 'f5db9f59', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7594c1af', '平面设计', NULL, '8229aae5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7756b5f9', '客服主管', NULL, '6a8386c9', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7961491d', '会议活动销售', NULL, '62446efb', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7d09114f', '广告审核', NULL, 'e59ab60b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8090d56c', '销售助理', NULL, '623c31eb', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8229aae5', '视觉/交互设计', NULL, 'faa146c1', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('826f9cee', '家教', NULL, 'fd96b7ef', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8316c048', '影视/传媒', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('843c32b8', '产品', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('85a52d1e', '联合创始人', NULL, '1b9967bc', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('86e0d02d', '教务管理', NULL, 'dc872f8f', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('870f8ed6', '媒介投放', NULL, 'e59ab60b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('874283f7', '市场营销', NULL, 'f5db9f59', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('87ce080d', '月嫂', NULL, 'fd0cf55b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('88565d2d', '宠物医生', NULL, 'afe9d3e5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('89ab90ad', '保险精算师', NULL, '61f6f6a7', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8d154d3f', '主播', NULL, '0c906321', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8f9f2b9e', '测绘/测量', NULL, '1ea00499', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('92e9bde7', '美容美发', NULL, 'b4f90626', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('953fb7e2', '保洁', NULL, 'fd0cf55b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('971b310a', '施工员', NULL, '1ea00499', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('988bb6e1', '物业管理', NULL, '3079d866', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('9bcfc81d', '产品助理', NULL, '0031a478', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a2b27f23', '广告制作', NULL, 'e59ab60b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a5335b5d', '内容运营', NULL, '1db89baa', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a5793137', '银行', NULL, 'c990d22a', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a679eaa6', '舞蹈老师', NULL, 'c859a788', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a93e1e32', '金融产品经理', NULL, 'e1a80b48', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a94bf91a', '品类运营', NULL, 'e3abbc60', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('aaab8388', '新媒体运营', NULL, 'a5335b5d', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('ab8e935f', '商务渠道', NULL, 'f5db9f59', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('ace108a0', 'AI产品经理', NULL, '0031a478', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('ae8f614c', '游戏制作人', NULL, 'bbeb2063', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('afcd5205', '人力资源经理', NULL, '62446f20', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('afe9d3e5', '宠物服务', NULL, 'b4f90626', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('b4f90626', '生活服务', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('b63a62fe', '设计师助理', NULL, '8229aae5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('b690ffed', '行政专员/助理', NULL, '62446f49', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('b849efd5', '美容顾问', NULL, '62446ed8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('bbeb2063', '游戏策划/制作', NULL, '843c32b8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('bc579739', '法务专员/助理', NULL, '62446f53', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('bd55ba6c', '工业设计', NULL, 'c226c2ce', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('bffeebee', '健身教练', NULL, 'c859a788', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c01fba46', '证券交易员', NULL, '1a79380b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c1ae8bc6', 'UI设计师', NULL, '8229aae5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c226c2ce', '工业/家居设计', NULL, 'faa146c1', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c7fe0fd2', '淘宝运营', NULL, 'e3abbc60', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c84b74da', 'C++开发', NULL, '62446f6c', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c859a788', '运动健身', NULL, 'b4f90626', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c862cfe7', '木工', NULL, '47371b78', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('c990d22a', '金融', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('cb969e6f', '置业顾问', NULL, '62446e8d', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('cfa822d2', '绿化工', NULL, '988bb6e1', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d1077fba', 'Android开发', NULL, '62446fa5', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d23ebd1d', '高级管理', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d2f694c0', '产品经理', NULL, '0031a478', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d34e3b45', '市场推广', NULL, 'f5db9f59', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d7e3e847', '油漆工', NULL, '47371b78', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d905d312', '焊工', NULL, '47371b78', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d9771485', '人力资源总监', NULL, '62446f20', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d9a8aa58', '柜员', NULL, 'a5793137', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('da622418', '教育培训', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('dc872f8f', '教育行政', NULL, 'da622418', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('dc957ec2', '室内设计', NULL, 'c226c2ce', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('def04b44', '天猫运营', NULL, 'e3abbc60', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e1a80b48', '其他产品职位', NULL, '843c32b8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e3abbc60', '电商运营', NULL, '1db89baa', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e4bcc3df', '珠宝销售', NULL, '62446ed8', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e552569f', '京东运营', NULL, 'e3abbc60', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e59ab60b', '广告', NULL, '8316c048', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e8b4e8f2', '拓展培训', NULL, '11cecdf0', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f0ed0a88', '区域负责人', NULL, '1b9967bc', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f4ca753b', '售后客服', NULL, '6a8386c9', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f59da600', '护工', NULL, 'fd0cf55b', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f5db9f59', '市场/营销', NULL, '66c4d212', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f8af6459', 'Python开发', NULL, '62446f6c', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f8ebd59b', '汽车销售', NULL, '62446ef2', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f9c83146', '用户研究', NULL, '66c4d212', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('faa146c1', '设计', NULL, NULL, 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('fac46be4', '用户研究员', NULL, 'f9c83146', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('fd0cf55b', '家政保洁', NULL, 'b4f90626', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('fd11e5c3', '汽车美容', NULL, '29c64e83', 1, 1648112091.084, 1648112091.084);
INSERT INTO `position`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('fd96b7ef', '教师', NULL, 'da622418', 1, 1648112091.084, 1648112091.084);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0348d077', '证券/期货', NULL, '623bf114', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('07ad4cb8', '汽车生产', NULL, 'a06cf718', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0c7db0e5', '银行', NULL, '623bf114', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0e2e40c7', '家政服务', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('0fb1a275', '学术/科研', NULL, '623bf123', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('14863727', '电力/热力/燃气', NULL, '30072166', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2087b7a7', '船舶/航空', NULL, 'fba7613b', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('25ea9049', '新零售', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2935fe25', '检测/认证', NULL, '31c735e5', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2d83ad29', '回收/维修', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('2d8df75a', '新能源', NULL, '30072166', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('30072166', '能源/化工/环保', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('31c735e5', '专业服务', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('4225fe3d', '环保', NULL, '30072166', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('473face2', '生活服务', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('4c8a363c', '工艺品/收藏品', NULL, '67596dc6', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('52c96d04', '日化', NULL, '67596dc6', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('56d5dab9', '汽车零部件', NULL, 'a06cf718', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('5771afdb', '制药', NULL, '92e589dc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('583d3b26', '服装/纺织/皮革', NULL, '67596dc6', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('5a538ce0', '咨询', NULL, '31c735e5', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('5b4efcfc', '房地产/建筑', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('5d1160fe', '服务业', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('5dec1ee7', '翻译', NULL, '31c735e5', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bcdbb', '互联网/IT/电子/通信', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bd63e', '电子商务', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bdb4e', '广告/传媒/文化/体育', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bde06', '游戏', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf090', '广播/影视', NULL, '623bdb4e', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf0a8', '文化/体育/娱乐', NULL, '623bdb4e', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf0bd', '数据服务', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf0cf', '保险', NULL, '623bf114', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf0e2', '学前教育', NULL, '623bf123', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf0f7', '广告/公关/会展', NULL, '623bdb4e', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf108', '新闻/出版', NULL, '623bdb4e', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf114', '金融', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('623bf123', '教育培训', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('624467d5', '消费电子', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('633a95d6', '培训机构', NULL, '623bf123', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('63acdc4b', '珠宝/首饰', NULL, '67596dc6', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('66aaec7f', '互联网金融', NULL, '623bf114', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('67596dc6', '消费品', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6aa6cc68', '其他专业服务', NULL, '31c735e5', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6c80258f', '装饰装修', NULL, '5b4efcfc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('6fce60d6', '石油/石化', NULL, '30072166', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('71d2521f', '机械设备/机电/重工', NULL, 'fba7613b', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('753cc505', '矿产/地质', NULL, '30072166', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('75c94000', '交通/运输', NULL, 'fd7afdc0', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('778cd48f', '仪器仪表/工业自动化', NULL, 'fba7613b', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7959133b', '建筑设计', NULL, '5b4efcfc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('797c5533', '基金', NULL, '623bf114', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7c29b6f5', '餐饮', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7d540415', '企业服务', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('7dd687d5', '物流/仓储', NULL, 'fd7afdc0', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('83e1fed4', '旅游', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('86727741', '婚庆/摄影', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8a98c54d', '美容/美发', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8a998c99', '印刷/包装', NULL, 'fba7613b', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8f02efb5', '化工', NULL, '30072166', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('8fb99e64', '家具/家电', NULL, '67596dc6', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('92e589dc', '制药/医疗', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('9f03ebeb', '采掘/冶炼', NULL, '30072166', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a0672532', '智能硬件', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a06cf718', '汽车', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a0a132a8', '医疗/护理/卫生', NULL, '92e589dc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a3d018b3', '食品/饮料/烟酒', NULL, '67596dc6', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a78b81b3', '宠物服务', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('a7b24103', '酒店', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('aaeed93c', '社交网络', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('b851d42b', '人力资源服务', NULL, '31c735e5', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('be66ec3d', '批发/零售', NULL, 'fd7afdc0', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('cc44ed46', '原材料/模具', NULL, 'fba7613b', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('cd86d30b', '法律', NULL, '31c735e5', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d2d7a657', '信托', NULL, '623bf114', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d337102e', '休闲/娱乐', NULL, '5d1160fe', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d79437bc', '医疗设备/器械', NULL, '92e589dc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('d85bc82d', 'O2O', NULL, '623bcdbb', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('dadbd91a', '地产中介', NULL, '5b4efcfc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e2086800', '建材', NULL, '5b4efcfc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e2ca4f9f', '4S店/后市场', NULL, 'a06cf718', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e50bc59d', '房地产开发', NULL, '5b4efcfc', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('e90545b4', '玩具/礼品', NULL, '67596dc6', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f40183e9', '院校', NULL, '623bf123', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('f9aedbc9', '贸易/进出口', NULL, 'fd7afdc0', 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('fba7613b', '机械/制造', NULL, NULL, 1, 1648650196.781, 1648650196.781);
INSERT INTO `industry`(`id`, `name`, `icon`, `p_id`, `enable_status`, `create_time`, `update_time`) VALUES ('fd7afdc0', '交通/物流/贸易/零售', NULL, NULL, 1, 1648650196.781, 1648650196.781);
