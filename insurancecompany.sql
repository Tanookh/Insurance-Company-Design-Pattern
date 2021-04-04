CREATE SCHEMA insurancecompany;
USE insurancecompany;
create table employee(firstname varchar(20),password varchar(20),employeenumber varchar(20) NOT NULL, PRIMARY KEY(employeenumber));
insert into employee(firstname ,password ,employeenumber ) value('adam','adam','123456') ;
create table insurance(namee varchar(20),id varchar(20) NOT NULL,datee varchar(20),remarks varchar(20),insurancetype varchar(20));
