package br.com.fatec.sistema.bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.sistema.bibliotecario.model.Acervo;

public interface AcervoRepository extends JpaRepository<Acervo, Long> {

	@Query(value = "SELECT * FROM acervo WHERE acervo.isbn = :isbn", nativeQuery = true)
	Acervo verificarAcervo(String isbn);

}
