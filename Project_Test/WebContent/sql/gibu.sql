create table gibu_write(
	do_idx int primary key,
	do_id varchar(20) not null,
	do_coment varchar(30) not null,
	do_date date not null,
	do_status varchar(10) not null
);

insert into gibu_write values(1,'bbada','빠른처리부탁드립니다',20220208,'yes');