create table client
(
    id              serial primary key,
    firstname      varchar(255) not null,
    lastName        varchar(255) not null,
    email           varchar(255) not null
);

drop table client;

select *from client;

insert into client (firstname, lastName, email) values ('alicja', 'sawczuk', 'asaw@wp.pl');