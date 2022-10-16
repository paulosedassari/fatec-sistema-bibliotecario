package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class DadosEmprestimo implements Serializable {

	private static final long serialVersionUID = -3151329448427989527L;

	private String isbn = "";
	private String ra = "";

	public DadosEmprestimo() {

	}

	public DadosEmprestimo(String isbn, String ra) {
		this.isbn = isbn;
		this.ra = ra;
	}

}
