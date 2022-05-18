create table vehicle
(
    id              serial primary key,
    brand           varchar(255) not null,
    model           varchar(255) not null,
    color           varchar(255) not null,
    production_Year int          not null,
    fuel_Type       varchar(255) not null
);

drop table vehicle;

select *from vehicle;

insert into vehicle values (5, 'seat', 'ibiza', 'niebieski', '0000', 'gaz');