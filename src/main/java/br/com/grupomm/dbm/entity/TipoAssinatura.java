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
@Table(name="tipo_assinatura")
@Component
public class TipoAssinatura implements AbstractEntity, Serializable {

	private static final long serialVersionUID = -5854515512931877654L;
	
	@Id
	@GeneratedValue
	@Column(name="id_tipo_assinatura")
	private Long idTipoAssinatura;
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoAssinatura")
	private List<Assinatura> assinaturas = new ArrayList<Assinatura>();


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

	public List<Assinatura> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(List<Assinatura> assinaturas) {
		this.assinaturas = assinaturas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
