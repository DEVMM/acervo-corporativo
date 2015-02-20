package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.RamoDeAtividade;

@Repository
public class RamoDeAtividadeDAO extends AbstractDAO<RamoDeAtividade> {
	
	@SuppressWarnings("unchecked")
	public List<RamoDeAtividade> listarRamoDeAtividade() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from RamoDeAtividade").list();
	}
	
	public RamoDeAtividade RamoDeAtividadeByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (RamoDeAtividade) session.get(RamoDeAtividade.class, new Integer(id));
	}
	
}
