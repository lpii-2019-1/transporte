package controlAdm;

import java.util.ArrayList;
import dao.PontoDAO;
import model.Ponto;
import model.Rota;

public class ControlAdmPonto {

	private Ponto pontoSelecionado;

	private ArrayList<Ponto> pontos;

	public boolean inserirPonto(String endereco) {
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado = new Ponto(endereco);
		if (poDAO.inserirPonto(this.pontoSelecionado)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean editarEndereco(String endereco) {
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado.setEndereco(endereco);
		if (poDAO.editarEndereco(this.pontoSelecionado)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean editarValidacao(String validacao) {
		PontoDAO poDAO = new PontoDAO();
		if (validacao.equals(validacao)) {
			this.pontoSelecionado.setValidacao(1);
		}
		if (poDAO.editarValidacao(this.pontoSelecionado)) {
			return true;
		} else {
			return false;
		}
	}

	public Ponto consultarEndereco(String valor) {
		Ponto ponto = new Ponto();
		ponto.setEndereco(valor);
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado = poDAO.consultarEndereco(ponto, 2);
		return this.pontoSelecionado;
	}

	public ArrayList<Ponto> consultarId(int id) {
		this.pontoSelecionado = new Ponto();
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado = poDAO.consultarId(id, 2);
		return this.pontos;
	}

	/** Verificar erro metodo **/
	
		public ArrayList<Ponto> consultarIdRota(Rota rota) {
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado = new Ponto();
		this.pontos = poDAO.consultarIdRota(rota, 2);
		return this.pontos;
	}
	
	
	public ArrayList<Ponto> listarPontos() {
		PontoDAO poDAO = new PontoDAO();
		this.pontos = poDAO.listarPontos(2);
		return this.pontos;
	}

	public boolean excluirPonto(String endereco) {
		Ponto p = new Ponto();
		p.setEndereco(endereco);
		PontoDAO poDAO = new PontoDAO();
		if (poDAO.excluirPonto(this.pontoSelecionado)) {
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
	
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}

}
