package com.dwa.webesferas.servicios;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwa.webesferas.modelo.Cliente;

@Service
public class ServicioCliente {

	@Autowired
	private RepoCliente repoCliente;
	private String Mensaje;
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public boolean validar(String correo, String contrasena, HttpSession  sesion) {
		Cliente usr = repoCliente.validar(correo, encriptar(contrasena));
		if (usr != null) {
			sesion.setAttribute("Idcliente", usr.getIdcliente());
			Mensaje = usr.getNombre() + " - " + usr.getCorreo();
			return true;
		}
		Mensaje = "Datos de acceso incorrectos.";
		return false;
	}
	
	private byte[] encriptar(String contrasena) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(contrasena.getBytes("utf8"));
			return digest.digest();
		}catch (Exception e) {
			return null;
		}
	}
	public boolean agregar(Cliente c,String contrasena,HttpSession sesion) {
		try {
			c.setContrasena(encriptar(contrasena));
			//Insertar en la bd
			repoCliente.save(c);
			sesion.setAttribute("idcliente", c.getIdcliente());
			this.Mensaje = "Datos del usuario almacenados con éxito.";
			return true;
		}catch(Exception e){
			this.Mensaje = "Error al registar al usuario.";
			return false;
		}
	}
	
	public Cliente buscar(int id) {
		try {
			Cliente cli = repoCliente.findById(id).get();
			return cli == null ? new Cliente() : cli;
		
		}catch(Exception e){
		this.Mensaje = "No se pudo realizar la busqueda del usuario";
		return null;
		}
	}

}