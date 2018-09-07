package br.com.casadocodigo.aux;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeraSenha {

	public static void main(String[] args) {

		String senhaCriptografado = new BCryptPasswordEncoder().encode("jkato");
		System.out.println(senhaCriptografado);
	}

}
