package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.NivelHierarquico;

@Repository
public class NivelHierarquicoDAO extends AbstractDAO<NivelHierarquico> {
	
	@SuppressWarnings("unchecked")
	public List<NivelHierarquico> listarNivelHierarquivo() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from NivelHierarquico").list();
	}
	
	public NivelHierarquico NivelHierarquivoByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (NivelHierarquico) session.get(NivelHierarquico.class, new Integer(id));
	}

}
