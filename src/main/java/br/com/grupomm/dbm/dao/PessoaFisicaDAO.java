package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.PessoaFisica;

@Repository
public class PessoaFisicaDAO extends AbstractDAO<PessoaFisica> {
	
	public PessoaFisica getPessoaFisicaByCPF(String cpf) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		PessoaFisica pf =  (PessoaFisica) session.createQuery("Select pf From PessoaFisica pf where pf.CPF=:cpf").setParameter("cpf", cpf).uniqueResult();
		Hibernate.initialize(pf.getEnderecoResidencial());
		return pf;
	}
	
	public PessoaFisica getPessoaFisicaByCodigo(String codigo) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return (PessoaFisica) session.createQuery("Select pf From PessoaFisica pf where pf.codigo=:codigo").setParameter("codigo", codigo).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> listarPessoas() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from PessoaFisica").list();
	}
}
