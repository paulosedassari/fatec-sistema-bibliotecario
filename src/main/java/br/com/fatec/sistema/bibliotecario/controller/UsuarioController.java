package br.com.fatec.sistema.bibliotecario.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.sistema.bibliotecario.model.Telefone;
import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.repository.UsuarioRepository;
import br.com.fatec.sistema.bibliotecario.utils.Status;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

//	@GetMapping("/teste")
//	public List<Acervo> teste() {
//		List<Acervo> lista = new ArrayList<>();
//		Acervo a = new Acervo(1l, "Os Inovadores", "Strong", "08.10.2022", "DISPONIVEL", 12345l);
//		lista.add(a);
//		System.out.println("passou aqui");
//		return lista;
//	}

	@GetMapping("/incluir")
	public void incluirUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Paulo");
		usuario.setCpf("7777777");
		usuario.setCondicao(Status.ALUNO);
		usuario.setDtInclusao(LocalDateTime.now());
		usuario.setDtNascimento(LocalDate.of(2000, 3, 7));
		usuario.setEndereco(null);
		usuario.setRa(12345l);
		usuario.setObras(null);
		List<Telefone> tel = new ArrayList<>();
		tel.add(new Telefone(14996198385l, Status.CELULAR, usuario));
		usuario.setTelefone(tel);
		
		usuarioRepository.save(usuario);
	}

}
