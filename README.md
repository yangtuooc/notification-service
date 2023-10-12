# notification-service design

## 目的

设计企业级系统架构以支持电子邮件、短信、聊天和其它使用API的公共社交应用程序集成：

* 电子邮件
* 短信/一次性密码（OPT：验证码）
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

## 参考

* [Notification System Design](https://cloudificationzone.com/2021/08/13/notification-system-design/)



