package cn.haloop.ns.dto;

import cn.haloop.ns.domain.model.Notification;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OtpNotificationRequest extends AbstractNotificationRequest {

  @Override
  protected void execute() {

  }

  @Override
  public Notification asNotification() {
    return null;
  }
}
