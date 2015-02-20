package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.EnderecoDAO;
import br.com.grupomm.dbm.entity.Endereco;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class EnderecoServiceImpl implements EnderecoService {
	
	private EnderecoDAO enderecoDAO;
	
	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
	
	@Override
	public void salvar(Endereco e) throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.enderecoDAO.salvar(e);

	}

	@Override
	public void atualizar(Endereco e) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.enderecoDAO.atualizar(e);
	}

	@Override
	public void merge(Endereco e) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.enderecoDAO.merge(e);
	}

	@Override
	public void excluir(Endereco e) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.enderecoDAO.excluir(e);
	}

	@Override
	public List<Endereco> listarEndereco() throws SQLException {
		return this.enderecoDAO.listarEndereco();
	}

	@Override
	public Endereco EnderecoByID(int id) throws SQLException {
		return this.enderecoDAO.EnderecoByID(id);
	}

	@Override
	public Endereco getEnderecoByCepAndNumero(Long cep, Integer numero)
			throws SQLException {
		return this.enderecoDAO.getEnderecoByCepAndNumero(cep, numero);
	}

}
