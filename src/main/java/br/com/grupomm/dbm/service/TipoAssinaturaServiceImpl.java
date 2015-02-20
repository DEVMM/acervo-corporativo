package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.TipoAssinaturaDAO;
import br.com.grupomm.dbm.entity.TipoAssinatura;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class TipoAssinaturaServiceImpl implements TipoAssinaturaService {
	
	private TipoAssinaturaDAO tipoAssinaturaDAO;

	public void setTipoAssinaturaDAO(TipoAssinaturaDAO tipoAssinaturaDAO) {
		this.tipoAssinaturaDAO = tipoAssinaturaDAO;
	}

	@Override
	public void salvar(TipoAssinatura t)
			throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.tipoAssinaturaDAO.salvar(t);
	}

	@Override
	public void atualizar(TipoAssinatura t)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.tipoAssinaturaDAO.atualizar(t);
	}

	@Override
	public void merge(TipoAssinatura t) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.tipoAssinaturaDAO.merge(t);
	}

	@Override
	public void excluir(TipoAssinatura t)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.tipoAssinaturaDAO.excluir(t);
	}

	@Override
	public List<TipoAssinatura> listarTipoAssinatura() throws SQLException {
		return this.tipoAssinaturaDAO.listarTipoAssinatura();
	}

	@Override
	public TipoAssinatura TipoAssinaturaByID(int id) throws SQLException {
		return this.tipoAssinaturaDAO.TipoAssinaturaByID(id);
	}

}
