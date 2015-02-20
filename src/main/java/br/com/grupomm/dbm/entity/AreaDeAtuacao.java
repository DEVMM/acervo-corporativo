package br.com.grupomm.dbm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="area_de_atuacao")
@Component
public class AreaDeAtuacao implements AbstractEntity, Serializable {

	private static final long serialVersionUID = -97412736166499758L; 
	
	@Id
	@GeneratedValue
	@Column(name="id_area")
	private Integer idArea;
	private String descricao;
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "area")
	private Set<PessoaFisica> pessoasFisicas = new HashSet<PessoaFisica>(0);*/
	
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
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
		result = prime * result + ((idArea == null) ? 0 : idArea.hashCode());
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
		AreaDeAtuacao other = (AreaDeAtuacao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idArea == null) {
			if (other.idArea != null)
				return false;
		} else if (!idArea.equals(other.idArea))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AreaDeAtuacao [idArea=" + idArea + ", descricao=" + descricao +"]";
	}
	
	
}
