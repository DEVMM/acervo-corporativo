package br.com.grupomm.dbm.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class AuthenticationToken extends UsernamePasswordAuthenticationToken {
	
	public AuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}
	private static final long serialVersionUID = 5143696533026620026L;
}
