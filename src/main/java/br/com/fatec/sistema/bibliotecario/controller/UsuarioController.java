package br.com.fatec.sistema.bibliotecario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Acervo;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@GetMapping("/teste")
	public List<Acervo> teste() {
		List<Acervo> lista = new ArrayList<>();
		Acervo a = new Acervo(1l, "Os Inovadores", "Strong", "08.10.2022", "DISPONIVEL", 12345l);
		lista.add(a);
		System.out.println("passou aqui");
		return lista;
	}

	@PostMapping("/incluir")
	public Acervo incluirUsuario(@RequestBody Acervo acervo) {
		System.out.println("bateu aqui");
		System.out.println(acervo.getId());
		System.out.println(acervo.getNome());
		System.out.println(acervo.getEditora());
		System.out.println(acervo.getDtInclusao());
		System.out.println(acervo.getSituacao());
		System.out.println(acervo.getIsbn());
		return new Acervo(acervo.getId(), acervo.getNome(), acervo.getEditora(), acervo.getDtInclusao(),
				acervo.getSituacao(), acervo.getIsbn());
	}

}
