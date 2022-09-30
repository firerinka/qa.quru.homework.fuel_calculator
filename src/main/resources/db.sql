create table car
(
    id    serial
        constraint car_pk
            primary key,
    name  varchar,
    fuel_economy double precision
);

alter table car
    owner to postgres;

create unique index car_id_uindex
    on car (id);

create table track
(
    id    serial
        constraint track_pk
            primary key,
    name  varchar,
    laps integer,
    lap_distance integer
);

alter table track
    owner to postgres;

create unique index track_id_uindex
    on track (id);

INSERT INTO car (name , fuel_economy )
    values ('Ferrari' , 85.5);
INSERT INTO car (name , fuel_economy )
    values ('Mercedes' , 80.0);
INSERT INTO track (name , laps, lap_distance )
    values ('Spa' , 25, 6976);
INSERT INTO track (name , laps, lap_distance )
    values ('Nurburgring' , 30, 5148);