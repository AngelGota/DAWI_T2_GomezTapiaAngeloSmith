package com.crudtdos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Libros")
@Data
public class Libros {
	@Id
	private int cod_libro;
	private String tit_libro;
	private int id_autor;
	private String fch_publicacion;
	private int id_genero;
	private double precio;
	private int estado;
	
	@ManyToOne
	@JoinColumn(name = "id_autor",
			updatable = false, insertable = false)
	private Autores objAutores;
	@ManyToOne
	@JoinColumn(name = "id_genero",
			updatable = false, insertable = false)
	private Generos objGeneros;
}
