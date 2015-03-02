package br.com.grupomm.dbm.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.grupomm.dbm.bo.CadastroBO;
import br.com.grupomm.dbm.entity.Email;
import br.com.grupomm.dbm.entity.Endereco;
import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.PessoaFisica;
import br.com.grupomm.dbm.entity.PessoaJuridica;
import br.com.grupomm.dbm.entity.Porte;
import br.com.grupomm.dbm.entity.RamoDeAtividade;
import br.com.grupomm.dbm.entity.Telefone;
import br.com.grupomm.dbm.utils.GerarCodigo;

@Controller
public class CadastroController {

	@Autowired
	private CadastroBO cadastroBO;
	@Autowired
	private GerarCodigo gerarCodigo;
	@Autowired
	private Pessoa pessoa;
	@Autowired
	private PessoaFisica pessoaFisica;
	@Autowired
	private Endereco e;

	@RequestMapping(value="/dbm/cadastrar-usuario")
	public String cadastroPessoaFisica(Model model) {

		model.addAttribute("pessoaFisica", new PessoaFisica());
		model.addAttribute("email", new String());
		model.addAttribute("emailSecundario", new String());
		model.addAttribute("telefoneResidencial", new String());
		model.addAttribute("telefoneComercial", new String());
		model.addAttribute("celular", new String());
		model.addAttribute("listarAreas", cadastroBO.listarAreaDeAtuacao());
		model.addAttribute("listarNiveis", cadastroBO.listarNivelHierarquico());
		model.addAttribute("idArea", new String());
		model.addAttribute("idNivel", new String());

		return "pessoa-fisica";
	}
	
	@RequestMapping(value="/dbm/cadastrar-empresa")
	public String cadastroPessoaJuridica(Model model) {
		model.addAttribute("pessoaJuridica", new PessoaJuridica());
		model.addAttribute("telefone", new Telefone());
		model.addAttribute("email", new Email());
		model.addAttribute("porteEmpresa", new Porte());
		model.addAttribute("ramoEmpresa", new RamoDeAtividade());
		model.addAttribute("listarPorte", cadastroBO.listarPorte());
		model.addAttribute("listarRamo", cadastroBO.listarRamoDeAtividade());
		model.addAttribute("idPorte", new String());
		model.addAttribute("idRamo", new String());
		return "pessoa-juridica";
	}
	
