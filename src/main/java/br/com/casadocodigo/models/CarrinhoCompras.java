/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 8 de abr de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */
package br.com.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe responsável em adicionar o produto no carrinho de compras. <br>
 * WebApplicationContext.SCOPE_SESSION - cria o carrinho no scopo da sessão,
 * assim seja únicoa para cada usuário que entrar na aplicação. O scope Default
 * é o SCOPE.APPLICATION HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 
 * * @Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS) - utilizando o proxyMode, não 
 * será necessário mais anotá-las com @Scope(value = WebApplicationContext.SCOPE_REQUEST)
 * 8 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@Component
@Scope ( value = WebApplicationContext.SCOPE_SESSION )
public class CarrinhoCompras implements Serializable{

    /**
     * TODO Comentar atributo
     */
    private static final long serialVersionUID = 1L;
    private Map < CarrinhoItem , Integer > itens = new LinkedHashMap < CarrinhoItem , Integer >();

    /**
     * 
     * Método que adiciona itens ao carrinho de compras.
     * 
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
    public int getQuantidade ( CarrinhoItem item ) {
        if ( ! itens.containsKey( item ) ) {
            itens.put( item , 0 );
        }
        return itens.get( item );
    }

    /**
     * 
     * Método que retorna a quantidade de itens no carrinho
     * 
     * @return
     */
    public Integer getQuantidade () {
        return itens.values().stream().reduce( 0 , ( proximo , accumulator ) -> proximo + accumulator );
    }

    /**
     * 
     * Método que retorna uma lista de itens.
     * @return
     */
    public Collection < CarrinhoItem > getItens () {
        return itens.keySet();
    }
    
    /**
     * 
     * Método que retorna o valor total do item produto
     * @param item
     * @return
     */
    public BigDecimal getTotal(CarrinhoItem item) {
        return item.getTotal(getQuantidade( item ));
    }
    
    /**
     * 
     * Método que retorna o valor total do carrinho de compras
     * @return
     */
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for(CarrinhoItem item : itens.keySet()) {
            total = total.add( getTotal(item) );
        }
        return total;
    }

    /** 
     * TODO Descrição do Método
     * @param produtoId
     * @param tipoPreco
     */
    public void remover ( Integer produtoId , TipoPreco tipoPreco ) {
        Produto produto = new Produto();
        produto.setId( produtoId );
        itens.remove( new CarrinhoItem( produto , tipoPreco ) );
    }
}
