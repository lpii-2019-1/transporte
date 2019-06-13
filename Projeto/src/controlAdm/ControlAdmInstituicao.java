package controlAdm;

import model.Cidade;

import model.Instituicao;
import model.Rota;

import java.util.ArrayList;

import dao.InstituicaoDAO;
import dao.RotaDAO;

public class ControlAdmInstituicao {
	private Cidade cidadeSelecionada;

	private Instituicao instituicaoSelecionada;
	private ArrayList<Instituicao> instituicoes;
	
	public void selecionarInstituicao(int i) {
		i--;
		this.instituicaoSelecionada = this.instituicoes.get(i);
	}
	public ArrayList<Instituicao> consultarNome(String nome) {
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicaoSelecionada.setNome(nome);
		this.instituicoes = iDAO.consultarNome(this.instituicaoSelecionada, 2);
		return this.instituicoes;
	}
	
	public Instituicao consultarEndereco(String endereco) {
		InstituicaoDAO iDAO = new InstituicaoDAO();
		Instituicao instituicao = new Instituicao();
		instituicao.setEndereco(endereco);
		this.instituicaoSelecionada = iDAO.consultarEndereco(instituicao, 2);
		return this.instituicaoSelecionada;
	}
	
	public ArrayList<Instituicao> consultarTelefone(String telefone) {
		InstituicaoDAO iDAO = new InstituicaoDAO();
		this.instituicaoSelecionada.setTelefone(telefone);
		this.instituicoes = iDAO.consultarTelefone(this.instituicaoSelecionada, 2);
		return this.instituicoes;
	}
	
	public ArrayList<Instituicao> consultarIdCidade(ArrayList<String> valoresCidade) {
		ControlAdmCidade ctrlCidade = new ControlAdmCidade();
		this.cidadeSelecionada =  ctrlCidade.consultarCidadeNomeUf(valoresCidade);
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicoes = iDAO.consultarIdCidade(this.cidadeSelecionada, 2);	
		return this.instituicoes;
	}
	
	 public boolean inserirInstituicao(ArrayList<String> valores) {// Se a Instituicao n existir no banco o método insere e retorna true//Se ela existir, não insere e retorna false
		if(valores.size() > 4) {
		 	ControlAdmCidade ctrlCidade = new ControlAdmCidade();
			
			ArrayList<String> dadosCidade = new ArrayList<String> ();
			dadosCidade.add(valores.get(3));
			dadosCidade.add(valores.get(4));
			
	
			Instituicao auxInstituicao = new Instituicao(valores.get(0), valores.get(1), valores.get(2));
			this.cidadeSelecionada = ctrlCidade.consultarCidadeNomeUf(dadosCidade);
			if(this.cidadeSelecionada.getId() != 0) {
				InstituicaoDAO iDAO = new InstituicaoDAO();
				if(this.consultarEndereco(auxInstituicao.getEndereco()).getId() == 0) {
					iDAO.inserirInstituicao(auxInstituicao, this.cidadeSelecionada);
					if(valores.size() == 5) {
						if(valores.get(4) == "Disponivel") {
							auxInstituicao.setValidacao(1);
							iDAO.editarValidacao(this.instituicaoSelecionada);
						}
					}
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		 else {
			 return false;
		 }
	 }
	 public boolean editarNome(String nome) {
		 this.instituicaoSelecionada.setNome(nome);
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 if(iDAO.editarNome(this.instituicaoSelecionada)) {
			return true; 
		 }else {
			 return false;
		 }
	 }
	 public boolean editarEndereco(String endereco) {
		 this.instituicaoSelecionada.setEndereco(endereco);
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 if(iDAO.editarEndereco(this.instituicaoSelecionada)) {
			 return true; 
		 }else {
			 return false;
		 } 
	 }

	 public boolean editarTelefone(String telefone) {
		 this.instituicaoSelecionada.setTelefone(telefone);
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 if(iDAO.editarTelefone(this.instituicaoSelecionada)) {
			 return true; 
		 }else {
			 return false;
		 }
	 }
	 public boolean editarIdCidade(ArrayList<String> cidade) {
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 ControlAdmCidade ctrlCidade = new ControlAdmCidade();
		 this.cidadeSelecionada = ctrlCidade.consultarCidadeNomeUf(cidade);
		 if(this.cidadeSelecionada.getId() != 0) {
			 if(iDAO.editarIdCidade(this.instituicaoSelecionada, this.cidadeSelecionada)) {
				 return true; 
			 }else {
				 return false;
			 }
		 }else {
			 return false;
		 }
		 
	 }
	 
	 public boolean editarValidacao(String validacao) {
	 	InstituicaoDAO iDAO = new InstituicaoDAO();
		if(validacao.equalsIgnoreCase("Disponivel")) {
			this.instituicaoSelecionada.setValidacao(1);
			if(iDAO.editarValidacao(this.instituicaoSelecionada)) {
				return true;
			}else {
				return false;
			}
		}
		else if(validacao.equalsIgnoreCase("Indisponivel")){
			this.instituicaoSelecionada.setValidacao(0);
			if(iDAO.editarValidacao(this.instituicaoSelecionada)) {
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	 
	 public boolean excluirInstituicao() {
		RotaDAO rDAO = new RotaDAO();
		ArrayList<Rota> rotas = rDAO.consultarIdInstituicao(this.instituicaoSelecionada, 2);
		if(rotas.get(0).getId() != 0){
			for(Rota r: rotas){
				rDAO.excluirInstituicao(r, this.instituicaoSelecionada);
			}
		}
		InstituicaoDAO iDAO = new InstituicaoDAO();
		if (iDAO.excluirInstituicao(this.instituicaoSelecionada)) {
			return true;
		} else {
			return false;
		}
	 }
 
	 public ArrayList<Instituicao> listarInstituicoes(){
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 this.instituicoes = new ArrayList<Instituicao>();
		 this.instituicoes = iDAO.listarInstituicoes(2);
		 return this.instituicoes;
		 
	 }
	 
	 public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	 }
	 public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	 }
	 public Instituicao getInstituicaoSelecionada() {
		return instituicaoSelecionada;
	 }
	 public void setInstituicaoSelecionada(Instituicao instituicaoSelecionada) {
		this.instituicaoSelecionada = instituicaoSelecionada;
	 }
	 public ArrayList<Instituicao> getInstituicoes() {
		return instituicoes;
	 }
	 public void setInstituicoes(ArrayList<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	 }
	
}
