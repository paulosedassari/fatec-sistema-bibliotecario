package br.com.fatec.sistema.bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.sistema.bibliotecario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	

}
