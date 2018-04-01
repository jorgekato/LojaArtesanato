package br.com.casadocodigo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.controller.HomeController;
/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * *Configurações do Spring.
 *@EnableWebMvc - habilita utilização do Web MVC do Spring.
 *@ComponentScan - configura  o caminho(pacote) onde o SpringMVC encontrará os nossos controllers
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@EnableWebMvc
@ComponentScan( basePackageClasses = { HomeController.class, ProdutoDAO.class } )
public class AppWebConfiguration {

	/**
	 * Método que ajuda o Spring a encontrar as views, definindo o caminho e a
	 * extensão dos arquivos.
	 * 
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix( "/WEB-INF/views/" );
		resolver.setSuffix( ".jsp" );
		return resolver;
	}
}
