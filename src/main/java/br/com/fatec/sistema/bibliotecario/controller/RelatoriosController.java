package br.com.fatec.sistema.bibliotecario.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.EmprestimoCompleto;
import br.com.fatec.sistema.bibliotecario.service.ServiceEmprestimo;
import br.com.fatec.sistema.bibliotecario.service.relatorios.EmprestadosPDF;

@RestController
@RequestMapping("/relatorios")
@CrossOrigin
public class RelatoriosController {

	@Autowired
	private ServiceEmprestimo serviceEmprestimo;

	@GetMapping("/emprestimos")
	public void downloadPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=ObrasEmprestadas.pdf";
		response.setHeader(headerKey, headerValue);

		List<EmprestimoCompleto> emprestimoCompleto = serviceEmprestimo.buscarTodos();

		EmprestadosPDF exporter = new EmprestadosPDF(emprestimoCompleto);
		exporter.export(response);

	}

}
