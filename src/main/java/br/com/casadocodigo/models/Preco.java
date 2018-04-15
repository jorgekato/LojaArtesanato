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

    /** 
     * TODO Descrição do Método
     * @return
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( this.tipo == null ) ? 0 : this.tipo.hashCode() );
        result = prime * result + ( ( this.valor == null ) ? 0 : this.valor.hashCode() );
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
        Preco other = ( Preco ) obj;
        if ( this.tipo != other.tipo )
            return false;
        if ( this.valor == null ) {
            if ( other.valor != null )
                return false;
        }
        else if ( ! this.valor.equals( other.valor ) )
            return false;
        return true;
    }

    /** 
     * TODO Descrição do Método
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        builder.append( "Preco [valor=" ).append( this.valor ).append( ", tipo=" ).append( this.tipo ).append( "]" );
        return builder.toString();
    }
    
    
}

