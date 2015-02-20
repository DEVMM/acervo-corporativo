package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.PorteDAO;
import br.com.grupomm.dbm.entity.Porte;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class PorteServiceImpl implements PorteService {
	private PorteDAO porteDAO;
	
	public void setPorteDAO(PorteDAO porteDAO) {
		this.porteDAO = porteDAO;
	}

	@Override
	public void salvar(Porte p) throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.porteDAO.salvar(p);

	}

	@Override
	public void atualizar(Porte p) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.porteDAO.atualizar(p);
	}

	@Override
	public void merge(Porte p) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.porteDAO.merge(p);
	}

	@Override
	public void excluir(Porte p) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.porteDAO.excluir(p);
	}

	@Override
	public List<Porte> listarPorte() throws SQLException {
		return this.porteDAO.listarPorte();
	}

	@Override
	public Porte porteByID(int id) throws SQLException {
		return this.porteDAO.PorteByID(id);
	}

}
