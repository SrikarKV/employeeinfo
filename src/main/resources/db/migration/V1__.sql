CREATE TABLE departments
(
    department_id   INT AUTO_INCREMENT NOT NULL,
    department_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_departments PRIMARY KEY (department_id)
);

CREATE TABLE employees
(
    employee_id     INT AUTO_INCREMENT NOT NULL,
    first_name      VARCHAR(255) NOT NULL,
    last_name       VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL,
    phone           VARCHAR(255) NULL,
    department_id   INT NULL,
    position        VARCHAR(255) NULL,
    date_of_joining datetime NULL,
    status          VARCHAR(255) NULL,
    CONSTRAINT pk_employees PRIMARY KEY (employee_id)
);

CREATE TABLE users
(
    user_id     INT AUTO_INCREMENT NOT NULL,
    username    VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    `role`      VARCHAR(255) NULL,
    employee_id INT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE employees
    ADD CONSTRAINT uc_employees_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE employees
    ADD CONSTRAINT FK_EMPLOYEES_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES departments (department_id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employees (employee_id);