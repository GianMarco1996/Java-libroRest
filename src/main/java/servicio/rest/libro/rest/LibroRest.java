package servicio.rest.libro.rest;

import java.util.ArrayList;
import java.util.List;

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
import servicio.rest.libro.service.inf.LibroService;

@RestController
@RequestMapping("/libros")
@Data
public class LibroRest {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public List<Libro> findAll(){
		try {
			List<Libro> libros = new ArrayList<Libro>();
			libros = this.getLibroService().findAll();
			return libros;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@GetMapping("/{id}")
	public Response findById(@PathVariable Long id) {
		try {
			Libro libro = new Libro();
			libro.setId(id);
			Libro objLibro = this.getLibroService().findById(libro);
			
			if(objLibro == null) {
				return new Response("0", "No existe libro con el id "+ id + " ingresado", null);
			}
			
			return new Response("1", "Si existe libro con el id "+ id+ " ingresado", objLibro);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping
	public Response save(@RequestBody Libro libro) {
		if(libro == null) {
			return new Response("0", "El libro es requerido", null);
		}
		
		if(libro.getNombre() == null || libro.getNombre().trim().length() < 5) {
			return new Response("0", "El nombre es requerido y debe tener como minimo 5 caracteres", null);
		}
		
		if(libro.getAutor() == null || libro.getAutor().trim().length() < 3) {
			return new Response("0", "El autor es requerido y debe tener como minimo 3 caracteres", null);
		}
		try {		
			Libro olibro = this.getLibroService().save(libro);
			if(olibro != null) {
				return  new Response("1", "El libro fue registrado exitosamente", olibro);
			}else {
				return  new Response("-1", "Error al registrar el libro",null);
			}
		} catch (Exception e) {
			return  new Response("-1", "Error al registrar el libro",null);
		}
	}
	
	@PutMapping("/{id}")
	public Response update(@PathVariable Long id, @RequestBody Libro libro) {
		if(id == null || id <= 0) {
			return new Response("0", "El id es requerido y debe ser mayor a cero", null);
		}
		try {
			Libro prmLibro = new Libro();
			prmLibro.setId(id);
			Libro objLibro = this.getLibroService().findById(prmLibro);
			if(objLibro == null) {
				return new Response("0", "No existe libro con el id "+ id +" ingresado", null);
			}
			
			libro.setId(id);
			BeanUtils.copyProperties(libro, prmLibro);
			return this.save(prmLibro);
				
		} catch (Exception e) {
			e.printStackTrace();
			return  new Response("-1", "Error al actualizar el libro",null);
		}
	}
	
	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Long id) {
	public Response delete(@PathVariable Long id) {
		if(id == null || id <= 0) {
			return new Response("0", "El id es requerido y debe ser mayor a cero", null);
		}
		try {
			Libro prmLibro = new Libro();
			prmLibro.setId(id);
			Libro objLibro = this.getLibroService().findById(prmLibro);
			if(objLibro == null) {
				return new Response("0", "No existe libro con el id "+ id +" ingresado", null);
			}
			
			//System.out.println(objLibro);
			this.getLibroService().delete(objLibro);
			return new Response("1", "Libro eliminado correctamente", null);
		} catch (Exception e) {
			return  new Response("-1", "Error al eliminar el libro",null);
		}
	}
	
	@DeleteMapping("/logico/{id}")
	public Response deleteLogico(@PathVariable Long id) {
		if(id == null || id <= 0) {
			return new Response("0", "El id es requerido y debe ser mayor a cero", null);
		}
		try {
			Libro prmLibro = new Libro();
			prmLibro.setId(id);
			Libro objLibro = this.getLibroService().findById(prmLibro);
			if(objLibro == null) {
				return new Response("0", "No existe libro con el id "+ id +" ingresado", null);
			}
			
			objLibro.setEstado("0");
			Libro oLibro= this.getLibroService().save(objLibro);
			if (oLibro!=null) {
				return  new Response("1", "El libro fue eliminado exitosamente", oLibro);
			}else {
				return  new Response("-1", "Error al eliminar el libro",null);
			}
			
		} catch (Exception e) {
			return  new Response("-1", "Error al eliminar el libro",null);
		}
	}
	
}
