package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDate;
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
	private Long idObra = 0l;

	private String nomeObra = "";
	private String editora = "";
	private LocalDate dtPublicacao;
	private LocalDateTime dtInclusaoObra = LocalDateTime.now();
	private String isbn = "";

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Acervo() {

	}

	public Acervo(Long idObra, String nomeObra, String editora, LocalDate dtPublicacao, LocalDateTime dtInclusaoObra, Status status, String isbn) {
		this.idObra = idObra;
		this.nomeObra = nomeObra;
		this.editora = editora;
		this.dtPublicacao = dtPublicacao;
		this.dtInclusaoObra = dtInclusaoObra;
		this.status = status;
		this.isbn = isbn;
	}

}
