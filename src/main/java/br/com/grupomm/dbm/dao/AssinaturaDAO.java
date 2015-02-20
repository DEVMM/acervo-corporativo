package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Assinatura;

@Repository
public class AssinaturaDAO extends AbstractDAO<Assinatura> {

	@SuppressWarnings("unchecked")
	public List<Assinatura> listarAssinatura() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Assinatura").list();
	}

	public Assinatura AssinaturaByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Assinatura) session.get(Assinatura.class, new Integer(id));
	}	

}
