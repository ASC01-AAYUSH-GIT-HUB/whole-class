-- Active: 1753160406093@@127.0.0.1@1433@MyFriendsDB
drop database MyFriendsDB;

CREATE DATABASE MyFriendsDB;
use MyFriendsDB;

CREATE TABLE Friends(
	first_name varchar(100) not null,
	friend_no int primary key,
	email varchar(100),
	last_name varchar(100)
);

insert into Friends(first_name,friend_no,email,last_name) values('aayush',1,'aayush.prasad@mail.com','prasad');
insert into Friends(first_name,friend_no,email,last_name) values('aryan',2,'aryan.praksh@mail.com','praksh');
insert into Friends(first_name,friend_no,email,last_name) values('anubhav',3,'anubhav.anand@mail.com','anand');
insert into Friends(first_name,friend_no,email,last_name) values('shekhar',4,'shekhar.suman@mail.com','suman');
insert into Friends(first_name,friend_no,email,last_name) values('aditya',5,'aditya.anand@mail.com','anand');

select * from Friends;

update Friends set email='praksh.dada@mail.com' where friend_no=2; 
delete from Friends where friend_no=4;
delete from Friends where last_name='anand';
select first_name as Name,last_name as Surname from Friends
where last_name='anand';
