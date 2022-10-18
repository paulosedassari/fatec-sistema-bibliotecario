package br.com.fatec.sistema.bibliotecario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.repository.UsuarioRepository;

@Service
public class ServiceUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void alterar(Long id, Usuario usuario) {
//		usuarioRepository.update(usuario, id);
	}

	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	public void incluir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
