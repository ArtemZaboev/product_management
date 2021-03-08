create database product_management;
create user p_user with encrypted password '1234';
grant all privileges on database product_management to p_user;
create table if not exists languages
(
    id   bigserial primary key not null,
    name varchar(255)          not null

);
create table if not exists currencies
(
    id   bigserial primary key not null,
    name varchar(255)          not null

);
create table if not exists products
(
    id         bigserial primary key not null,
    create_data timestamptz           not null,
    update_data timestamptz           not null

);
create table if not exists prices
(
    product_id  bigint      not null,
    currency_id bigint      not null,
    value       numeric(12) not null,
    primary key (product_id, currency_id),
    foreign key (product_id) references products (id) on DELETE cascade on UPDATE cascade,
    foreign key (currency_id) references currencies (id) on DELETE cascade on UPDATE cascade

);

create table if not exists name_description
(
    product_id  bigint       not null,
    language_id bigint       not null,
    name        varchar(255) not null,
    description varchar(255) not null,
    primary key (product_id, language_id),
    foreign key (product_id) references products (id) on DELETE cascade on UPDATE cascade,
    foreign key (language_id) references languages (id) on DELETE cascade on UPDATE cascade

);

