package com.persistencia.consumidor.controles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.persistencia.consumidor.modelos.Usuario;

@RestController
public class ControleUsuario {

	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
		ResponseEntity<?> resposta = new RestTemplate()
				.postForEntity("http://localhost:8080/cadastrar-usuario",
						usuario, usuario.getClass());
		return resposta;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/obter")
	public ResponseEntity<List<Usuario>> obter() {
		List<Usuario> usuarios = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8080/obter-usuarios", usuarios.getClass());
		usuarios = resposta.getBody();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.FOUND);
	}
}

