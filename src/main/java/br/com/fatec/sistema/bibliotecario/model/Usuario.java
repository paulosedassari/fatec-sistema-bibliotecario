package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.fatec.sistema.bibliotecario.utils.Status;
import lombok.Data;

@Data
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3610385707435226050L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario = 0l;

	private String nomeUsuario = "";
	private String cpf = "";
	private String email = "";
	private String telefone = "";
	private LocalDate dtNascimento;
	private LocalDate dtInclusaoUsuario = LocalDate.now();
	private String ra = "";
	private String cep = "";
	private String localidade = "";
	private String bairro = "";
	private String logradouro = "";
	private Integer numLogradouro = 0;
	private String uf = "";

	@Enumerated(EnumType.STRING)
	private Status categoria;

//	@OneToMany(mappedBy = "usuario")
//	private List<Telefone> telefone;

	@OneToMany(mappedBy = "usuario")
	private List<Acervo> obras;

	public Usuario() {

	}

	public Usuario(Long idUsuario, String nome, String cpf, String email, String telefone, LocalDate dtNascimento,
			LocalDate dtInclusao, String ra, String cep, String localidade, String bairro, String logradouro,
			Integer numLogradouro, String uf, Status categoria, List<Acervo> obras) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
		this.dtInclusaoUsuario = dtInclusao;
		this.ra = ra;
		this.cep = cep;
		this.localidade = localidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numLogradouro = numLogradouro;
		this.uf = uf;
		this.categoria = categoria;
		this.obras = obras;
	}

}
