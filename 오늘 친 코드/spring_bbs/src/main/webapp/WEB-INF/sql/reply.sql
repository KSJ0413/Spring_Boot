use webtest;
 
create table reply(
   rnum int not null auto_increment primary key,
   content varchar(500) not null,
   regdate date not null,
   id varchar(10) not null,
   bbsno int(7) not null,
   foreign key(bbsno) references bbs(bbsno)
);
 
select * from bbs;
 
insert into reply(content, regdate, id, bbsno)
values('의견입니다.3',sysdate(),'user1',96);
 
 
-- list(목록)
select rnum, content, regdate, id, bbsno
from REPLY
where bbsno = 96
order by rnum DESC
limit 0, 3;
 
 
-- total(목록)
select count(*) from reply
where bbsno = 96;

-- create(댓글등록)
select * from bbs;
 
insert into reply(content, regdate, id, bbsno)
values('의견입니다.',sysdate(), 'user1', 1) ;

-- read(댓글 내용)
select * from reply
where rnum=1;