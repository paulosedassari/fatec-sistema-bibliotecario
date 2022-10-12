package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.fatec.sistema.bibliotecario.utils.Status;
import lombok.Data;

@Data
@Entity
public class Acervo implements Serializable {

	private static final long serialVersionUID = 3457074876884361210L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAcervo = 0l;

	private String nome = "";
	private String editora = "";
	private LocalDateTime dtInclusao = LocalDateTime.now();
	private Long isbn = 0l;
	
	@Enumerated(EnumType.STRING)
	private Status situacao = Status.DISPONIVEL;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Acervo(Long idAcervo, String nome, String editora, LocalDateTime dtInclusao, Status situacao, Long isbn) {
		this.idAcervo = idAcervo;
		this.nome = nome;
		this.editora = editora;
		this.dtInclusao = dtInclusao;
		this.situacao = situacao;
		this.isbn = isbn;
	}

}
