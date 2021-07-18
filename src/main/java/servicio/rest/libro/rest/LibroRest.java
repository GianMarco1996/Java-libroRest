package servicio.rest.libro.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import servicio.rest.libro.domain.Libro;
import servicio.rest.libro.service.LibroService;

@RestController
@RequestMapping("/libros")
@Data
public class LibroRest {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public List<Libro> findAll() {
		List<Libro> libros = new ArrayList<Libro>();
		libros = this.getLibroService().findAll();
		return libros;
	}
	
	@GetMapping("/{id}")
	public Libro findById(@PathVariable Long id) {
		Optional<Libro> libro = this.getLibroService().findById(id);
		if(libro != null && libro.isPresent()){
			return libro.get();
		}
		return null;
	}
	
	@PostMapping
	public Libro save(@RequestBody Libro libro) {
		return this.getLibroService().save(libro);
	}
	
	@PutMapping("/{id}")
	public Libro update(@PathVariable Long id, @RequestBody Libro libro) {
		Libro olibro = this.findById(id);
		if(olibro != null) {
			libro.setId(id);
			BeanUtils.copyProperties(libro, olibro);
			return this.getLibroService().save(olibro);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Libro libro = this.findById(id);
		if(libro != null) {
			this.getLibroService().delete(libro);
		}
	}
	
	
	@DeleteMapping("/logico/{id}")
	public Libro deleteLogico(@PathVariable Long id) {
		Libro libro = this.findById(id);
		if(libro != null) {
			libro.setEstado("0");
			this.getLibroService().save(libro);
		}
		return null;
	}
}
