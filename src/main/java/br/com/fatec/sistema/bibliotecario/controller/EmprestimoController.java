package br.com.fatec.sistema.bibliotecario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.DadosEmprestimo;
import br.com.fatec.sistema.bibliotecario.model.Emprestimo;
import br.com.fatec.sistema.bibliotecario.service.ServiceEmprestimo;

@RestController
@RequestMapping("/emprestimo")
@CrossOrigin
public class EmprestimoController {

	@Autowired
	private ServiceEmprestimo serviceEmprestimo;

	@GetMapping("/buscarTodos")
	public List<Emprestimo> buscarTodos() {
		System.out.println("passou aqui");
		return serviceEmprestimo.findAll();
	}

	@PostMapping("/incluir")
	public void incluirEmprestimo(@RequestBody DadosEmprestimo dadosemprestimo) {
		serviceEmprestimo.associarEmprestimo(dadosemprestimo);
	}

}
