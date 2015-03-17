package br.com.grupomm.dbm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.grupomm.dbm.bo.AssinaturaBO;
import br.com.grupomm.dbm.bo.CadastroBO;
import br.com.grupomm.dbm.bo.PessoaBO;
import br.com.grupomm.dbm.entity.PessoaFisica;
import br.com.grupomm.dbm.entity.PessoaJuridica;

@Controller
public class AdministracaoController {
	
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
	
	@RequestMapping("/administracao/inicio")
	public String carregarPaginiaInicia(Model model, Principal principal) {
		
		this.activeUser = (User) ((Authentication)principal).getPrincipal();
		try {
				this.pessoaFisica = pessoaBO.getPessoaFisicaByCodigo(activeUser.getUsername());
				model.addAttribute("pf", this.pessoaFisica);
				model.addAttribute("listarEmpresas", this.pessoaBO.listarEmpresa());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "dashboard-administracao";
	}
}
