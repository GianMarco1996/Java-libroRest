package servicio.rest.libro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import servicio.rest.libro.domain.Libro;
import servicio.rest.libro.repository.LibroRepository;
import servicio.rest.libro.service.LibroService;

@Service
@Data
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public Libro save(Libro libro) {
		return this.getLibroRepository().save(libro);
	}

	@Override
	public List<Libro> findAll() {
		return this.getLibroRepository().findAll();
	}

	@Override
	public Optional<Libro> findById(Long id) {
		return this.getLibroRepository().findById(id);
	}

	@Override
	public void delete(Libro libro) {
		this.getLibroRepository().delete(libro);
	}
	
	

}
