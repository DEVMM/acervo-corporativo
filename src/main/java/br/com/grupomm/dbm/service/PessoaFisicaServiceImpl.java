package br.com.grupomm.dbm.service;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.PessoaFisicaDAO;
import br.com.grupomm.dbm.entity.PessoaFisica;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class PessoaFisicaServiceImpl implements PessoaFisicaService {
	
	private PessoaFisicaDAO pessoaFisicaDAO;

	public void setPessoaFisicaDAO(PessoaFisicaDAO pessoaFisicaDAO) {
		this.pessoaFisicaDAO = pessoaFisicaDAO;
	}

	@Override
	public void salvar(PessoaFisica pF) throws DataIntegrityViolationException, ConstraintViolationException, MySQLIntegrityConstraintViolationException, SQLException{
		this.pessoaFisicaDAO.salvar(pF);
	}

	@Override
	public void atualizar(PessoaFisica pF)  throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException{
		this.pessoaFisicaDAO.atualizar(pF);
	}

	@Override
	public void merge(PessoaFisica pF)  throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException{
		this.pessoaFisicaDAO.merge(pF);
	}

	@Override
	public void excluir(PessoaFisica pF)  throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException{
		this.pessoaFisicaDAO.excluir(pF);
	}

}
