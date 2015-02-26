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
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(Email email) {
		email.setPessoa(this);
		this.emails.add(email);
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Telefone telefone) {
		telefone.setPessoa(this);
		this.telefones.add(telefone);
	}
	public List<Assinatura> getAssinaturas() {
		return assinaturas;
	}
	public void setAssinaturas(Assinatura assinatura) {
		assinatura.setPessoa(this);
		this.assinaturas.add(assinatura);
	}
	public List<PessoaFisica> getPessoasFisicas() {
		return pessoasFisicas;
	}
	public void setPessoasFisicas(PessoaFisica pessoaFisica) {
		pessoaFisica.setPessoa(this);
		this.pessoasFisicas.add(pessoaFisica);
	}
	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}
	public void setPessoasJuridicas(PessoaJuridica pessoaJuridica) {
		pessoaJuridica.setPessoa(this);
		this.pessoasJuridicas.add(pessoaJuridica);
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
}
