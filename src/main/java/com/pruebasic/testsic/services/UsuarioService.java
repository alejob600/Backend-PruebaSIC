package com.pruebasic.testsic.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pruebasic.testsic.models.UsuarioModel;
import com.pruebasic.testsic.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
        @Autowired
        UsuarioRepository usuarioRepository;

        public ArrayList<UsuarioModel> obtenerUsuarios(){
            return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        }

        public UsuarioModel guardarUsuario(UsuarioModel usuario){
            return usuarioRepository.save(usuario);
        }

        public Optional<UsuarioModel> obtenerPorId(Long id){
            return usuarioRepository.findById(id);
        }

       

        public ArrayList<UsuarioModel> findUsuarioModelById(Long id){
            return usuarioRepository.findUsuarioModelById(id);
        }

        public Optional<UsuarioModel> obtenerPorNombre(String nombre){
            return usuarioRepository.findByNombre(nombre);
        }

        public boolean eliminarUsuario (Long id){
            try {
                usuarioRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

}
