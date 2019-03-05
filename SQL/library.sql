Create table student(
student_id number(10),
student_name varchar2(20),
phone_number number(10),
address varchar2(30)
);
create sequence student_student_id_seq
start with 1
increment by 1;
alter table student add password varchar2(20);
select * from student;
desc student;
Create table author(
author_id number(10),
author_name varchar2(20), constraint pk_author_id primary key(author_id)
);

create sequence author_author_id_seq
start with 1
increment by 1;

select* from user_cons_columns where TABLE_NAME='AUTHOR';

Create table publication(
id number(10),
name varchar2(20),constraint pk_id primary key(id)
);

create sequence publication_id_seq
start with 1
increment by 1;


create table book_details(
id number(10),
isbn number(20) not null,
name varchar2(20) not null,
price number(10) not null,
publication_id number(10),
author_id number(10), constraint pk_book_id primary key(id),
constraint fk_publication_id foreign key (publication_id) references publication(id),
constraint fk_author_id foreign key(author_id) references author (author_id)
);
select * from book_details;
create sequence id_seq
start with 1
increment by 1;

Create table admin(
username varchar2(25),
password varchar2(20)
);

insert into admin values('vaikunth','siddharth');

select * from author;
select * from book_details;
delete  from  book_details;
insert into book_details values(1,12345,'java',120,2,1,0);
insert into book_details values(3,87654,'Sql',156,2,1,0);
commit;

insert into author(author_id,author_name) values(1,'janani');
insert into publication(id,name) values(2,'oxford');

select * from author;

update book_details set price= where;
select * from  author;
delete from publication;
delete from author;


select * from student;

alter table book_details add status int;
update book_details set status=1;

commit;

alter table book_details modify(unique(isbn));
