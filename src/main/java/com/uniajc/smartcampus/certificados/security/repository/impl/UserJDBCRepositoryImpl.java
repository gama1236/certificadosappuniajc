package com.uniajc.smartcampus.certificados.security.repository.impl;

import com.uniajc.smartcampus.certificados.security.JwtUserFactory;
import com.uniajc.smartcampus.certificados.security.models.Authority;
import com.uniajc.smartcampus.certificados.security.models.JwtUser;
import com.uniajc.smartcampus.certificados.security.repository.UserJDBCRepository;
import com.uniajc.smartcampus.certificados.security.repository.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJDBCRepositoryImpl implements UserJDBCRepository {

    @Autowired
    @Qualifier("jdbcLogin")
    private JdbcTemplate jdbc;

    @Autowired
    private AuthorityJDBCRepositoryImpl authorityJDBC;

    @Override
    public JwtUser selectByLogin(String login) {
        List<Authority> list = authorityJDBC.selectByLogin(login);
        JwtUser user = jdbc.queryForObject("SELECT * FROM apps_uniajc.sec_usuario AS usuario WHERE usuario.login = ?", new Object[]{login}, new UserRowMapper());
        user.setAuthorities(JwtUserFactory.mapToGrantedAuthorities(list));
        return user;
    }

}
