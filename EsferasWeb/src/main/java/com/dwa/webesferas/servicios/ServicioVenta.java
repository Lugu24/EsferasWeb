package com.dwa.webesferas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwa.webesferas.modelo.Venta;

@Service
public class ServicioVenta {
	@Autowired
	private RepoVentas repoVenta;

	private String Mensaje;

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public boolean agregar(Venta venta) {
		try {
			repoVenta.save(venta);
			this.Mensaje = "Venta Registrada con exito";
			return true;
		} catch (Exception e) {
			this.Mensaje = "Error al registrar la venta.";
			return false;
		}
	}

	public Iterable<Venta> verTodos() {
		try {
			this.Mensaje = "";
			return repoVenta.findAll();
		} catch (Exception e) {
			this.Mensaje = e.getMessage();
			return null;
		}
	}
	public Venta buscar(int id) {
	try {
		this.Mensaje="";
		Venta venta = repoVenta.findById(id).get();
		return venta== null? new Venta():venta;
	}catch (Exception e) {
		this.Mensaje=e.getMessage();
		return null;
	}
	
	
	}
}
