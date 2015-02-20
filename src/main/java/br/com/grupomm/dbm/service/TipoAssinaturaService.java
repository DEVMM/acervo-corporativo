package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.entity.TipoAssinatura;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface TipoAssinaturaService {
	public void salvar(TipoAssinatura t) throws DataIntegrityViolationException, ConstraintViolationException, MySQLIntegrityConstraintViolationException, SQLException;
	public void atualizar(TipoAssinatura t) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void merge(TipoAssinatura t) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void excluir(TipoAssinatura t) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public List<TipoAssinatura> listarTipoAssinatura() throws SQLException;
	public TipoAssinatura TipoAssinaturaByID(int id) throws SQLException;
}
