create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert hibernate_sequence values (1);
insert hibernate_sequence values (1);

create table ais (
    id serial not null primary key,
    channelId int not null,
    channel varchar(64)
) engine=MyISAM;
CREATE UNIQUE INDEX ais_id_uindex ON public.ais (id);

create table vessel (
    id serial not null primary key,
    mmsi varchar(9) not null,
    imo varchar(7),
    eta varchar(13),
    country varchar(255),
    length int,
    width int,
    draught float,
    callSign varchar(16),
    typeCode int,
    type varchar(255),
    typeDetail varchar(255),
    name varchar(255)
) engine=MyISAM;
CREATE UNIQUE INDEX vessel_id_uindex ON public.vessel (id);

create table vessel_position (
    id serial not null primary key,
    lat float not null,
    lon float not null,
    cog float not null,
    sog float not null,
    trueHeading int not null,
    rot float not null,
    navStateCode int not null,
    navState varchar(64),
    destination varchar(255),
    msgTime varchar(13)
) engine=MyISAM;
CREATE UNIQUE INDEX vessel_position_id_uindex ON public.vessel_position (id);
