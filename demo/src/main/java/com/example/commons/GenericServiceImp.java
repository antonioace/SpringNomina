package com.example.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public abstract class GenericServiceImp<T,ID extends Serializable> implements GenericService<T, ID>{

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return getDAO().save(entity);
	}

	@Override
	public void delete(ID id) {
		// TODO Auto-generated method stub
		 getDAO().deleteById(id);;
	}

	@Override
	public T get(ID id) {
	Optional <T> object=getDAO().findById(id);
	if(object.isPresent()) {
		return object.get();
		
	}
	return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getAll() {
		List <T> list=new ArrayList<>();
		getDAO().findAll().forEach(obj-> list.add(obj));
		
		return list;
		
		
	}
	public abstract CrudRepository<T,ID> getDAO();

}
