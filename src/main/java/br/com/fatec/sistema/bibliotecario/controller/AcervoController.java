package br.com.fatec.sistema.bibliotecario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.repository.AcervoRepository;

@RestController
@RequestMapping("/acervo")
@CrossOrigin
public class AcervoController {

	@Autowired
	private AcervoRepository acervoRepository;

	@GetMapping("/buscarTodos")
	public List<Acervo> buscarTodos() {
		System.out.println("passou aqui");
		return acervoRepository.findAll();
	}

	@PostMapping("/incluir")
	public void incluirObra(@RequestBody Acervo acervo) {
		System.out.println(acervo);
		acervoRepository.save(acervo);
	}

}
