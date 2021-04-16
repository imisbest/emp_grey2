drop sequence emp_seq;
create sequence emp_seq;
drop table emp cascade constraint;
create table emp(
id number(3) primary key not null,
name varchar2(20),
salary varchar2(10),
age varchar2(10),
birthday date
);
commit;
insert into emp values(emp_seq.nextval,'刘一','5742','43',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'陈二','78532','22',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'张三','3567','87',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'李四','5657','24',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'王五','32356','32',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'赵六','446','65',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'孙七','13455','15',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'周八','5245','76',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'吴九','57485','12',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
insert into emp values(emp_seq.nextval,'郑十','44356','46',TO_DATE('2015-07-01', 'YYYY-MM-DD'));
commit;
select * from emp;



drop table user2 cascade constraint;
create table user2(
name varchar2(20) primary key not null,
password varchar2(10),
truename varchar(30),
sex varchar2(10)
);
commit;
insert into user2 values('qqq','qqq','aaa','man');
commit;
select * from user2;
