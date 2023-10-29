package com.crudtdos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Generos")
@Data
public class Generos {
	@Id
	private int id_genero;
	private String descripcion;
}
