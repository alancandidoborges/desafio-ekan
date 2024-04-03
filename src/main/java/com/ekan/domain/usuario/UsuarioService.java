package com.ekan.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;	
	
	@Transactional
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Boolean existsByLogin(String login) {
		return repository.existsByLogin(login);
	}
}
