package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.PessoaJuridicaDAO;
import br.com.grupomm.dbm.entity.PessoaJuridica;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {
	
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	public void setPessoaJuridicaDAO(PessoaJuridicaDAO pessoaJuridicaDAO) {
		this.pessoaJuridicaDAO = pessoaJuridicaDAO;
	}

	@Override
	public void salvar(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException{
		this.pessoaJuridicaDAO.salvar(pJ);

	}

	@Override
	public void atualizar(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		this.pessoaJuridicaDAO.atualizar(pJ);
	}

	@Override
	public void merge(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		this.pessoaJuridicaDAO.merge(pJ);
	}

	@Override
	public void excluir(PessoaJuridica pJ) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		this.pessoaJuridicaDAO.excluir(pJ);
	}

	@Override
	public PessoaJuridica getPessoaJuridicaByCNPJ(String CNPJ)
			throws SQLException {
		return this.pessoaJuridicaDAO.getPessoaJuridicaByCNPJ(CNPJ);
	}

	@Override
	public PessoaJuridica getPessoaJuridicaByInscricaoEstadual(String ie)
			throws SQLException {
		return this.pessoaJuridicaDAO.getPessoaJuridicaByInscricaoEstadual(ie);
	}

	@Override
	public PessoaJuridica getPessoaJuridicaByCodigo(String codigo)
			throws SQLException {
		return this.pessoaJuridicaDAO.getPessoaJuridicaByCodigo(codigo);
	}

	@Override
	public List<PessoaJuridica> listarEmpresas() throws SQLException {
		return this.pessoaJuridicaDAO.listarEmpresas();
	}

}
