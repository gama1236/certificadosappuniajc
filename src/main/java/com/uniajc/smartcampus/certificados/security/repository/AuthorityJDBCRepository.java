package com.uniajc.smartcampus.certificados.security.repository;

import com.uniajc.smartcampus.certificados.security.models.Authority;

import java.util.List;

public interface AuthorityJDBCRepository {
  
  List<Authority> selectByLogin(String login);
  
}
