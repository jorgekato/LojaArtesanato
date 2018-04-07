/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 31 de mar de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */

package br.com.casadocodigo.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 31 de mar de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Entity
public class Produto {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String titulo;
    private String descricao;
    private Integer paginas;
    
    private Calendar dataLancamento;
    
    @ElementCollection
    private List<Preco> precos;
    
    
    /**
     * Método de recuperação do campo id
     *
     * @return valor do campo id
     */
    public Integer getId () {
        return this.id;
    }

    
    /**
     * Valor de id atribuído a id
     *
     * @param id Atributo da Classe
     */
    public void setId ( Integer id ) {
        this.id = id;
    }

    
    /**
     * Método de recuperação do campo precos
     *
     * @return valor do campo precos
     */
    public List < Preco > getPrecos () {
        return this.precos;
    }

    
    /**
     * Valor de precos atribuído a precos
     *
     * @param precos Atributo da Classe
     */
    public void setPrecos ( List < Preco > precos ) {
        this.precos = precos;
    }

    /**
     * Método de recuperação do campo titulo
     *
     * @return valor do campo titulo
     */
    public String getTitulo () {
        return this.titulo;
    }
    
    /**
     * Valor de titulo atribuído a titulo
     *
     * @param titulo Atributo da Classe
     */
    public void setTitulo ( String titulo ) {
        this.titulo = titulo;
    }
    
    /**
     * Método de recuperação do campo descricao
     *
     * @return valor do campo descricao
     */
    public String getDescricao () {
        return this.descricao;
    }
    
    /**
     * Valor de descricao atribuído a descricao
     *
     * @param descricao Atributo da Classe
     */
    public void setDescricao ( String descricao ) {
        this.descricao = descricao;
    }
    
    /**
     * Método de recuperação do campo paginas
     *
     * @return valor do campo paginas
     */
    public Integer getPaginas () {
        return this.paginas;
    }
    
    /**
     * Valor de paginas atribuído a paginas
     *
     * @param paginas Atributo da Classe
     */
    public void setPaginas ( Integer paginas ) {
        this.paginas = paginas;
    }


    
    /**
     * Método de recuperação do campo dataLancamento
     *
     * @return valor do campo dataLancamento
     */
    public Calendar getDataLancamento () {
        return this.dataLancamento;
    }


    
    /**
     * Valor de dataLancamento atribuído a dataLancamento
     *
     * @param dataLancamento Atributo da Classe
     */
    public void setDataLancamento ( Calendar dataLancamento ) {
        this.dataLancamento = dataLancamento;
    }


    /** 
     * TODO Descrição do Método
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        builder.append( "Produto [id=" ).append( this.id ).append( ", titulo=" ).append( this.titulo ).append( ", descricao=" ).append( this.descricao ).append( ", paginas=" ).append( this.paginas )
                .append( ", dataLancamento=" ).append( this.dataLancamento ).append( ", precos=" ).append( this.precos ).append( "]" );
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
        result = prime * result + ( ( this.dataLancamento == null ) ? 0 : this.dataLancamento.hashCode() );
        result = prime * result + ( ( this.descricao == null ) ? 0 : this.descricao.hashCode() );
        result = prime * result + ( ( this.id == null ) ? 0 : this.id.hashCode() );
        result = prime * result + ( ( this.paginas == null ) ? 0 : this.paginas.hashCode() );
        result = prime * result + ( ( this.precos == null ) ? 0 : this.precos.hashCode() );
        result = prime * result + ( ( this.titulo == null ) ? 0 : this.titulo.hashCode() );
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
        Produto other = ( Produto ) obj;
        if ( this.dataLancamento == null ) {
            if ( other.dataLancamento != null )
                return false;
        }
        else if ( ! this.dataLancamento.equals( other.dataLancamento ) )
            return false;
        if ( this.descricao == null ) {
            if ( other.descricao != null )
                return false;
        }
        else if ( ! this.descricao.equals( other.descricao ) )
            return false;
        if ( this.id == null ) {
            if ( other.id != null )
                return false;
        }
        else if ( ! this.id.equals( other.id ) )
            return false;
        if ( this.paginas == null ) {
            if ( other.paginas != null )
                return false;
        }
        else if ( ! this.paginas.equals( other.paginas ) )
            return false;
        if ( this.precos == null ) {
            if ( other.precos != null )
                return false;
        }
        else if ( ! this.precos.equals( other.precos ) )
            return false;
        if ( this.titulo == null ) {
            if ( other.titulo != null )
                return false;
        }
        else if ( ! this.titulo.equals( other.titulo ) )
            return false;
        return true;
    }



}
