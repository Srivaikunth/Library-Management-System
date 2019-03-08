Create table student(
student_id number(10),
student_name varchar2(40) not null,
phone_number number(10) constraint chk_std_phone check(phone_number not like '%[^0-9]%'),
address varchar2(30) not null,
password varchar2(20) not null);


create sequence student_student_id_seq
start with 1
increment by 1;



Create table author(
author_id number(10),
author_name varchar2(40) not null, constraint pk_author_id primary key(author_id)
);

create sequence author_author_id_seq
start with 1
increment by 1;



Create table publication(
id number(10),
name varchar2(30) not null,constraint pk_id primary key(id)
);

create sequence publication_id_seq
start with 1
increment by 1;


create table book_details(
id number(10),
isbn number(20) not null,
name varchar2(40) not null,
price float(10) not null,
publication_id number(10),
author_id number(10), constraint pk_book_id primary key(id),
constraint uk_isbn unique (isbn),
constraint fk_publication_id foreign key (publication_id) references publication(id),
constraint fk_author_id foreign key(author_id) references author (author_id)
);


create sequence id_seq
start with 1
increment by 1;

Create table admin(
id number(10),
username varchar2(25),
password varchar2(20), constraint pk_admin_id primary key(id)
);

insert into admin values(101,'vaikunth','siddharth');
insert into admin values(102,'siddharth','vaikunth');
commit;
select * from author;
select * from book_details;
select * from student;
select* from admin;




alter table book_details add status int;
update book_details set status=1;

commit;

drop table admin;
drop table book_details;
drop table author;
drop table publication;
drop table student;

