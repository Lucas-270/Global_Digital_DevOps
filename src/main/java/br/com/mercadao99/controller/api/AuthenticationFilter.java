package br.com.mercadao99.controller.api;


import br.com.mercadao99.model.User;
import br.com.mercadao99.repository.UserRepository;
import br.com.mercadao99.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AuthenticationFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UserRepository repository;
	
	public AuthenticationFilter(TokenService tokenService, UserRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(
				HttpServletRequest request, 
				HttpServletResponse response, 
				FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = extractToken(request);
		
		boolean valid = tokenService.validate(token);
		
		if (valid) authenticate(token);
		
		filterChain.doFilter(request, response);
		
	}

	private void authenticate(String token) {
		Long id = tokenService.getUserId(token);
		
		Optional<User> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			User user = optional.get();
			UsernamePasswordAuthenticationToken auth = 
					new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(auth);		
		}
		
	}

	private String extractToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		
		if (header == null || header.isEmpty() || !header.startsWith("Bearer "))
			return null;
		
		return header.substring(7, header.length());
	}

}
