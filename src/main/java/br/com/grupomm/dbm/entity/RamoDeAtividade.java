package br.com.grupomm.dbm.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="ramo_de_atividade")
@Component
public class RamoDeAtividade implements AbstractEntity, Serializable {
	
	private static final long serialVersionUID = 1443388886692631796L;
	@Id
	@GeneratedValue
	@Column(name="id_ramo")
	private Integer idRamo;
	private String descricao;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ramo")
	private List<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
	
	public Integer getIdRamo() {
		return idRamo;
	}
	public void setIdRamo(Integer idRamo) {
		this.idRamo = idRamo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idRamo == null) ? 0 : idRamo.hashCode());
		result = prime
				* result
				+ ((pessoasJuridicas == null) ? 0 : pessoasJuridicas.hashCode());
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
		RamoDeAtividade other = (RamoDeAtividade) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idRamo == null) {
			if (other.idRamo != null)
				return false;
		} else if (!idRamo.equals(other.idRamo))
			return false;
		if (pessoasJuridicas == null) {
			if (other.pessoasJuridicas != null)
				return false;
		} else if (!pessoasJuridicas.equals(other.pessoasJuridicas))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "RamoDeAtividade [idRamo=" + idRamo + ", descricao=" + descricao
				+ ", pessoasJuridicas=" + pessoasJuridicas + "]";
	}
	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}
	public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
		this.pessoasJuridicas = pessoasJuridicas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
