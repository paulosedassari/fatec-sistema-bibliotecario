package br.com.fatec.sistema.bibliotecario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.BaseFaculdade;
import br.com.fatec.sistema.bibliotecario.repository.BaseFaculdadeRepository;
import br.com.fatec.sistema.bibliotecario.service.ServiceBaseFaculdade;

@Service
public class ServiceBaseFaculdadeImpl implements ServiceBaseFaculdade {

	@Autowired
	private BaseFaculdadeRepository baseRepository;

	@Override
	public Boolean logar(String usuario, String senha) {

		BaseFaculdade usuarioEncontrado = baseRepository.buscarUsuario(usuario);

		if (usuarioEncontrado == null) {
			return false;
		}

		return true;
	}

}
