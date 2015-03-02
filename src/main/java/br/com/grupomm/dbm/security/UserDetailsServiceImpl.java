package br.com.grupomm.dbm.security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.grupomm.dbm.dao.PessoaDAO;
import br.com.grupomm.dbm.entity.Perfil;
import br.com.grupomm.dbm.entity.Pessoa;

@SuppressWarnings("deprecation")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Pessoa p = new Pessoa();
		try {
			p = this.pessoaDAO.getPessoaByCodigo(username);
			if (p == null) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return builUserFromEntity(p);
	}
	
	private User builUserFromEntity(Pessoa pessoa) {
		User springUser = null;
		try {
			String login = pessoa.getCodigo();
			String senha = pessoa.getCodigo();
			boolean enabled = pessoa.isAtivo();
			boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;
            
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Perfil p : pessoa.getPerfis()) {
            	authorities.add(new GrantedAuthorityImpl(p.getDescricao()));
			}
            
            springUser = new User(login, senha, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return springUser;
	}
}
