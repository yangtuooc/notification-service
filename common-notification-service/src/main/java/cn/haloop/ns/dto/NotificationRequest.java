package cn.haloop.ns.dto;

import cn.haloop.ns.domain.model.Notification;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "NotificationRequest", description = "通知请求")
public class NotificationRequest {

  public Notification asNotification() {
    return new Notification();
  }
}
