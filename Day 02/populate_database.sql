CREATE DATABASE IF NOT EXISTS technologic;
USE technologic;
DROP TABLE IF EXISTS voters;

CREATE TABLE voters (
    id INT PRIMARY KEY,
    v_email VARCHAR(30) UNIQUE,
    v_password VARCHAR(30),
    v_status boolean
);

DROP TABLE IF EXISTS candidates;

CREATE TABLE candidates (
    id INT PRIMARY KEY,
    c_name VARCHAR(30) UNIQUE,
    party VARCHAR(30),
    votes int
);

insert into voters values (001, 'arnab.goswami@gmail.com', 'pass001', false);
insert into voters values (002, 'aditya.tadepalli@gmail.com', 'pass002', false);
insert into voters values (003, 'ansh.sharma@gmail.com', 'pass003', false);
insert into voters values (004, 'dhruvaa.singh@gmail.com', 'pass004', false);
insert into voters values (005, 'aarushi.talvar@gmail.com', 'pass005', false);

insert into candidates values (01, 'Elephant', 'Republican', 00);
insert into candidates values (02, 'Donkey', 'Democratic', 00);


SELECT 
    *
FROM
    voters;
SELECT 
    *
FROM
    candidates;
