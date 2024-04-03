package com.ekan.domain.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	UserDetails findByLogin(String login);
	boolean existsByLogin(String login);
	List<Usuario> findByLoginContaining(String login);
	@Query(value = "select * from tab_usuario where login = :login and password = :password", nativeQuery = true)
	Usuario login(String login, String password);
}
