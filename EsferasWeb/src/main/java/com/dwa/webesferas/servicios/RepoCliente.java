package com.dwa.webesferas.servicios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dwa.webesferas.modelo.Cliente;

public interface RepoCliente extends CrudRepository <Cliente, Integer>{
	@Query(value = "SELECT *FROM cliente WHERE Correo = ?1 AND contrasena = ?2 ", 
			nativeQuery = true)
	Cliente validar(String correo, byte[] contrasena);
}