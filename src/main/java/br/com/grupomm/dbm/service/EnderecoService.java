package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.entity.Endereco;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface EnderecoService {
	public void salvar(Endereco e) throws DataIntegrityViolationException, ConstraintViolationException, MySQLIntegrityConstraintViolationException, SQLException;
	public void atualizar(Endereco e) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void merge(Endereco e) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public void excluir(Endereco e) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException;
	public List<Endereco> listarEndereco() throws SQLException;
	public Endereco EnderecoByID(int id) throws SQLException;
	public Endereco getEnderecoByCepAndNumero(Long cep, Integer numero) throws SQLException;
}
