package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.dao.SolicitacaoDAO;
import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.Solicitacao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class SolicitacaoServiceImpl implements SolicitacaoService {
	
	private SolicitacaoDAO solicitacaoDAO;
	
	public void setSolicitacaoDAO(SolicitacaoDAO solicitacaoDAO) {
		this.solicitacaoDAO = solicitacaoDAO;
	}

	@Override
	public void salvar(Solicitacao s) throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.solicitacaoDAO.salvar(s);
	}

	@Override
	public void atualizar(Solicitacao s)
			throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.solicitacaoDAO.atualizar(s);;
	}

	@Override
	public void merge(Solicitacao s) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.solicitacaoDAO.merge(s);
	}

	@Override
	public void excluir(Solicitacao s) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.solicitacaoDAO.excluir(s);
	}

	@Override
	public List<Solicitacao> listarSolicitacoes() throws SQLException {
		return this.solicitacaoDAO.listarSolicitacoes();
	}

	@Override
	public Solicitacao solicitacaoByID(Solicitacao s) throws SQLException {
		return this.solicitacaoDAO.solicitacaoByID(s);
	}

	@Override
	public Solicitacao getSolicitacaoBySolicitante(Pessoa pessoa)
			throws SQLException {
		return this.solicitacaoDAO.getSolicitacaoBySolicitante(pessoa);
	}

}
