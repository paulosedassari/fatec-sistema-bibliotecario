package br.com.fatec.sistema.bibliotecario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.sistema.bibliotecario.model.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Long> {

	@Query(value = "SELECT * FROM mobile WHERE ra = :ra", nativeQuery = true)
	Optional<Mobile> buscarUsuario(String ra);

}
