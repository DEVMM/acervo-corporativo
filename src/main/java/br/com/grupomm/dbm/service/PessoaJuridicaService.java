package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.entity.PessoaJuridica;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface PessoaJuridicaService {
	public void salvar(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void atualizar(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void merge(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void excluir(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public PessoaJuridica getPessoaJuridicaByCNPJ(String CNPJ) throws SQLException;
	public PessoaJuridica getPessoaJuridicaByInscricaoEstadual(String ie) throws SQLException;
	public PessoaJuridica getPessoaJuridicaByCodigo(String codigo) throws SQLException;
	public List<PessoaJuridica> listarEmpresas() throws SQLException;
}