	@RequestMapping(value= "/dbm/cadastrar-empresa/salvar", method = RequestMethod.POST)
	public @ResponseBody String salvarEmpresa(@ModelAttribute("pessoaJuridica") PessoaJuridica pJ,
			@ModelAttribute("telefone") Telefone telefone,
			@ModelAttribute("email") Email email,
			@ModelAttribute("porteEmpresa") Porte porte, 
			@ModelAttribute("ramoEmpresa") RamoDeAtividade ramo, 
			@ModelAttribute("cpfPessoa") String cpf,
			@ModelAttribute("idPorte") String idPorte, 
			@ModelAttribute("idRamo") String idRamo){
		this.pessoa.setCodigo(gerarCodigo.randomString());
		this.pessoa = salvarEPegarPessoa(this.pessoa);
		telefone.setPessoa(this.pessoa);
		this.cadastroBO.salvarTelefone(telefone);
		email.setPessoa(this.pessoa);
		this.cadastroBO.salvarEmail(email);
		pJ.setPessoa(this.pessoa);
		pJ.setPorte(this.cadastroBO.getPorteById(Integer.parseInt(idPorte)));
		pJ.setRamo(this.cadastroBO.getRamoById(Integer.parseInt(idRamo)));
		
		if (!(cpf.length() == 0)) {
			try {
				pJ.setResponsavel(this.cadastroBO.getPessoaFisicaByCPF(cpf));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.cadastroBO.salvarPssoaJuridica(pJ);
		return "dados-finalizados";
	}

	@RequestMapping(value= "/dbm/cadastrar-usuario/salvar", method = RequestMethod.POST)
	public String salvarUsuario(@ModelAttribute("pessoaFisica") PessoaFisica pF,
			@ModelAttribute("email") String email,
			@ModelAttribute("emailSecundario") String emailSecundario,
			@ModelAttribute("telefoneResidencial") String telefoneResidencial,
			@ModelAttribute("telefoneComercial") String telefoneComercial,
			@ModelAttribute("celular") String celular, 
			@ModelAttribute("idArea") String idArea,
			@ModelAttribute("idNivel") String idNivel){
		
		Pessoa p = new Pessoa();
		p.setCodigo(gerarCodigo.randomString());
		
		this.pessoa = salvarEPegarPessoa(p);
		
		//Vincular Telefones
		if(!(celular.length()==0)) { Telefone t = new Telefone(); t.setNumero(celular); t.setTipo("celular"); t.setPessoa(this.pessoa); this.cadastroBO.salvarTelefone(t);}
		if(!(telefoneResidencial.length()==0)) { Telefone t2 = new Telefone(); t2.setNumero(telefoneResidencial); t2.setTipo("residencial"); t2.setPessoa(this.pessoa); this.cadastroBO.salvarTelefone(t2);}
		if(!(telefoneComercial.length()==0)) { Telefone t3 = new Telefone(); t3.setNumero(telefoneComercial); t3.setTipo("comercial"); t3.setPessoa(this.pessoa); this.cadastroBO.salvarTelefone(t3); }
		
		//Vincular Emails
		if(!(email.length()==0)) { Email mail = new Email(); mail.setEmail(email); mail.setPrincipal(true); mail.setPessoa(this.pessoa); this.cadastroBO.salvarEmail(mail); }
		if(!(emailSecundario.length()==0)){ Email mail1 = new Email(); mail1.setEmail(emailSecundario); mail1.setPessoa(this.pessoa); mail1.setPrincipal(false); this.cadastroBO.salvarEmail(mail1); }
		pF.setCPF(pF.getCPF().replace(".", ""));
		pF.setCPF(pF.getCPF().replace("-", ""));
		pF.getEnderecoResidencial().setTipo("Residencial");
		pF.setPessoa(this.pessoa);
		pF.setNivel(this.cadastroBO.getNivelByID(Integer.parseInt(idNivel)));
		pF.setArea(this.cadastroBO.getAreaByID(Integer.parseInt(idArea)));
		this.cadastroBO.salvarPessoaFisica(pF);
		
		return "dados-finalizados";

	}

	public Pessoa salvarEPegarPessoa(Pessoa p) {
		this.cadastroBO.salvarPessoa(p);
		return this.cadastroBO.getPessoaByCodigo(p.getCodigo());
	}
	
	@RequestMapping(value="/dbm/localizarResponsavel", method=RequestMethod.POST)
	public String localizarResponsavel(@ModelAttribute("CPF") String CPF, Model model) {
		try {
			model.addAttribute("pessoaFisica", this.cadastroBO.getPessoaFisicaByCPF(CPF));
			model.addAttribute("listarAreas", cadastroBO.listarAreaDeAtuacao());
			model.addAttribute("listarNiveis", cadastroBO.listarNivelHierarquico());
			model.addAttribute("cpfPessoa", new String());
			return "componentes/includes/form-pessoaFisica";
		} catch (Exception e) {
			e.printStackTrace();
			return "novoUsuario";
		}
	}
	
	@RequestMapping(value="/dbm/validarCPF", method= RequestMethod.POST)
	public @ResponseBody String validarCPF(@ModelAttribute("cpf") String CPF) {
		try {
			this.cadastroBO.getPessoaFisicaByCPF(CPF);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping(value="/dbm/validarEmail", method= RequestMethod.POST)
	public @ResponseBody String validarEmail(@ModelAttribute("email") String email) {
		try {
			Email e = this.cadastroBO.getEmailByEndereco(email);
			e.getEmail();
			return "true";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping(value="/dbm/validarCNPJ", method= RequestMethod.POST)
	public @ResponseBody String validarCNPJ(@ModelAttribute("cnpj") String cnpj) {
		System.out.println(cnpj);
		try {
			this.cadastroBO.getPessoaJuridicaByCNPJ(cnpj);
			return "true";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping(value="/dbm/validarInscricaoEstadual", method= RequestMethod.POST)
	public @ResponseBody String validarInscricaoEstadual(@ModelAttribute("inscricaoEstadual") String inscricaoEstadual) {
		try {
			this.cadastroBO.getPessoaJuridicaByInscricaoEstadual(inscricaoEstadual);
			return "true";
		} catch (SQLException ex) {
			ex.printStackTrace();
			return "false";
		}
	}
	
}


