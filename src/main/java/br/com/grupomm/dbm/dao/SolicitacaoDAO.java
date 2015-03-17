package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.Solicitacao;

@Repository
public class SolicitacaoDAO extends AbstractDAO<Solicitacao>{
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listarSolicitacoes() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Solicitacao").list();
	}
	
	public Solicitacao solicitacaoByID(Solicitacao s) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Solicitacao) session.get(Solicitacao.class, new Long(s.getIdSolicitacao()));
	}
	
	public Solicitacao getSolicitacaoBySolicitante(Pessoa pessoa) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Solicitacao.class, "sl");
		criteria.createAlias("sl.pessoa", "pessoa");
		criteria.add(Restrictions.eq("pessoa.id", pessoa.getId()));
		Solicitacao sl = (Solicitacao) criteria.uniqueResult();
		return sl;
	}
}
