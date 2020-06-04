package com.uniajc.smartcampus.certificados.security.repository;

import com.uniajc.smartcampus.certificados.security.models.JwtUser;

public interface UserJDBCRepository {

	JwtUser selectByLogin(String login);
	
}
