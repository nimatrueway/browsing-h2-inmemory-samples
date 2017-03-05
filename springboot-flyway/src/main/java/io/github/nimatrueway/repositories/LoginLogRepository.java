package io.github.nimatrueway.repositories;

import io.github.nimatrueway.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginLogRepository extends CrudRepository<LoginLog, Long> {

  @Query(value = "SELECT COUNT(loginlog) FROM LoginLog loginlog LEFT JOIN loginlog.user user WHERE user.username=:username")
  Optional<Long> queryLoginCount(@Param("username") String username);

}
