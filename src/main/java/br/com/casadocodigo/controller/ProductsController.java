package br.com.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.models.Produto;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe controladora de produtos.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@Controller
public class ProductsController {

    @RequestMapping ( "/produtos/form" )
    public String form () {
        return "/produtos/form";
    }

    @RequestMapping ( "/produtos" )
    public String save ( Produto produto ) {
        System.out.println( produto );
        return "/produtos/ok";
    }
}
