# boot-04-jdbc

<br>

**数据库环境：**

mysql 8

```sql
create database jdbc;
use jdbc;

create table `user`(
    `id` int primary key auto_increment,
    `name` nvarchar(20),
    `age` int,
    `sex` nvarchar(2)
) engine=InnoDB default charset=UTF8;

insert into user (`name`,`age`,`sex`) values ('张一',18,'男');
insert into user (`name`,`age`,`sex`) values ('张二',19,'女');
insert into user (`name`,`age`,`sex`) values ('张三',20,'未知');
```

