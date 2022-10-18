package br.com.fatec.sistema.bibliotecario.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.repository.AcervoRepository;

@Service
public class ServiceAcervo {

	@Autowired
	private AcervoRepository acervoRepository;

	public void alterar(Long id, Acervo acervo) {
		Acervo acervoVerificado = acervoRepository.buscarObra(id);
		Long idObra = acervoVerificado.getIdObra();
		LocalDate dtPublicacao = acervo.getDtPublicacao();
		String editora = acervo.getEditora();
		String isbn = acervo.getIsbn();
		String nomeObra = acervo.getNomeObra();
		String status;

		if (acervo.getStatus().name() == "DISPONIVEL") {
			status = "DISPONIVEL";
		} else {
			status = "EMPRESTADO";
		}

		System.out.println(idObra + " " + dtPublicacao + " " + editora + " " + isbn + " " + nomeObra + " " + status);
		acervoRepository.update(idObra, dtPublicacao, editora, isbn, nomeObra, status);
	}

	public List<Acervo> buscarTodos() {
		return acervoRepository.findAll();
	}

	public void incluirObra(Acervo acervo) {
		acervoRepository.save(acervo);
	}

	public void deletar(Long id) {
		acervoRepository.deleteById(id);
	}

}
