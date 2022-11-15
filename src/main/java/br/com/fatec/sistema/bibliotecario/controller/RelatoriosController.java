package br.com.fatec.sistema.bibliotecario.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.EmprestimoCompleto;
import br.com.fatec.sistema.bibliotecario.service.ServiceEmprestimo;
import br.com.fatec.sistema.bibliotecario.service.relatorios.EmprestadosPDF;
import br.com.fatec.sistema.bibliotecario.service.relatorios.TratamentoDatas;

@RestController
@RequestMapping("/relatorios")
@CrossOrigin
public class RelatoriosController {

	@Autowired
	private ServiceEmprestimo serviceEmprestimo;

	@Autowired
	private TratamentoDatas tratamentoDatas;

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

	@GetMapping("/download/emprestimo/pData={pData}/sData={sData}")
	public void downloadRelatorioEmprestimo(HttpServletResponse response, @PathVariable String pData,
			@PathVariable String sData) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=ObrasEmprestadas.pdf";
		response.setHeader(headerKey, headerValue);

		String primeiraData = tratamentoDatas.formatarData(pData);
		String segundaData = tratamentoDatas.formatarData(sData);

		List<EmprestimoCompleto> emprestimoCompleto = serviceEmprestimo.relatorioEmprestimo(primeiraData, segundaData);

		EmprestadosPDF exporter = new EmprestadosPDF(emprestimoCompleto);
		exporter.export(response);
	}

//	@PostMapping("/download/emprestimo")
//	public void downloadRelatorioEmprestimo(HttpServletResponse response, @RequestBody DadosRelatorios dados) {
//		System.out.println(dados.getPData());
//		System.out.println(dados.getSData());
//	}
}
