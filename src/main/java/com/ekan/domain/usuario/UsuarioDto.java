package com.ekan.domain.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
	private Long   id;
	private String login;
	public UsuarioDto(Usuario usuario) {
		this.id    = usuario.getId();
		this.login = usuario.getLogin();
	}
}
