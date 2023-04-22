package br.com.fatec.sistema.bibliotecario.service;

import java.util.List;

import br.com.fatec.sistema.bibliotecario.model.DadosEmprestimo;
import br.com.fatec.sistema.bibliotecario.model.Emprestimo;
import br.com.fatec.sistema.bibliotecario.model.EmprestimoCompleto;

public interface ServiceEmprestimo {

	List<EmprestimoCompleto> buscarTodos();

	Boolean associarEmprestimo(DadosEmprestimo dadosemprestimo);

	Boolean verificaRegistros(Long id);

	List<EmprestimoCompleto> relatorioEmprestimo(String primeiraData, String segundaData);

	void desassociar(Long id);

	Emprestimo buscarEmprestimo(Long id);

}
