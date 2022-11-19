package br.com.fatec.sistema.bibliotecario.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Acervo;
import br.com.fatec.sistema.bibliotecario.model.EmprestimoCompleto;
import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.service.ServiceAcervo;
import br.com.fatec.sistema.bibliotecario.service.ServiceEmprestimo;
import br.com.fatec.sistema.bibliotecario.service.ServiceUsuario;
import br.com.fatec.sistema.bibliotecario.service.relatorios.TratamentoDatas;
import br.com.fatec.sistema.bibliotecario.service.relatorios.pdf.AcervoPDF;
import br.com.fatec.sistema.bibliotecario.service.relatorios.pdf.EmprestadosPDF;
import br.com.fatec.sistema.bibliotecario.service.relatorios.pdf.UsuarioPDF;
import br.com.fatec.sistema.bibliotecario.service.relatorios.xlsx.AcervoExcel;
import br.com.fatec.sistema.bibliotecario.service.relatorios.xlsx.EmprestadosExcel;
import br.com.fatec.sistema.bibliotecario.service.relatorios.xlsx.UsuarioExcel;

@RestController
@RequestMapping("/relatorios")
@CrossOrigin
public class RelatoriosController {

	@Autowired
	private ServiceEmprestimo serviceEmprestimo;

	@Autowired
	private ServiceAcervo serviceAcervo;

	@Autowired
	private ServiceUsuario serviceUsuario;

	@Autowired
	private AcervoExcel acervoExcel;

	@Autowired
	private UsuarioExcel usuarioExcel;

	@Autowired
	private EmprestadosExcel emprestadosExcel;

	@Autowired
	private TratamentoDatas tratamentoDatas;

	@GetMapping("/download/pdf/acervo/pData={pData}/sData={sData}")
	public void downloadRelatorioAcervoPDF(HttpServletResponse response, @PathVariable String pData,
			@PathVariable String sData) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=ObrasEmprestadas.pdf";
		response.setHeader(headerKey, headerValue);

		String primeiraData = tratamentoDatas.formatarDataParaPesquisaDB(pData);
		String segundaData = tratamentoDatas.formatarDataParaPesquisaDB(sData);

		List<Acervo> acervo = serviceAcervo.relatorioAcervo(primeiraData, segundaData);

		AcervoPDF exporter = new AcervoPDF(acervo);
		exporter.export(response);
	}

	@GetMapping("/download/pdf/usuario/pData={pData}/sData={sData}")
	public void downloadRelatorioUsuarioPDF(HttpServletResponse response, @PathVariable String pData,
			@PathVariable String sData) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=ObrasEmprestadas.pdf";
		response.setHeader(headerKey, headerValue);

		String primeiraData = tratamentoDatas.formatarDataParaPesquisaDB(pData);
		String segundaData = tratamentoDatas.formatarDataParaPesquisaDB(sData);

		List<Usuario> usuario = serviceUsuario.relatorioUsuario(primeiraData, segundaData);

		UsuarioPDF exporter = new UsuarioPDF(usuario);
		exporter.export(response);
	}

	@GetMapping("/download/pdf/emprestimo/pData={pData}/sData={sData}")
	public void downloadRelatorioEmprestimoPDF(HttpServletResponse response, @PathVariable String pData,
			@PathVariable String sData) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=ObrasEmprestadas.pdf";
		response.setHeader(headerKey, headerValue);

		String primeiraData = tratamentoDatas.formatarDataParaPesquisaDB(pData);
		String segundaData = tratamentoDatas.formatarDataParaPesquisaDB(sData);

		List<EmprestimoCompleto> emprestimoCompleto = serviceEmprestimo.relatorioEmprestimo(primeiraData, segundaData);

		EmprestadosPDF exporter = new EmprestadosPDF(emprestimoCompleto);
		exporter.export(response);
	}

	@GetMapping("/download/xlsx/acervo/pData={pData}/sData={sData}")
	public void downloadRelatorioAcervoXLSX(HttpServletResponse response, @PathVariable String pData,
			@PathVariable String sData) throws IOException {

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=RelatorioConclusão.xlsx");

		String primeiraData = tratamentoDatas.formatarDataParaPesquisaDB(pData);
		String segundaData = tratamentoDatas.formatarDataParaPesquisaDB(sData);

		List<Acervo> emprestimoCompleto = serviceAcervo.relatorioAcervo(primeiraData, segundaData);

		ByteArrayInputStream stream = acervoExcel.gerarExcelEmprestimo(emprestimoCompleto);
		IOUtils.copy(stream, response.getOutputStream());
	}

	@GetMapping("/download/xlsx/usuario/pData={pData}/sData={sData}")
	public void downloadRelatorioUsuarioXLSX(HttpServletResponse response, @PathVariable String pData,
			@PathVariable String sData) throws IOException {

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=RelatorioConclusão.xlsx");

		String primeiraData = tratamentoDatas.formatarDataParaPesquisaDB(pData);
		String segundaData = tratamentoDatas.formatarDataParaPesquisaDB(sData);

		List<Usuario> emprestimoCompleto = serviceUsuario.relatorioUsuario(primeiraData, segundaData);

		ByteArrayInputStream stream = usuarioExcel.gerarExcelEmprestimo(emprestimoCompleto);
		IOUtils.copy(stream, response.getOutputStream());
	}

	@GetMapping("/download/xlsx/emprestimo/pData={pData}/sData={sData}")
	public void downloadRelatorioEmprestimoXLSX(HttpServletResponse response, @PathVariable String pData,
			@PathVariable String sData) throws IOException {

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=RelatorioConclusão.xlsx");

		String primeiraData = tratamentoDatas.formatarDataParaPesquisaDB(pData);
		String segundaData = tratamentoDatas.formatarDataParaPesquisaDB(sData);

		List<EmprestimoCompleto> emprestimoCompleto = serviceEmprestimo.relatorioEmprestimo(primeiraData, segundaData);

		ByteArrayInputStream stream = emprestadosExcel.gerarExcelEmprestimo(emprestimoCompleto);
		IOUtils.copy(stream, response.getOutputStream());
	}

}
