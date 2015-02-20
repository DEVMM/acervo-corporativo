package br.com.grupomm.dbm.service;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.grupomm.dbm.entity.PessoaFisica;

public interface PessoaFisicaService {
	public void salvar(PessoaFisica pF) throws DataIntegrityViolationException, ConstraintViolationException, MySQLIntegrityConstraintViolationException, SQLException;
	public void atualizar(PessoaFisica pF) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void merge(PessoaFisica pF) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void excluir(PessoaFisica pF) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
}
