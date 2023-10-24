package cn.haloop.ns.dto;

import cn.haloop.ns.domain.model.Notification;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailNotificationRequest extends AbstractNotificationRequest {

  @Schema(name = "subject", description = "邮件主题")
  private String subject;


  @Override
  protected void execute() {
    if (subject == null || subject.isEmpty()) {
      throw new IllegalArgumentException("邮件主题不能为空");
    }
  }

  @Override
  public Notification asNotification() {
    return null;
  }
}
