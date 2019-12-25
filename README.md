# High-concurrent-server [![Build Status](https://travis-ci.org/GreatGarlic/High-concurrent-server.svg?branch=master)](https://travis-ci.org/GreatGarlic/High-concurrent-server) [![maven](https://maven-badges.herokuapp.com/maven-central/io.github.greatgarlic/High-concurrent-server/badge.svg)](https://search.maven.org/search?q=High-concurrent-server)

基于Netty4.1.x+Disruptor3.x实现的高性能通信服务器架构

其主要的核心思想就是将Logback的AsyncAppenderBase中的java.util.concurrent.ArrayBlockingQueue替换为了Disruptor线程间通信库

ArrayBlockingQueue与Disruptor的性能比较请点击如下链接查看:

<https://github.com/LMAX-Exchange/disruptor/wiki/Performance-Results>

良好的解决了由于业务处理线程池线程间切换造成的性能损耗问题，从而提高了并发能力，欢迎拍砖+吐槽+帮助改善该架构的性能以及可扩展性

PS:由于Netty官方废弃5.0,现在一律使用4.1.X

## 安装

### Maven

在项目的pom.xml的dependencies中加入以下内容:

``` xml
<dependency>
    <groupId>io.github.greatgarlic</groupId>
    <artifactId>high-concurrent-server</artifactId>
    <version>1.0</version>
</dependency>
```

### Gradle

``` Gradle
compile 'io.github.greatgarlic:high-concurrent-server:1.0'
```

## 使用

将配置加入工程的```logback.xml```文件中

``` xml
<appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    <Target>System.out</Target>
    <encoder>
    <charset>utf-8</charset>
        <pattern>%d-%c-%t-%5p: %m%n</pattern>
    </encoder>
</appender>
<!--异步输出 -->
<appender name="ASYNCFILE"class="org.server.log.appender.DisruptorLogAppender">
    <queueSize>1024</queueSize>
    <discardingThreshold>0</discardingThreshold>
    <appender-ref ref="CONSOLE" />
</appender>
```


## 我的

QQ号：405653510

QQ邮箱:405653510@qq.com

Gmail邮箱：ly405653510@gmail.com
