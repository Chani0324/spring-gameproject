DROP TABLE IF EXISTS User;

CREATE TABLE User(
id VARCHAR(40) primary key,  
pw VARCHAR(40),
mail VARCHAR(40) UNIQUE,
name VARCHAR(40),
nickname VARCHAR(40) UNIQUE
);

​
DROP TABLE IF EXISTS Total;

CREATE TABLE Total(
nickname VARCHAR(40) primary key,   
score1 int,
score2 int,
score3 int
);
​
DROP TABLE IF EXISTS Olduser;

CREATE TABLE Olduser (
num int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
id VARCHAR(40),
pw VARCHAR(40),
mail VARCHAR(40),
name VARCHAR(40),
nickname VARCHAR(40)
);


DROP TABLE IF EXISTS cgame1;

create table cgame1(
num int UNSIGNED AUTO_INCREMENT PRIMARY KEY,  
nickname VARCHAR(40),
score1 int unsigned
);
​
​
DROP TABLE IF EXISTS cgame2;

CREATE TABLE cgame2(
 num int UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
 nickname VARCHAR(40),
 score2 int unsigned
);
​
DROP TABLE IF EXISTS cgame3;

CREATE TABLE cgame3(
 num int UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
 nickname VARCHAR(40),  
 score3 int unsigned
);
​
ALTER TABLE Olduser AUTO_INCREMENT = 1;
ALTER TABLE cgame1 AUTO_INCREMENT = 1;
ALTER TABLE cgame2 AUTO_INCREMENT = 1;
ALTER TABLE cgame3 AUTO_INCREMENT = 1;


SELECT @@AUTOCOMMIT;  
SET AUTOCOMMIT = FALSE;   
​
​
drop trigger IF EXISTS user_total;
​​
DELIMITER $$
CREATE TRIGGER user_total
AFTER INSERT
ON user
FOR EACH ROW
BEGIN
insert into Total(nickname, score1, score2, score3) values (new.nickname,0,0,0);
END $$        
DELIMITER ;


DROP TRIGGER IF EXISTS update_nickname;

DELIMITER $$
CREATE TRIGGER update_nickname
AFTER UPDATE
ON user
FOR EACH ROW
BEGIN
	IF NEW.nickname != OLD.nickname THEN
		UPDATE total SET total.nickname = new.nickname where total.nickname = old.nickname;
		UPDATE cgame1 SET cgame1.nickname = new.nickname where cgame1.nickname = old.nickname;
		UPDATE cgame2 SET cgame2.nickname = new.nickname where cgame2.nickname = old.nickname;
		UPDATE cgame3 SET cgame3.nickname = new.nickname where cgame3.nickname = old.nickname;
	END IF;
END $$
DELIMITER ;
​

DROP TRIGGER IF EXISTS delete_user;

DELIMITER $$
CREATE TRIGGER delete_user
BEFORE DELETE
ON user
FOR EACH ROW
BEGIN
	INSERT INTO Olduser VALUES (NULL, old.id, old.pw, old.mail, old.name, old.nickname);
	DELETE FROM total WHERE total.nickname = old.nickname;
	DELETE FROM cgame1 WHERE cgame1.nickname = old.nickname;
	DELETE FROM cgame2 WHERE cgame2.nickname = old.nickname;
	DELETE FROM cgame3 WHERE cgame3.nickname = old.nickname;
END $$
DELIMITER ;

