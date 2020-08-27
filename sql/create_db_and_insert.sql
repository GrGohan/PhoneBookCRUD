CREATE DATABASE test
	
USE test;

CREATE TABLE contacts
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    number bigint(20)
)
	
COLLATE='utf8_general_ci';
CREATE UNIQUE INDEX contacts_name_uindex ON contacts (name);
	
INSERT INTO `contacts` (`name`,`number`)
VALUES
  ("Andrew", 79605530554),
  ("Tim", 79635580565),
  ("Tag", 79605630558),
  ("Jimmy", 79605533557);