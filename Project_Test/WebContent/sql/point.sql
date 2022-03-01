create table point(
	p_idx int primary key,
	p_id varchar(10) not null,
	p_point int not null,
	p_status varchar(10) not null,
	p_date date not null
);

insert into point values(1,'bbada',100,'in',20220208);
insert into point values(2,'bbada',100,'out',20220208);