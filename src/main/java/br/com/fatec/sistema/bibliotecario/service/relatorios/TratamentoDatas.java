package br.com.fatec.sistema.bibliotecario.service.relatorios;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class TratamentoDatas {

	public String formatarDataParaPesquisaDB(String data) {

		String[] temp = data.split(" ");
		String dataFormat = "";

		switch (temp[1].trim()) {
		case "Jan":
			temp[1] = "01";
			break;
		case "Feb":
			temp[1] = "02";
			break;
		case "Mar":
			temp[1] = "03";
			break;
		case "Apr":
			temp[1] = "04";
			break;
		case "May":
			temp[1] = "05";
			break;
		case "Jun":
			temp[1] = "06";
			break;
		case "Jul":
			temp[1] = "07";
			break;
		case "Aug":
			temp[1] = "08";
			break;
		case "Sep":
			temp[1] = "09";
			break;
		case "Oct":
			temp[1] = "10";
			break;
		case "Nov":
			temp[1] = "11";
			break;
		case "Dec":
			temp[1] = "12";
			break;
		default:
			break;
		}

		dataFormat = temp[3].concat("/").concat(temp[1]).concat("/").concat(temp[2]);

		return dataFormat;
	}

	public String retornaDataCorreta(LocalDate data) {
		
		String string = data.toString();

		String[] temp = string.split("-");
		String dataFormat = "";

		dataFormat = temp[2].concat("/").concat(temp[1]).concat("/").concat(temp[0]);

		return dataFormat;

	}

}
