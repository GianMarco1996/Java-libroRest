package servicio.rest.libro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "LIBRO")
public class Libro {
	
	@Id
	@Column(name = "ID")
	public Long id;
	
	@Column(name = "NOMBRE")
	public String nombre;
	
	@Column(name = "AUTOR")
	public String autor;
	
	@Column(name = "ESTADO")
	public String estado;

}
