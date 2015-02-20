package br.com.grupomm.dbm.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.grupomm.dbm.entity.AbstractEntity;

@Repository
public abstract class AbstractDAO <t extends AbstractEntity> {
	
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void salvar(t entity) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(entity);
	}

	public void excluir(t entity) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {

		Session session = this.sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	public void atualizar(t entity) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(entity);
	}

	public void merge(t entity) throws DataIntegrityViolationException, ConstraintViolationException, SQLException, MySQLIntegrityConstraintViolationException {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(entity);
	}
	
}
