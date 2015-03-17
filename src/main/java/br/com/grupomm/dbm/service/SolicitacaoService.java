package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.Solicitacao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface SolicitacaoService {
	public void salvar(Solicitacao s) throws DataIntegrityViolationException, ConstraintViolationException, MySQLIntegrityConstraintViolationException, SQLException;
	public void atualizar(Solicitacao s) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void merge(Solicitacao s) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void excluir(Solicitacao s) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public List<Solicitacao> listarSolicitacoes() throws SQLException;
	public Solicitacao solicitacaoByID(Solicitacao s) throws SQLException;
	public Solicitacao getSolicitacaoBySolicitante(Pessoa pessoa) throws SQLException;
}
