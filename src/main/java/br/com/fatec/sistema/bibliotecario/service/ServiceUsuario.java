package br.com.fatec.sistema.bibliotecario.service;

import java.util.List;
import java.util.Optional;

import br.com.fatec.sistema.bibliotecario.model.Usuario;

public interface ServiceUsuario {

	Optional<Usuario> buscarUsuario(Long id);

	List<Usuario> buscarTodos();

	void incluir(Usuario usuario);

	void alterar(Long id, Usuario usuario);

	void deletar(Long id);

	List<Usuario> relatorioUsuario(String primeiraData, String segundaData);

	Usuario verificarUsuario(String ra);

}
