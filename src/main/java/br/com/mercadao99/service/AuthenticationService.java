package br.com.mercadao99.service;

import br.com.mercadao99.model.User;
import br.com.mercadao99.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByEmail(username);
		if (user.isEmpty()) throw new UsernameNotFoundException("user not found");
		return user.get();
	}
	
	public static PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
