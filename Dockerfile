FROM azul/zulu-openjdk-alpine:17


ADD ./target/demo-0.0.1-SNAPSHOT.jar      /opt/vscode_springboot_system/console/demo-0.0.1-SNAPSHOT.jar

WORKDIR /opt/vscode_springboot_system/console

# 声明端口
EXPOSE 8777/tcp

# JVM 参数环境变量
ENV JVM_XMX 2048M
ENV JVM_XMS 512M

MAINTAINER Coding_lyl Rookie@fospot.cn

#CMD ["java","-jar","/opt/vscode_springboot_system/console/demo-0.0.1-SNAPSHOT.jar"]
#CMD java -server -Xmx$JVM_XMX -Xms$JVM_XMS -jar demo-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/opt/vscode_springboot_system/console/demo-0.0.1-SNAPSHOT.jar"]