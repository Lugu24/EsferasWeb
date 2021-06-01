package com.dwa.webesferas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dwa.webesferas.servicios.ServicioCliente;

@Controller
public class PaginaController {
	@Autowired
	ServicioCliente servicioCliente;
	
	@GetMapping("/pagina/Index")
	public String index() {
		return "pagina/Index";
	}
}
