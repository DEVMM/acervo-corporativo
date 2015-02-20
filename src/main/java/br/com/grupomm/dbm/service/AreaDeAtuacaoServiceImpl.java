package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.AreaDeAtuacaoDAO;
import br.com.grupomm.dbm.entity.AreaDeAtuacao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Transactional
@Service
public class AreaDeAtuacaoServiceImpl implements AreaDeAtuacaoService {
	
	private AreaDeAtuacaoDAO areaDeAtuacaoDAO;

	public void setAreaDeAtuacaoDAO(AreaDeAtuacaoDAO areaDeAtuacaoDAO) {
		this.areaDeAtuacaoDAO = areaDeAtuacaoDAO;
	}

	@Override
	public void salvar(AreaDeAtuacao a)
			throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.areaDeAtuacaoDAO.salvar(a);

	}

	@Override
	public void atualizar(AreaDeAtuacao a)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.areaDeAtuacaoDAO.salvar(a);
	}

	@Override
	public void merge(AreaDeAtuacao a)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.areaDeAtuacaoDAO.merge(a);

	}

	@Override
	public void excluir(AreaDeAtuacao a)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.areaDeAtuacaoDAO.excluir(a);
	}

	@Override
	public List<AreaDeAtuacao> listarAreaDeAtuacao() throws SQLException {
		return this.areaDeAtuacaoDAO.listarAreaDeAtuacao();
	}

	@Override
	public AreaDeAtuacao AreaDeAtuacaoByID(int id) throws SQLException {
		return this.areaDeAtuacaoDAO.AreaDeAtuacaoByID(id);
	}

}
