package br.com.fatec.sistema.bibliotecario.service.relatorios.pdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.fatec.sistema.bibliotecario.model.Usuario;

public class UsuarioPDF {

	private List<Usuario> usuario;

	public UsuarioPDF(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(4);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.BLACK);

		cell.setPhrase(new Phrase("ID Usuario", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Usuario", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Categoria", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Data Inclusão", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);
	}

	/**
	 * É criado uma nova linha da tabela, porém agora com os valores vindos do Vo
	 * 
	 * @param table table Objeto criado com o número de colunas que a tabela terá
	 */
	private void writeTableData(PdfPTable table) {
		for (Usuario i : usuario) {
			table.addCell(String.valueOf(i.getIdUsuario()));
			table.addCell(String.valueOf(i.getNomeUsuario()));
			table.addCell(String.valueOf(i.getCategoria()));
			table.addCell(String.valueOf(i.getDtInclusaoUsuario()));
			table.addCell(String.valueOf(i.getEmail()));
		}
	}

	/**
	 * Cria o documento pdf e adiciona a tabela criada no mesmo
	 */
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(15);
		font.setColor(Color.BLACK);

		Paragraph p = new Paragraph("OBRAS EMPRESTADAS", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 2.8f, 2.5f, 2.5f, 2.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();
	}

}
