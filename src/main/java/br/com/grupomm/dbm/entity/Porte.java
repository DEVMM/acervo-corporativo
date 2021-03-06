package br.com.grupomm.dbm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Porte")
@Component
public class Porte implements AbstractEntity, Serializable {
	
	private static final long serialVersionUID = -8919950828739486473L;
	
	@Id
	@GeneratedValue
	@Column(name="id_porte")
	private Integer idPorte;
	private String descricao;
	
	public Integer getIdPorte() {
		return idPorte;
	}
	public void setIdPorte(Integer idPorte) {
		this.idPorte = idPorte;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idPorte == null) ? 0 : idPorte.hashCode());
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
		Porte other = (Porte) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idPorte == null) {
			if (other.idPorte != null)
				return false;
		} else if (!idPorte.equals(other.idPorte))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Porte [idPorte=" + idPorte + ", descricao=" + descricao + "]";
	}
	
}
