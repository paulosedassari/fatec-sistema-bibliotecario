package br.com.fatec.sistema.bibliotecario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.service.ServiceAcervo;

@RestController
@RequestMapping("/acervo")
@CrossOrigin
public class AcervoController {

	@Autowired
	private ServiceAcervo serviceAcervo;

	@GetMapping("/buscarTodos")
	public List<Acervo> buscarTodos() {
		return serviceAcervo.buscarTodos();
	}

	@PostMapping("/incluir")
	public void incluirObra(@RequestBody Acervo acervo) {
		System.out.println(acervo.getStatus());
		serviceAcervo.incluirObra(acervo);

	}

	@PutMapping("/alterar/{id}")
	public void alterarObra(@PathVariable("id") Long id, @RequestBody Acervo acervo) {
		serviceAcervo.alterar(id, acervo);
	}

	@DeleteMapping("/deletar/{id}")
	public void deletarObra(@PathVariable("id") Long id) {
		serviceAcervo.deletar(id);
	}

}
