package com.pruebasic.testsic.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.pruebasic.testsic.models.MarcaModel;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface MarcaRepository extends CrudRepository<MarcaModel, String>{
    public abstract ArrayList<MarcaModel> findByMarca(String marca);
}


