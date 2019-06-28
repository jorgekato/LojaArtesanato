package br.com.casadocodigo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.models.Usuario;

/**
 * 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 6 de mai de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

@Repository
public class UsuarioDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * Método que realizar a consulta do usuário.
	 * UserDetails - retorno que espera que a classe Usuário implemente sua interface.
	 * @param email
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String email) {
		List<Usuario> usuarios = em.createQuery( "select u from Usuario u where u.email = :email", Usuario.class )
				.setParameter("email", email)
				.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("O usuário " + email + " não foi encontrado.");
		}
		
		return usuarios.get( 0 );
	}

    /** 
     * TODO Descrição do Método
     */
    public void gravar (Usuario usuario) {

        em.persist(usuario);
    }

	/**
	 * Método da interface UserDetailsService que foi sobrescrito acima.
	 */
//	@Override
//	public UserDetails loadUserByUsername( String arg0 ) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
