create table hibernate_sequence (
    next_val bigint
);
insert into hibernate_sequence values (1);
insert into hibernate_sequence values (1);

create table post (
    id serial not null primary key,
    name varchar(64),
    url text unique not null
);
CREATE UNIQUE INDEX post_id_uindex ON public.post (id);

create table vessel (
    id serial not null primary key,
    mmsi varchar(9) unique not null,
    country varchar(255),
    length int,
    width int,
    draught float,
    call_sign varchar(16),
    type_code int,
    type varchar(255),
    type_detail varchar(255),
    name varchar(255)
);
CREATE UNIQUE INDEX vessel_id_uindex ON public.vessel (id);

create table vessel_route (
    id serial not null primary key,
    lat float not null,
    lon float not null,
    cog float not null,
    sog float not null,
    true_heading int not null,
    eta varchar(13),
    rot float not null,
    nav_state_code int not null,
    nav_state varchar(64),
    destination varchar(255),
    msg_time varchar(13)
);
CREATE UNIQUE INDEX vessel_route_id_uindex ON public.vessel_route (id);


