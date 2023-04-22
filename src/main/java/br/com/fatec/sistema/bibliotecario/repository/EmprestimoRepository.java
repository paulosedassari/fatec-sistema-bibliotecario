package br.com.fatec.sistema.bibliotecario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fatec.sistema.bibliotecario.model.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

	@Query(value = "select * from emprestimo e inner join usuario u on e.usuario_id = u.id_usuario inner join acervo on e.obra_id_obra = acervo.id_obra order by id_emprestimo asc", nativeQuery = true)
	public List<Emprestimo> buscar();

	@Query(value = "select * from emprestimo where dt_emprestimo between :primeiraData and :segundaData", nativeQuery = true)
	public List<Emprestimo> buscarRelatorioEmprestimoPorData(String primeiraData, String segundaData);

	@Query(value = "delete from emprestimo where id_emprestimo = :id", nativeQuery = true)
	public void apagarAssociacao(Long id);

	@Query(value = "select * from emprestimo where id_emprestimo = :id", nativeQuery = true)
	public Emprestimo buscaUm(Long id);
	
	@Query(value = "select count(*) from emprestimo where usuario_id = :id", nativeQuery = true)
	Integer verificaQtd(Long id);

}
