# vscode_demo
Springboot+Mybatis+Redis+Docker
#####项目基本介绍######
  该项目是主微服务，项目本身是一个空壳。旨在搭建一套完全部署在docker容器的云服务，
  该项目衍生出的其他微服务项目以及所有技术都会部署在docker中，主要的docker构建文件在本项目中。
  
######微服务体系介绍####
  vscode_demo 主微服务
  oneService  微服务一
  
  
  
####本项目技术栈说明####
1.springboot：项目基于Springboot搭建
2.docker：  所有的服务包括第三方服务都部署在容器
3.nacos：  作为服务的注册中心以及配置中心
4.mybatis： 项目持久层框架
5.redis：  项目缓存数据库，以及作用于解决分布式锁
6.rabbitMq：此消息队列主要用于多个服务之间的数据通信
