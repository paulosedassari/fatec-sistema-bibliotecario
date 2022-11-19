package br.com.fatec.sistema.bibliotecario.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.sistema.bibliotecario.model.Acervo;

public interface AcervoRepository extends JpaRepository<Acervo, Long> {

	@Query(value = "SELECT * FROM acervo WHERE acervo.isbn = :isbn", nativeQuery = true)
	Acervo verificarAcervo(String isbn);

	@Query(value = "UPDATE acervo SET dt_publicacao = :dtPublicacao, editora = :editora, isbn = :isbn, nome_obra = :nomeObra WHERE id_obra = :idObra", nativeQuery = true)
	void update(Long idObra, LocalDate dtPublicacao, String editora, String isbn, String nomeObra);

	@Query(value = "SELECT * FROM acervo WHERE acervo.id_obra = :id", nativeQuery = true)
	Acervo buscarObra(Long id);

	@Query(value = "update acervo set status = 'EMPRESTADO' where id_obra = :idObra", nativeQuery = true)
	public void atualizaStatusObra(Long idObra);

	@Query(value = "select * from acervo where dt_inclusao_obra between :primeiraData and :segundaData", nativeQuery = true)
	public List<Acervo> buscarRelatorioAcervoPorData(String primeiraData, String segundaData);

}
