package br.com.fatec.sistema.bibliotecario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sistema.bibliotecario.model.Usuario;
import br.com.fatec.sistema.bibliotecario.repository.UsuarioRepository;

@Service
public class ServiceUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> buscarUsuario(Long id) {
		return usuarioRepository.findById(id);
	}

	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	public void incluir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void alterar(Long id, Usuario usuario) {
		Usuario usuarioEncontrado = usuarioRepository.buscarUsuario(id);
		Long idUsuario = usuarioEncontrado.getIdUsuario();
		String bairro = usuario.getBairro();
		String categoria;

		if (usuario.getCategoria().name().equals("ALUNO")) {
			categoria = "ALUNO";
		} else {
			categoria = "FUNCIONARIO";
		}

		String cep = usuario.getCep();
		String cpf = usuario.getCpf();
		String email = usuario.getEmail();
		String localidade = usuario.getLocalidade();
		String logradouro = usuario.getLogradouro();
		String nomeUsuario = usuario.getNomeUsuario();
		Integer numLogradouro = usuario.getNumLogradouro();
		String ra = usuario.getRa();
		String telefone = usuario.getTelefone();
		String uf = usuario.getUf();
		usuarioRepository.update(idUsuario, bairro, categoria, cep, cpf, email, localidade, logradouro, nomeUsuario,
				numLogradouro, ra, telefone, uf);
	}

	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> relatorioUsuario(String primeiraData, String segundaData) {
		List<Usuario> result = usuarioRepository.buscarRelatorioUsuarioPorData(primeiraData, segundaData);
		return result;
	}

}
