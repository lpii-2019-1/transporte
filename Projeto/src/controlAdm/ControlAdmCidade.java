package controlAdm;

import model.Cidade;
import model.Instituicao;

import java.util.ArrayList;

import dao.CidadeDAO;
import dao.InstituicaoDAO;

public class ControlAdmCidade {
	private Cidade cidadeSelecionada;
	
	private ArrayList<Cidade> cidades;
	private ArrayList<Cidade> todasCidades;
	private ArrayList<Instituicao> instituicoes;
	
	
	
	/*Metodos de Consulta*/
	public Cidade consultarCidadeNomeUf(ArrayList<String> valores) {
		this.cidadeSelecionada = new Cidade(valores.get(0), valores.get(1));
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada = cDAO.consultarNomeUf(this.cidadeSelecionada, 2);
		return this.cidadeSelecionada;
	}
	
	public Cidade consultarPorInstituicao(String endereco) {
		Instituicao instituicao = new Instituicao();
		instituicao.setEndereco(endereco);
		InstituicaoDAO iDAO = new InstituicaoDAO();
		instituicao = iDAO.consultarEndereco(instituicao, 2);
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada = cDAO.consultarInstituicao(instituicao, 2);
		return this.cidadeSelecionada;
	}
	
	public ArrayList<Cidade> consultarNome(String nome){
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada = new Cidade();
		this.cidadeSelecionada.setNome(nome);
		this.cidades = cDAO.consultarNome(this.cidadeSelecionada, 2);
		return this.cidades;
	}
	
	public ArrayList<Cidade> consultarUf(String uf){
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada = new Cidade();
		this.cidadeSelecionada.setUf(uf);
		this.cidades = cDAO.consultarUf(this.cidadeSelecionada, 2);
		return this.cidades;
	}
	
	/*Metodos de Edição*/
	
	public boolean editarNomeCidade(String nome) {
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada.setNome(nome);
		if(cDAO.editarNome(this.cidadeSelecionada)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean editarUfCidade(String uf) {
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada.setUf(uf);
		if(cDAO.editarUf(this.cidadeSelecionada)) {;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarValidacaoCidade(String validacao) {
		CidadeDAO cDAO = new CidadeDAO();
		boolean test = false; 
		if(validacao.equalsIgnoreCase("Disponivel")) {
			for(int i = 0; i < this.cidadeSelecionada.getInstituicoes().size(); i++) {
				if(this.cidadeSelecionada.getInstituicoes().get(i).getValidacao() == 1) {
					test = true;
					break;
				}
			}
			if(test) {
				this.cidadeSelecionada.setValidacao(1);
				if(cDAO.editarValidacao(this.cidadeSelecionada)) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		else if(validacao.equalsIgnoreCase("Indisponivel")){
			this.cidadeSelecionada.setValidacao(0);
			if(cDAO.editarValidacao(this.cidadeSelecionada)) {
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/*Metodo para listar todas cidades do banco*/
	
	public ArrayList<Cidade> listarTodasCidades() {
		CidadeDAO cDAO = new CidadeDAO();
		this.todasCidades = cDAO.listarCidades(2);
		return this.todasCidades;
	}
	
	/*Metodo de iniserir*/
	public boolean inserirCidade(ArrayList<String> valores) { //nome, uf e talvez Disponibilidade
		Cidade c = new Cidade(valores.get(0), valores.get(1));
		CidadeDAO cDAO = new CidadeDAO();
		if(cDAO.consultarNomeUf(c, 2).getId() == 0) {
			cDAO.inserirCidade(c);					
			if(valores.size() == 3) {
				if(valores.get(2) == "Disponivel") {
					c.setValidacao(1);
					cDAO.editarValidacao(c);
				}else {
					cDAO.editarValidacao(c);
				}
			}
			return true;
		}else {
			return false;
		}
	}
	/*Metodo para excluir cidade*/
	
	public boolean excluirCidade() {
		CidadeDAO cDAO = new CidadeDAO();
		InstituicaoDAO iDAO = new InstituicaoDAO();
		if(iDAO.consultarIdCidade(this.cidadeSelecionada, 2).get(0).getId() != 0){
			for(Instituicao i : iDAO.consultarIdCidade(this.cidadeSelecionada, 2)) {
				iDAO.excluirInstituicao(i);
			}
		}
		if(cDAO.excluirCidade(this.cidadeSelecionada)) {
			return true;
		}else {
			return false;
		}
	}
	/*Listar Todas as instituicoes da cidade*/
	public ArrayList<Instituicao> listarInstituicoesCidade(){
		CidadeDAO cDAO = new CidadeDAO();
		this.instituicoes = cDAO.listarInstituicoes(this.cidadeSelecionada, 2);
		return this.instituicoes;
	}

	//Getters and Setters
	
	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}


	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}
	
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}

	public ArrayList<Cidade> getTodasCidades() {
		return todasCidades;
	}

	public void setTodasCidades(ArrayList<Cidade> todasCidades) {
		this.todasCidades = todasCidades;
	}

	public ArrayList<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(ArrayList<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}

	public void selecionarCidade(int i) { 
		i--;
		this.cidadeSelecionada = cidades.get(i);
	}
}
