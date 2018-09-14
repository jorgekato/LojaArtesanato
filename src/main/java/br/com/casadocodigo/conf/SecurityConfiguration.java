package br.com.casadocodigo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.casadocodigo.DAO.UsuarioDAO;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe de configuração que armazena as configurações de segurança.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 27 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/**
	 * 
	 * Método que configura as permissões de acesso as views.
	 * A ordem inserida é relevante
	 * @param http
	 * @throws Exception
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure( HttpSecurity http ) throws Exception {

		http.authorizeRequests()
		.antMatchers( "/produtos/form" ).hasRole("ADMIN")
		.antMatchers( "/carrinho/**" ).permitAll()
//		.antMatchers( "/pagamento/**" ).permitAll()
		.antMatchers( "/resources/**" ).permitAll()
		.antMatchers( "/url-magica-maluca-faldfakjgdal34tldt4ef3fvnw62" ).permitAll()
		.antMatchers( HttpMethod.POST, "/produtos" ).hasRole( "ADMIN" )
		.antMatchers( HttpMethod.GET, "/produtos" ).hasRole( "ADMIN" )
		.antMatchers( "/produtos/**" ).permitAll()	//permite acesso a todas as view que não estejam bloqueadas.
		.antMatchers( "/" ).permitAll()
		.anyRequest().authenticated()		//verifica todo request para saber se esta autenticado.
		.and().formLogin().loginPage( "/login" ).permitAll() // caso não esteja autenticado, envia para view de login.
		.and().logout().logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) );
	}
	
	
	/**
	 * 
	 * Método de configuração de autenticação do Spring para utilizar a classe UsuarioDAO
	 * userDetailsService - espera receber um objeto que implemente um interface com o mesmo 
	 * nome. Com isso, a classe UsuarioDAO deve implementar esta interface;
	 * 
	 * BCryptPasswordEncoder - classe de configuração de codificação de senhas dos usuários.
	 * 
	 * @param auth
	 * @throws Exception
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
		
		auth.userDetailsService( usuarioDAO )
		.passwordEncoder( new BCryptPasswordEncoder() );  
	}

}
