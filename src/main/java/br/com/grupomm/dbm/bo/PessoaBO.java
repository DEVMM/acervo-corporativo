package br.com.grupomm.dbm.bo;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.PessoaFisica;
import br.com.grupomm.dbm.entity.PessoaJuridica;

@Component
public class PessoaBO extends AutowiredServices {
	
	private User activeUser;
	@Autowired
	private PessoaFisica pessoaFisica;
	@Autowired
	private PessoaJuridica pessoaJuridica;
	
	public PessoaJuridica getPessoaJuridicaByCodigo(String codigo) {
		try {
			return this.pessoaJuridicaService.getPessoaJuridicaByCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PessoaFisica getPessoaFisicaByCodigo(String codigo) {
		try {
			return this.pessoaFisicaService.getPessoaFisicaByCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Pessoa getUsuarioLogado(Principal principal) {
		this.activeUser = (User) ((Authentication)principal).getPrincipal();
		try {
			if (!(this.getPessoaFisicaByCodigo(activeUser.getUsername()) == null)) {
				return this.pessoaFisica = this.getPessoaFisicaByCodigo(activeUser.getUsername());
			} else if (!(this.getPessoaJuridicaByCodigo(activeUser.getUsername()) == null)) {
				return this.pessoaJuridica = this.getPessoaJuridicaByCodigo(activeUser.getUsername());
			} 
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PessoaJuridica> listarEmpresa() {
		try {
			return this.pessoaJuridicaService.listarEmpresas();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
