package com.uniajc.smartcampus.certificados.controllers.security.repository;

import com.uniajc.smartcampus.certificados.controllers.security.models.Authority;

import java.util.List;

public interface AuthorityJDBCRepository {
  
  List<Authority> selectByLogin(String login);
  
}
