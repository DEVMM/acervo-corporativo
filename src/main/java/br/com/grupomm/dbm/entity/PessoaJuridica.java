package br.com.grupomm.dbm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="pessoa_juridica")
@Component
public class PessoaJuridica implements AbstractEntity, Serializable {

	private static final long serialVersionUID = -3348468570357598711L;
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	private String CNPJ;
	@Column(name="inscricao_estadual")
	private String inscricaoEstadual;
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	@Column(name="razao_social")
	private String razaoSocial;
	private Boolean ativo;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_porte")
	private Porte porte;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_ramo")
	private RamoDeAtividade ramo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_endereco")
	private Endereco enderecoComercial;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_responsavel")
	private PessoaFisica responsavel;
	
	@OneToOne(fetch = FetchType.LAZY)		
	@JoinColumn(name = "id_aoscuidados")
	private PessoaFisica aosCuidados;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public RamoDeAtividade getRamo() {
		return ramo;
	}

	public void setRamo(RamoDeAtividade ramo) {
		this.ramo = ramo;
	}

	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}

	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}

	public PessoaFisica getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(PessoaFisica responsavel) {
		this.responsavel = responsavel;
	}

	public PessoaFisica getAosCuidados() {
		return aosCuidados;
	}

	public void setAosCuidados(PessoaFisica aosCuidados) {
		this.aosCuidados = aosCuidados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
		result = prime * result
				+ ((aosCuidados == null) ? 0 : aosCuidados.hashCode());
		result = prime
				* result
				+ ((enderecoComercial == null) ? 0 : enderecoComercial
						.hashCode());
		result = prime
				* result
				+ ((inscricaoEstadual == null) ? 0 : inscricaoEstadual
						.hashCode());
		result = prime * result
				+ ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((porte == null) ? 0 : porte.hashCode());
		result = prime * result + ((ramo == null) ? 0 : ramo.hashCode());
		result = prime * result
				+ ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result
				+ ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		if (aosCuidados == null) {
			if (other.aosCuidados != null)
				return false;
		} else if (!aosCuidados.equals(other.aosCuidados))
			return false;
		if (enderecoComercial == null) {
			if (other.enderecoComercial != null)
				return false;
		} else if (!enderecoComercial.equals(other.enderecoComercial))
			return false;
		if (inscricaoEstadual == null) {
			if (other.inscricaoEstadual != null)
				return false;
		} else if (!inscricaoEstadual.equals(other.inscricaoEstadual))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (porte == null) {
			if (other.porte != null)
				return false;
		} else if (!porte.equals(other.porte))
			return false;
		if (ramo == null) {
			if (other.ramo != null)
				return false;
		} else if (!ramo.equals(other.ramo))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [pessoa=" + pessoa + ", CNPJ=" + CNPJ
				+ ", inscricaoEstadual=" + inscricaoEstadual
				+ ", nomeFantasia=" + nomeFantasia + ", razaoSocial="
				+ razaoSocial + ", ativo=" + ativo + ", porte=" + porte
				+ ", ramo=" + ramo + ", enderecoComercial=" + enderecoComercial
				+ ", responsavel=" + responsavel + ", aosCuidados="
				+ aosCuidados + "]";
	}
	
	
}
