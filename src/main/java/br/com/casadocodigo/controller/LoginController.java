package br.com.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Realizar o controle da view login <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 13 de mai de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Controller
public class LoginController {

	/**
	 * 
	 * Método que redireciona para a página de login
	 * 
	 * @return
	 */

	@RequestMapping( value = "/login", method = RequestMethod.GET )
	public String loginForm() {
		return "loginForm";

	}
}
