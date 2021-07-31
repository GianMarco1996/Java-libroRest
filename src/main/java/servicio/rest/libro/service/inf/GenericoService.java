package servicio.rest.libro.service.inf;

import java.util.List;
import java.util.Optional;

import servicio.rest.libro.service.exception.ServiceException;

public interface GenericoService<T> {

	T save(T t) throws ServiceException;
	
	List<T> findAll() throws ServiceException;
	
	Optional<T> findById(Long id) throws ServiceException;
	
	T findById(T t) throws ServiceException;
	
	void delete(T t) throws ServiceException;
	
}
