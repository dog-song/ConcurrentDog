实际业务开发过程中，业务逻辑可能非常复杂，核心业务 + N 个子业务。
如果都放到一块儿去做，代码可能会很长，耦合度不断攀升，维护起来也麻烦，甚至头疼。
还有一些业务场景不需要在一次请求中同步完成，比如邮件发送、短信发送等。

MQ 确实可以解决这个问题，但 MQ 重啊，非必要不提升架构复杂度。针对这些问题，我们了解一下 Spring Event。


spring 内置事件:


1. ApplicationContextEvent 是 Spring Context 相关的事件基类.
> 友情提示：Spring Context 可以简单理解成 IoC 容器。

- ContextStartedEvent：Spring Context 启动完成 事件。
- ContextStoppedEvent：Spring Context 停止完成 事件。
- ContextClosedEvent：Spring Context 停止开始 事件。
- ContextRefreshedEvent：Spring Context 初始化或刷新完成 事件。

也就是说，在 Spring Context 的整个生命周期中，会发布相应的 ApplicationContextEvent 事件。

2. SpringApplicationEvent 是 Spring Boot Application （应用）相关的事件基类.

- ApplicationStartingEvent：Application 启动开始 事件。
- ApplicationEnvironmentPreparedEvent：Spring Environment 准备完成的事件。
- ApplicationContextInitializedEvent：Spring Context 准备完成，但是 Bean Definition 未加载时的事件
- ApplicationPreparedEvent：Spring Context 准备完成，但是未刷新时的事件。
- ApplicationReadyEvent：Application 启动成功 事件。
- ApplicationFailedEvent：Application 启动失败 事件。

也就是说，在 Application 的整个生命周期中，会发布相应的 SpringApplicationEvent 事件。


3. RefreshRoutesEvent

Spring Cloud Gateway 通过监听 RefreshRoutesEvent 事件，结合 Nacos 作为配置中心，实现网关路由动态刷新 的功能。

> 友情提示：Spring Cloud Zuul 也是通过监听 RoutesRefreshedEvent 事件，实现网关路由动态刷新 的功能。

4. RefreshRemoteApplicationEvent

Spring Cloud Config Client 通过监听 RefreshRemoteApplicationEvent 事件，结合 RabbitMQ 作为 Spring Cloud Bus 消息总线，实现本地配置刷新 的功能。

5. 彩蛋

① 如果胖友想要多个监听器按照指定顺序 执行，可以通过实现 Ordered 接口，指定其顺序。

② 如果胖友想要监听多种 ApplicationContext 事件，可以实现 SmartApplicationListener 接口，具体示例可以看看 SourceFilteringListener 类。

③ @TransactionalEventListener 注解，可以声明在当前事务“结束”时，执行相应的监听逻辑。

④ 可以通过实现 ApplicationEventMulticaster 接口，定义自定义的事件广播器，可以往里面添加和移除监听器，并发布事件给注册在其中的监听器。使用比较少，基本可以忽略。



