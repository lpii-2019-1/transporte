package controlAdm;

import model.Cidade;
import model.Instituicao;

import java.util.ArrayList;

import dao.CidadeDAO;
import dao.InstituicaoDAO;

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
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicaoSelecionada.setEndereco(endereco);
		this.instituicaoSelecionada = iDAO.consultarEndereco(this.instituicaoSelecionada, 2);
		return this.instituicaoSelecionada;
	}
	
	public Instituicao consultarTelefone(String telefone) {
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicaoSelecionada.setTelefone(telefone);
		this.instituicaoSelecionada = iDAO.consultarTelefone(this.instituicaoSelecionada, 2);
		return this.instituicaoSelecionada;
	}
	
	public ArrayList<Instituicao> consultarIdCidade(ArrayList<String> valoresCidade) {
		ControlAdmCidade ctrlCidade = new ControlAdmCidade();
		this.cidadeSelecionada =  ctrlCidade.consultarCidadeNomeUf(valoresCidade);
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicoes = iDAO.consultarIdCidade(this.cidadeSelecionada, 2);	
		return this.instituicoes;
	}
	 public ArrayList<Instituicao> consultarIdRota(){
		 
	 }
	 public void inserirInstituicao(ArrayList<String> valores) {
		this.instituicaoSelecionada = new Instituicao(valores.get(0), valores.get(1), valores.get(2));
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		Instituicao auxInstituicao = new Instituicao();
		auxInstituicao = consultarEndereco(this.instituicaoSelecionada.getEndereco());
		if(auxInstituicao.getId() == 0) {
			iDAO.inserirInstituicao(this.instituicaoSelecionada);
			if(valores.size() == 4) {
				if(valores.get(3) == "Disponivel") {
					iDAO.editarValidacao(consultarEndereco(this.instituicaoSelecionada.getEndereco()));
				}
			}
			iDAO.inserirInstituicao(this.instituicaoSelecionada);

		}
		 
	 }
	
}
