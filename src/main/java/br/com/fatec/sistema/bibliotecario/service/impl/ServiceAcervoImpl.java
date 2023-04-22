package br.com.fatec.sistema.bibliotecario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.enums.Status;
import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.repository.AcervoRepository;
import br.com.fatec.sistema.bibliotecario.service.ServiceAcervo;

@Service
public class ServiceAcervoImpl implements ServiceAcervo {

	@Autowired
	private AcervoRepository acervoRepository;

	@Override
	public void alterar(Long id, Acervo acervo) {
		acervoRepository.update(acervoRepository.buscarObra(id).getIdObra(), acervo.getDtPublicacao(),
				acervo.getEditora(), acervo.getIsbn(), acervo.getNomeObra());
	}

	@Override
	public List<Acervo> buscarTodos() {
		return acervoRepository.findAll();
	}

	@Override
	public void incluirObra(Acervo acervo) {
		acervoRepository.save(acervo);
	}

	@Override
	public Boolean deletar(Long id) {
		return verificaSeEstaEmprestado(id);
	}

	@Override
	public List<Acervo> relatorioAcervo(String primeiraData, String segundaData) {
		return acervoRepository.buscarRelatorioAcervoPorData(primeiraData, segundaData);
	}

	@Override
	public void desassociarStatus(Long id) {
		acervoRepository.desassociarStatus(id);
	}

	private Boolean verificaSeEstaEmprestado(Long id) {

		Optional<Acervo> usuarioEncontrado = acervoRepository.findById(id);

		if (!usuarioEncontrado.get().getStatus().equals(Status.EMPRESTADO)) {
			acervoRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public Acervo verificarAcervo(String isbn) {
		return acervoRepository.verificarAcervo(isbn);
	}

	void atualizaStatusObra(Long idObra) {
		acervoRepository.atualizaStatusObra(idObra);
	}
}
