package com.pruebasic.testsic.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import com.pruebasic.testsic.models.MarcaModel;
import com.pruebasic.testsic.services.MarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    MarcaService marcaService;

    @GetMapping()
    public ArrayList<MarcaModel> obtenerMarcas(){
        return marcaService.obtenerMarcas();        
    }

    @PostMapping()
    public MarcaModel guardarMarca(@Valid @RequestBody MarcaModel marca){
        return this.marcaService.guardarMarca(marca);
    }

    @GetMapping(path = "/{id}")
    public Optional<MarcaModel> obtenerMarcaPorId(@PathVariable("id") String id){
        return this.marcaService.obtenerPorId(id);
    }

    @GetMapping(path = "/{marca}")
    public ArrayList<MarcaModel> obtenerPorMarca(@PathVariable("marca") String marca){
        return this.marcaService.obtenerPorMarca(marca);
    }

    @DeleteMapping(path = "/{id}")
        public String eliminarPorId(@PathVariable("id") String id){
            boolean ok = this.marcaService.eliminarMarca(id);
            if(ok){
                return "Se eliminó el usuario con id" + id;
            }else{
                return "No se pudo eliminar el usuario con id"+ id;
            }
        }
}