# DB作成
create database if not exists testdb;

# 学生情報テーブル
drop table testdb.tbl_student;
create table if not exists testdb.tbl_student (
  id int primary key auto_increment,
  stu_name varchar(50),
  sex varchar(10),
  age tinyint
);