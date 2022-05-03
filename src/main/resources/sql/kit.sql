create table kit
(
    id   int auto_increment,
    name varchar(255) not null,
    data mediumtext   not null,
    constraint kit_pk
        primary key (id)
);