use webtest;
drop table user;
CREATE TABLE user(
  id      varchar(8)                   not null  ,
  pw          varchar(8)        NOT NULL ,
  name     varchar(20)                      NOT NULL  ,
  PRIMARY KEY (id)
);                         
 
 INSERT INTO user(id, pw, name)  
    VALUES('admin', '1234', 'kim'); 
     INSERT INTO user(id, pw, name)  
    VALUES('user', '1234', 'lee'); 
     INSERT INTO user(id, pw, name)  
    VALUES('tester', '1234', 'park'); 
    INSERT INTO user(id, pw, name)  
    VALUES('asd', 'asd', 'KKK'); 
 select * from user; 
 
 -- id&pw 체크후 맞으면 1 틀리면 0 
select count(*) 
 from user
where id = asd
 and pw = asd;



-- loginCheck 후 name 값 가져오기
 select name
 from user
 where id ="admin" AND pw = "1234";