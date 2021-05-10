package com.pruebasic.testsic.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

import com.pruebasic.testsic.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findUsuarioModelById(Long id);
    Optional<UsuarioModel> findByNombre(String nombre);
}


