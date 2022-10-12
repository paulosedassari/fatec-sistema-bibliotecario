package br.com.fatec.sistema.bibliotecario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco = 0l;

	private String estado = "";
	private String cidade = "";
	private String bairro = "";
	private String rua = "";
	private Integer numero = 0;
	
	@ManyToOne
	@JoinColumn(name = "usuairo_id")
	private Usuario usuario;

	public Endereco() {
		
	}

	public Endereco(String estado, String cidade, String bairro, String rua, Integer numero,
			Usuario usuario) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.usuario = usuario;
	}

}
