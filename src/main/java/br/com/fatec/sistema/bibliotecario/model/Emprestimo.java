package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 7157522348823391398L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmprestimo = 0l;

	private LocalDateTime dtEmprestimo;
	private LocalDateTime dtDevolucao;

	@OneToOne
	private Acervo obra;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Emprestimo() {

	}

	public Emprestimo(LocalDateTime dtEmprestimo, LocalDateTime dtDevolucao, Acervo idObra,
			Usuario idUsuario) {
		this.dtEmprestimo = dtEmprestimo;
		this.dtDevolucao = dtDevolucao;
		this.obra = idObra;
		this.usuario = idUsuario;
	}

}
