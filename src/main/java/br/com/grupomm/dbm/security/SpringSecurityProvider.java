package br.com.grupomm.dbm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class SpringSecurityProvider implements AuthenticationProvider {
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		
		UserDetails usuario = userDetailsServiceImpl.loadUserByUsername(username);

		if (usuario == null) {
			throw new BadCredentialsException("Usuário não encontrado.");
		}
		
		try {
			return new AuthenticationToken(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
		} catch (BadCredentialsException e) {
			throw e;
		} catch (Exception e) {
			throw new BadCredentialsException("Falha na autenticação", e);
		}
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)
                && authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
