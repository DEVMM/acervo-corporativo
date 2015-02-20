package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Email;

@Repository
public class EmailDAO extends AbstractDAO<Email>{
	
	@SuppressWarnings("unchecked")
	public List<Email> listarEmail() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Email").list();
	}
	
	public Email EmailByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Email) session.get(Email.class, new Integer(id));
	}
	
	public Email getEmailByEndereco(String email) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Email) session.createQuery("From Email where email= :email").setParameter("email", email).uniqueResult();
	}
	
}
