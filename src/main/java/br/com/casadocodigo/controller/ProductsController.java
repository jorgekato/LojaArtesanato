package br.com.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.models.Produto;
import br.com.casadocodigo.models.TipoPreco;

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

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping ( "produtos/form" )
    public ModelAndView form () {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject( "tipos", TipoPreco.values() );
        
        return modelAndView;
    }

    @RequestMapping ( "produtos" )
    public String save ( Produto produto ) {
        System.out.println( produto );
        produtoDAO.gravar(produto);
        return "/produtos/ok";
    }
}
