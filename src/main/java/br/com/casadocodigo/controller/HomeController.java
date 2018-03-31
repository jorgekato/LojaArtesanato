package br.com.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author jorge
 *
 */

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		System.out.println( "Entrando na home da CDC" );
		return "home";
	}
}
