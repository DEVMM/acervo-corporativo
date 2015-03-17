package br.com.grupomm.dbm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.grupomm.dbm.bo.AssinaturaBO;
import br.com.grupomm.dbm.bo.CadastroBO;
import br.com.grupomm.dbm.bo.PessoaBO;
import br.com.grupomm.dbm.entity.Assinatura;
import br.com.grupomm.dbm.entity.Email;
import br.com.grupomm.dbm.entity.PessoaFisica;
import br.com.grupomm.dbm.entity.PessoaJuridica;
import br.com.grupomm.dbm.entity.Telefone;

@Controller
public class AssinaturaController {
	
	private User activeUser;
	@Autowired
	private PessoaFisica pessoaFisica;
	@Autowired
	private PessoaJuridica pessoaJuridica;
	@Autowired
	private CadastroBO cadastroBO;
	@Autowired
	private PessoaBO pessoaBO;
	@Autowired
	private AssinaturaBO assinaturaBO;
		
	@RequestMapping(value="/assinatura/dashboard")
	public String dashboardAssinaturas(Model model, Principal principal) {
	    
		this.activeUser = (User) ((Authentication)principal).getPrincipal();
		try {
			if (!(pessoaBO.getPessoaFisicaByCodigo(activeUser.getUsername()) == null)) {
				this.pessoaFisica = pessoaBO.getPessoaFisicaByCodigo(activeUser.getUsername());
				model.addAttribute("pf", this.pessoaFisica);
				model.addAttribute("assinatura", this.assinaturaBO.getAssinaturaByPessoa(this.pessoaFisica));
			} else if (!(pessoaBO.getPessoaJuridicaByCodigo(activeUser.getUsername()) == null)) {
				this.pessoaJuridica = pessoaBO.getPessoaJuridicaByCodigo(activeUser.getUsername());
				model.addAttribute("pj", this.pessoaJuridica);
				model.addAttribute("assinatura", this.assinaturaBO.getAssinaturaByPessoa(this.pessoaJuridica));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "dashboard-assinaturas";
	}

	@RequestMapping(value="/assinatura/novaAssinatura", method= RequestMethod.POST)
	public String novaAssinatura(Model model) {

		return null;
	}
	
	
	@RequestMapping(value="/administracao/incluirAssinatura", method= RequestMethod.POST)
	public String chamarModelIncluirAssinaturaAdministracao(Model model) {
		model.addAttribute("pessoaJuridica", new PessoaJuridica());
		model.addAttribute("telefone", new Telefone());
		model.addAttribute("email", new Email());
		model.addAttribute("listarPorte", cadastroBO.listarPorte());
		model.addAttribute("listarRamo", cadastroBO.listarRamoDeAtividade());
		model.addAttribute("idPorte", new String());
		model.addAttribute("idRamo", new String());
		model.addAttribute("assinatura", new Assinatura());
		model.addAttribute("tiposDeAssinaturas", this.assinaturaBO.listarTiposDeAssinaturas());
		model.addAttribute("idTipoAssinatura", new String());
		return "pessoa-juridica";
	}
	
}
