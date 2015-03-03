package br.com.grupomm.dbm.bo;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.grupomm.dbm.entity.AreaDeAtuacao;
import br.com.grupomm.dbm.entity.Email;
import br.com.grupomm.dbm.entity.Endereco;
import br.com.grupomm.dbm.entity.NivelHierarquico;
import br.com.grupomm.dbm.entity.Pessoa;
import br.com.grupomm.dbm.entity.PessoaFisica;
import br.com.grupomm.dbm.entity.PessoaJuridica;
import br.com.grupomm.dbm.entity.Porte;
import br.com.grupomm.dbm.entity.RamoDeAtividade;
import br.com.grupomm.dbm.entity.Telefone;

public class CadastroBO extends AutowiredServices {

	public void salvarPessoa(Pessoa p) {
		try {
			this.pessoaService.salvar(p);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvarPessoaFisica(PessoaFisica pF) {
		try {
			this.pessoaFisicaService.salvar(pF);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			this.excluirPessoa(pF.getPessoa());
			e.printStackTrace();
		}
	}

	public void salvarPssoaJuridica(PessoaJuridica pJ) {
		try {
			this.pessoaJuridicaService.salvar(pJ);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}

	public List<NivelHierarquico> listarNivelHierarquico() {
		try {
			return this.nivelHierarquicoService.listarNivelHierarquico();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<AreaDeAtuacao> listarAreaDeAtuacao() {
		try {
			return this.areaDeAtuacaoService.listarAreaDeAtuacao();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pessoa getPessoaByCodigo(String codigo) {
		try {
			return this.pessoaService.getPessoaByCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public NivelHierarquico getNivelByID(int id) {
		try {
			return this.nivelHierarquicoService.NivelHierarquicoByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public AreaDeAtuacao getAreaByID(int id) {
		try {
			return this.areaDeAtuacaoService.AreaDeAtuacaoByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void salvarTelefone(Telefone t) {
		System.out.println(t);
		try {
			this.telefoneService.salvar(t);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}

	public Telefone getTelefoneByNumber(String numero) {
		try {
			return this.telefoneService.getTelefoneByNumber(numero);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Email getEmailByEndereco(String e) throws SQLException {
		return this.emailService.getEmailByEndereco(e);
	}

	public void salvarEmail(Email email) {
		try {
			this.emailService.salvar(email);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvarEndereco(Endereco e) {
		try {
			this.enderecoService.salvar(e);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e1) {
			e1.printStackTrace();
		}
	}

	public Endereco getEnderecoByCepAndNumero(Endereco e) {
		try {
			return this.enderecoService.getEnderecoByCepAndNumero(e.getCep(), e.getNumero());
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	public void atualizarPessoa(Pessoa p) {
		try {
			this.pessoaService.atualizar(p);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirPessoa(Pessoa p) {
		try {
			this.pessoaService.excluir(p);
		} catch (DataIntegrityViolationException | ConstraintViolationException
				| SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Porte> listarPorte() {
		try {
			return this.porteService.listarPorte();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<RamoDeAtividade> listarRamoDeAtividade() {
		try {
			return this.ramoDeAtividadeService.listarRamoDeAtividade();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PessoaFisica getPessoaFisicaByCPF(String cpf) throws Exception{
		return this.pessoaFisicaService.getPessoaFisicaByCPF(cpf);
	}
	
	public PessoaJuridica getPessoaJuridicaByCNPJ(String CNPJ) throws SQLException {
		return this.pessoaJuridicaService.getPessoaJuridicaByCNPJ(CNPJ);
	}
	
	public PessoaJuridica getPessoaJuridicaByInscricaoEstadual(String ie) throws SQLException {
		return this.pessoaJuridicaService.getPessoaJuridicaByInscricaoEstadual(ie);
	}
	
	public Porte getPorteById(Integer id) {
		try {
			return this.porteService.porteByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public RamoDeAtividade getRamoById(Integer id) {
		try {
			return this.ramoDeAtividadeService.RamoDeAtividadeByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
