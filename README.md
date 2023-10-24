# notification-service design

## 目的

设计企业级系统架构以支持电子邮件、短信、聊天和其它使用API的公共社交应用程序集成：

* 电子邮件
* 短信/一次性密码（OTP：验证码）
* 推送通知
* 聊天

## 功能需求

* 发送通知
* 优先通知
* 根据客户保存的偏好发送通知
* 单个/简单和批量通知消息
* 各种通知的分析用例
* 通知消息的报告

## 非功能需求

* 高性能
* 高可用性(HA)
* 低延迟
* 可扩展/可插拔设计：可添加更多客户端、适配器和供应商
* 可靠性：消息不会丢失、重复或无序

## 模块划分

* common-notification-service: 提供通用的通知服务，如验证、优先级设定等
* external-modules-service: 理与第三方系统的集成，如SMS供应商、Email供应商等
* notification-analytics-service: 提供通知的统计和分析功能
* notification-broadcast-service: 负责广播通知给各种适配器，如SMS、Email等
* notification-core: 包含通用实体、工具类、常量等
* notification-inbound-service: 处理入站的通知，如外部系统的回应或反馈
* notification-outbound-service: 处理出站的通知，从其他模块接收通知，然后调度给相应的适配器发送
* notification-template-service: 负责管理通知的模板

## FAQ


## 参考

* [Notification System Design](https://cloudificationzone.com/2021/08/13/notification-system-design/)
  <img src="docs/deep-dive/architecture.png">



