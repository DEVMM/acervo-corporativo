package br.com.grupomm.dbm.bo;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.entity.Assinatura;
import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.TipoAssinatura;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class AssinaturaBO extends AutowiredServices {


	public Assinatura getAssinaturaByPessoa(Pessoa pessoa) {
		try {
			return this.assinaturaService.getAssinaturaByPessoa(pessoa);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void criarAssinatura(Assinatura a) throws DataIntegrityViolationException, ConstraintViolationException, MySQLIntegrityConstraintViolationException, SQLException {
		this.assinaturaService.salvar(a);
	}

	public List<Assinatura> listarAssinaturas() {
		try {
			return this.assinaturaService.listarAssinatura();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<TipoAssinatura> listarTiposDeAssinaturas() {
		try {
			return this.tipoAssinaturaService.listarTipoAssinatura();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}