create table if not exists persons (
    id integer not null generated always as identity (increment 1 start 1 minvalue 1),
    name character varying not null,
    birth_date date,
    age integer,
    constraint pk_persons primary key (id)
)