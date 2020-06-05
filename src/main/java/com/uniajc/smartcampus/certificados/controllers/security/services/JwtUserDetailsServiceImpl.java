package com.uniajc.smartcampus.certificados.controllers.security.services;

import com.uniajc.smartcampus.certificados.controllers.security.repository.impl.UserJDBCRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserJDBCRepositoryImpl repo;

	@Override
	public UserDetails loadUserByUsername(String login) {
		return repo.selectByLogin(login);
	}

}
