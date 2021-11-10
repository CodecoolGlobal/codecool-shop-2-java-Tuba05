create database codecool-shop;

create schema schema_name;

create table "Products"
(
    id serial
        constraint products_pk
            primary key,
    name text,
    price int,
    currency text,
    description text,
    type text,
    supplier text
);

create table "ProductCategories"
(
    id serial
        constraint productcategories_pk
            primary key,
    name text,
    department text,
    description text
);

create table "Suppliers"
(
    id int
        constraint suppliers_pk
            primary key,
    name text,
    product_type text
);

