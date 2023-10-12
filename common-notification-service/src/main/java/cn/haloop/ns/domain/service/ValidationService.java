package cn.haloop.ns.domain.service;

import cn.haloop.ns.domain.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {


  public void validate(Notification notification) {
    // TODO：根据业务规则和预期格式验证消息是否合法
    // TODO：业务规则包含当前通知是否可以发送、是否风控等。
  }
}
