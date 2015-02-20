package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.TelefoneDAO;
import br.com.grupomm.dbm.entity.Telefone;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class TelefoneServiceImpl implements TelefoneService {
	
	private TelefoneDAO telefoneDAO;
	
	public void setTelefoneDAO(TelefoneDAO telefoneDAO) {
		this.telefoneDAO = telefoneDAO;
	}

	@Override
	public void salvar(Telefone t) throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.telefoneDAO.salvar(t);

	}

	@Override
	public void atualizar(Telefone t) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.telefoneDAO.atualizar(t);
	}

	@Override
	public void merge(Telefone t) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.telefoneDAO.merge(t);
	}

	@Override
	public void excluir(Telefone t) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.telefoneDAO.excluir(t);
	}

	@Override
	public List<Telefone> listarTelefone() throws SQLException {
		return this.telefoneDAO.listarTelefone();
	}

	@Override
	public Telefone TelefoneByID(int id) throws SQLException {
		return this.telefoneDAO.TelefoneByID(id);
	}

	@Override
	public Telefone getTelefoneByNumber(String numero) throws SQLException {
		return this.telefoneDAO.getTelefoneByNumber(numero);
	}


}
