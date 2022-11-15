package br.com.fatec.sistema.bibliotecario.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.model.DadosEmprestimo;
import br.com.fatec.sistema.bibliotecario.model.Emprestimo;
import br.com.fatec.sistema.bibliotecario.model.EmprestimoCompleto;
import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.repository.AcervoRepository;
import br.com.fatec.sistema.bibliotecario.repository.EmprestimoRepository;
import br.com.fatec.sistema.bibliotecario.repository.UsuarioRepository;

@Service
public class ServiceEmprestimo {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AcervoRepository acervoRepository;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

	public void associarEmprestimo(DadosEmprestimo dadosemprestimo) {

		Usuario usuarioEncontrado = usuarioRepository.verificarUsuario(dadosemprestimo.getRa());
		Acervo acervoEncontrado = acervoRepository.verificarAcervo(dadosemprestimo.getIsbn());

		LocalDate date = LocalDate.now();
		Emprestimo novoEmprestimo = new Emprestimo(date, date.plusDays(7), acervoEncontrado, usuarioEncontrado);

		try {

			emprestimoRepository.save(novoEmprestimo);

			acervoRepository.atualizaStatusObra(acervoEncontrado.getIdObra());

		} catch (Exception e) {

		}

	}

	public String formatarData(LocalDateTime localDateTime) {
		String dataFormatada = localDateTime.format(formatter);
		return dataFormatada;
	}

	public List<EmprestimoCompleto> relatorioEmprestimo(String primeiraData, String segundaData) {

		List<Emprestimo> result = emprestimoRepository.buscarrelatorioEmprestimoPorData(primeiraData, segundaData);
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

}
