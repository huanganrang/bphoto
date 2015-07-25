 CREATE USER 'bphoto'@'127.0.0.1' IDENTIFIED BY '123456';
flush privileges;
 create database bphoto;
 alter database bphoto character set utf8; 
 grant all privileges on bphoto.* to bphoto@localhost identified by '123456';
 flush privileges;
 
 ---GRANT USAGE ON *.* TO 'appmonitor'@'localhost' IDENTIFIED BY '123456' WITH GRANT OPTION;