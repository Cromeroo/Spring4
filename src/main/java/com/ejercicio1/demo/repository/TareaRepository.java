package com.ejercicio1.demo.repository;

import com.ejercicio1.demo.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea,Long> {


}
