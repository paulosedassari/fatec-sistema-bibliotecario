package br.com.fatec.sistema.bibliotecario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.service.ServiceUsuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private ServiceUsuario serviceUsuario;

	@GetMapping("/buscarTodos")
	public List<Usuario> buscarTodos() {
		return serviceUsuario.buscarTodos();
	}

	@PostMapping("/incluir")
	public void incluirUsuario(@RequestBody Usuario usuario) {
		System.out.println(usuario);
		serviceUsuario.incluir(usuario);
	}

	@PutMapping("/alterar/{id}")
	public void alterarUsuario(@PathVariable("id")Long id, @RequestBody Usuario usuario) {
		serviceUsuario.alterar(id, usuario);
	}

}
