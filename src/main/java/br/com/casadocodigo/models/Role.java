package br.com.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe que representa as permissões do usuãrio.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 6 de mai de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Entity
public class Role implements GrantedAuthority {

	/**
	 * TODO Comentar atributo
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String nome;

	/** 
     * TODO Construtor padrão da classe
     */
    public Role () {
    }
	
    /** 
     * TODO Construtor alternativo da classe
     * @param string
     */
    public Role ( String nome ) {
        this.nome = nome;
    }

    /**
	 * Método de recuperação do campo nome
	 *
	 * @return valor do campo nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Valor de nome atribuído a nome
	 *
	 * @param nome Atributo da Classe
	 */
	public void setNome( String nome ) {
		this.nome = nome;
	}

	/**
	 * 
	 * Método que retorna o atributo nome.
	 * @return
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return this.nome;
	}
	
	
}

