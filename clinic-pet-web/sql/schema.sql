
-- for test client db
create table client(
uid serial primary key,
login varchar(200),
email varchar(200)
);


create table pet(
uid serial primary key,
client_id int not null references client(uid),
nick varchar(200)
);


/*create table adress(
uid serial primary key,
street varchar(200),
city varchar(200)
);


create table client(
uid serial primary key,
name varchar(200),
adress int not null references adress(uid)
);


create table pet_class(
uid serial primary key,
class_name varchar(200)
);


create table pet(
uid serial primary key,
nick varchar(200),
client_id int not null references client(uid)
);


insert into adress (street, city) values('PITERBURG', 'LENINSKAYA');
insert into adress (street, city) values('MOSKOW', 'PETROGRANDKAYA');

insert into client (name, adress) values('petr','1');

insert into pet(client_id, nick) values(1,'sparky');

insert into pet(client_id, nick) values(1,'boby');

select pet.nick, client.name, adress.street, adress.city from pet as pet
	join client as client on(client.uid=pet.client_id)
	join adress on(adress.uid=client.adress);*/
