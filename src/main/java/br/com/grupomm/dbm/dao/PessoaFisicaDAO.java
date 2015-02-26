package br.com.grupomm.dbm.dao;

import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
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
	
}
