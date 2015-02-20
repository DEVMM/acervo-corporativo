package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.NivelHierarquicoDAO;
import br.com.grupomm.dbm.entity.NivelHierarquico;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class NivelHierarquicoServiceImpl implements NivelHierarquicoService {
	
	private NivelHierarquicoDAO nivelHierarquicoDAO;

	public void setNivelHierarquicoDAO(NivelHierarquicoDAO nivelHierarquicoDAO) {
		this.nivelHierarquicoDAO = nivelHierarquicoDAO;
	}

	@Override
	public void salvar(NivelHierarquico n)
			throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.nivelHierarquicoDAO.salvar(n);

	}

	@Override
	public void atualizar(NivelHierarquico n)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.nivelHierarquicoDAO.atualizar(n);
	}

	@Override
	public void merge(NivelHierarquico n)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.nivelHierarquicoDAO.merge(n);
	}

	@Override
	public void excluir(NivelHierarquico n)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.nivelHierarquicoDAO.excluir(n);
	}

	@Override
	public List<NivelHierarquico> listarNivelHierarquico() throws SQLException {
		return this.nivelHierarquicoDAO.listarNivelHierarquivo();
	}

	@Override
	public NivelHierarquico NivelHierarquicoByID(int id) throws SQLException {
		return this.nivelHierarquicoDAO.NivelHierarquivoByID(id);
	}

	
}
