package br.com.fatec.sistema.bibliotecario.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.model.DadosEmprestimo;
import br.com.fatec.sistema.bibliotecario.model.Emprestimo;
import br.com.fatec.sistema.bibliotecario.model.EmprestimoCompleto;
import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.repository.EmprestimoRepository;
import br.com.fatec.sistema.bibliotecario.service.ServiceEmprestimo;

@Service
public class ServiceEmprestimoImpl implements ServiceEmprestimo {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private ServiceUsuarioImpl serviceUsuarioImpl;

	@Autowired
	private ServiceAcervoImpl serviceAcervoImpl;

	@Override
	public List<EmprestimoCompleto> buscarTodos() {

		List<Emprestimo> result = emprestimoRepository.buscar();

		List<EmprestimoCompleto> listEmprestimo = new ArrayList<EmprestimoCompleto>();

		for (Emprestimo emprestimo : result) {
			EmprestimoCompleto emprestimoCompleto = new EmprestimoCompleto();

			emprestimoCompleto.setIdEmprestimo(emprestimo.getIdEmprestimo());
			emprestimoCompleto.setNomeUsuario(emprestimo.getUsuario().getNomeUsuario());
			emprestimoCompleto.setNomeObra(emprestimo.getObra().getNomeObra());
			emprestimoCompleto.setIsbn(emprestimo.getObra().getIsbn());
			emprestimoCompleto.setDtEmprestimo(emprestimo.getDtEmprestimo());
			emprestimoCompleto.setDtDevolucao(emprestimo.getDtDevolucao());

			listEmprestimo.add(emprestimoCompleto);

		}

		return listEmprestimo;
	}

	@Override
	public Boolean associarEmprestimo(DadosEmprestimo dadosemprestimo) {

		Usuario usuarioEncontrado = serviceUsuarioImpl.verificarUsuario(dadosemprestimo.getRa());
		Acervo acervoEncontrado = serviceAcervoImpl.verificarAcervo(dadosemprestimo.getIsbn());

		LocalDate date = LocalDate.now();
		Emprestimo novoEmprestimo = new Emprestimo(date, date.plusDays(7), acervoEncontrado, usuarioEncontrado);

		try {

			if (verificaRegistros(usuarioEncontrado.getIdUsuario())) {
				emprestimoRepository.save(novoEmprestimo);
				serviceAcervoImpl.atualizaStatusObra(acervoEncontrado.getIdObra());

				return true;
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao associar empréstimo. " + e);
		}

		return false;
	}

	@Override
	public Boolean verificaRegistros(Long id) {
		Integer qtdRegistros = emprestimoRepository.verificaQtd(id);

		if (qtdRegistros < 3) {
			return true;
		}

		return false;
	}

	@Override
	public List<EmprestimoCompleto> relatorioEmprestimo(String primeiraData, String segundaData) {

		List<Emprestimo> result = emprestimoRepository.buscarRelatorioEmprestimoPorData(primeiraData, segundaData);
		List<EmprestimoCompleto> listEmprestimo = new ArrayList<EmprestimoCompleto>();

		for (Emprestimo emprestimo : result) {
			EmprestimoCompleto emprestimoCompleto = new EmprestimoCompleto();

			emprestimoCompleto.setIdEmprestimo(emprestimo.getIdEmprestimo());
			emprestimoCompleto.setNomeUsuario(emprestimo.getUsuario().getNomeUsuario());
			emprestimoCompleto.setNomeObra(emprestimo.getObra().getNomeObra());
			emprestimoCompleto.setIsbn(emprestimo.getObra().getIsbn());
			emprestimoCompleto.setDtEmprestimo(emprestimo.getDtEmprestimo());
			emprestimoCompleto.setDtDevolucao(emprestimo.getDtDevolucao());

			listEmprestimo.add(emprestimoCompleto);
		}
		return listEmprestimo;
	}

	@Override
	public void desassociar(Long id) {
		emprestimoRepository.apagarAssociacao(id);
	}

	@Override
	public Emprestimo buscarEmprestimo(Long id) {
		Emprestimo findById = emprestimoRepository.buscaUm(id);
		return findById;
	}

}
