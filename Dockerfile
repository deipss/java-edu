FROM centos:7

MAINTAINER java-edu-web

RUN yum update -y && \
yum install -y wget && \
yum install -y java-1.8.0-openjdk java-1.8.0-openjdk-devel && \
yum clean all

# Set environment variables.
ENV HOME /root

# Define working directory.
WORKDIR /root

# Define default command.
CMD ["bash"]
COPY java-edu-web/target/java-edu-web-1.0.1-SNAPSHOT.jar java-edu-web.jar
ENTRYPOINT ["java","-jar","/java-edu-web.jar"]