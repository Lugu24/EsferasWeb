package com.dwa.webesferas.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dwa.webesferas.modelo.Cliente;
import com.dwa.webesferas.servicios.ServicioCliente;

@Controller
public class ClienteController {
	@Autowired
	ServicioCliente servicioCliente; 
	
	@GetMapping(path = {"/cliente/Login","/"})
	public String Login() {
		return "cliente/Login";
	}
	
	@PostMapping("/cliente/Login")
	public String Login(@RequestParam("username") String correo,
			@RequestParam("password") String contrasena,
			Model modelo, HttpSession sesion) {
		
		return "redirect:/pagina/Index";	
	}
	
	@GetMapping("/cliente/Registro")
	public String registro(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/Registro";
	}
	
	@PostMapping("/cliente/Registro")
	public String registro(Model modelo, @ModelAttribute Cliente user,
			@RequestParam("contrasena") String clave,HttpSession sesion) {
		boolean res = servicioCliente.agregar(user,clave,sesion);
		if(res) {
			return "redirect:/pagina/Index";
		}
		modelo.addAttribute("error", servicioCliente.getMensaje());
		return "/cliente/Registro";
	}
	@GetMapping("/cliente/salir")
	public String salir(HttpSession sesion) {
		SecurityContextHolder.clearContext();
		sesion.invalidate();
		return "redirect:/";
	}
} 