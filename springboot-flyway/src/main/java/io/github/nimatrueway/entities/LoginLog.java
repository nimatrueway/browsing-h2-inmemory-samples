package io.github.nimatrueway.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "`LoginLogs`")
public class LoginLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "`id`")
  protected Long id;

  @ManyToOne
  @JoinColumn(name = "`user_id`")
  protected User user;

  @Column(name = "`login_time`")
  protected Timestamp loginTime;

}
