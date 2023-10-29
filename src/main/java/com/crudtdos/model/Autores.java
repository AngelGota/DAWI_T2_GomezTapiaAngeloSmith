package com.crudtdos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Autores")
@Data
public class Autores {
	@Id
	private int id_autor;
	private String nombre;
	private String apellido;
}
