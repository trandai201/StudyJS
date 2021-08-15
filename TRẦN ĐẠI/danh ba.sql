create database DanhBa
go
use DanhBa
go
create table table_User(
	userName nvarchar(20),
	password varchar(20),
	name nvarchar(50),
	DOB varchar(12),
	phone varchar(11),
	address nvarchar(50),
	email varchar(25)

)
create table table_Phone(
	userName varchar(20),
	name nvarchar(50),
	phone varchar(20)
)