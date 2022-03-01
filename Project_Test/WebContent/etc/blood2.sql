create table blood_j_plusa(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_j_minusa(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_j_plusb(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_j_minusb(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_j_pluso(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_j_minuso(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_j_plusab(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_j_minusab(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_plusa(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_minusa(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_plusb(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_minusb(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_pluso(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_minuso(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_plusab(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);
create table blood_h_minusab(
	id varchar(10) primary key,
	name varchar(10) not null,
	bloodtype varchar(20) not null,
	cardnum int
);

insert into blood_j_plusa values('bbada','김도엽','a',0322123456);
insert into blood_j_minusa values('java','홍길동','a',0122654321);
insert into blood_j_plusb values('tutu','강감찬','b',0222456123);
insert into blood_j_minusb values('yuyu','김유신','b',0122321654);
insert into blood_j_pluso values('sisi','김시민','o',0222121212);
insert into blood_j_minuso values('lyly','유성룡','o',0122232323);
insert into blood_j_plusab values('huhu','허준','ab',0422343434);
insert into blood_j_minusab values('lili','이순신','ab',0422454545);

insert into blood_h_plusa values('bbada','김도엽','a',0322123456);
insert into blood_h_minusa values('java','홍길동','a',0122654321);
insert into blood_h_plusb values('tutu','강감찬','b',0222456123);
insert into blood_h_minusb values('yuyu','김유신','b',0122321654);
insert into blood_h_pluso values('sisi','김시민','o',0222121212);
insert into blood_h_minuso values('lyly','유성룡','o',0122232323);
insert into blood_h_plusab values('huhu','허준','ab',0422343434);
insert into blood_h_minusab values('lili','이순신','ab',0422454545);