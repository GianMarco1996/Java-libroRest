package servicio.rest.libro.service;

import java.util.List;
import java.util.Optional;

import servicio.rest.libro.domain.Libro;

public interface LibroService {

	Libro save(Libro libro);
	
	List<Libro> findAll();
	
	Optional<Libro> findById(Long id);
	
	void delete(Libro libro);
	
}
