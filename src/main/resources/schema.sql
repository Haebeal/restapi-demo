drop table if exists item;

create table item (
    id integer primary key,
    item_name text
);

insert into item(id, item_name) values (1, '大豆');
insert into item(id, item_name) values (2, '小豆');
insert into item(id, item_name) values (3, '納豆');
