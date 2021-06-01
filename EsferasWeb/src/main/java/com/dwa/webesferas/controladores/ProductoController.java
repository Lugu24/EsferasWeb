package com.dwa.webesferas.controladores;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dwa.webesferas.modelo.Cliente;
import com.dwa.webesferas.modelo.Producto;
import com.dwa.webesferas.modelo.Venta;
import com.dwa.webesferas.servicios.ServicioCliente;
import com.dwa.webesferas.servicios.ServicioProducto;
import com.dwa.webesferas.servicios.ServicioVenta;

@Controller
public class ProductoController {
@Autowired
ServicioProducto servicioProducto;
@Autowired
ServicioCliente servicioCliente;
@Autowired
ServicioVenta servicioVenta;



@GetMapping("/producto/listar")
public String listar(Model modelo) {
	Iterable<Producto> producto= servicioProducto.verTodos();
	if(producto.iterator().hasNext()) {
		modelo.addAttribute("productos",producto);
	}
	else {
		modelo.addAttribute("error", "Aun no hay productos registrados");
	}
	modelo.addAttribute("producto", new Producto());
	if(!servicioProducto.getMensaje().equals("")) {
		modelo.addAttribute("error",servicioProducto.getMensaje());
	}
	return "/producto/producto";
}

@GetMapping("/producto/comprar/{id}")
public String comprar( Model modelo, @PathVariable int id,@ModelAttribute  Venta venta, 
		HttpSession sesion) {
	Enumeration<String> a = sesion.getAttributeNames();
	int iduser = Integer.parseInt(sesion.getAttribute("Idcliente").toString());
	
	Cliente cliente = servicioCliente.buscar(iduser);
		venta.setCliente(cliente); 
		
	LocalDate now = LocalDate.now();
		venta.setFecha(now);
	 
	Producto producto = servicioProducto.buscar(id);
		venta.setProducto(producto);
	
	BigDecimal precio = producto.getPrecio();
		venta.setTotal(precio);
	
	
	if(!servicioVenta.agregar(venta)) {
		modelo.addAttribute("error", servicioVenta.getMensaje());	
	}
	
	return "/producto/mensaje";
}

@GetMapping("/producto/registrar")
public String registrar(Model model) {
	model.addAttribute("producto", new Producto());
	return "/producto/Registro";
}
@PostMapping("/producto/registrar")
public String registrar(Model modelo, @ModelAttribute Producto producto) {
	
	boolean res = servicioProducto.agregar(producto);
	if(res) {
		return "redirect:/producto/listar";
	}
	modelo.addAttribute("error", servicioProducto.getMensaje());
	
	return "/producto/Registro";	
}

}
