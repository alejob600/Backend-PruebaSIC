package com.pruebasic.testsic.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pruebasic.testsic.models.MarcaModel;
import com.pruebasic.testsic.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class MarcaService {
    @Autowired
    MarcaRepository marcaRepository;
    
    public ArrayList<MarcaModel> obtenerMarcas(){
        return (ArrayList<MarcaModel>) marcaRepository.findAll();
    }

    public MarcaModel guardarMarca(MarcaModel marca){
        return marcaRepository.save(marca);
    }

    public Optional<MarcaModel> obtenerPorId(String id){
        return marcaRepository.findById(id);
    }
    

    public ArrayList<MarcaModel> obtenerPorMarca(String marca){
        return marcaRepository.findByMarca(marca);
    }

    public boolean eliminarMarca (String id){
        try {
            marcaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}

