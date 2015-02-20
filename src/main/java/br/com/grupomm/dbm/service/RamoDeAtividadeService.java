package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.entity.RamoDeAtividade;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface RamoDeAtividadeService {
	
	public void salvar(RamoDeAtividade r) throws DataIntegrityViolationException, ConstraintViolationException, MySQLIntegrityConstraintViolationException, SQLException;
	public void atualizar(RamoDeAtividade r) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void merge(RamoDeAtividade r) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void excluir(RamoDeAtividade r) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public List<RamoDeAtividade> listarRamoDeAtividade() throws SQLException;
	public RamoDeAtividade RamoDeAtividadeByID(int id) throws SQLException;

}
