create table request_write(
	re_idx int primary key,
	re_id varchar(20) not null,
	re_locate varchar(50) not null,
	re_content varchar(1000) not null,
	re_date date not null,
	re_write_date date not null,
	re_status varchar(10) not null,
	re_count int not null,
	re_btype char(5) not null,
	re_blood char(5) not null,
	re_RH char(5) not null
);

insert into request_write values(1,'bbada','영남대학교병원','수술때문에 혈액 요청드립니다',20220208,20220208,'yes',1,'j','a','plus');