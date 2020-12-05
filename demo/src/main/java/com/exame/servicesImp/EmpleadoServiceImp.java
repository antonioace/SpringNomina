package com.exame.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.commons.GenericServiceImp;
import com.example.dao.EmpleadoDAO;
import com.example.model.Empleado;
import com.example.services.EmpleadoService;

@Service
public class EmpleadoServiceImp extends GenericServiceImp<Empleado, String> implements EmpleadoService {
	@Autowired
	private EmpleadoDAO empleadoDAO;

	@Override
	public CrudRepository<Empleado, String> getDAO() {
		return empleadoDAO;
	}

}
