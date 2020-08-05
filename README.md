# cloud2020
微服务
1.配置集群eureka注册中心
修改映射配置hosts，可以用cmd，drivers快速进入，点击文件夹etc进行修改hosts。
127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com
2.实现客户端负载均衡
使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
通过微服务名称来调服务，负载均衡机制用的是默认的是轮询的方式。
3.使用actuator实现健康监控。如果使用http调用的方法，需要和spring-boot-starter-web一起使用。
4.服务发现Discovery