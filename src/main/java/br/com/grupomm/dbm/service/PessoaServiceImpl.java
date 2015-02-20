package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.PessoaDAO;
import br.com.grupomm.dbm.entity.Pessoa;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	private PessoaDAO pessoaDAO;

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	@Override
	public void salvar(Pessoa p) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		this.pessoaDAO.salvar(p);
	}

	@Override
	public void atualizar(Pessoa p) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		this.pessoaDAO.atualizar(p);
	}

	@Override
	public void merge(Pessoa p) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		this.pessoaDAO.merge(p);
	}

	@Override
	public void excluir(Pessoa p) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		this.excluir(p);
	}

	@Override
	public List<Pessoa> listarPessoas() throws SQLException {
		return this.pessoaDAO.listarPessoas();
	}

	@Override
	public Pessoa getPessoaByCodigo(String codigo) throws SQLException {
		return this.pessoaDAO.getPessoaByCodigo(codigo);
	}

}
