package com.uniajc.smartcampus.certificados.security;

import org.springframework.security.core.GrantedAuthority;

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
