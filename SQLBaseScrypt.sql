CREATE DATABASE test;
USE test;
DROP TABLE IF EXISTS `test`.`user`;
 CREATE TABLE `user` (
   `id` int(8) NOT NULL AUTO_INCREMENT,
   `name` varchar(25) NOT NULL DEFAULT 'undefined',
   `age` int(3) NOT NULL DEFAULT '0',
   `isAdmin` bit(1) NOT NULL DEFAULT b'0',
   `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
INSERT INTO User(name, age, isAdmin, date) VALUES('Tevl', 18, true, '2015-10-21 12:15:58'); 
INSERT INTO User(name, age, isAdmin, date) VALUES('Jenn', 19, false, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Ben', 41, false, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Gon', 42, false, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Tibr', 21, false, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Nibr', 31, true, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Mimr', 11, true, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Bing', 61, false, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Jing', 45, false, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Fing', 46, false, '2015-10-21 12:15:58');
INSERT INTO User(name, age, isAdmin, date) VALUES('Ping', 44, false, '2015-10-21 12:15:58');
