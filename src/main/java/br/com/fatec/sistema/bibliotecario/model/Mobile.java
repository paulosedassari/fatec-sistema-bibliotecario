package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Mobile implements Serializable {

	private static final long serialVersionUID = 6613743415934111830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuarioMobile = 0l;

	private String nomeUsuario = "";
	private String ra = "";
	private String cpf = "";
	private String curso = "";
	private LocalDate dtCadastro = LocalDate.now();
	private String senha = "";

}
