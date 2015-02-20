package br.com.grupomm.dbm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.grupomm.dbm.entity.Endereco;

@Repository
public class EnderecoDAO extends AbstractDAO<Endereco> {
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listarEndereco() throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Endereco").list();
	}
	
	public Endereco EnderecoByID(int id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Endereco) session.get(Endereco.class, new Integer(id));
	}
	
	public Endereco getEnderecoByCepAndNumero(Long cep, Integer numero) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();      
		return (Endereco) session.createQuery("From Endereco where cep= :cep and numero= :numero").setParameter("cep", cep).setParameter("numero", numero).uniqueResult();
	}
	
}
