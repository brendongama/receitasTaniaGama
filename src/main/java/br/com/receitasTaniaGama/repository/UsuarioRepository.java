package br.com.receitasTaniaGama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.receitasTaniaGama.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findBylogin(String login);

}
