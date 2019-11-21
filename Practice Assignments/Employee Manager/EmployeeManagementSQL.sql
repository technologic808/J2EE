create database if not exists technologic;
use technologic;

INSERT INTO `technologic`.`eval_dept` (`deptId`, `deptName`, `location`, `strength`) VALUES ('1', 'IT', 'basement', '0');
INSERT INTO `technologic`.`eval_dept` (`deptId`, `deptName`, `location`, `strength`) VALUES ('2', 'Finance', 'ground', '0');
INSERT INTO `technologic`.`eval_dept` (`deptId`, `deptName`, `location`, `strength`) VALUES ('3', 'HR', 'first', '0');
INSERT INTO `technologic`.`eval_dept` (`deptId`, `deptName`, `location`, `strength`) VALUES ('4', 'Legal', 'second', '0');
INSERT INTO `technologic`.`eval_dept` (`deptId`, `deptName`, `location`, `strength`) VALUES ('5', 'Development', 'third', '0');

select * from eval_emp;