package io.github.nimatrueway.controllers;

import io.github.nimatrueway.repositories.LoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainController {

  @Autowired
  private LoginLogRepository loginLogRepository;

  @RequestMapping(value = "/nimaLoginCount", method = RequestMethod.GET)
  public ResponseEntity<String> nimaLoginCount() {
    Optional<Long> loginCount = loginLogRepository.queryLoginCount("nima");
    return ResponseEntity.ok(loginCount.map(Object::toString).orElse(""));
  }

}
