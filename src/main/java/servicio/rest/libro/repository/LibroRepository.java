package servicio.rest.libro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import servicio.rest.libro.domain.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

}
