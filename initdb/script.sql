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

INSERT INTO consultations (date, client, type, description, rate, user_id) VALUES 
('9/07/2025', 'Arkea', 'Consultation', 'Proposition de modification du progiciel', 100, 1),
('19/07/2025', 'Thales', 'Consultation', 'POC de proposition de logiciel de suivi de projet', 120, 1);

INSERT INTO courses (date, client, type, start_hour, end_hour, module, class_level, user_id) VALUES 
('1/07/2025', 'Brest OpenCampus', 'Cours', '10:00', '12:00', 'Java', 'Learn IT B3', 1),
('13/07/2025', 'ENIB', 'Cours', '14:00', '16:00', 'Java', 'Promo Java 2025', 1);