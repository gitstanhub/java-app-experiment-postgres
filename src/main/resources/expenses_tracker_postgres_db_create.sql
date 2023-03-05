create database expenses-tracker_postgres_db
    with owner postgres;

\c expenses-tracker_postgres_db

create table account
(
    id    serial
        constraint account_pk
            primary key,
    name  varchar,
    balance integer
);

alter table account
    owner to postgres;

create unique index account_id_uindex
    on account (id);

create table expense
(
    id             serial
        constraint expense_pk
            primary key,
    account_id     integer
        constraint expense_account_id_fk
            references account,
    expense_category varchar,
    expense_amount  integer,
    expense_description varchar
);

alter table expense
    owner to postgres;

create unique index expense_id_uindex
    on expense (id);