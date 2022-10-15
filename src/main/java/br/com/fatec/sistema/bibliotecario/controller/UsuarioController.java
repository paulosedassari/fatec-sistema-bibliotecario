package br.com.fatec.sistema.bibliotecario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/buscarTodos")
	public List<Usuario> teste() {
		System.out.println("passou aqui");
		return usuarioRepository.findAll();
	}

	@PostMapping("/incluir")
	public void incluirUsuario(@RequestBody Usuario usuario) {
		System.out.println(usuario);
		usuarioRepository.save(usuario);
	}

}
