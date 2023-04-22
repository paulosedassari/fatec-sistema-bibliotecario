package br.com.fatec.sistema.bibliotecario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Mobile;
import br.com.fatec.sistema.bibliotecario.service.impl.ServiceBaseFaculdadeImpl;
import br.com.fatec.sistema.bibliotecario.service.impl.ServiceMobileImpl;

@RestController
@RequestMapping("/mobile")
@CrossOrigin
public class MobileController {

	@Autowired
	private ServiceBaseFaculdadeImpl serviceBaseFaculdade;

	@Autowired
	private ServiceMobileImpl serviceMobile;

	@GetMapping("/logar/{usuario}/{senha}")
	public Boolean logar(@PathVariable("usuario") String usuario, @PathVariable("senha") String senha) {
		return serviceMobile.logar(usuario, senha);
	}

	@PostMapping("/incluir")
	public Boolean incluirUsuario(@RequestBody Mobile usuario) {
		return serviceMobile.incluir(usuario);
	}

	@GetMapping("/userLogado/{ra}")
	public Optional<Mobile> buscarUsuario(@PathVariable("ra") String ra) {
		return serviceMobile.userLogado(ra);
	}

}
