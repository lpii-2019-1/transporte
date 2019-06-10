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

	public void inserirPonto(String endereco) {
		PontoDAO poDAO = new PontoDAO();
		Ponto po = new Ponto();
		po.setEndereco(endereco);
		this.setPontoSelecionado(po);
		poDAO.inserirPonto(this.getPontoSelecionado());
	}
		
	public void editarEndereco(String endereco) {
		PontoDAO poDAO = new PontoDAO();
		Ponto po = new Ponto();
		po.setEndereco(endereco);
//		po.setId(id);
		po = poDAO.consultarEndereco(po, 2);
		this.setPontoSelecionado(po);
		poDAO.editarEndereco(this.getPontoSelecionado());	
	}

	public void editarValidacao(int x) {
		PontoDAO poDAO = new PontoDAO();
		Ponto po = new Ponto();
		po.setValidacao(x);
//		po.setId(id);
		this.setPontoSelecionado(po);
		poDAO.editarValidacao(this.getPontoSelecionado());
	}

	public Ponto consultarEndereco(String endereco) {
		PontoDAO poDAO = new PontoDAO();
		Ponto po = new Ponto();
		po.setEndereco(endereco);
		po = poDAO.consultarEndereco(po, 2);
		this.setPontoSelecionado(po);
		return this.getPontoSelecionado();
	}

	public Ponto consultarId(int id) {
		PontoDAO poDAO = new PontoDAO();
		Ponto po = new Ponto();
		po.setId(id);
		po = poDAO.consultarId(id, 2);
		this.setPontoSelecionado(po);
		return this.getPontoSelecionado();
	}
	
	/** Verificar erro metodo **//*
	public Ponto consultarIdRota(Rota rota) {
		PontoDAO poDAO = new PontoDAO();
		this.setPontoSelecionado(poDAO.consultarIdRota(rota, 2));
		return this.getPontoSelecionado();
	}
	*/

	public ArrayList<Ponto> listarPontos() {
		ArrayList<Ponto> pontos = new ArrayList<Ponto>();
		Ponto auxPonto = new Ponto();
		boolean test = true;
		for (int i = 0; i < this.pontosTodasRotas.size(); i++) {
			for (int j = 0; j < this.pontosTodasRotas.get(i).size(); j++) {
				auxPonto = this.pontosTodasRotas.get(i).get(j);
				if (i == 0 && j == 0) {
					pontos.add(auxPonto);
				}
				for (int k = 0; k < pontos.size(); k++) {
					if (auxPonto.getId() == pontos.get(k).getId()) {
						test = false;
						break;
					}
				}
				if (test) {
					pontos.add(auxPonto);
				}
			}
		}
		this.pontos = pontos;
		return this.pontos;
	}

	public void excluirPonto(int x) {
		PontoDAO poDAO = new PontoDAO();
		Ponto po = new Ponto();
		po.setId(x);
		this.setPontoSelecionado(po);
		poDAO.excluirPonto(this.getPontoSelecionado());
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
