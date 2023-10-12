package cn.haloop.ns.dto;

import cn.haloop.ns.domain.NotificationTemplate;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Template", description = "通知模板")
public class Template {

  @NotBlank(message = "模板名称不能为空")
  @Schema(name = "name", description = "模板名称", requiredMode = RequiredMode.REQUIRED)
  private String name;

  @NotBlank(message = "模板内容不能为空")
  @Schema(name = "content", description = "模板内容", requiredMode = RequiredMode.REQUIRED)
  private String content;

  @Schema(name = "description", description = "模板描述")
  private String description;

  public NotificationTemplate asNotificationTemplate() {
    return new NotificationTemplate(name, content, description);
  }
}
