package br.com.desafio.desafioorange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.desafioorange.model.Vacinas;

public interface VacinasDao extends JpaRepository<Vacinas, Integer> {

}
