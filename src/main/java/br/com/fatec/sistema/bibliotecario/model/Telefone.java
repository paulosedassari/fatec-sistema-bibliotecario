package br.com.fatec.sistema.bibliotecario.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.fatec.sistema.bibliotecario.enums.Status;
import lombok.Data;

@Data
@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone = 0l;

	private Long numero = 0l;

	private Status tipo = Status.CELULAR;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Telefone() {

	}

	public Telefone(Long numero, Status tipo, Usuario usuario) {
		this.numero = numero;
		this.tipo = tipo;
		this.usuario = usuario;
	}

}
