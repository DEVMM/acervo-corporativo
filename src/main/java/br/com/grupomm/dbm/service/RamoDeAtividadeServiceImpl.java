package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.RamoDeAtividadeDAO;
import br.com.grupomm.dbm.entity.RamoDeAtividade;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class RamoDeAtividadeServiceImpl implements RamoDeAtividadeService {
	
	private RamoDeAtividadeDAO ramoDeAtividadeDAO;
	
	public void setRamoDeAtividadeDAO(RamoDeAtividadeDAO ramoDeAtividadeDAO) {
		this.ramoDeAtividadeDAO = ramoDeAtividadeDAO;
	}

	@Override
	public void salvar(RamoDeAtividade r)
			throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.ramoDeAtividadeDAO.salvar(r);
	}

	@Override
	public void atualizar(RamoDeAtividade r)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.ramoDeAtividadeDAO.atualizar(r);
	}

	@Override
	public void merge(RamoDeAtividade r)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.ramoDeAtividadeDAO.merge(r);
	}

	@Override
	public void excluir(RamoDeAtividade r)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.ramoDeAtividadeDAO.excluir(r);
	}

	@Override
	public List<RamoDeAtividade> listarRamoDeAtividade() throws SQLException {
		return this.ramoDeAtividadeDAO.listarRamoDeAtividade();
	}

	@Override
	public RamoDeAtividade RamoDeAtividadeByID(int id) throws SQLException {
		return this.ramoDeAtividadeDAO.RamoDeAtividadeByID(id);
	}

}
