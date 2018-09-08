package br.com.casadocodigo.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Configura as classes utilizadas pelo Spring na inicialização da aplicação. <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 
	 * Inicializa as configurações na inicialização da aplicação
	 * @return
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
	 */
    @Override
    protected Class < ? >[] getRootConfigClasses () {
		return new Class[] { SecurityConfiguration.class, AppWebConfiguration.class, JPAConfiguration.class };
    }

    /**
     * 
     * Método que retorna um array de classes de configurações.
     * 
     * @return
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
     */
    @Override
    protected Class < ? >[] getServletConfigClasses () {
		return new Class[] {};
    }

    @Override
    protected String[] getServletMappings () {
        return new String[] { "/" };
    }

    /**
     * Método que filtra os caracteres para ser em UTF-8
     * 
     * @return
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters()
     */
    @Override
    protected Filter[] getServletFilters () {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding( "UTF-8" );
        return new Filter[] { encodingFilter };
    }
    
    /** 
     * Método que retorna o mesmo caminho do arquivo sem alterá-lo.
     * @param registration
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#customizeRegistration(javax.servlet.ServletRegistration.Dynamic)
     */
    @Override
    protected void customizeRegistration ( Dynamic registration ) {
        registration.setMultipartConfig( new MultipartConfigElement( "" ) );
    }
    
    /** 
     * Método de configuração do profile a ser utilizado na inicialização do servidor. Profile configurado em JPAConfiguration no metodo DataSource
     * @param servletContext
     * @throws ServletException
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#onStartup(javax.servlet.ServletContext)
     */
    @Override
    public void onStartup ( ServletContext servletContext ) throws ServletException {
        super.onStartup( servletContext );
        servletContext.addListener( new RequestContextListener() );
        servletContext.setInitParameter( "spring.profiles.active" , "dev" );
    }
}
