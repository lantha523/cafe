-- 建立資料庫
-- drop database  if exists `orginal_cafe`;
-- create database  if not exists `orginal_cafe`;

-- ===========member table================
drop table if exists `member`;
create table member 
(mem_no int(10) not null auto_increment comment '會員編號', 
	mem_username varchar(255) not null comment '會員帳號',
	mem_password varchar(255) not null comment '會員密碼', 
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

insert into `member`
(`mem_username`,`mem_password`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values 
('choco','8825252','黃淵和','0988877788','john323@gmail.com','台北市遼寧街22號','2000-01-01','img','1','2021-01-01','2021-01-01');
insert into `member`
(`mem_username`,`mem_password`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values 
('lalao','2225252','黃錢和','0988877218','john123@gmail.com','台北市遼寧街21號','2000-01-01','img','1','2021-01-01','2021-01-01');
insert into `member`
(`mem_username`,`mem_password`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values 
('babap','4445666','淵平和','0939877328','john567@gmail.com','台北市遼寧街23號','2000-01-01','img','1','2021-01-01','2021-01-01');
insert into `member`
(`mem_username`,`mem_password`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values 
('bfbfq','2234234','蔣淵和','0988777788','john321@gmail.com','台北市遼寧街24號','2000-01-01','img','1','2021-01-01','2021-01-01');
insert into `member`
(`mem_username`,`mem_password`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values 
('fgfgr','1234456','王和平','0988333788','john678@gmail.com','台北市遼寧街25號','2000-01-01','img','1','2021-01-01','2021-01-01');

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

-- 餐點狀態 0:下架 1:上架

insert into `dish` 
(`dish_img`,`dish_name`,`dish_price`,`dish_note`,`dish_status`,`dish_quantity`,`cr_date`,`md_date`,`dish_type`) values 
('https://images.pexels.com/photos/9700895/pexels-photo-9700895.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500','推薦菜單1','250','好吃的燉飯','1','100','1990-07-04','1990-07-04','推薦菜色');

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

insert into `ord`
(`mem_no`,`ord_time`,`ord_price`,`ord_status`,`cr_date`,`md_date`) values 
('1','2021-01-01','300','1','2021-01-01','2021-01-01');

-- 訂單狀態 0:未確認 1:已付款 2:已取餐  3:取消 


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

insert into `contact_us`
(`con_name`,`con_email`,`con_phone`,`con_msg`,`con_time`) values 
('john','hj32@gmail.com','0928777654','人外有人天，天外有天，相愛容易，相處極端，認為總是它人錯在先，互不信，互乜不容，如此日子茫然啊！','2021-01-01');




-- ===========order_list table================
drop table if exists `order_list`;
create table order_list (ord_no int(10) not null comment '訂單編號', 
	dish_no int(10) not null comment '餐點編號', 
	ord_quantity int(10) not null comment '訂單數量', 
	ord_priceeach int(10) comment '每件商品價格', 
	primary key (ord_no, dish_no));

insert into `order_list`
(`ord_no`,`dish_no`,`ord_quantity`,`ord_priceeach`) values 
('1','1','1','300');





-- ===========administrator table================
drop table if exists `administrator`;
create table administrator 
(adm_no int(10) not null auto_increment comment '管理者編號', 
	adm_account varchar(255) not null comment '管理者帳戶', 
	adm_pasword varchar(255) not null comment '管理者密碼', 
	adm_name varchar(255) not null comment '管理者姓名', 
	adm_address varchar(255) not null comment '管理者地址', 
	adm_phone varchar(255) not null comment '管理者電話', 
	adm_level varchar(255) not null comment '管理者階級', 
	adm_status tinyint(3) not null comment '管理者狀態', 
	primary key (adm_no));

insert into `administrator`
(`adm_account`,`adm_pasword`,`adm_name`,`adm_address`,`adm_phone`,`adm_level`,`adm_status`) values 
('king','8785657','金','台北市富錦街20號','0908766678','最高管理者','1');

-- 管理者狀態 0:未啟用 1:已啟用

-- ===========adm_function table================
drop table if exists `adm_function`;
create table adm_function 
(function_no int(10) not null auto_increment, 
	function_detail varchar(255) not null, 
	primary key (function_no));

insert into `adm_function`
(`function_detail`) values 
('系統信件發送');


-- ===========adm＿authority table================
drop table if exists `adm＿authority`;
create table `adm＿authority` 
(adm_no int(10) not null comment '管理者編號', 
	function_no int(10) not null comment '功能編號', 
	primary key (adm_no, function_no));

insert into `adm＿authority`
(`adm_no`,`function_no`) values 
('1','1');




alter table `adm＿authority` add constraint `adm＿authority_ibfk_1` foreign key (adm_no) references administrator (adm_no);
alter table `adm＿authority` add constraint `adm＿authority_ibfk_2` foreign key (function_no) references adm_function (function_no);
alter table `ord` add constraint ord_ibfk_1 foreign key (mem_no) references member (mem_no);
alter table order_list add constraint order_list_ibfk_1 foreign key (ord_no) references `ord` (ord_no);
alter table order_list add constraint order_list_ibfk_2 foreign key (dish_no) references dish (dish_no);




