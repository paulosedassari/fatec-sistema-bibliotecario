package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 2561274389411758845L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco = 0l;

	private Integer cep = 0;
	private String estado = "";
	private String localidade = "";
	private String bairro = "";
	private String logradouro = "";
	private Integer numero = 0;
	private String uf = "";

	@ManyToOne
	@JoinColumn(name = "usuairo_id")
	private Usuario usuario;

	public Endereco() {

	}

	public Endereco(Integer cep, String estado, String localidade, String bairro, String logradouro,
			Integer numero, String uf, Usuario usuario) {
		this.cep = cep;
		this.estado = estado;
		this.localidade = localidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.uf = uf;
		this.usuario = usuario;
	}

}
