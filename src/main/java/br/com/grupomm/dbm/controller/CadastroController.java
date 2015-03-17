package br.com.grupomm.dbm.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.grupomm.dbm.bo.AssinaturaBO;
import br.com.grupomm.dbm.bo.CadastroBO;
import br.com.grupomm.dbm.entity.Assinatura;
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
	private Endereco endereco;
	@Autowired
	private Porte porte;
	@Autowired
	private RamoDeAtividade ramoDeAtividade;
	@Autowired
	private AssinaturaBO assinaturaBO;

	@RequestMapping(value="/assinatura/cadastrar-usuario")
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
	
	@RequestMapping(value= "/administracao/cadastrar-empresa/salvar", method = RequestMethod.POST)
	public @ResponseBody String salvarEmpresa(@ModelAttribute("pessoaJuridica") PessoaJuridica pJ,
			@ModelAttribute("telefone") Telefone telefone,
			@ModelAttribute("email") Email email,
			@ModelAttribute("porteEmpresa") Porte porte, 
			@ModelAttribute("ramoEmpresa") RamoDeAtividade ramo, 
			@ModelAttribute("idPorte") String idPorte, 
			@ModelAttribute("idRamo") String idRamo,
			@ModelAttribute("assinatura") Assinatura a, 
			@ModelAttribute("idTipoAssinatura") String idTipoAssinatura){
		
		List<Telefone> tels = new ArrayList<Telefone>();
		tels.add(telefone);
		List<Email> emails = new ArrayList<Email>();
		emails.add(email);
		
		pJ.setCodigo(gerarCodigo.randomString());
		pJ.setTelefones(tels);
		pJ.setEmails(emails);
		
		String cep = pJ.getEnderecoComercial().getCep();
		cep.replace("-", "");
		pJ.getEnderecoComercial().setCep(cep);
		
		pJ.setPorte(this.cadastroBO.getPorteById(Integer.parseInt(idPorte)));
		pJ.setRamo(this.cadastroBO.getRamoById(Integer.parseInt(idRamo)));
		
		this.cadastroBO.salvarPssoaJuridica(pJ);
		a.setPessoa(pJ);
		
		try {
			this.assinaturaBO.criarAssinatura(a);
			return "true";
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
			this.cadastroBO.excluirPessoa(pJ);
			return "false";
		}
		
		
	}

	@RequestMapping(value= "/assinatura/cadastrar-usuario/salvar", method = RequestMethod.POST)
	public String salvarUsuario(@ModelAttribute("pessoaFisica") PessoaFisica pF,
			@ModelAttribute("email") String email,
			@ModelAttribute("emailSecundario") String emailSecundario,
			@ModelAttribute("telefoneResidencial") String telefoneResidencial,
			@ModelAttribute("telefoneComercial") String telefoneComercial,
			@ModelAttribute("celular") String celular, 
			@ModelAttribute("idArea") String idArea,
			@ModelAttribute("idNivel") String idNivel){
		
		pF.setCodigo(gerarCodigo.randomString());
		String cep = pF.getEnderecoResidencial().getCep();
		cep.replace("-", "");
		pF.getEnderecoResidencial().setCep(cep);
		pF.setCPF(pF.getCPF().replace(".", ""));
		pF.setCPF(pF.getCPF().replace("-", ""));
		pF.getEnderecoResidencial().setTipo("Residencial");
		pF.setNivel(this.cadastroBO.getNivelByID(Integer.parseInt(idNivel)));
		pF.setArea(this.cadastroBO.getAreaByID(Integer.parseInt(idArea)));
		
		this.cadastroBO.salvarPessoaFisica(pF);
		
		//Vincular Telefones
		if(!(celular.length()==0)) { Telefone t = new Telefone(); t.setNumero(celular); t.setTipo("celular"); t.setPessoa(pF); this.cadastroBO.salvarTelefone(t);}
		if(!(telefoneResidencial.length()==0)) { Telefone t2 = new Telefone(); t2.setNumero(telefoneResidencial); t2.setTipo("residencial"); t2.setPessoa(pF); this.cadastroBO.salvarTelefone(t2);}
		if(!(telefoneComercial.length()==0)) { Telefone t3 = new Telefone(); t3.setNumero(telefoneComercial); t3.setTipo("comercial"); t3.setPessoa(pF); this.cadastroBO.salvarTelefone(t3); }
		
		//Vincular Emails
		if(!(email.length()==0)) { Email mail = new Email(); mail.setEmail(email); mail.setPrincipal(true); mail.setPessoa(pF); this.cadastroBO.salvarEmail(mail); }
		if(!(emailSecundario.length()==0)){ Email mail1 = new Email(); mail1.setEmail(emailSecundario); mail1.setPessoa(pF); mail1.setPrincipal(false); this.cadastroBO.salvarEmail(mail1); }
		
		
		return "dados-finalizados";

	}

	public Pessoa salvarEPegarPessoa(Pessoa p) {
		this.cadastroBO.salvarPessoa(p);
		return this.cadastroBO.getPessoaByCodigo(p.getCodigo());
	}
	
	@RequestMapping(value="/assinatura/localizarResponsavel", method=RequestMethod.POST)
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
	
	@RequestMapping(value="/assinatura/validarCPF", method= RequestMethod.POST)
	public @ResponseBody String validarCPF(@ModelAttribute("cpf") String CPF) {
		try {
			this.cadastroBO.getPessoaFisicaByCPF(CPF);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping(value="/assinatura/validarEmail", method= RequestMethod.POST)
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
	
	@RequestMapping(value="/validarCNPJ", method= RequestMethod.POST)
	public @ResponseBody String validarCNPJ(@ModelAttribute("cnpj") String cnpj) throws SQLException {
		
		if (this.cadastroBO.getPessoaJuridicaByCNPJ(cnpj) == null) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@RequestMapping(value="/assinatura/validarInscricaoEstadual", method= RequestMethod.POST)
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


