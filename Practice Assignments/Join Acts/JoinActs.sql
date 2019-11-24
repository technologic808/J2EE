create database if not exists cdac;
use cdac;

INSERT INTO `cdac`.`courses` (`cId`, `courseName`) VALUES ('1', 'DAC');
INSERT INTO `cdac`.`courses` (`cId`, `courseName`) VALUES ('2', 'DAI');
INSERT INTO `cdac`.`courses` (`cId`, `courseName`) VALUES ('3', 'DBDA');
INSERT INTO `cdac`.`courses` (`cId`, `courseName`) VALUES ('4', 'DHPCA');
INSERT INTO `cdac`.`courses` (`cId`, `courseName`) VALUES ('5', 'DMC');

SELECT 
    *
FROM
    courses;
    
SELECT 
    *
FROM
    students;