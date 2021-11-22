

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


insert into `dish` 
(`dish_img`,`dish_name`,`dish_price`,`dish_note`,`dish_status`,`dish_quantity`,`cr_date`,`md_date`,`dish_type`) values 
('https://images.pexels.com/photos/9700895/pexels-photo-9700895.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500','推薦菜單1','250','好吃的燉飯','1','100','1990-07-04','1990-07-04','推薦菜色');

insert into `ord`
(`mem_no`,`ord_time`,`ord_price`,`ord_status`,`cr_date`,`md_date`) values 
('1','2021-01-01','300','1','2021-01-01','2021-01-01');


insert into `contact_us`
(`con_name`,`con_email`,`con_phone`,`con_msg`,`con_time`) values 
('john','hj32@gmail.com','0928777654','人外有人天，天外有天，相愛容易，相處極端，認為總是它人錯在先，互不信，互乜不容，如此日子茫然啊！','2021-01-01');


insert into `order_list`
(`ord_no`,`dish_no`,`ord_quantity`,`ord_priceeach`) values 
('1','1','1','300');



insert into `administrator`
(`adm_account`,`adm_pasword`,`adm_name`,`adm_address`,`adm_phone`,`adm_level`,`adm_status`) values 
('king','8785657','金','台北市富錦街20號','0908766678','最高管理者','1');


insert into `adm_function`
(`function_detail`) values 
('系統信件發送');

insert into `adm_authority`
(`adm_authority_no`,`adm_no`,`function_no`) values 
('1','1','1');


