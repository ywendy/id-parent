# id 生成器

## 订单生成规则

1 + 41（毫秒时间戳） + 3 （应用id，0~7）+ 1 （类型）+ 2(环境最大表示三个环境) + 10 seq（自增） + 6 gen（hash (用户id)）


## deploy


mvn deploy:deploy-file -DgroupId=com.yooeee.id.gen -DartifactId=id-generator -Dversion=1.0 -Dpackaging=jar -Dfile=target/id-generator-1.0.jar -Durl=http://192.168.0.215:8081/nexus/content/repositories/releases -DrepositoryId=releases
