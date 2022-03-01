create table member(
	m_id varchar(20) primary key,
	m_name varchar(15) not null,
	m_passwd varchar(15) not null,
	m_blood char(5) not null,
	m_addr varchar(50) not null,
	m_phone varchar(15) not null,
	m_gender varchar(5) not null,
	m_email varchar(20) not null
);

insert into member values('bbada','김도엽','1q2w3e4r','a','대구광역시 달서구 뭐시기동 1-1','01023990498','남','bbada0420@naver.com');