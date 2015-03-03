package br.com.grupomm.dbm.dao;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.PessoaFisica;
@Repository
public class PessoaFisicaDAO extends AbstractDAO<PessoaFisica> {
	
	public PessoaFisica getPessoaFisicaByCPF(String cpf) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		PessoaFisica pf =  (PessoaFisica) session.createQuery("Select pf From PessoaFisica pf where pf.CPF=:cpf").setParameter("cpf", cpf).uniqueResult();
		Hibernate.initialize(pf.getPessoa());
		Hibernate.initialize(pf.getEnderecoResidencial());
		return pf;
	}
	
	public PessoaFisica getPessoaFisicaByCodigo(String codigo) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PessoaFisica.class);
		criteria.createAlias("pessoa", "p");
		criteria.add(Restrictions.like("p.codigo", codigo, MatchMode.EXACT));
		return (PessoaFisica) criteria.uniqueResult();
	}
}
