package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.fatec.sistema.bibliotecario.enums.Status;
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
	private LocalDate dtInclusaoObra = LocalDate.now();
	private String isbn = "";
	private Integer numPaginas = 0;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Acervo() {

	}

	public Acervo(Long idObra, String nomeObra, String editora, LocalDate dtPublicacao, LocalDate dtInclusaoObra,
			Status status, String isbn, Integer numPaginas) {
		this.idObra = idObra;
		this.nomeObra = nomeObra;
		this.editora = editora;
		this.dtPublicacao = dtPublicacao;
		this.dtInclusaoObra = dtInclusaoObra;
		this.status = status;
		this.isbn = isbn;
		this.numPaginas = numPaginas;
	}

}
