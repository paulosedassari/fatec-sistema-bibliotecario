package br.com.fatec.sistema.bibliotecario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BaseFaculdade implements Serializable {

	private static final long serialVersionUID = 4765529934746687896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBaseFaculdade = 0l;

	private String nomeUsuario = "";
	private String ra = "";
	private String cpf = "";
	private String curso = "";
	private String dtNascimento = "";

}
