-- liquibase formatted sql

--changeSet dkirillov: 1
CREATE TABLE socks (
    id SERIAL PRIMARY KEY,
    color VARCHAR(50) not null,
    cotton_part INTEGER,
    quantity INTEGER
)