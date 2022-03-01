create table board(
	bo_num int primary key,
	bo_name varchar(20) not null,
	bo_pass varchar(15) not null,
	bo_subject varchar(50) not null,
	bo_content varchar(2000) not null,
	bo_re_ref int not null,
	bo_re_lev int not null,
	bo_re_seq int not null,
	bo_readcount int default 0,
	bd_date date not null
);

