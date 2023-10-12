package cn.haloop.ns.service;

import cn.haloop.ns.domain.NotificationTemplate;
import cn.haloop.ns.repository.NotificationTemplateRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationTemplateService {

  private final NotificationTemplateRepository repo;

  public NotificationTemplate getTemplate(UUID templateId) {
    return repo.getReferenceById(templateId);
  }

  public NotificationTemplate createTemplate(NotificationTemplate template) {
    return repo.save(template);
  }

  public NotificationTemplate updateTemplate(NotificationTemplate template) {
    return repo.save(template);
  }

  public void deleteTemplate(UUID templateId) {
    repo.deleteById(templateId);
  }

}
