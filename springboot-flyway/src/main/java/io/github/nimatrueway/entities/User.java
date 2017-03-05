package io.github.nimatrueway.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "`Users`")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "`id`")
  protected Long id;

  @Column(name = "`username`")
  protected String username;

  @Column(name = "`password_hash`")
  protected String passwordHash;

}
