package com.crudtdos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudtdos.model.Libros;

public interface ILibrosRepository extends JpaRepository<Libros, Integer>{

}
