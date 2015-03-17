package br.com.grupomm.dbm.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.grupomm.dbm.bo.AssinaturaBO;
import br.com.grupomm.dbm.bo.CadastroBO;
import br.com.grupomm.dbm.bo.PessoaBO;
import br.com.grupomm.dbm.bo.SolicitacaoBO;
import br.com.grupomm.dbm.entity.Assinatura;
import br.com.grupomm.dbm.entity.Email;
import br.com.grupomm.dbm.entity.Endereco;
import br.com.grupomm.dbm.entity.PessoaFisica;
import br.com.grupomm.dbm.entity.Solicitacao;

@Controller
public class SolicitacaoController {

	@Autowired
	private Solicitacao solicitacao;
	@Autowired
	private SolicitacaoBO solicitacaoBO;
	@Autowired
	private CadastroBO cadastroBO;
	@Autowired
	private AssinaturaBO assinaturaBO;
	@Autowired
	private Email email;
	@Autowired
	private Endereco endereco;
	@Autowired
	private PessoaBO pessoaBO;



	@RequestMapping(value="/solicitacoes/callModalAddAssinatura", method= RequestMethod.POST)
	public String callModalAddAssinatura(Model model) {
		model.addAttribute("pessoaFisica", new PessoaFisica());
		model.addAttribute("email", new Email());
		model.addAttribute("assinatura", new Assinatura());
		return "modals/add-assinatura";
	}

	@RequestMapping(value="/solicitacoes/novaAssinatura", method= RequestMethod.POST)
	public @ResponseBody String solicitarNovaAssinatura(Model model, Principal principal, 
			@ModelAttribute("pessoaFisica") PessoaFisica pf, 
			@ModelAttribute("email") Email e, 
			@ModelAttribute("assinatura") Assinatura a) {
		
		List<Email> emails = new ArrayList<Email>();
		emails.add(e);
		pf.setEmails(emails);
		solicitacao.setDataSolicitacao(Calendar.getInstance());
		solicitacao.setDadosBeneficiario(pf);
		solicitacao.setDadosSolicitante(pessoaBO.getUsuarioLogado(principal));
		
		this.solicitacaoBO.salvarSolicitacao(new Solicitacao());

		System.out.println(pf.toString());
		System.out.println(e.toString());
		System.out.println(a.toString());

		return "Suuuuuuuucessoooooo";
	}
}
