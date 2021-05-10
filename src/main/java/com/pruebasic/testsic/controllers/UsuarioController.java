package com.pruebasic.testsic.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import com.pruebasic.testsic.models.UsuarioModel;
import com.pruebasic.testsic.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    @PostMapping()
    public UsuarioModel guardarUsuario(@Valid @RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/{nombre}")
    public UsuarioModel obtenerUsuarioPorNombre(@PathVariable("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre).get();
    }

  

    @GetMapping("/query2")
    public  ArrayList<UsuarioModel> findUsuarioModelById(@RequestParam("id") Long id){
        return  this.usuarioService.findUsuarioModelById(id);
    }
 
        
    @DeleteMapping(path = "/{id}")
        public String eliminarPorId(@PathVariable("id") Long id){
            boolean ok = this.usuarioService.eliminarUsuario(id);
            if(ok){
                return "Se eliminó el usuario con id" + id;
            }else{
                return "No se pudo eliminar el usuario con id"+ id;
            }
        }
}

    

