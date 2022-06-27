# 高CPU使用率分析
```
1、top 命令分析，是否高CPU使用率、负载率，但是CPU空闲时间长
2、安装arthas
thread 查询有多少线程，及其CPU使用率
thread -n [tid] >> [filename] 将某个线程的执行方法栈及CPU状态字输出到某个文件
```
- 参考 https://www.jianshu.com/p/3ba1e933682b

# Arthas使用
## 安装
```shell script
curl -O https://arthas.aliyun.com/arthas-boot.jar
java -jar arthas-boot.jar
```

## ognl
```
# 注意SpringExtensionFactory的版本，不同版本，类路径可能不一样
sc -d 'org.apache.dubbo.config.spring.extension.SpringExtensionFactory'
# 上面的命中得出cloassLoader的内存地址
ognl -c 2e1ef60 '#context=@org.apache.dubbo.config.spring.extension.SpringExtensionFactory@getContexts().iterator.next, #context.getBean("umsTradeBillSplitJob").execute(null)' -x 3

```
- 参考 https://cloud.tencent.com/developer/article/1846725

## monitor
```shell script
# 每秒的请求数
monitor -c 1 <类全路径名> <方法名>
```

## trace

```shell script
# 方法内部调用路径，并输出方法路径上的每个节点上耗时
# 可以指定毫秒数
trace com.frxs.repeater.receiver.event.consumer.RecieveGeneralMsgConsumer onMessage  -n 5 --skipJDKMethod false '#cost > 3000'
```

## profile
火焰图查看
```shell script
profiler start
profiler status
profiler stop --format html
```