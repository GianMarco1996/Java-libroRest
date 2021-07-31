package servicio.rest.libro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import servicio.rest.libro.domain.Libro;
import servicio.rest.libro.repository.LibroRepository;
import servicio.rest.libro.service.exception.ServiceException;
import servicio.rest.libro.service.inf.LibroService;

@Service
@Data
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public Libro save(Libro libro) throws ServiceException {
		return this.getLibroRepository().save(libro);
	}

	@Override
	public List<Libro> findAll() throws ServiceException {
		return this.getLibroRepository().findAll();
	}

	/*@Override
	public Optional<Libro> findById(Long id) throws ServiceException {
		return this.getLibroRepository().findById(id);
	}*/

	@Override
	public void delete(Libro libro) throws ServiceException {
		this.getLibroRepository().delete(libro);
	}

	@Override
	public Libro findById(Libro libro) throws ServiceException {
		Optional<Libro> optLibro = this.getLibroRepository().findById(libro.getId());
		if (optLibro!=null) {
			if (optLibro.isPresent()) {
				return optLibro.get();
			}
		}
		return null;
	}

}
