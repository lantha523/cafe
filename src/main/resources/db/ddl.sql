-- 建立資料庫
-- drop database  if exists `orginal_cafe`;
-- create database  if not exists `orginal_cafe`;

-- ===========member table================
drop table if exists `member`;
create table member 
(mem_no int(10) not null auto_increment comment '會員編號',
	mem_name varchar(255) not null comment '會員姓名', 
	mem_phone varchar(255) not null comment '會員手機號碼',  
	mem_email varchar(255) not null comment '會員電子信箱', 
	mem_address varchar(255) not null comment '會員地址', 
	mem_birth date not null comment '會員生日', 
	mem_img varchar(255) comment '會員圖片', 
	mem_status tinyint(3) not null comment '會員狀態', 
	cr_date datetime not null comment '建立日期', 
	md_date datetime not null comment '修改日期', 
	primary key (mem_no));
-- 會員狀態 0:未啟用 1:已啟用

-- ===========dish table================
drop table if exists `dish`;
create table `dish` 
(dish_no int(10) not null auto_increment comment '餐點編號', 
	dish_img varchar(255) comment '餐點圖片', 
	dish_name varchar(255) not null comment '餐點名稱', 
	dish_price int(10) not null comment '餐點價格', 
	dish_note varchar(255) not null comment '餐點信息', 
	dish_status tinyint(3) comment '餐點狀態', 
	dish_quantity int(10) not null comment '餐點數量', 
	cr_date datetime not null comment '創建日期', 
	md_date datetime not null comment '修改日期', 
	dish_type varchar(255) not null comment '餐點種類', 
	primary key (dish_no));

-- 餐點狀態 0:下架 1:上架 2:售完

-- ===========order table================
drop table if exists `ord`;
create table `ord` 
(ord_no int(10) not null auto_increment comment '訂單編號', 
	mem_no int(10) not null comment '會員編號', 
	ord_time datetime not null comment '訂單時間', 
	ord_price int(10) not null comment '訂單總金額', 
	ord_status tinyint(3) comment '訂單狀態', 
	cr_date datetime not null comment '創建日期', 
	md_date datetime not null comment '修改日期', 
	primary key (ord_no));



-- ===========contact_us table================
drop table if exists `contact_us`;
create table contact_us 
(con_no int(10) not null auto_increment comment '留言板編號', 
	con_name varchar(255) not null comment '留言者', 
	con_email varchar(255) not null comment '留言者email', 
	con_phone varchar(255) not null comment '留言者電話', 
	con_msg text not null comment '留言者信息', 
	con_time datetime not null comment '留言時間', 
	primary key (con_no));



-- ===========order_list table================
drop table if exists `order_list`;
create table order_list (ord_no int(10) not null comment '訂單編號', 
	dish_no int(10) not null comment '餐點編號', 
	ord_quantity int(10) not null comment '訂單數量', 
	ord_priceeach int(10) comment '每件商品價格', 
	primary key (ord_no, dish_no));




-- ===========administrator table================
drop table if exists `administrator`;
create table administrator 
(adm_no int(10) not null auto_increment comment '管理者編號',
	adm_name varchar(255) not null comment '管理者姓名', 
	adm_address varchar(255) not null comment '管理者地址', 
	adm_phone varchar(255) not null comment '管理者電話', 
	adm_level varchar(255) not null comment '管理者階級', 
	adm_status tinyint(3) not null comment '管理者狀態', 
	primary key (adm_no));


--
-- Table structure for table `users` 會員帳密
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         username varchar(255) NOT NULL COMMENT '會員帳號',
                         password char(68) NOT NULL COMMENT '會員密碼',
                         enabled tinyint(1) NOT NULL COMMENT '會員資格',
                         mem_no int(10) COMMENT '會員編號',
                         adm_no int(10) COMMENT '管理員編號',
                         PRIMARY KEY (username)  ,
                         CONSTRAINT users_memfk_1 FOREIGN KEY (mem_no) REFERENCES member (mem_no),
                         CONSTRAINT users_admfk_2 FOREIGN KEY (adm_no) REFERENCES administrator (adm_no)
);

-- ===========adm_function table================
drop table if exists `adm_function`;
create table adm_function 
(function_no int(10) not null auto_increment, 
	function_detail varchar(255) not null, 
	primary key (function_no));


-- ===========adm_authority table================
drop table if exists `adm_authority`;
create table `adm_authority` 
(
	adm_authority_no int(10) not null auto_increment comment '管理員權限號碼',
	adm_no int(10) not null comment '管理者編號', 
	function_no int(10) not null comment '功能編號', 
	primary key (adm_authority_no));




alter table `adm_authority` add constraint `adm_authority_ibfk_1` foreign key (adm_no) references administrator (adm_no);
alter table `adm_authority` add constraint `adm_authority_ibfk_2` foreign key (function_no) references adm_function (function_no);
alter table `ord` add constraint ord_ibfk_1 foreign key (mem_no) references member (mem_no);
alter table order_list add constraint order_list_ibfk_1 foreign key (ord_no) references `ord` (ord_no);
alter table order_list add constraint order_list_ibfk_2 foreign key (dish_no) references dish (dish_no);



