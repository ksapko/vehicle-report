create table client
(
    id              serial primary key,
    firstName       varchar(255) not null,
    lastName        varchar(255) not null,
    email           varchar(255) not null
);

drop table client;

select *from client;

insert into client values (1, 'kasia', 'nowak', 'knowak@wp.pl');