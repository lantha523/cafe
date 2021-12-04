

insert into `member`
(`mem_no`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,
 `cr_date`,`md_date`) values
(1,'黃淵和','0988877788','john323@gmail.com','台北市遼寧街22號','2000-01-01','img','1','2021-01-01','2021-01-01');
insert into `member`
(`mem_no`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values
(2,'黃錢和','0988877218','john123@gmail.com','台北市遼寧街21號','2000-01-01','img','1','2021-01-01',
 '2021-01-01');
insert into `member`
(`mem_no`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values
(3,'淵平和','0939877328','john567@gmail.com','台北市遼寧街23號','2000-01-01','img','1','2021-01-01',
 '2021-01-01');
insert into `member`
(`mem_no`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values
(4,'蔣淵和','0988777788','john321@gmail.com','台北市遼寧街24號','2000-01-01','img','1','2021-01-01',
 '2021-01-01');
insert into `member`
(`mem_no`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values
(5,'金','0908766678','john321@gmail.com','台北市富錦街20號','2000-01-01','img','1','2021-01-01',
 '2021-01-01');
insert into `member`
(`mem_no`,`mem_name`,`mem_phone`,`mem_email`,`mem_address`,`mem_birth`,`mem_img`,`mem_status`,`cr_date`,`md_date`) values
(6,'王和平','0988333788','john321@gmail.com','台北市遼寧街25號','2000-01-01','img','1','2021-01-01',
 '2021-01-01');

insert into `dish` 
(`dish_img`,`dish_name`,`dish_price`,`dish_note`,`dish_status`,`dish_quantity`,`cr_date`,`md_date`,`dish_type`) values 
('https://images.pexels.com/photos/9700895/pexels-photo-9700895.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500','推薦菜單1','250','好吃的燉飯','1','100','1990-07-04','1990-07-04','RECOMMEND');

insert into `ord`
(`mem_no`,`ord_time`,`ord_price`,`ord_status`,`cr_date`,`md_date`) values 
(1,'2021-01-01','300','1','2021-01-01','2021-01-01');


insert into `contact_us`
(`con_name`,`con_email`,`con_phone`,`con_msg`,`con_time`) values 
('john','hj32@gmail.com','0928777654','人外有人天，天外有天，相愛容易，相處極端，認為總是它人錯在先，互不信，互乜不容，如此日子茫然啊！','2021-01-01');


insert into `order_list`
(`ord_no`,`dish_no`,`ord_quantity`,`ord_priceeach`) values 
(1,1,1,300);



insert into `administrator`
(`adm_no`,`adm_name`,`adm_address`,`adm_phone`,`adm_level`,`adm_status`) values
(1,'金','台北市富錦街20號','0908766678','master','1'),
(2,'王和平','台北市遼寧街25號','0988333788','servant','1');


INSERT INTO `users`
VALUES
('choco','{bcrypt}$2a$10$456OJnARlH/LKc3ez.UB5.DiJGQGWcdWVtGr9DOkSz9mn/YJ8VK0i',1,1,null), -- 8825252
('lalao','{bcrypt}$2a$10$FPX2J7oCq.hk3rBC3OF0LuBbWqrwHlCoq0cN0ceOWDuK94paE.Mgi',1,2,null), -- 2225252
('babap','{bcrypt}$2a$10$GowEM0bEKA6wwxziGhudxO3F0ohr80brnFM83F1vyvIlyVBRAHX3y',1,3,null), -- 4445666
('bfbfq','{bcrypt}$2a$10$Rf4OXR44DfposMEyVuNo1e9Vk6TIqrtJeU1h98oKyLILMJFi7HvRO',1,4,null), -- 2234234
('fgfgr','{bcrypt}$2a$10$PjcxkdlyY8xHw..WDqcCxOxuHJR1KTYSIx0VY2c7m3QeEtOAcRo/W',1,5,2), -- 1234456
('king','{bcrypt}$2a$10$1EffUPfU0dVSG.fe.IhMBu/pjG1n9u7xzUqXV/7MPeZg6pSBt4LeG',1,6,1); -- 8785657


insert into `adm_function`
(`function_no`,`function_detail`) values
(1,'菜單管理'),
(2,'訂單管理'),
(3,'會員管理'),
(4,'管理員管理');

insert into `adm_authority`
(`adm_authority_no`,`adm_no`,`function_no`) values 
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,2,1);