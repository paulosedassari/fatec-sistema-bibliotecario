package br.com.fatec.sistema.bibliotecario.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatarData {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static String formatarData(LocalDateTime localDateTime) {
		String dataFormatada = localDateTime.format(formatter);
		return dataFormatada;
	}

}
