package br.com.grupomm.dbm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
		return true;
	}
	
	@Override
	public String toString() {
		return "RamoDeAtividade [idRamo=" + idRamo + ", descricao=" + descricao + "]";
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
