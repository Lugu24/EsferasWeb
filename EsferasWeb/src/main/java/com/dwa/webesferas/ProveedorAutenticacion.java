package com.dwa.webesferas;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dwa.webesferas.servicios.ServicioCliente;


@Component
public class ProveedorAutenticacion implements AuthenticationProvider {
	@Autowired
	ServicioCliente serviciocliente;
	
	@Override
	public Authentication authenticate (Authentication authentication) 
				throws AuthenticationException{
		
		String correo = authentication.getName();
		String contrasena = authentication.getCredentials().toString();
		HttpServletRequest request =
				((ServletRequestAttributes) 
						RequestContextHolder.getRequestAttributes()).getRequest();
		if(serviciocliente.validar(correo,contrasena,request.getSession())) {
			return new UsernamePasswordAuthenticationToken(correo+contrasena,contrasena, new ArrayList<>());
		}
		else {
			throw new
			BadCredentialsException("Usuario o contraseña incorrecta");
		}
		
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
