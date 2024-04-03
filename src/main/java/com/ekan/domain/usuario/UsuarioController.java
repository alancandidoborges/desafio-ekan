package com.ekan.domain.usuario;

import java.util.List;
import java.util.Optional;

import com.ekan.enums.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {
	
	  @Autowired
	  private UsuarioService service;

	  @Operation(summary = "Inclui um novo registro", method = "POST")
	  @PostMapping("/post")
	  public ResponseEntity<Object> save(@RequestBody @Valid Usuario usuario) {

	    if (service.existsByLogin(usuario.getLogin())){
	      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.RECORD_ALREADY_EXISTS.toString());
	    }

		  Usuario newUsuario = new Usuario();
	    
	    usuario.setId(null);
		String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
		usuario.setPassword(encryptedPassword);
		newUsuario = service.save(usuario);

	    if (newUsuario == null)
	      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.RECORD_NOT_SAVED.toString());

	    return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Registrado com sucesso");
	  }
}
