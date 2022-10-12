package br.com.fatec.sistema.bibliotecario.model;

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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario = 0l;

	private String nome = "";

	private String cpf = "";

	private LocalDate dtNascimento;

	private LocalDateTime dtInclusao = LocalDateTime.now();

	private Long ra = 0l;

	@Enumerated(EnumType.STRING)
	private Status condicao;

	@OneToMany(mappedBy = "usuario")
	private List<Endereco> endereco;

	@OneToMany(mappedBy = "usuario")
	private List<Telefone> telefone;

	@OneToMany(mappedBy = "usuario")
	private List<Acervo> obras;

}
