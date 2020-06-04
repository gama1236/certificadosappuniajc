package com.uniajc.smartcampus.certificados.security.repository.impl;

import java.util.List;

import com.uniajc.smartcampus.certificados.security.models.Authority;
import com.uniajc.smartcampus.certificados.security.repository.AuthorityJDBCRepository;
import com.uniajc.smartcampus.certificados.security.repository.rowmapper.AuthorityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityJDBCRepositoryImpl implements AuthorityJDBCRepository {

	@Autowired
	@Qualifier("jdbcLogin")
	private JdbcTemplate jdbc;

	@Override
	public List<Authority> selectByLogin(String login) {
		String sql = "SELECT rol.rol_id AS ROL_ID, rol.rol_nombre AS ROL_NOMBRE, " +
				"rol.rol_descripcion AS ROL_DESCRIPCION, rol.rol_tipo AS ROL_TIPO, " +
				"rol.rol_estado AS ROL_ESTADO, rol.rol_publico AS ROL_PUBLICO " +
				"FROM apps_uniajc.sec_rol AS rol " +
				"INNER JOIN apps_uniajc.sec_usuario_rol AS usu_rol ON usu_rol.rol_id = rol.rol_id " +
				"INNER JOIN apps_uniajc.sec_usuario AS usuario ON usu_rol.usua_id = usuario.id_usuario " +
				"WHERE usuario.login = ?";
		return jdbc.query(sql, new Object[] { login }, new AuthorityRowMapper());
	}

}
