package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

	private String nome = "";
	private String cpf = "";
	private String email = "";
	private String telefone = "";
	private LocalDate dtNascimento;
	private LocalDateTime dtInclusao = LocalDateTime.now();
	private Long ra = 0l;
	private Integer cep = 0;
	private String localidade = "";
	private String bairro = "";
	private String logradouro = "";
	private Integer numero = 0;
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
			LocalDateTime dtInclusao, Long ra, Integer cep, String localidade, String bairro, String logradouro,
			Integer numero, String uf, Status categoria, List<Acervo> obras) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
		this.dtInclusao = dtInclusao;
		this.ra = ra;
		this.cep = cep;
		this.localidade = localidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.uf = uf;
		this.categoria = categoria;
		this.obras = obras;
	}

}
