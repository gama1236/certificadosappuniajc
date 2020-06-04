package com.uniajc.smartcampus.certificados.security;

import com.uniajc.smartcampus.certificados.security.models.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static Set<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority("ROLE_" + authority.getRolTipo()))
                .collect(Collectors.toSet());
    }

}
