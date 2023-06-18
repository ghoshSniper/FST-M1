REM   Script: Activity3
REM   Acitivity3 session.

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


CREATE TABLE salesman ( 
    salesman_id int NOT NULL, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

ALTER table salesman( 
    ALTER COLUMN salesman_id int NOT NULL 
);

ALTER table salesman 
    MODIFY salesman_id int NOT NULL;

DESCRIBE salesman


INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

