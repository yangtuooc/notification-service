package cn.haloop.ns.dto;

import cn.haloop.ns.domain.model.Notification;
import cn.haloop.ns.domain.model.NotificationType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SmsNotificationRequest.class, name = "SMS"),
    @JsonSubTypes.Type(value = EmailNotificationRequest.class, name = "EMAIL"),
    @JsonSubTypes.Type(value = OtpNotificationRequest.class, name = "OTP"),
    @JsonSubTypes.Type(value = InAppNotificationRequest.class, name = "IN_APP"),
})
@Schema(name = "NotificationRequest", description = "通知请求")
public abstract class AbstractNotificationRequest {

  @Schema(name = "type", description = "通知类型")
  private NotificationType type;

  @Schema(name = "recipient", description = "接收方")
  private String recipient;

  @Schema(name = "content", description = "通知内容")
  private String content;

  protected abstract void execute();

  public abstract Notification asNotification();

  public void validate() {
    if (type == null) {
      throw new IllegalArgumentException("通知类型不能为空");
    }
    if (recipient == null) {
      throw new IllegalArgumentException("消息接收方不能为空");
    }
    if (content == null) {
      throw new IllegalArgumentException("通知内容不能为空");
    }
    execute();
  }
}
