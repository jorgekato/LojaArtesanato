package br.com.casadocodigo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe que representa um usuário. <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 6 de mai de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Entity
public class Usuario implements UserDetails {

	/**
	 * TODO Comentar atributo
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	private String senha;
	private String nome;

	@OneToMany( fetch = FetchType.EAGER )
	List < Role > roles = new ArrayList < Role >();
	
	/**
	 * Método de recuperação do campo email
	 *
	 * @return valor do campo email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Valor de email atribuído a email
	 *
	 * @param email Atributo da Classe
	 */
	public void setEmail( String email ) {
		this.email = email;
	}
	
	/**
	 * Método de recuperação do campo senha
	 *
	 * @return valor do campo senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Valor de senha atribuído a senha
	 *
	 * @param senha Atributo da Classe
	 */
	public void setSenha( String senha ) {
		this.senha = senha;
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
	 * Método de recuperação do campo roles
	 *
	 * @return valor do campo roles
	 */
	public List < Role > getRoles() {
		return roles;
	}
	
	/**
	 * Valor de roles atribuído a roles
	 *
	 * @param roles Atributo da Classe
	 */
	public void setRoles( List < Role > roles ) {
		this.roles = roles;
	}
	
	/**
	 * Retorna um coleção de objetos do tipo GrantedAuthority.
	 * GrantedAuthority - espera que a classe Role implemente esta interface.
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection < ? extends GrantedAuthority > getAuthorities() {
		return this.roles;
	}
	
	@Override
	public String getPassword() {
		return this.senha;
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
