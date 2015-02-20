package br.com.grupomm.dbm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="tipo_assinatura")
@Component
public class TipoAssinatura implements AbstractEntity, Serializable {

	private static final long serialVersionUID = -5854515512931877654L;
	
	@Id
	@GeneratedValue
	@Column(name="id_tipo_assinatura")
	private Long idTipoAssinatura;
	private String descricao;
	private Date dtValidade;
	private Date dtCriacao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoAssinatura")
	private List<Assinatura> assinaturas = new ArrayList<Assinatura>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assinaturas == null) ? 0 : assinaturas.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((dtCriacao == null) ? 0 : dtCriacao.hashCode());
		result = prime * result
				+ ((dtValidade == null) ? 0 : dtValidade.hashCode());
		result = prime
				* result
				+ ((idTipoAssinatura == null) ? 0 : idTipoAssinatura.hashCode());
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
		TipoAssinatura other = (TipoAssinatura) obj;
		if (assinaturas == null) {
			if (other.assinaturas != null)
				return false;
		} else if (!assinaturas.equals(other.assinaturas))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtCriacao == null) {
			if (other.dtCriacao != null)
				return false;
		} else if (!dtCriacao.equals(other.dtCriacao))
			return false;
		if (dtValidade == null) {
			if (other.dtValidade != null)
				return false;
		} else if (!dtValidade.equals(other.dtValidade))
			return false;
		if (idTipoAssinatura == null) {
			if (other.idTipoAssinatura != null)
				return false;
		} else if (!idTipoAssinatura.equals(other.idTipoAssinatura))
			return false;
		return true;
	}

	public Long getIdTipoAssinatura() {
		return idTipoAssinatura;
	}

	public void setIdTipoAssinatura(Long idTipoAssinatura) {
		this.idTipoAssinatura = idTipoAssinatura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public List<Assinatura> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(List<Assinatura> assinaturas) {
		this.assinaturas = assinaturas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TipoAssinatura [idTipoAssinatura=" + idTipoAssinatura
				+ ", descricao=" + descricao + ", dtValidade=" + dtValidade
				+ ", dtCriacao=" + dtCriacao + ", assinaturas=" + assinaturas
				+ "]";
	}
	

}
