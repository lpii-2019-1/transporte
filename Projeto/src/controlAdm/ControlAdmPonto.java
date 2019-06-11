package controlAdm;

import java.util.ArrayList;

import dao.PontoDAO;
import model.Cidade;
import model.Ponto;
import model.Rota;

public class ControlAdmPonto {

	private Ponto pontoSelecionado;
	private Rota rotaSelecionada;

	private ArrayList<ArrayList<Ponto>> pontosTodasRotas;
	private ArrayList<Ponto> pontos;
	

	public boolean verificaId(Cidade c) {
		if (c.getId() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/** Refazer **/
	public void inserirPonto(String endereco) {
		PontoDAO poDAO = new PontoDAO();
		Ponto po = new Ponto();
		po.setEndereco(endereco);
		this.setPontoSelecionado(po);
		poDAO.inserirPonto(this.getPontoSelecionado());
	}
		
	public boolean editarEndereco(String endereco) {
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado.setEndereco(endereco);
		if(poDAO.editarEndereco(this.pontoSelecionado)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean editarValidacao(String validacao) {
		PontoDAO poDAO = new PontoDAO();
		if(validacao.equals(validacao)) {
			this.pontoSelecionado.setValidacao(1);
		}
		if(poDAO.editarValidacao(this.pontoSelecionado)) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Ponto> consultarEndereco(String valor) {
		this.pontoSelecionado = new Ponto();
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado = poDAO.consultarEndereco(this.pontoSelecionado, 2);
		return this.pontos;
	}

	public ArrayList<Ponto> consultarId(int id) {
		this.pontoSelecionado = new Ponto();
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado = poDAO.consultarId(id, 2);
		return this.pontos;
	}
	
	/** Verificar erro metodo **//*
	public Ponto consultarIdRota(Rota rota) {
		PontoDAO poDAO = new PontoDAO();
		this.setPontoSelecionado(poDAO.consultarIdRota(rota, 2));
		return this.getPontoSelecionado();
	}
	*/
	
	public ArrayList<Ponto> listarPontos() {
		PontoDAO poDAO = new PontoDAO();
		this.pontos = new ArrayList<Ponto>();
		this.pontos = poDAO.listarPontos(2);
		return this.pontos;
	}
	
	public boolean excluirPonto(int x) {
		PontoDAO poDAO = new PontoDAO();
		if(poDAO.excluirPonto(this.pontoSelecionado)) {
			return true;
		} else {
			return false;
		}
	}

	public Ponto getPontoSelecionado() {
		return pontoSelecionado;
	}

	public void setPontoSelecionado(Ponto pontoSelecionado) {
		this.pontoSelecionado = pontoSelecionado;
	}

	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}

	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
	}

}
