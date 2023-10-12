package cn.haloop.ns.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class NotificationTemplate {

  @Id
  private UUID id = UUID.randomUUID();

  @Column(name = "name")
  private String name;

  @Column(name = "content")
  private String content;

  @Column(name = "description")
  private String description;

  public NotificationTemplate(String name, String content, String description) {
    this.name = name;
    this.content = content;
    this.description = description;
  }

  public void update(NotificationTemplate newTemplate) {
    this.name = newTemplate.name;
    this.content = newTemplate.content;
    this.description = newTemplate.description;
  }
}
