create table case_information
(
    id                 integer      not null,
    objective_element  varchar(255) not null,
    subjective_element varchar(255) not null,
    primary key (id)
);
create table criminal_case
(
    id                  integer      not null,
    case_time           bigint       not null,
    name                varchar(255) not null,
    case_information_id integer,
    procuratorate_id    integer      not null,
    primary key (id)
);
create table procurator
(
    id         integer not null,
--     age        integer not null,
--     birthday   timestamp,
--     experience integer not null,
--     id_number  varchar(255),
    name       varchar(255),
--     sex        varchar(255),
    primary key (id)
);
create table procuratorate
(
    id   integer     not null,
    name varchar(50) not null,
    primary key (id)
);
create table procuratorate_procurators
(
    procuratorate_id integer not null,
    procurators_id   integer not null
);
alter table procuratorate
    add constraint UK_ec3a9dinq8c8yg3isw4216urg unique (name);
alter table procuratorate_procurators
    add constraint UK_avfmrw88o20jiuri8l75f4f37 unique (procurators_id);
alter table criminal_case
    add constraint FKqgv7nkowcko6baqoau5ra235a foreign key (case_information_id) references case_information;
alter table criminal_case
    add constraint FKnlvv52hcrep9s3vevtv6dl4te foreign key (procuratorate_id) references procuratorate;
alter table procuratorate_procurators
    add constraint FK62g9jle5jl2jps60aimrp5oy7 foreign key (procurators_id) references procurator;
alter table procuratorate_procurators
    add constraint FK2215vsjflb61v4kgtpt14buxq foreign key (procuratorate_id) references procuratorate;