package br.com.casadocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.models.Produto;
import br.com.casadocodigo.models.TipoPreco;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe controladora de produtos. <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@Controller
@RequestMapping ( "/produtos" )
public class ProductsController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping ( "/form" )
    public ModelAndView form () {
        ModelAndView modelAndView = new ModelAndView( "produtos/form" );
        modelAndView.addObject( "tipos" , TipoPreco.values() );
        return modelAndView;
    }
    /**
     * 
     * TODO Descrição do Método
     * @param produto
     * @param redirectAttributes - o atributo Flash só dura uma requisição, após isso ele deixa de existir.
     * @return
     */
    @RequestMapping ( method = RequestMethod.POST )
    public ModelAndView save ( Produto produto, RedirectAttributes redirectAttributes ) {
        System.out.println( produto );
        produtoDAO.gravar( produto );
        redirectAttributes.addFlashAttribute( "sucesso", "Produto cadastrado com sucesso!" );
        return new ModelAndView( "redirect:produtos" );
    }

    @RequestMapping ( method = RequestMethod.GET )
    public ModelAndView listar () {
        List < Produto > produtos = produtoDAO.find();
        ModelAndView modelAndView = new ModelAndView( "produtos/lista" );
        modelAndView.addObject( "produtos" , produtos );
        return modelAndView;
    }
}
