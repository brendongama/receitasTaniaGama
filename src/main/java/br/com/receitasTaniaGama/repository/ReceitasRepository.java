package br.com.receitasTaniaGama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.receitasTaniaGama.model.Receita;

public interface ReceitasRepository extends JpaRepository<Receita, Integer>{

}
