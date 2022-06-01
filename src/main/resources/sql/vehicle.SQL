create table vehicle (
                             id              serial primary key,
                             brand           varchar(255) not null,
                             model           varchar(255) not null,
                             color           varchar(255) not null,
                             production_Year int          not null,
                             fuel_Type       varchar(255) not null,
                             client_id int not null,
                             constraint fk_vehicle_client foreign key(client_id) references vehicle(id)
);


drop table vehicle;

select *from vehicle;

insert into vehicle (brand, model, color, production_Year, fuel_Type,client_id) values ('seat', 'ibiza', 'niebieski', '0000', 'gaz',1);
