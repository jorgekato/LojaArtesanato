package br.com.casadocodigo.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Configura as classes utilizadas pelo Spring <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class < ? >[] getRootConfigClasses () {
        // TODO Auto-generated method stub
        return null;
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
        return new Class[] { AppWebConfiguration.class , JPAConfiguration.class };
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
}
