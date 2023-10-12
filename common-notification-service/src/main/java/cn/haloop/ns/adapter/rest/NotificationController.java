package cn.haloop.ns.adapter.rest;

import cn.haloop.ns.domain.model.Notification;
import cn.haloop.ns.domain.model.NotificationStatus;
import cn.haloop.ns.dto.NotificationRequest;
import cn.haloop.ns.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/notifications")
@Tag(name = "NotificationController", description = "通知管理")
public class NotificationController {

  private final NotificationService svc;

  @Operation(
      summary = "创建通知",
      operationId = "createNotification"
  )
  @PostMapping
  public ResponseEntity<Notification> createNotification(@RequestBody NotificationRequest request) {
    return ResponseEntity.ok(svc.createNotification(request));
  }

  @Operation(
      summary = "获取通知状态",
      operationId = "getNotificationStatus"
  )
  @GetMapping("/{id}/status")
  public ResponseEntity<NotificationStatus> getNotificationStatus(
      @Parameter(hidden = true) @PathVariable("id") Notification notification) {
    return ResponseEntity.ok(notification.getStatus());
  }
}
