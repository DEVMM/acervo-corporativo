package br.com.grupomm.dbm.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.grupomm.dbm.service.AreaDeAtuacaoService;
import br.com.grupomm.dbm.service.EmailService;
import br.com.grupomm.dbm.service.EnderecoService;
import br.com.grupomm.dbm.service.NivelHierarquicoService;
import br.com.grupomm.dbm.service.PessoaFisicaService;
import br.com.grupomm.dbm.service.PessoaJuridicaService;
import br.com.grupomm.dbm.service.PessoaService;
import br.com.grupomm.dbm.service.PorteService;
import br.com.grupomm.dbm.service.RamoDeAtividadeService;
import br.com.grupomm.dbm.service.TelefoneService;

public abstract class AutowiredServices {
	
	protected PessoaService pessoaService;
	@Autowired(required=true)
	@Qualifier(value="pessoaService")
	public void setPessoaService(PessoaService ps){
		this.pessoaService = ps;
	}
	
	protected PessoaFisicaService pessoaFisicaService;
	@Autowired(required=true)
	@Qualifier(value="pessoaFisicaService")
	public void setPessoaFisicaService(PessoaFisicaService pfs){
		this.pessoaFisicaService = pfs;
	}

	protected PessoaJuridicaService pessoaJuridicaService;
	@Autowired(required=true)
	@Qualifier(value="pessoaJuridicaService")
	public void setPessoaJuridicaService(PessoaJuridicaService pjs){
		this.pessoaJuridicaService = pjs;
	}
	
	protected EnderecoService enderecoService;
	@Autowired(required=true)
	@Qualifier(value="enderecoService")
	public void setEnderecoService(EnderecoService es){
		this.enderecoService = es;
	}
	
	protected EmailService emailService;
	@Autowired(required=true)
	@Qualifier(value="emailService")
	public void setEmailService(EmailService es){
		this.emailService = es;
	}
	
	protected TelefoneService telefoneService;
	@Autowired(required=true)
	@Qualifier(value="telefoneService")
	public void setTelefoneService(TelefoneService ts){
		this.telefoneService = ts;
	}
	
	protected NivelHierarquicoService nivelHierarquicoService;
	@Autowired(required=true)
	@Qualifier(value="nivelHierarquicoService")
	public void setNivelHierarquicoService(NivelHierarquicoService ns){
		this.nivelHierarquicoService = ns;
	}
	
	protected AreaDeAtuacaoService areaDeAtuacaoService;
	@Autowired(required=true)
	@Qualifier(value="areaDeAtuacaoService")
	public void setAreaDeAtuacaoService(AreaDeAtuacaoService as){
		this.areaDeAtuacaoService = as;
	}
	
	protected PorteService porteService;
	@Autowired(required=true)
	@Qualifier(value="porteService")
	public void setPorteService(PorteService ps){
		this.porteService = ps;
	}
	
	protected RamoDeAtividadeService ramoDeAtividadeService;
	@Autowired(required=true)
	@Qualifier(value="ramoDeAtividadeService")
	public void setRamoDeAtividadeService(RamoDeAtividadeService rs){
		this.ramoDeAtividadeService = rs;
	}
}