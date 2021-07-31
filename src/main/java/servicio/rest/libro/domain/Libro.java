package servicio.rest.libro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Libro")
@Table(name = "LIBRO")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLibro")
	@SequenceGenerator(name = "seqLibro", allocationSize = 1, sequenceName = "SEQ_LIBRO")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "AUTOR")
	private String autor;
	
	@Column(name = "ESTADO")
	private String estado;

}
