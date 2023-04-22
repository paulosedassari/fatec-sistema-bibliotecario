package br.com.fatec.sistema.bibliotecario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.DadosEmprestimo;
import br.com.fatec.sistema.bibliotecario.model.Emprestimo;
import br.com.fatec.sistema.bibliotecario.model.EmprestimoCompleto;
import br.com.fatec.sistema.bibliotecario.service.impl.ServiceAcervoImpl;
import br.com.fatec.sistema.bibliotecario.service.impl.ServiceEmprestimoImpl;

@RestController
@RequestMapping("/emprestimo")
@CrossOrigin
public class EmprestimoController {

	@Autowired
	private ServiceAcervoImpl serviceAcervo;

	@Autowired
	private ServiceEmprestimoImpl serviceEmprestimo;

	@GetMapping("/buscarTodos")
	public List<EmprestimoCompleto> buscarTodos() {
		List<EmprestimoCompleto> buscarTodos = serviceEmprestimo.buscarTodos();
		return buscarTodos;
	}

	@PostMapping("/incluir")
	public boolean incluirEmprestimo(@RequestBody DadosEmprestimo dadosemprestimo) {
		boolean associarEmprestimo = serviceEmprestimo.associarEmprestimo(dadosemprestimo);
		return associarEmprestimo;
	}

	@GetMapping("/desassociar/{id}")
	public void desassociarRegistro(@PathVariable("id") Long id) {
		Emprestimo emprestimoEncontrado = serviceEmprestimo.buscarEmprestimo(id);
		serviceAcervo.desassociarStatus(emprestimoEncontrado.getObra().getIdObra());
		serviceEmprestimo.desassociar(id);
	}

}
