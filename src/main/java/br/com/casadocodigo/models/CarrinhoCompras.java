/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 8 de abr de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */
package br.com.casadocodigo.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe responsável em adicionar o produto no carrinho de compras.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 8 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Component
public class CarrinhoCompras {

    private Map < CarrinhoItem , Integer > itens = new LinkedHashMap < CarrinhoItem , Integer >();

    
    /**
     * 
     * Método que adiciona itens ao carrinho de compras.
     * @param item
     */
    public void add ( CarrinhoItem item ) {
        itens.put( item , getQuantidade( item ) + 1 );
    }

    /**
     * Método que verifica se o item ja existe.
     * 
     * @param item
     * @return
     */
    private int getQuantidade ( CarrinhoItem item ) {
        if ( ! itens.containsKey( item ) ) {
            itens.put( item , 0 );
        }
        
        return itens.get( item );
    }
    
    
    /**
     * 
     * Método que retorna a quantidade de itens no carrinho
     * @return
     */
    public Integer getQuantidade() {
        return itens.values().stream().reduce( 0 ,(proximo, accumulator ) -> proximo + accumulator);
    }
}
