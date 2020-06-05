package com.uniajc.smartcampus.certificados.controllers.security;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uniajc.smartcampus.certificados.controllers.security.models.JwtUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -3301605591108950415L;

	@Value("${jwt.secret}")
	private String secret;

	public String getUsernameFromToken(String token) {
		String username = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				username = claims.getSubject();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return username;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				created = new Date((Long) claims.get(ClaimKeyType.CLAIM_KEY_CREATED.getValue()));
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date vencimiento = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				vencimiento = claims.getExpiration();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return vencimiento;
	}

	public String getAudienceFromToken(String token) {
		String audience = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				audience = (String) claims.get(ClaimKeyType.CLAIM_KEY_AUDIENCE.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());		
		}
		return audience;
	}

	public Integer getPegeIdFromToken(String token) {
		Integer pegeId = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				pegeId = (Integer) claims.get(ClaimKeyType.CLAIM_KEY_ID.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());		
		}
		return pegeId;
	}

	private Claims getClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date vencimiento = getExpirationDateFromToken(token);
		return (vencimiento != null) && vencimiento.before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}

}