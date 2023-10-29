package com.crudtdos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudtdos.model.Generos;

public interface IGeneroRepository extends JpaRepository<Generos, Integer> {

}
