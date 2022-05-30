package com.persistencia.produtor.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.persistencia.produtor.entidades.Usuario;
import com.persistencia.produtor.repositorios.RepositorioUsuario;

@RestController
public class ControleUsuario {
	@Autowired
	private RepositorioUsuario repositorio;

	@PostMapping("/cadastrar-usuario")
	public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
		repositorio.save(usuario);
		return new ResponseEntity<Usuario>(HttpStatus.CREATED);
	}
	
	@GetMapping("/obter-usuarios")
	public ResponseEntity<List<Usuario>> obterUsuarios(){
		List<Usuario> usuarios = repositorio.findAll();
		return new ResponseEntity<>(usuarios, HttpStatus.FOUND);
	}
}

