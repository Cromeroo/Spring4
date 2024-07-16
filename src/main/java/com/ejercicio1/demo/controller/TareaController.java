package com.ejercicio1.demo.controller;

import com.ejercicio1.demo.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejercicio1.demo.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> getAllTareas(){
        return tareaService.getAllTareas();
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea){
        return tareaService.createTarea(tarea);
    }

    @PutMapping("/{id}")
    public Tarea updateTarea(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        return tareaService.updateTarea(id, tareaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
        return ResponseEntity.ok().build();
    }



}
