package br.com.mercadao99.service;


import br.com.mercadao99.model.User;;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

	@Value("${mercadao99.jwt.duration}")
	private long duration;
	
	@Value("${mercadao99.jwt.secret}")
	private String secret;

	public String createToken(Authentication authenticate) {
		User user = (User) authenticate.getPrincipal();
		Date today = new Date();
		Date expiration = new Date(today.getTime() + duration);
		
		String token = Jwts.builder() 
						.setIssuer("EPICTaskAPI")
						.setSubject(user.getId().toString())
						.setIssuedAt(today)
						.setExpiration(expiration)
						.signWith(SignatureAlgorithm.HS256, secret)
						.compact();
		return token;
	}

	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			return false;
		}
		
	}

	public Long getUserId(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Long.valueOf(claims.getSubject());
	}

}
