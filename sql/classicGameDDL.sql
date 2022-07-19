DROP TABLE IF EXISTS User;

CREATE TABLE User(
id VARCHAR(40) primary key,  
pw VARCHAR(40),
mail VARCHAR(40),
name VARCHAR(40),
nickname VARCHAR(40)
);
​
​
​-- Total 테이블
DROP TABLE IF EXISTS Total;
​
CREATE TABLE Total(
nickname VARCHAR(40) primary key,   
score1 int,
score2 int,
score3 int
);
​
​
-- cgame1 테이블
DROP TABLE IF EXISTS cgame1;
​
create table cgame1(
num int unsigned auto_increment  primary key,  
nickname VARCHAR(40),
score1 int unsigned
);
​
​
DROP TABLE IF EXISTS cgame2;
​
CREATE TABLE cgame2(
 num int unsigned auto_increment  primary key, 
 nickname VARCHAR(40),
 score2 int unsigned
);
​
DROP TABLE IF EXISTS cgame3;
​
CREATE TABLE cgame3(
 num int unsigned auto_increment  primary key, 
 nickname VARCHAR(40),  
 score3 int unsigned
);
​
​
​--mysql auto commit
SELECT @@AUTOCOMMIT;   // AUTOCOMMIT 여부 확인
SET AUTOCOMMIT = FALSE;   // AUTOCOMMIT 해제
​
​
drop trigger IF EXISTS user_total;
​
​
DELIMITER $$
CREATE TRIGGER user_total
AFTER INSERT
ON user
FOR EACH ROW
BEGIN 
insert into Total(nickname, score1, score2, score3) values (new.nickname,0,0,0);
END$$        
DELIMITER ;
​
