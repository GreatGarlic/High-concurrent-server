High-concurrent-server
======================

基于Netty5.x+Disruptor3.x实现的高性能通信服务器架构
其主要的核心思想就是将Logback的AsyncAppenderBase中的java.util.concurrent.ArrayBlockingQueue替换为了Disruptor线程间通信库

ArrayBlockingQueue与Disruptor的性能比较请点击如下链接查看:
https://github.com/LMAX-Exchange/disruptor/wiki/Performance-Results

良好的解决了由于业务处理线程池线程间切换造成的性能损耗问题，从而提高了并发能力，欢迎拍砖+吐槽+帮助改善该架构的性能以及可扩展性

我的：

QQ号：405653510

QQ邮箱:405653510@qq.com

Gmail邮箱：ly405653510@gmail.com
