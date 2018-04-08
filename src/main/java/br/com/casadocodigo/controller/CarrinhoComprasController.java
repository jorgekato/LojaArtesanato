/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 8 de abr de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */
package br.com.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.DAO.ProdutoDAO;
import br.com.casadocodigo.models.CarrinhoCompras;
import br.com.casadocodigo.models.CarrinhoItem;
import br.com.casadocodigo.models.Produto;
import br.com.casadocodigo.models.TipoPreco;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe controladora do carrinho de compras.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 8 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@Controller
@RequestMapping ( "/carrinho" )
public class CarrinhoComprasController {

    @Autowired
    CarrinhoCompras carrinho;
    
    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/add")
    public ModelAndView add ( Integer produtoId , TipoPreco tipoPreco ) {
        ModelAndView modelAndView = new ModelAndView( "redirect:/produtos" );
        CarrinhoItem carrinhoItem = criaItem( produtoId , tipoPreco );
        carrinho.add(carrinhoItem);
        return modelAndView;
    }

    public CarrinhoItem criaItem ( Integer produtoId , TipoPreco tipoPreco ) {
        Produto produto = produtoDAO.find( produtoId );
        CarrinhoItem carrinhoItem = new CarrinhoItem( produto , tipoPreco );
        
        return carrinhoItem;
    }
}
