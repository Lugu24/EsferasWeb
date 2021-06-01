package com.dwa.webesferas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwa.webesferas.modelo.Producto;

@Service
public class ServicioProducto
{
	@Autowired
	private RepoProducto repoProducto;

	private String Mensaje;

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public boolean agregar(Producto producto) {
		try {
			repoProducto.save(producto);
			this.Mensaje = "Producto registrado con exito";
			return true;
		} catch (Exception e) {
			this.Mensaje = "Error al registrar el producto.";
			return false;
		}
	}

	public Iterable<Producto> verTodos() {
		try {
			this.Mensaje = "";
			return repoProducto.findAll();
		} catch (Exception e) {
			this.Mensaje = e.getMessage();
			return null;
		}
	}
	public Producto buscar(int id) {
	try {
		this.Mensaje="";
		Producto producto = repoProducto.findById(id).get();
		return producto== null? new Producto():producto;
	}catch (Exception e) {
		this.Mensaje=e.getMessage();
		return null;
	}
	
	
	}
}
