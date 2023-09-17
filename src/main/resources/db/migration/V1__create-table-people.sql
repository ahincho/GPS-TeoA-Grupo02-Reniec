CREATE TABLE people (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    father_lastname VARCHAR(32) NOT NULL,
    mother_lastname VARCHAR(32) NOT NULL,
    document_number VARCHAR(8) NOT NULL UNIQUE,
    check_digit VARCHAR(1) NOT NULL,
    PRIMARY KEY (id)
);