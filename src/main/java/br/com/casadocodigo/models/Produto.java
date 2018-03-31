/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 31 de mar de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */

package br.com.casadocodigo.models;

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

public class Produto {
    
    private String titulo;
    private String descricao;
    private Integer paginas;
    
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
     * TODO Descrição do Método
     * @return
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( this.descricao == null ) ? 0 : this.descricao.hashCode() );
        result = prime * result + ( ( this.paginas == null ) ? 0 : this.paginas.hashCode() );
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
        if ( this.descricao == null ) {
            if ( other.descricao != null )
                return false;
        }
        else if ( ! this.descricao.equals( other.descricao ) )
            return false;
        if ( this.paginas == null ) {
            if ( other.paginas != null )
                return false;
        }
        else if ( ! this.paginas.equals( other.paginas ) )
            return false;
        if ( this.titulo == null ) {
            if ( other.titulo != null )
                return false;
        }
        else if ( ! this.titulo.equals( other.titulo ) )
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
        builder.append( "Produto [titulo=" ).append( this.titulo ).append( ", descricao=" ).append( this.descricao ).append( ", paginas=" ).append( this.paginas ).append( "]" );
        return builder.toString();
    }

    
    

}
