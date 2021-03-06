# install docker on centos
- 查看内核版本
> uname -r

- 确保 yum 包更新到最新。
> sudo yum update

- 执行 Docker 安装脚本。
> curl >fsSL [https://get.docker.com](https://get.docker.com) >o get>[docker.sh](http://docker.sh) sudo sh get>[docker.sh](http://docker.sh)

- 启动 Docker 进程。
> sudo systemctl start docker
> sudo systemctl enbable docker

- 镜像加速 新版的 Docker 使用 /etc/docker/daemon.json
```json
{
 "registry-mirrors": ["http://hub-mirror.c.163.com"]
 }
```
#### lunch some images in docker
```bash
docker run --name tomcat -p 8080:8080 -d tomcat 
docker run -p 27017:27017  -d mongo
docker run -p 6379:6379  -d redis redis-server --appendonly yes
```
#### 删除未启动的容器
```bash
docker rm $( docker ps -a -q)
```
# mysql
```bash
docker run --name mysql_1 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=deipss -d mysql:latest
docker exec -it mysql_1 bash
mysql -u root -p -h localhost
ALTER USER 'root'@'%' IDENTIFIED BY 'deipss' PASSWORD EXPIRE NEVER;
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'deipss'; 
FLUSH PRIVILEGES;
commit;
select Host,User,plugin from mysql.user;
```

- [https://www.cnblogs.com/limingxie/p/8655457.html](https://www.cnblogs.com/limingxie/p/8655457.html) 【使用docker运行mysql】
- [https://www.cnblogs.com/lifan1998/p/9177731.html](https://www.cnblogs.com/lifan1998/p/9177731.html) 【2059错误】
- [https://blog.csdn.net/ora_dy/article/details/80251487](https://blog.csdn.net/ora_dy/article/details/80251487) 【2059错误】
# zookeeper,kakfa
```bash
docker pull wurstmeister/zookeeper  
docker pull wurstmeister/kafka  
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper
docker run  -d --name kafka \
-p 9092:9092 \
-e KAFKA_BROKER_ID=0 \
-e KAFKA_ZOOKEEPER_CONNECT=39.108.158.123:2181 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://39.108.158.123:9092 \
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
-t wurstmeister/kafka
KAFKA_BROKER_ID=0
KAFKA_ZOOKEEPER_CONNECT=192.168.1.100:2181
KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.1.100:9092
KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092
中间两个参数的192.168.204.128改为宿主机器的IP地址，如果不这么设置，
可能会导致在别的机器上访问不到kafka。
```
```bash
docker exec -it kafka /bin/bash
```
# Mongo
```bash
docker run -d -p 27017:27017 -v mongo_configdb:/data/configdb -v mongo_db:/data/db --name mongo docker.io/mongo --auth
docker exec -it mongo mongo admin
db.createUser({ user: 'lutos', pwd: 'lutos', roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] });
db.auth("lutos","lutos");

use lutos
db.createUser({ user: 'lutos', pwd: 'lutos', roles: [{ role: "readWrite", db: "lutos" }] });

docker exec -it mongo mongo -u lutos -p lutos lutos
```
# RabbitMQ
```bash
docker pull rabbitmq:management
docker run -d -p 5672:5672 -p 15672:15672 --name myrabbitmq [id]
docker exec -it 9e83ee385ca7 /bin/bash 
rabbitmqctl  add_user  admin  admin
rabbitmqctl  set_user_tags admin administrator
```
# elasticsearch
```bash
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.9.2
docker run --name es -d -p 9200:9200 -p 9300:9300 \
-e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.9.2

```
# redis
```bash
docker run -d --name redis -p 6379:6379 redis --requirepass "redis" --appendonly yes

```


