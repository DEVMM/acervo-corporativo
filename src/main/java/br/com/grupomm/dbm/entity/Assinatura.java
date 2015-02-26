package br.com.grupomm.dbm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="assinatura")
@Component
public class Assinatura implements AbstractEntity, Serializable {

	private static final long serialVersionUID = 8885793599420506021L;
	
	@Id
	@GeneratedValue
	@Column(name="id_assinatura")
	private Long idAssinatura;
	private String codigo;
	private Boolean status;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_assinatura")
	private TipoAssinatura tipoAssinatura;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="id_endereco_cobranca")
	private Endereco enderecoCobranca;
	
	@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="id_endereco_entrega")
	private Endereco enderecoEntrega;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="assinatura_pai")
	private Assinatura assinaturaPai;

	public Long getIdAssinatura() {
		return idAssinatura;
	}

	public void setIdAssinatura(Long idAssinatura) {
		this.idAssinatura = idAssinatura;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public TipoAssinatura getTipoAssinatura() {
		return tipoAssinatura;
	}

	public void setTipoAssinatura(TipoAssinatura tipoAssinatura) {
		this.tipoAssinatura = tipoAssinatura;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(Endereco enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Assinatura getAssinaturaPai() {
		return assinaturaPai;
	}

	public void setAssinaturaPai(Assinatura assinaturaPai) {
		this.assinaturaPai = assinaturaPai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assinaturaPai == null) ? 0 : assinaturaPai.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((enderecoCobranca == null) ? 0 : enderecoCobranca.hashCode());
		result = prime * result
				+ ((enderecoEntrega == null) ? 0 : enderecoEntrega.hashCode());
		result = prime * result
				+ ((idAssinatura == null) ? 0 : idAssinatura.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((tipoAssinatura == null) ? 0 : tipoAssinatura.hashCode());
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
		Assinatura other = (Assinatura) obj;
		if (assinaturaPai == null) {
			if (other.assinaturaPai != null)
				return false;
		} else if (!assinaturaPai.equals(other.assinaturaPai))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (enderecoCobranca == null) {
			if (other.enderecoCobranca != null)
				return false;
		} else if (!enderecoCobranca.equals(other.enderecoCobranca))
			return false;
		if (enderecoEntrega == null) {
			if (other.enderecoEntrega != null)
				return false;
		} else if (!enderecoEntrega.equals(other.enderecoEntrega))
			return false;
		if (idAssinatura == null) {
			if (other.idAssinatura != null)
				return false;
		} else if (!idAssinatura.equals(other.idAssinatura))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoAssinatura == null) {
			if (other.tipoAssinatura != null)
				return false;
		} else if (!tipoAssinatura.equals(other.tipoAssinatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assinatura [idAssinatura=" + idAssinatura + ", codigo="
				+ codigo + ", status=" + status + ", tipoAssinatura="
				+ tipoAssinatura + ", pessoa=" + pessoa + ", enderecoCobranca="
				+ enderecoCobranca + ", enderecoEntrega=" + enderecoEntrega
				+ ", assinaturaPai=" + assinaturaPai + "]";
	}


}
