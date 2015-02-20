package br.com.grupomm.dbm.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="pessoa_fisica")
@Component
public class PessoaFisica implements AbstractEntity, Serializable {

	private static final long serialVersionUID = 482401824743530814L;
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	private String nome;
	private String sobrenome;
	private char sexo;
	private String CPF;
	@Column(name="data_nascimento")
	private Date dtNascimento;
	private Boolean status;
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="id_nivel")
	private NivelHierarquico nivel;
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="id_area")
	private AreaDeAtuacao area;
	@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="id_endereco")
	private Endereco enderecoResidencial;
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public NivelHierarquico getNivel() {
		return nivel;
	}
	public void setNivel(NivelHierarquico nivel) {
		this.nivel = nivel;
	}
	public AreaDeAtuacao getArea() {
		return area;
	}
	public void setArea(AreaDeAtuacao area) {
		this.area = area;
	}
	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}
	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result
				+ ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime
				* result
				+ ((enderecoResidencial == null) ? 0 : enderecoResidencial
						.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + sexo;
		result = prime * result
				+ ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (enderecoResidencial == null) {
			if (other.enderecoResidencial != null)
				return false;
		} else if (!enderecoResidencial.equals(other.enderecoResidencial))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (sexo != other.sexo)
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PessoaFisica [pessoa=" + pessoa + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", sexo=" + sexo + ", CPF="
				+ CPF + ", dtNascimento=" + dtNascimento + ", status=" + status
				+ ", nivel=" + nivel + ", area=" + area
				+ ", enderecoResidencial=" + enderecoResidencial + "]";
	}
	
	
}
