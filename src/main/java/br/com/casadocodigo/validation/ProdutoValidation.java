/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 4 de abr de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */
package br.com.casadocodigo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.models.Produto;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe que realiza validações. <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 4 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
public class ProdutoValidation implements Validator {

    /**
     * Método que verifica se a classe Produto é suportada para realizar a validação.
     * 
     * @param arg0
     * @return
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports ( Class < ? > clazz ) {
        return Produto.class.isAssignableFrom( clazz );
    }

    /**
     * TODO Descrição do Método
     * 
     * @param arg0
     * @param arg1
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     *      org.springframework.validation.Errors)
     */
    @Override
    public void validate ( Object target , Errors errors ) {
        ValidationUtils.rejectIfEmpty( errors , "titulo" , "field.required" );
        ValidationUtils.rejectIfEmpty( errors , "descricao" , "field.required" );
        Produto produto = ( Produto ) target;
        if ( produto.getPaginas() == null || produto.getPaginas() <= 0) {
            errors.rejectValue( "paginas" , "field.required" );
        }
    }
}
