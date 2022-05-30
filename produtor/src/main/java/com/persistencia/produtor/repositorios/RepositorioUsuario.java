package com.persistencia.produtor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencia.produtor.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}