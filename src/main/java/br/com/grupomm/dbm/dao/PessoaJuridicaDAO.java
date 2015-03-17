package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.PessoaJuridica;

@Repository
public class PessoaJuridicaDAO extends AbstractDAO<PessoaJuridica>{
	public PessoaJuridica getPessoaJuridicaByCNPJ(String CNPJ) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		PessoaJuridica pj=  (PessoaJuridica) session.createQuery("Select pj From PessoaJuridica pj where pj.CNPJ=:CNPJ").setParameter("CNPJ", CNPJ).uniqueResult();
		return pj;
	}
	
	public PessoaJuridica getPessoaJuridicaByInscricaoEstadual(String ie) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		PessoaJuridica pj=  (PessoaJuridica) session.createQuery("Select pj From PessoaJuridica pj where pj.inscricaoEstadual=:inscricaoEstadual").setParameter("inscricaoEstadual", ie).uniqueResult();
		Hibernate.initialize(pj.getEnderecoComercial());
		Hibernate.initialize(pj.getResponsavel());
		return pj;
	}
	
	public PessoaJuridica getPessoaJuridicaByCodigo(String codigo) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return (PessoaJuridica) session.createQuery("Select pj From PessoaJuridica pj where pj.codigo= :codigo").setParameter("codigo", codigo).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> listarEmpresas() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		List<PessoaJuridica> pjs = (List<PessoaJuridica>) session.createQuery("from PessoaJuridica").list();
		for (PessoaJuridica pessoaJuridica : pjs) {
			Hibernate.initialize(pessoaJuridica.getAssinaturas());
		}
		return pjs;
	}
}
