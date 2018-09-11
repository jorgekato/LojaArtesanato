/**
 * 
 */
package br.com.casadocodigo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe responsável por captar as exceções.
 * @ControllerAdvice - monitora todos os controllers da aplicação.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 11 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler ( Exception.class )
    public ModelAndView trataExcecaoGenerica ( Exception exception ) {
        System.out.println( "Erro genérico acontecendo:" );
        exception.printStackTrace();

        ModelAndView modelAndView = new ModelAndView( "error" );
        modelAndView.addObject( "exception" , exception );
        return modelAndView;
    }
}
