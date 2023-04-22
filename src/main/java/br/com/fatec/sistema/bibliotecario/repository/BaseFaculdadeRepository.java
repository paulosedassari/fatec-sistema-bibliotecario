package br.com.fatec.sistema.bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.sistema.bibliotecario.model.BaseFaculdade;

public interface BaseFaculdadeRepository extends JpaRepository<BaseFaculdade, Long> {

	@Query(value = "SELECT * FROM base_faculdade WHERE ra = :ra", nativeQuery = true)
	BaseFaculdade buscarUsuario(String ra);

}
