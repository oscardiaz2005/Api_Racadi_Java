package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Estudiante;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstuServicio {

    @Autowired
    private RepositorioEstudiante repositorioEstudiante;

    public Estudiante agregar(Estudiante estu) {
        return repositorioEstudiante.save((estu));

    }
        public List<Estudiante> listaEstudiantes(){
            return repositorioEstudiante.findAll();
        }


        //Metodo para actualizar un administrador
        public Estudiante actualizarEstu(String documento, Estudiante estu){
            return repositorioEstudiante.findById(documento).map(estudianteExistente -> {
                estudianteExistente.setNombre(estu.getNombre());
                estudianteExistente.setApellido(estu.getApellido());
                estudianteExistente.setFecha_nacimiento(estu.getFecha_nacimiento());
                estudianteExistente.setGenero(estu.getGenero());
                estudianteExistente.setCelular(estu.getCelular());
                estudianteExistente.setCorreo(estu.getCorreo());
                estudianteExistente.setDireccion(estu.getDireccion());
                estudianteExistente.setSede(estu.getSede());
                estudianteExistente.setUsuario(estu.getUsuario());
                estudianteExistente.setContrasena(estu.getContrasena());
                estudianteExistente.setNivel(estu.getNivel());
                estudianteExistente.setPlan(estu.getPlan());
                estudianteExistente.setFoto_perfil(estu.getFoto_perfil());
                return repositorioEstudiante.save(estudianteExistente);
            }).orElseThrow(() -> new RuntimeException("Profesor no encontrado con documento: " + documento));
        }


        public void eliminarEstu(String documento){
            repositorioEstudiante.deleteById(documento);
        }
    }


