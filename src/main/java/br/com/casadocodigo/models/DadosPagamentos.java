/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 12 de abr de 2018<br>
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
 * 12 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
public class DadosPagamentos {
    
    
    
    private BigDecimal value;

    /** 
     * TODO Construtor padrão/alternativo da classe
     */
    public DadosPagamentos (BigDecimal value) {
        this.value = value;
    }
    
    /** 
     * TODO Construtor padrão/alternativo da classe
     */
    public DadosPagamentos () {
        // TODO Auto-generated constructor stub
    }

    
    /**
     * Método de recuperação do campo value
     *
     * @return valor do campo value
     */
    public BigDecimal getValue () {
        return this.value;
    }

}
