package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Porte;

@Repository
public class PorteDAO extends AbstractDAO<Porte> {
	@SuppressWarnings("unchecked")
	public List<Porte> listarPorte() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Porte").list();
	}
	
	public Porte PorteByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Porte) session.get(Porte.class, new Integer(id));
	}
}
