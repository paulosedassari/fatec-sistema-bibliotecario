package br.com.fatec.sistema.bibliotecario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.service.impl.ServiceUsuarioImpl;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private ServiceUsuarioImpl serviceUsuario;
	
	@GetMapping("/buscarUsuario/{id}")
	public Optional<Usuario> buscarUsuario(@PathVariable("id")Long id) {
		return serviceUsuario.buscarUsuario(id);
	}

	@GetMapping("/buscarTodos")
	public List<Usuario> buscarTodos() {
		return serviceUsuario.buscarTodos();
	}

	@PostMapping("/incluir")
	public void incluirUsuario(@RequestBody Usuario usuario) {
		serviceUsuario.incluir(usuario);
	}

	@PutMapping("/alterar/{id}")
	public void alterarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		serviceUsuario.alterar(id, usuario);
	}

	@DeleteMapping("/deletar/{id}")
	public void deletarUsuario(@PathVariable("id") Long id) {
		serviceUsuario.deletar(id);
	}

}
