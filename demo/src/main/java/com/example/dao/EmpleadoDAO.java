package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Empleado;

public interface EmpleadoDAO extends CrudRepository<Empleado, String> {

}
