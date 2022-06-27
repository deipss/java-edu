# mysql进程排查	       	       
show open tables where in_use > 0;

select * from information_schema.innodb_trx;

show processlist 