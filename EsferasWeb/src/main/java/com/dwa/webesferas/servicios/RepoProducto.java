package com.dwa.webesferas.servicios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dwa.webesferas.modelo.Producto;

public interface RepoProducto extends CrudRepository<Producto, Integer>{
	@Query(value = "SELECT * FROM roducto", nativeQuery =true)
	ArrayList<Producto> todos();

}
