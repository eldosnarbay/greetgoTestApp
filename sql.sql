create database school;
use school;

create table groups(
	id int primary key auto_increment,
	name varchar(5)
);
insert into groups(name) values('11a');


create table pupils(
	id int primary key auto_increment,
	fname varchar(50),
	lname varchar(50),
	birthdate datetime,
	groupId int references groups(id)
);

insert into pupils(fname, lname, birthdate, group_id) values ('John', 'Doe', '2008-08-08', 1);