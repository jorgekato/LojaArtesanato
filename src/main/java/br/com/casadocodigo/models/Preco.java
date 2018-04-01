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
}

