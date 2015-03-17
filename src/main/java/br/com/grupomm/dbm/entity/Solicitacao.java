package br.com.grupomm.dbm.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="solicitacoes_dbm")
public class Solicitacao implements AbstractEntity, Serializable {
	private static final long serialVersionUID = -1054841125470323323L;
	@Id
	@GeneratedValue
	@Column(name="id_solicitacao")
	private Long idSolicitacao;
	private Calendar dataSolicitacao;
	private String comentario;
	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="beneficiado")
	private PessoaFisica dadosBeneficiario;
	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="solicitante")
	private Pessoa dadosSolicitante;
	private Assinatura assinatura;
	
	public Long getIdSolicitacao() {
		return idSolicitacao;
	}
	public void setIdSolicitacao(Long idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}
	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public PessoaFisica getDadosBeneficiario() {
		return dadosBeneficiario;
	}
	public void setDadosBeneficiario(PessoaFisica dadosBeneficiario) {
		this.dadosBeneficiario = dadosBeneficiario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Pessoa getDadosSolicitante() {
		return dadosSolicitante;
	}
	public void setDadosSolicitante(Pessoa pessoa) {
		this.dadosSolicitante = pessoa;
	}
	public Assinatura getAssinatura() {
		return assinatura;
	}
	public void setAssinatura(Assinatura assinatura) {
		this.assinatura = assinatura;
	}
	
}
