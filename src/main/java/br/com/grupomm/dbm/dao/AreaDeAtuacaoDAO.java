package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.AreaDeAtuacao;

@Repository
public class AreaDeAtuacaoDAO extends AbstractDAO<AreaDeAtuacao> {
	
	@SuppressWarnings("unchecked")
	public List<AreaDeAtuacao> listarAreaDeAtuacao() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from AreaDeAtuacao").list();
	}
	
	public AreaDeAtuacao AreaDeAtuacaoByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (AreaDeAtuacao) session.get(AreaDeAtuacao.class, new Integer(id));
	}

}
