package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Acervo implements Serializable {

	private static final long serialVersionUID = 3457074876884361210L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0l;
	
	@Column(length = 50, nullable = true)
	private String nome = "";
	
	@Column(length = 25, nullable = true)
	private String editora = "";
	
	@Column(length = 10, nullable = true)
	private String dtInclusao = "";
	
	@Column(length = 15, nullable = true)
	private String situacao = "";
	
	@Column(length = 50, nullable = true)
	private Long isbn = 0l;

	public Acervo(Long id, String nome, String editora, String dtInclusao, String situacao, Long isbn) {
		this.id = id;
		this.nome = nome;
		this.editora = editora;
		this.dtInclusao = dtInclusao;
		this.situacao = situacao;
		this.isbn = isbn;
	}

}
