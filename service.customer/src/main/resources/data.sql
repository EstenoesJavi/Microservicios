DROP TABLE IF EXISTS tbl_identification_type;

CREATE TABLE tbl_identification_type (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS tbl_customers;

CREATE TABLE tbl_customers (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  last_Name VARCHAR(250) NOT NULL,
  identificaction_type_id INT NOT NULL,
  id_Number INT NOT NULL, 
  city_Birth VARCHAR(250) NOT NULL,
  creation_Date DATE NOT NULL
);

INSERT INTO tbl_identification_type VALUES 
(1, 'CC'),
(2, 'CE'),
(3, 'TI');

INSERT INTO tbl_customers VALUES 
(1,'Cristian', 'Arango', 1, '12345', 'Copacabana', '1993-08-06');
