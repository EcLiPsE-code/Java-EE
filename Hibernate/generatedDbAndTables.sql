create database library;
use library;

create table readers(
	id int primary key auto_increment,
    name varchar(50) not null,
    surname varchar(50) not null,
    lastName varchar(50) not null,
    age int not null
);

create table orders(
	id int primary key auto_increment,
    dateOfIssue Date not null,
    countDay int not null,
	dateOfcompletion Date not null,
    typeOfIssue boolean not null,
    readerId int not null,
    foreign key (readerId) references readers (id) on delete cascade
);

create table books(
	id int primary key auto_increment, 
    name varchar(50) not null,
    author varchar(50) not null,
    countPages int not null,
    countCopies int not null,
    orderId int,
    foreign key (orderId) references orders (id) on delete cascade 
);

