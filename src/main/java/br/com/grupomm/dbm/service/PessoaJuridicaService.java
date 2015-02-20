package br.com.grupomm.dbm.service;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.grupomm.dbm.entity.PessoaJuridica;

public interface PessoaJuridicaService {
	public void salvar(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void atualizar(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void merge(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void excluir(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
}
