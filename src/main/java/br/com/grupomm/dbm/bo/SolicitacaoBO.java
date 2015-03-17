package br.com.grupomm.dbm.bo;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.Solicitacao;

@Component
public class SolicitacaoBO extends AutowiredServices {
	
	public void salvarSolicitacao(Solicitacao s) {
		try {
			this.solicitacaoService.salvar(s);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerSolicitacao(Solicitacao s) {
		try {
			this.solicitacaoService.excluir(s);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void aprovarSolicitacao(Solicitacao s) {
		try {
			this.solicitacaoService.atualizar(s);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Solicitacao getSolicitacaoByID(Solicitacao s) {
		try {
			return this.solicitacaoService.solicitacaoByID(s);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Solicitacao> listarSolicitacoes() {
		try {
			return this.solicitacaoService.listarSolicitacoes();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Solicitacao getSolicitacaoBySolicitante(Pessoa pessoa) {
		try {
			return this.solicitacaoService.getSolicitacaoBySolicitante(pessoa);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}	
