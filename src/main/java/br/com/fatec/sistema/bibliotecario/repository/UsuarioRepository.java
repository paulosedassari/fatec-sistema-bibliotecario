package br.com.fatec.sistema.bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.sistema.bibliotecario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "SELECT * FROM usuario WHERE usuario.ra = :ra", nativeQuery = true)
	Usuario verificarUsuario(String ra);

	@Query(value = "SELECT * FROM usuario WHERE usuario.id_usuario = :id", nativeQuery = true)
	Usuario buscarUsuario(Long id);

	@Query(value = "UPDATE usuario SET bairro = :bairro, categoria = :categoria, cep = :cep, cpf = :cpf, email = :email, localidade = :localidade, logradouro = :logradouro, nome_usuario = :nomeUsuario, num_logradouro = :numLogradouro, ra = :ra, telefone = :telefone,  uf = :uf "
			+ "WHERE usuario.id_usuario = :idUsuario", nativeQuery = true)
	void update(Long idUsuario, String bairro, String categoria, String cep, String cpf, String email,
			String localidade, String logradouro, String nomeUsuario, Integer numLogradouro, String ra, String telefone,
			String uf);

//	@Query(value = "UPDATE usuario SET id_usuario = : WHERE usuario.ra = :ra", nativeQuery = true)
//	void update(Usuario usuario, Long id);

}
