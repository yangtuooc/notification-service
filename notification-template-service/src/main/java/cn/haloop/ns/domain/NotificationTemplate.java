package cn.haloop.ns.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NotificationTemplate {

  @Id
  private UUID id = UUID.randomUUID();

  @Column(name = "name")
  private String name;

  @Column(name = "content")
  private String content;

  @Column(name = "description")
  private String description;
}
