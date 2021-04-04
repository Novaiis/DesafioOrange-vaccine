package br.com.desafio.desafioorange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.desafioorange.model.Usuarios;

public interface UsuariosDao extends JpaRepository<Usuarios, Integer> {

}
