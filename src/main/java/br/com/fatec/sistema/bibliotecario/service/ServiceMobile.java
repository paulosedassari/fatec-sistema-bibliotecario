package br.com.fatec.sistema.bibliotecario.service;

import java.util.Optional;

import br.com.fatec.sistema.bibliotecario.model.Mobile;

public interface ServiceMobile {

	Boolean incluir(Mobile usuario);

	Boolean logar(String usuario, String senha);

	Optional<Mobile> userLogado(String id);

}
