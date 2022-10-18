package br.com.fatec.sistema.bibliotecario.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.utils.Status;

public interface AcervoRepository extends JpaRepository<Acervo, Long> {

	@Query(value = "SELECT * FROM acervo WHERE acervo.isbn = :isbn", nativeQuery = true)
	Acervo verificarAcervo(String isbn);

	@Query(value = "UPDATE acervo SET dt_publicacao = :dtPublicacao, editora = :editora, isbn = :isbn, nome_obra = :nomeObra, status = :status WHERE id_obra = :idObra", nativeQuery = true)
	void update(Long idObra, LocalDate dtPublicacao, String editora, String isbn, String nomeObra, String status);

}
