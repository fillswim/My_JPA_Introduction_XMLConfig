CREATE TABLE my_db.employees
(
    id         int NOT NULL auto_increment,
    name       varchar(15),
    surname    varchar(25),
    department varchar(20),
    salary     int,
    PRIMARY KEY (id)
);

