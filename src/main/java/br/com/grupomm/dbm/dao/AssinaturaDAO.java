package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Assinatura;
import br.com.grupomm.dbm.entity.Pessoa;

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
	
	public Assinatura getAssinaturaByPessoa(Pessoa pessoa) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Assinatura.class, "assinatura");
		criteria.createAlias("assinatura.pessoa", "pessoa");
		criteria.add(Restrictions.eq("pessoa.codigo", pessoa.getCodigo()));
		return (Assinatura) criteria.uniqueResult();
	}

}
