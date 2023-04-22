package br.com.fatec.sistema.bibliotecario.relatorios.xlsx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.utils.TratamentoDatas;

@Service
public class UsuarioExcel {

	@Autowired
	private TratamentoDatas tratamentoDatas;

	public ByteArrayInputStream gerarExcelEmprestimo(List<Usuario> usuario) throws IOException {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Relatorio - Usuários");

			Row row = sheet.createRow(0);

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			Cell cell = row.createCell(0);
			cell.setCellValue("Nome Usuário");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(1);
			cell.setCellValue("Nome obra");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(2);
			cell.setCellValue("ISBN/ISNN");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(3);
			cell.setCellValue("Data Empréstimo");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(4);
			cell.setCellValue("Data Devolução");
			cell.setCellStyle(headerCellStyle);

			Row dataRow = sheet.createRow(1);

			for (Usuario e : usuario) {
				dataRow.createCell(0).setCellValue(e.getIdUsuario());
				dataRow.createCell(1).setCellValue(e.getNomeUsuario());
				dataRow.createCell(2).setCellValue(e.getCategoria().toString());
				dataRow.createCell(3).setCellValue(tratamentoDatas.retornaDataCorreta(e.getDtInclusaoUsuario()));
				dataRow.createCell(4).setCellValue(e.getEmail());
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			return new ByteArrayInputStream(outputStream.toByteArray());
		}
	}

}
