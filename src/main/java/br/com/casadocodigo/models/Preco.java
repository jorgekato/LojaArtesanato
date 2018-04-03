/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 31 de mar de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */

package br.com.casadocodigo.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * @Embeddable - relacionar e portar os elementos de preço para dentro desta coleção em Produto
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Embeddable
public class Preco {
    private BigDecimal valor;
    private TipoPreco tipo;
    
    /**
     * Método de recuperação do campo valor
     *
     * @return valor do campo valor
     */
    public BigDecimal getValor () {
        return this.valor;
    }
    
    /**
     * Valor de valor atribuído a valor
     *
     * @param valor Atributo da Classe
     */
    public void setValor ( BigDecimal valor ) {
        this.valor = valor;
    }
    
    /**
     * Método de recuperação do campo tipo
     *
     * @return valor do campo tipo
     */
    public TipoPreco getTipo () {
        return this.tipo;
    }
    
    /**
     * Valor de tipo atribuído a tipo
     *
     * @param tipo Atributo da Classe
     */
    public void setTipo ( TipoPreco tipo ) {
        this.tipo = tipo;
    }
    
    
}

