-- Create the database
CREATE DATABASE IF NOT EXISTS invoices CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

CREATE USER IF NOT EXISTS 'monthe'@'localhost' IDENTIFIED BY 'java';
GRANT ALL PRIVILEGES ON invoices.* TO 'monthe'@'localhost';
FLUSH PRIVILEGES;

-- Create tables
USE invoices;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);

INSERT INTO users (username, password) VALUES (
    'vmonthe', '38a0963a6364b09ad867aa9a66c6d009673c21e182015461da236ec361877f77'
);

DROP TABLE IF EXISTS consultations;

CREATE TABLE consultations (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date varchar(255) NOT NULL,
    client varchar(255) NOT NULL,
    type varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    rate int NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

DROP TABLE IF EXISTS courses;

CREATE TABLE courses (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date varchar(255) NOT NULL,
    client varchar(255) NOT NULL,
    type varchar(255) NOT NULL,
    start_hour varchar(255) NOT NULL,
    end_hour varchar(255) NOT NULL,
    module varchar(255) NOT NULL,
    class_level varchar(255) NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

DROP TABLE IF EXISTS invoices;

CREATE TABLE invoices (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date varchar(255) NOT NULL,
    prestation_type varchar(100) NOT NULL,
    amount double NOT NULL,
    consultation_id int NULL,
    course_id int NULL,
    user_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (consultation_id) REFERENCES consultations(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
