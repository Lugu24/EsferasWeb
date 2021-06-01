package com.dwa.webesferas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dwa.webesferas.modelo.Venta;
import com.dwa.webesferas.servicios.ServicioVenta;

@Controller
public class VentasController {
@Autowired
ServicioVenta servicioVenta;

@GetMapping("/pagina/Ventas")
public String listar(Model modelo) {
	Iterable<Venta> ventas= servicioVenta.verTodos();
	if(ventas.iterator().hasNext()) {
		modelo.addAttribute("ventas",ventas);
	}
	else {
		modelo.addAttribute("error", "Aun no hay ventas registradas");
	}
	modelo.addAttribute("venta", new Venta());
	if(!servicioVenta.getMensaje().equals("")) {
		modelo.addAttribute("error",servicioVenta.getMensaje());
	}
	return "pagina/Ventas";
}
}
