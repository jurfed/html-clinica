create table client(
name varchar(200) primary key
);

create table pet(
uid serial primary key,
name varchar(200),
clientname varchar(200) not null references client(name) on update cascade,
type varchar(200)
);



insert into client values('Pit');
insert into client values('John');

insert into pet(name, clientname, type) values ('kissi','Pit','cat');
insert into pet(name, clientname, type) values ('bobbi','John', 'dog');


update client set name='John1' where name ='John';
update pet set name='kuku' where clientname='John'
