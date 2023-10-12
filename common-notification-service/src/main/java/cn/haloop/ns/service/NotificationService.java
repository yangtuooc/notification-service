package cn.haloop.ns.service;

import cn.haloop.ns.domain.model.Notification;
import cn.haloop.ns.domain.service.PrioritizationService;
import cn.haloop.ns.domain.service.SchedulingService;
import cn.haloop.ns.domain.service.ValidationService;
import cn.haloop.ns.dto.AbstractNotificationRequest;
import cn.haloop.ns.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

  private final ValidationService validationService;
  private final SchedulingService schedulingService;
  private final PrioritizationService prioritizationService;
  private final NotificationRepository notificationRepository;


  public Notification createNotification(AbstractNotificationRequest request) {
    Notification notification = request.asNotification();
    validationService.validate(notification);
    prioritizationService.setPriority(notification);
    schedulingService.scheduleNotification(notification);
    return notificationRepository.save(notification);
  }

}
