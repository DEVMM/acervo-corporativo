package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Telefone;

@Repository
public class TelefoneDAO extends AbstractDAO<Telefone> {
	
	@SuppressWarnings("unchecked")
	public List<Telefone> listarTelefone() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Telefone").list();
	}
	
	public Telefone TelefoneByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Telefone) session.get(Telefone.class, new Integer(id));
	}
	
	public Telefone getTelefoneByNumber(String numero) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Telefone) session.createQuery("from Telefone where numero =:numero").setParameter("numero", numero).uniqueResult();
	}
	
	
	
	
}
