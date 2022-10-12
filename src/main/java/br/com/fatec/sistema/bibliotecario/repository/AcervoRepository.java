package br.com.fatec.sistema.bibliotecario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.sistema.bibliotecario.model.Acervo;

public interface AcervoRepository extends JpaRepository<Acervo, Long> {
	
	

}
