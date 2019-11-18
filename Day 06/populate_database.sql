CREATE DATABASE IF NOT EXISTS technologic;
USE technologic;
DROP TABLE IF EXISTS voters;

CREATE TABLE voters (
    id INT PRIMARY KEY auto_increment,
    v_email VARCHAR(30) UNIQUE,
    v_password VARCHAR(30),
    v_status BOOLEAN,
    role VARCHAR(30)
);

DROP TABLE IF EXISTS candidates;

CREATE TABLE candidates (
    id INT PRIMARY KEY,
    c_name VARCHAR(30) UNIQUE,
    party VARCHAR(30),
    votes int
);

insert into voters values (001, 'arnab.goswami@gmail.com', 'pass001', false, 'admin');
insert into voters values (002, 'aditya.tadepalli@gmail.com', 'pass002', false, 'voter');
insert into voters values (003, 'ansh.sharma@gmail.com', 'pass003', false, 'voter');
insert into voters values (004, 'dhruvaa.singh@gmail.com', 'pass004', false, 'voter');
insert into voters values (005, 'aarushi.talvar@gmail.com', 'pass005', false, 'voter');
insert into voters values (006, 'elephant.longtrunk@gmail.com', 'pass006', false, 'candidate');
insert into voters values (007, 'donkey.thiccass@gmail.com', 'pass007', false, 'candidate');

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

desc voters;