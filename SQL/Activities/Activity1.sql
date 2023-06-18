REM   Script: Activity1
REM   Acitivity1 session.

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


ALTER table salesman 
    MODIFY salesman_id int NOT NULL;

DESCRIBE salesman


