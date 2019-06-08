package controlUsuario;

import model.*;

import java.util.ArrayList;

import dao.*;

public class ControlUsuario {
	
	private Rota rotaSelecionada;
	private Cidade CidadePesquisada;
	private ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>(); 
	private String telaInstituicoes;
	private Instituicao instituicaoSelecionada = new Instituicao();
	/*------------ Métodos para pesquisar cidade e retornar instituições ------------*/
	
	public Cidade pesquisarCidade(String nome, String uf){
		CidadeDAO cDAO = new CidadeDAO();
		Cidade c = new Cidade();
		c.setNome(nome);
		c.setUf(uf);
		c = cDAO.consultarNomeUf(c, 1);
		this.CidadePesquisada = c;
		return this.CidadePesquisada;
	}
	
	public boolean verificaId(Cidade c) {
		if(c.getId() == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public String respostaConsultaCidade(String nome, String uf) {
		
		String retorno = null;
		Cidade c = this.pesquisarCidade(nome, uf);
		if(this.verificaId(c)) {
			retorno = this.telaInstituicoes;
		}else {
			return retorno;
		}
		return retorno;
	}

	public ArrayList<String> retornaInstituicoes(Cidade c){
		this.instituicoes = c.getInstituicoes();
		ArrayList<String> nomeInstituicoes = new ArrayList<String>();
		String nome = "";
		for(int i = 0; i < this.instituicoes.size(); i++) {
			nome = this.instituicoes.get(i).getNome();
			nomeInstituicoes.add(nome);
		}
		return nomeInstituicoes;
	}
	
	public boolean selecionarInstituicao(String nome) {
		int aux = 0;
		boolean test = false;
		for(int i = 0; i < this.instituicoes.size(); i++) {
			if(this.instituicoes.get(i).getNome() == nome) {
				aux = i;
				test = true;
				break;
			}
		}
		if(test) {
			this.instituicaoSelecionada = this.instituicoes.get(aux);
			return true;
		}else {
			return false;
		}
	}
	/*------------------------------------------------------------------------------------*/
	
	
}

