create database codecool_shop;
create schema public;

create table suppliers
(
    id serial,
    name text,
    products text
);

create unique index suppliers_id_uindex
    on suppliers (id);

alter table suppliers
    add constraint suppliers_pk
        primary key (id);

create table product_categories
(
    id serial,
    name text,
    department text,
    description text
);

create unique index product_categories_id_uindex
    on product_categories (id);

alter table product_categories
    add constraint product_categories_pk
        primary key (id);

create table products
(
    id serial,
    name text,
    price int,
    description text,
    category text,
    supplier text
);

create unique index products_id_uindex
    on products (id);

alter table products
    add constraint products_pk
        primary key (id);

create table department
(
    id serial,
    name text
);

create unique index department_id_uindex
    on department (id);

alter table department
    add constraint department_pk
        primary key (id);



