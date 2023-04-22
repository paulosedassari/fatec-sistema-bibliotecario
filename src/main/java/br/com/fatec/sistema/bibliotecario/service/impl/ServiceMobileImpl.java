package br.com.fatec.sistema.bibliotecario.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.BaseFaculdade;
import br.com.fatec.sistema.bibliotecario.model.Mobile;
import br.com.fatec.sistema.bibliotecario.repository.BaseFaculdadeRepository;
import br.com.fatec.sistema.bibliotecario.repository.MobileRepository;
import br.com.fatec.sistema.bibliotecario.service.ServiceMobile;
import br.com.fatec.sistema.bibliotecario.utils.Encode;

@Service
public class ServiceMobileImpl implements ServiceMobile {

	@Autowired
	private MobileRepository mobileRepository;

	@Autowired
	private BaseFaculdadeRepository baseRepository;

	@Override
	public Boolean incluir(Mobile usuario) {

		codificaSenha(usuario);

		if (verificaSeUsuarioEstaNaBaseDaFatec(usuario.getRa())) {
			mobileRepository.save(usuario);
			return true;
		}

		return false;
	}

	private void codificaSenha(Mobile usuario) {
		usuario.setSenha(Encode.codificarSenha(usuario.getSenha()));
	}

	private Boolean verificaSeUsuarioEstaNaBaseDaFatec(String ra) {
		BaseFaculdade usuarioEncontrado = baseRepository.buscarUsuario(ra);

		if (usuarioEncontrado == null) {
			return false;
		}

		return true;
	}

	@Override
	public Boolean logar(String usuario, String senha) {

		Optional<Mobile> usuarioEncontrado = mobileRepository.buscarUsuario(usuario);

		if (usuarioEncontrado == null) {
			return false;
		}

		return true;
	}

	@Override
	public Optional<Mobile> userLogado(String ra) {
		return mobileRepository.buscarUsuario(ra);
	}

}
