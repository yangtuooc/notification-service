package cn.haloop.ns.adapter.rest;

import cn.haloop.ns.domain.NotificationTemplate;
import cn.haloop.ns.dto.Template;
import cn.haloop.ns.service.NotificationTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/templates")
@Tag(name = "NotificationTemplateController", description = "通知模板管理")
public class NotificationTemplateController {

  private final NotificationTemplateService svc;

  @Operation(
      summary = "创建模板",
      operationId = "createTemplate"
  )
  @PostMapping
  public ResponseEntity<Void> createTemplate(@Validated @RequestBody Template template) {
    svc.createTemplate(template.asNotificationTemplate());
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Operation(
      summary = "获取所有的模板列表",
      operationId = "getAllTemplates"
  )
  @GetMapping
  public ResponseEntity<List<NotificationTemplate>> getAllTemplates() {
    return ResponseEntity.ok(svc.getAllTemplates());
  }

  @Operation(
      summary = "根据ID获取指定模板",
      operationId = "getTemplate"
  )
  @GetMapping("/{id}")
  public ResponseEntity<NotificationTemplate> getTemplate(
      @Parameter(hidden = true) @PathVariable("id") NotificationTemplate template) {
    return ResponseEntity.ok(template);
  }

  @Operation(
      summary = "根据ID删除指定模板",
      operationId = "deleteTemplate"
  )
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTemplate(
      @Parameter(hidden = true) @PathVariable("id") UUID template) {
    svc.deleteTemplate(template);
    return ResponseEntity.noContent().build();
  }

  @Operation(
      summary = "根据ID更新指定模板",
      operationId = "updateTemplate"
  )
  @PutMapping("/{id}")
  public ResponseEntity<Void> updateTemplate(
      @Parameter(hidden = true) @PathVariable("id") NotificationTemplate template,
      @Validated @RequestBody Template newTemplate) {
    svc.updateTemplate(template, newTemplate.asNotificationTemplate());
    return ResponseEntity.noContent().build();
  }
}
