/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 8 de abr de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */

package br.com.casadocodigo.models;

import java.math.BigDecimal;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 8 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */


public class CarrinhoItem {

    private Produto produto;
    private TipoPreco tipoPreco;

    /** 
     * TODO Construtor padrão/alternativo da classe
     * @param produto
     * @param tipoPreco
     */
    public CarrinhoItem ( Produto produto , TipoPreco tipoPreco ) {
        this.produto = produto;
        this.tipoPreco = tipoPreco;
    }

    
    /**
     * Método de recuperação do campo produto
     *
     * @return valor do campo produto
     */
    public Produto getProduto () {
        return this.produto;
    }

    
    /**
     * Valor de produto atribuído a produto
     *
     * @param produto Atributo da Classe
     */
    public void setProduto ( Produto produto ) {
        this.produto = produto;
    }

    
    /**
     * Método de recuperação do campo tipoPreco
     *
     * @return valor do campo tipoPreco
     */
    public TipoPreco getTipoPreco () {
        return this.tipoPreco;
    }

    
    /**
     * Valor de tipoPreco atribuído a tipoPreco
     *
     * @param tipoPreco Atributo da Classe
     */
    public void setTipoPreco ( TipoPreco tipoPreco ) {
        this.tipoPreco = tipoPreco;
    }
    
    /**
     * Método que retorna o tipo de preço.
     * @return
     */
    public BigDecimal getPreco() {
        return produto.precoPara(tipoPreco);
    }
    
    /** 
     * Método que retorna o valor total do produto.
     * @param quantidade
     * @return
     */
    public BigDecimal getTotal ( int quantidade ) {
        return this.getPreco().multiply( new BigDecimal( quantidade ) );
    }


    /** 
     * TODO Descrição do Método
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        builder.append( "CarrinhoItem [produto=" ).append( this.produto ).append( ", tipoPreco=" ).append( this.tipoPreco ).append( "]" );
        return builder.toString();
    }


    /** 
     * TODO Descrição do Método
     * @return
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( this.produto == null ) ? 0 : this.produto.hashCode() );
        result = prime * result + ( ( this.tipoPreco == null ) ? 0 : this.tipoPreco.hashCode() );
        return result;
    }


    /** 
     * TODO Descrição do Método
     * @param obj
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        CarrinhoItem other = ( CarrinhoItem ) obj;
        if ( this.produto == null ) {
            if ( other.produto != null )
                return false;
        }
        else if ( ! this.produto.equals( other.produto ) )
            return false;
        if ( this.tipoPreco != other.tipoPreco )
            return false;
        return true;
    }


   
   
}
