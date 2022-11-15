package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class DadosRelatorios implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pData = "";
	private String sData = "";

}
