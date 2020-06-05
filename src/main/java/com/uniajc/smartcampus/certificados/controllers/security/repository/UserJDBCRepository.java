package com.uniajc.smartcampus.certificados.controllers.security.repository;

import com.uniajc.smartcampus.certificados.controllers.security.models.JwtUser;

public interface UserJDBCRepository {

	JwtUser selectByLogin(String login);
	
}
