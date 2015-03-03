package br.com.grupomm.dbm.dao;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.PessoaJuridica;

@Repository
public class PessoaJuridicaDAO extends AbstractDAO<PessoaJuridica>{
	public PessoaJuridica getPessoaJuridicaByCNPJ(String CNPJ) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		PessoaJuridica pj=  (PessoaJuridica) session.createQuery("Select pj From PessoaJuridica pj where pj.CNPJ=:CNPJ").setParameter("CNPJ", CNPJ).uniqueResult();
		Hibernate.initialize(pj.getPessoa());
		return pj;
	}
	
	public PessoaJuridica getPessoaJuridicaByInscricaoEstadual(String ie) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		PessoaJuridica pj=  (PessoaJuridica) session.createQuery("Select pj From PessoaJuridica pj where pj.inscricaoEstadual=:inscricaoEstadual").setParameter("inscricaoEstadual", ie).uniqueResult();
		Hibernate.initialize(pj.getPessoa());
		Hibernate.initialize(pj.getEnderecoComercial());
		Hibernate.initialize(pj.getResponsavel());
		return pj;
	}
	
	public PessoaJuridica getPessoaJuridicaByCodigo(String codigo) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PessoaJuridica.class);
		criteria.createAlias("pessoa", "p");
		criteria.add(Restrictions.like("p.codigo", codigo, MatchMode.EXACT));
		return (PessoaJuridica) criteria.uniqueResult();
	}
}
