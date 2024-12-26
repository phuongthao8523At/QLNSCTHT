DROP DATABASE IF EXISTS `qlnsHT`;
CREATE DATABASE IF NOT EXISTS `qlnsHT`;

USE `qlnsHT`;


CREATE TABLE `account`
(
    `username` VARCHAR(255) PRIMARY KEY,
    `password` VARCHAR(255) NOT NULL
);
INSERT INTO `account`(username, password)
VALUES ('admin', '123');

CREATE TABLE `employee`
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    fullName   VARCHAR(255),
    address    VARCHAR(555),
    phone      VARCHAR(20),
    gender     VARCHAR(20),
    position   VARCHAR(100),
    department VARCHAR(150),
    hireDate   DATETIME   DEFAULT CURRENT_TIMESTAMP,
    leaveDate  DATETIME,
    isDeleted  TINYINT(2) DEFAULT 0
);

CREATE TABLE contract
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    employeeId   INT,
    contractType VARCHAR(255),
    startDate    VARCHAR(255),
    endDate      VARCHAR(255),
    isDeleted    TINYINT(2) DEFAULT 0
);

CREATE TABLE recuitment
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    position       VARCHAR(255),
    quantity       INT,
    deadline       VARCHAR(255),
    jobDescription VARCHAR(555)
);
DROP TABLE IF EXISTS salary;
CREATE TABLE salary
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    employee_id   INT,
    salary_amount FLOAT DEFAULT 0,
    working_day   INT   DEFAULT 0,
    wage          FLOAT DEFAULT 0,
    salary_date   VARCHAR(255),
    detail        VARCHAR(255),
    CONSTRAINT fk_salary_employee FOREIGN KEY (employee_id) REFERENCES employee (id)
);


ALTER TABLE contract
    ADD FOREIGN KEY (employeeId) REFERENCES employee (id);
INSERT INTO employee(fullName, address, phone, gender, position, department, hireDate, leaveDate, isDeleted)
VALUES ('Thảo', 'Hà Nội', '0987654321', 'Nữ', 'Nhân viên', 'Nhân sự', '2021-01-01', NULL, 0),
       ('Huy', 'HCM', '0123456789', 'Nam', 'Nhân viên', 'Nhân sự', '2021-01-02', NULL, 0),
       ('Hàn', 'Hà Nội', '0987654321', 'Nữ', 'Nhân viên', 'Nhân sự', '2021-01-03', NULL, 0),
       ('Huyền', 'HCM', '0123456789', 'Nam', 'Nhân viên', 'Nhân sự', '2021-01-04', NULL, 0),
       ('Tuyến', 'Hà Nội', '0987654321', 'Nữ', 'Nhân viên', 'Nhân sự', '2021-01-05', NULL, 0);
