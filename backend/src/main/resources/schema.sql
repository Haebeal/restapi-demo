drop table if exists item;

create table item (
    id serial not null primary key,
    item_name text
);
