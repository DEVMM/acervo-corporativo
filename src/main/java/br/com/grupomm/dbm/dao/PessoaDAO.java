package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Pessoa;

@Repository
public class PessoaDAO extends AbstractDAO<Pessoa> {
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarPessoas() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pessoa> listarPessoas = session.createQuery("from Pessoa").list();
		return listarPessoas;
	}
	
	public Pessoa getPessoaByCodigo(String codigo) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return (Pessoa) session.createQuery("from Pessoa where codigo=:codigo").setParameter("codigo", codigo).uniqueResult();
	}
	
}
