package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.TipoAssinatura;

@Repository
public class TipoAssinaturaDAO extends AbstractDAO<TipoAssinatura> {
	
	@SuppressWarnings("unchecked")
	public List<TipoAssinatura> listarTipoAssinatura() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from TipoAssinatura").list();
	}
	
	public TipoAssinatura TipoAssinaturaByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (TipoAssinatura) session.get(TipoAssinatura.class, new Integer(id));
	}
	
}
