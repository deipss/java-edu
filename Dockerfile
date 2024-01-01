FROM centos:7

MAINTAINER deipss666@gmail.com

RUN yum update -y && \
yum install -y wget && \
yum install -y unzip && \
yum install -y java-1.8.0-openjdk java-1.8.0-openjdk-devel && \
yum clean all

# Set environment variables.
ENV HOME /root
VOLUME /tmp

# Define working directory.
WORKDIR /root


# Define default command.
CMD ["bash"]
CMD ["wget -P /opt https://ompc.oss-cn-hangzhou.aliyuncs.com/jvm-sandbox/release/sandbox-1.4.0-bin.zip "]
CMD ["unzip sandbox-1.4.0-bin.zip "]
COPY java-edu-web/target/java-edu-web-1.0.1-SNAPSHOT.jar /root/java-edu-web.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/root/java-edu-web.jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"]