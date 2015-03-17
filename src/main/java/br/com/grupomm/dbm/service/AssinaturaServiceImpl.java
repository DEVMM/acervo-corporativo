package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.AssinaturaDAO;
import br.com.grupomm.dbm.entity.Assinatura;
import br.com.grupomm.dbm.entity.Pessoa;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class AssinaturaServiceImpl implements AssinaturaService {

	private AssinaturaDAO assinaturaDAO;
	
	public void setAssinaturaDAO(AssinaturaDAO assinaturaDAO) {
		this.assinaturaDAO = assinaturaDAO;
	}
	@Override
	public void salvar(Assinatura a) throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.assinaturaDAO.salvar(a);

	}

	@Override
	public void atualizar(Assinatura a) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.assinaturaDAO.atualizar(a);
	}

	@Override
	public void merge(Assinatura a) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.assinaturaDAO.merge(a);
	}

	@Override
	public void excluir(Assinatura a) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.assinaturaDAO.excluir(a);
	}

	@Override
	public List<Assinatura> listarAssinatura() throws SQLException {
		return this.assinaturaDAO.listarAssinatura();
	}

	@Override
	public Assinatura AssinaturaByID(int id) throws SQLException {
		return this.assinaturaDAO.AssinaturaByID(id);
	}
	
	@Override
	public Assinatura getAssinaturaByPessoa(Pessoa pessoa) throws SQLException {
		return this.assinaturaDAO.getAssinaturaByPessoa(pessoa);
	}

}
