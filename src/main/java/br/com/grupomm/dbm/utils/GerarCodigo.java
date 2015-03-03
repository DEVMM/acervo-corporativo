package br.com.grupomm.dbm.utils;

import static org.bitbucket.dollar.Dollar.$;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.service.PessoaService;

@Component
public class GerarCodigo {
	
	protected PessoaService pessoaService;
	/*@Autowired(required=true)
	@Qualifier(value="pessoaService")*/
	@Autowired
	public void setPessoaService(PessoaService ps){
		this.pessoaService = ps;
	}
	
	private String validCharacters = $('0', '9').join() + $('A', 'Z').join();

	public String randomString() {
		
		boolean code = false;
		try {
			while (code == false) {
				String codigo = $(validCharacters).shuffle().slice(8).toString();
				Pessoa p = this.pessoaService.getPessoaByCodigo(codigo);
				if (p == null) return codigo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
