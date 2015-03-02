package br.com.grupomm.dbm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="pessoa")
public class Pessoa implements AbstractEntity, Serializable {

	private static final long serialVersionUID = -4436364834267060433L;
	 
	@Id
	@GeneratedValue
	@Column(name = "id_pessoa")
	private Long id;
	private String codigo;
	private Boolean ativo;
	
	@OneToMany(mappedBy="pessoa", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Email> emails = new ArrayList<>();
	
	@OneToMany(mappedBy="pessoa", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Telefone> telefones = new ArrayList<>();
	
	@OneToMany(mappedBy="pessoa", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Assinatura> assinaturas = new ArrayList<>();
	
	@OneToMany(mappedBy="pessoa", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
	
	@OneToMany(mappedBy="pessoa", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
	@JoinTable(name="perfil_pessoa", 
		joinColumns = { @JoinColumn(name = "id_pessoa", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "id_perfil", nullable = false, updatable = false) })  
	private List<Perfil> perfis = new ArrayList<Perfil>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Assinatura> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(List<Assinatura> assinaturas) {
		this.assinaturas = assinaturas;
	}

	public List<PessoaFisica> getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
		this.pessoasJuridicas = pessoasJuridicas;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assinaturas == null) ? 0 : assinaturas.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((perfis == null) ? 0 : perfis.hashCode());
		result = prime * result
				+ ((pessoasFisicas == null) ? 0 : pessoasFisicas.hashCode());
		result = prime
				* result
				+ ((pessoasJuridicas == null) ? 0 : pessoasJuridicas.hashCode());
		result = prime * result
				+ ((telefones == null) ? 0 : telefones.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (assinaturas == null) {
			if (other.assinaturas != null)
				return false;
		} else if (!assinaturas.equals(other.assinaturas))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (perfis == null) {
			if (other.perfis != null)
				return false;
		} else if (!perfis.equals(other.perfis))
			return false;
		if (pessoasFisicas == null) {
			if (other.pessoasFisicas != null)
				return false;
		} else if (!pessoasFisicas.equals(other.pessoasFisicas))
			return false;
		if (pessoasJuridicas == null) {
			if (other.pessoasJuridicas != null)
				return false;
		} else if (!pessoasJuridicas.equals(other.pessoasJuridicas))
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", codigo=" + codigo + ", ativo=" + ativo
				+ ", emails=" + emails + ", telefones=" + telefones
				+ ", assinaturas=" + assinaturas + ", pessoasFisicas="
				+ pessoasFisicas + ", pessoasJuridicas=" + pessoasJuridicas
				+ ", perfis=" + perfis + "]";
	}

}
