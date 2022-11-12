package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.fatec.sistema.bibliotecario.utils.Status;
import lombok.Data;

@Data
public class EmprestimoCompleto implements Serializable {

	private static final long serialVersionUID = 6233536982692507005L;

	private Long idEmprestimo = 0l;

	private LocalDateTime dtEmprestimo;
	private LocalDateTime dtDevolucao;

	private Long idUsuario = 0l;

	private String nomeUsuario = "";
	private String cpf = "";
	private String email = "";
	private String telefone = "";
	private LocalDate dtNascimento;
	private LocalDateTime dtInclusaoUsuario = LocalDateTime.now();
	private String ra = "";
	private String cep = "";
	private String localidade = "";
	private String bairro = "";
	private String logradouro = "";
	private Integer numLogradouro = 0;
	private String uf = "";
	private Status categoria;

	private Long idObra = 0l;
	private String nomeObra = "";
	private String editora = "";
	private LocalDate dtPublicacao;
	private LocalDateTime dtInclusaoObra = LocalDateTime.now();
	private String isbn = "";
	private Status status;

}
