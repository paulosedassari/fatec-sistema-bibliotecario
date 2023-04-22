package br.com.fatec.sistema.bibliotecario.service;

import java.util.List;

import br.com.fatec.sistema.bibliotecario.model.Acervo;

public interface ServiceAcervo {

	public void alterar(Long id, Acervo acervo);

	public List<Acervo> buscarTodos();

	public void incluirObra(Acervo acervo);

	public Boolean deletar(Long id);

	public List<Acervo> relatorioAcervo(String primeiraData, String segundaData);

	public void desassociarStatus(Long id);

}
