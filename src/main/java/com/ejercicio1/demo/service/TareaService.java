package com.ejercicio1.demo.service;
import com.ejercicio1.demo.Exceptions.ResourceNotFoundException;

import com.ejercicio1.demo.model.Tarea;
import com.ejercicio1.demo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas(){
        return tareaRepository.findAll();
    }
    public Tarea updateTarea(Long id, Tarea tareaDetails) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id " + id));
        tarea.setTitulo(tareaDetails.getTitulo());
        tarea.setDescripcion(tareaDetails.getDescripcion());
        tarea.setEstado(tareaDetails.getEstado());
        return tareaRepository.save(tarea);
    }

    public void deleteTarea(Long id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id " + id));
        tareaRepository.delete(tarea);
    }

    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

}
