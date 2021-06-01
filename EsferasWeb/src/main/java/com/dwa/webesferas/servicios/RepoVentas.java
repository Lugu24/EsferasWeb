package com.dwa.webesferas.servicios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dwa.webesferas.modelo.Venta;

public interface RepoVentas extends CrudRepository<Venta, Integer>{
	@Query(value = "SELECT * FROM ventas", nativeQuery =true)
	ArrayList<Venta> todos();

}
