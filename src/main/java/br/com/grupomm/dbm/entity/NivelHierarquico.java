package br.com.grupomm.dbm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="nivel_hierarquico")
@Component
public class NivelHierarquico implements AbstractEntity, Serializable {
	
	private static final long serialVersionUID = -3449524090256628364L;
	@Id
	@GeneratedValue
	@Column(name="id_nivel")
	private Integer idNivel;
	private String descricao;
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "nivel")
	private Set<PessoaFisica> pessoasFisicas = new HashSet<PessoaFisica>(0);*/
	
	public Integer getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
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
		result = prime * result + ((idNivel == null) ? 0 : idNivel.hashCode());
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
		NivelHierarquico other = (NivelHierarquico) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idNivel == null) {
			if (other.idNivel != null)
				return false;
		} else if (!idNivel.equals(other.idNivel))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "NivelHierarquico [idNivel=" + idNivel + ", descricao="
				+ descricao + "]";
	}
	
}
