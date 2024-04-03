package com.ekan.config.security.configuration;

import com.ekan.domain.usuario.Usuario;
import com.ekan.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AuthenticationService {
	@Autowired
	final private UsuarioRepository repository;
	public AuthenticationService(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	public UserDetails findByLogin(String login) {
		return repository.findByLogin(login);
	}
	public Usuario login(String login, String password) {
		return repository.login(login, password);
	}
	@Transactional
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}	
	public boolean existsByLogin(String login) {
		return repository.existsByLogin(login);
	}
}
