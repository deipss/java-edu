# docker 常用命令
## install docker on ubuntu 
```shell
https://docs.docker.com/engine/install/ubuntu/
```

## install docker on centos
```dockerfile

- 查看内核版本
> uname -r

- 确保 yum 包更新到最新。
> sudo yum update

- 执行 Docker 安装脚本。
> curl >fsSL [https://get.docker.com](https://get.docker.com) >o get>[docker.sh](http://docker.sh) sudo sh get>[docker.sh](http://docker.sh)

- 启动 Docker 进程。
> sudo systemctl start docker
开机启动
> sudo systemctl enable docker 


- 镜像加速 新版的 Docker 使用 /etc/docker/daemon.json
{
 "registry-mirrors": ["http://hub-mirror.c.163.com"]
 }
```


## 查询docker镜像
```shell
文档 https://hub.docker.com/
查看镜像  docker image ls
查看已下载的 docker images 
删除镜像 docker imamges rm 

```

## 容器启动
```bash
docker run --name tomcat -p 8080:8080 -d tomcat   --restart=always
docker run -p 27017:27017  -d mongo --restart=always
docker run -p 6379:6379  -d redis redis-server --appendonly yes --restart=always

设置容器的启动策略：用docker run命令创建并运行容器时，加上  --restart=always参数即可
docker update --restart=always 01a07d12cfec
```


## 删除未启动的容器
```bash
docker rm $( docker ps -a -q)
```

## 查看端口映射
```shell
docker port [容器id]
```

# 常见服务
## mysql
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
## zookeeper,kakfa
```bash
docker pull wurstmeister/zookeeper  
docker pull wurstmeister/kafka  
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper
docker run  -d --name kafka \
-p 9092:9092 \
-e KAFKA_BROKER_ID=0 \
-e KAFKA_ZOOKEEPER_CONNECT=192.168.1.101:2181 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.1.101:9092 \
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
-t wurstmeister/kafka
KAFKA_ZOOKEEPER_CONNECT KAFKA_ADVERTISED_LISTENERS 
两个参数的192.168.204.128改为宿主机器的IP地址，如果不这么设置，可能会导致在别的机器上访问不到kafka。
```
```bash
docker exec -it kafka /bin/bash
```
## Mongo
```bash
docker run -d -p 27017:27017 -v mongo_configdb:/data/configdb -v mongo_db:/data/db --name mongo docker.io/mongo --auth
docker exec -it mongo mongo admin
db.createUser({ user: 'lutos', pwd: 'lutos', roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] });
db.auth("lutos","lutos");

use lutos
db.createUser({ user: 'lutos', pwd: 'lutos', roles: [{ role: "readWrite", db: "lutos" }] });

docker exec -it mongo mongo -u lutos -p lutos lutos
```
## RabbitMQ
```bash
docker pull rabbitmq:management
docker run -d -p 5672:5672 -p 15672:15672 --name myrabbitmq [id]
docker exec -it 9e83ee385ca7 /bin/bash 
rabbitmqctl  add_user  admin  admin
rabbitmqctl  set_user_tags admin administrator
```
## elasticsearch
```bash
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.9.2
docker run --name es -d -p 9200:9200 -p 9300:9300 \
-e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.9.2

```
## redis
```bash
docker pull redis
docker run -d --name redis -p 6379:6379 redis --requirepass "redis" --appendonly yes
```



## rocketmq
https://hub.docker.com/r/xuchengen/rocketmq
```shell
# mq
docker pull xuchengen/rocketmq:latest
docker volume create rocketmq_data
# Linux 或 Mac
docker run -itd \
 --name=rocketmq \
 --hostname rocketmq \
 --restart=always \
 -p 8080:8080 \
 -p 9876:9876 \
 -p 10909:10909 \
 -p 10911:10911 \
 -p 10912:10912 \
 -v rocketmq_data:/home/app/data \
 -v /etc/localtime:/etc/localtime \
 -v /var/run/docker.sock:/var/run/docker.sock \
 --net=host \
 --restart=always \
 xuchengen/rocketmq:latest
```

## zk
```shell
 docker run --name=main-zk  --restart=always   -p 2181:2181  bitnami/zookeeper:latest 

```