# id 生成器

## 订单生成规则

1 + 41 + 3 ）+ 1 + 2 + 10 seq + 6 gen

| 符号位 | 时间戳(毫秒) | 应用ID | 订单类型 | 环境(ENV) | 自增SEQ | gene预留  
| - | :-: | -: | -: | -: | -: | -: | 
| 1 | 41 | 3 | 1 | 2 | 10 | 6 
|正整数默认为0| 毫秒时间| 应用Id取值(0~7)| 0和1 | 0/1/2 | 0~1023 | 预留做分库分表用

## 打包发布
### 打包
mvn clean assembly:assembly 把三个模块打成一个包
### 发布到私服
mvn deploy:deploy-file -DgroupId=com.yooeee.id.gen -DartifactId=id-generator -Dversion=1.0 -Dpackaging=jar -Dfile=target/id-generator-1.0.jar -Durl=http://192.168.0.215:8081/nexus/content/repositories/releases -DrepositoryId=releases



## 传输协议
  1        2          3       4
 len + header len + header + body
 
 1:总长度
 2:header 长度
 3: header body
 4: body
 