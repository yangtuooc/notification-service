package cn.haloop.ns.dto;

import cn.haloop.ns.domain.model.Notification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InAppNotificationRequest extends AbstractNotificationRequest {

  @Override
  protected void execute() {

  }

  @Override
  public Notification asNotification() {
    return null;
  }
}
