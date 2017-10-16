drop database DB1;
create database DB1;
use DB1;
create table ta1
(
	name varchar(30) primary key,
	age int
);
insert into ta1 value('¹þ¹¤´ó',20);
COMMIT;