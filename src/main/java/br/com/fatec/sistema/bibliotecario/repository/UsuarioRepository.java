package br.com.fatec.sistema.bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.sistema.bibliotecario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "SELECT * FROM usuario WHERE usuario.ra = :ra", nativeQuery = true)
	Usuario verificarUsuario(String ra);

//	void update(Usuario usuario, Long id);

//	@Query(value = "UPDATE usuario SET id_usuario = : WHERE usuario.ra = :ra", nativeQuery = true)
//	void update(Usuario usuario, Long id);

}
