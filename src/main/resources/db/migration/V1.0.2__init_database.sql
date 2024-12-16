CREATE TABLE employees
(
    id            BINARY(16)   NOT NULL,
    name          VARCHAR(255) NULL,
    dob           date NULL,
    gender        SMALLINT NULL,
    salary DOUBLE NULL,
    phone         VARCHAR(255) NULL,
    department_id INT NULL,
    CONSTRAINT pk_employees PRIMARY KEY (id)
);