package br.com.grupomm.dbm.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupomm.dbm.dao.EmailDAO;
import br.com.grupomm.dbm.entity.Email;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	private EmailDAO emailDAO;
	
	public void setEmailDAO(EmailDAO emailDAO) {
		this.emailDAO =  emailDAO;
	}
	
	@Override
	public void salvar(Email e) throws DataIntegrityViolationException,
			ConstraintViolationException,
			MySQLIntegrityConstraintViolationException, SQLException {
		this.emailDAO.salvar(e);
	}

	@Override
	public void atualizar(Email e) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.emailDAO.atualizar(e);
	}

	@Override
	public void merge(Email e) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.emailDAO.merge(e);
	}

	@Override
	public void excluir(Email e) throws DataIntegrityViolationException,
			ConstraintViolationException, SQLException,
			MySQLIntegrityConstraintViolationException {
		this.emailDAO.excluir(e);
	}

	@Override
	public List<Email> listarEmail() throws SQLException {
		return this.emailDAO.listarEmail();
	}

	@Override
	public Email EmailByID(int id) throws SQLException {
		return this.emailDAO.EmailByID(id);
	}

	@Override
	public Email getEmailByEndereco(String email) throws SQLException {
		return this.emailDAO.getEmailByEndereco(email);
	}

}
