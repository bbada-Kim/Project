create table bloodcount(
	bc_idx int primary key,
	bc_cnum int not null,
	bc_btype char(5) not null,
	bc_blood char(5) not null,
	bc_RH char(5) not null,
	bc_status varchar(15) not null
);
insert into bloodcount values(1,null,1,'0322123456','card.jpg','j','a','p','jin.jpg','ing');
insert into bloodcount values(2,1,null,'0122654321','card.jpg','j','a','m','jin.jpg','no');
insert into bloodcount values(3,null,2,'0222456123','card.jpg','j','b','p','jin.jpg','yes');
insert into bloodcount values(4,2,null,'0122321654','card.jpg','j','b','m','jin.jpg','no');
insert into bloodcount values(5,null,3,'0222121212','card.jpg','j','ab','p','jin.jpg','ing');
insert into bloodcount values(6,3,null,'0122232323','card.jpg','j','ab','m','jin.jpg','yes');
insert into bloodcount values(7,null,4,'0422343434','card.jpg','j','o','p','jin.jpg','yes');
insert into bloodcount values(8,4,null,'0422454545','card.jpg','j','o','m','jin.jpg','no');


insert into bloodcount values(9,null,5,'0322565656','card.jpg','h','a','p','jin.jpg','yes');
insert into bloodcount values(10,5,null,'0122676767','card.jpg','h','a','m','jin.jpg','yes');
insert into bloodcount values(11,null,6,'0122787878','card.jpg','h','b','p','jin.jpg','yes');
insert into bloodcount values(12,6,null,'0522898989','card.jpg','h','b','m','jin.jpg','yes');
insert into bloodcount values(13,null,7,'0122909090','card.jpg','h','ab','p','jin.jpg','yes');
insert into bloodcount values(14,7,null,'0222101010','card.jpg','h','ab','m','jin.jpg','yes');
insert into bloodcount values(15,null,8,'0622010101','card.jpg','h','o','p','jin.jpg','yes');
insert into bloodcount values(16,8,null,'0622111222','card.jpg','h','o','m','jin.jpg','yes');
insert into bloodcount values(17,null,9,'0111111111','card.jpg','j','a','p','jin.jpg','yes');
insert into bloodcount values(18,9,null,'0222222222','card.jpg','h','o','m','jin.jpg','ing');

insert into bloodcount values(17,0111111111,'j','a','p','com');
insert into bloodcount values(18,0222222222,'h','o','m','com');

insert into bloodcount values(1,0322123456,'j','a','p','ing');
insert into bloodcount values(2,0122654321,'j','a','m','com');
insert into bloodcount values(3,0222456123,'j','b','p','com');
insert into bloodcount values(4,0122321654,'j','b','m','com');
insert into bloodcount values(5,0222121212,'j','ab','p','com');
insert into bloodcount values(6,0122232323,'j','ab','m','com');
insert into bloodcount values(7,0422343434,'j','o','p','com');
insert into bloodcount values(8,0422454545,'j','o','m','com');

insert into bloodcount values(9,0322565656,'h','a','p','com');
insert into bloodcount values(10,0122676767,'h','a','m','com');
insert into bloodcount values(11,0122787878,'h','b','p','com');
insert into bloodcount values(12,0522898989,'h','b','m','com');
insert into bloodcount values(13,0122909090,'h','ab','p','com');
insert into bloodcount values(14,0222101010,'h','ab','m','com');
insert into bloodcount values(15,0622010101,'h','o','p','com');
insert into bloodcount values(16,0622111222,'h','o','m','com');