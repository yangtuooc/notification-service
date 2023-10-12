package cn.haloop.ns.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Notification {

  @Id
  private UUID id = UUID.randomUUID();

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "priority")
  @Enumerated(EnumType.STRING)
  private Priority priority;

  @Column(name = "scheduledTime")
  private LocalDateTime scheduledTime;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private NotificationStatus status;

}
