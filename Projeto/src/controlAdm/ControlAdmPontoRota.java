package controlAdm;

import java.util.ArrayList;

import dao.PontoDAO;
import dao.RotaDAO;
import model.Ponto;
import model.Rota;

public class ControlAdmPontoRota {

	private Ponto pontoSelecionado;
	private Rota rotaSelecionada;

	public boolean inserirPonto(ArrayList<String> valores) {
		RotaDAO rDAO = new RotaDAO();
		Ponto ponto = this.consultarEndereco(valores.get(0));
		if(ponto.getId() != 0) {
			int ordem = Integer.parseInt(valores.get(1));
			ponto.setOrdem(ordem);
			if (rDAO.inserirPontoRota(this.rotaSelecionada, ponto)) {
				return true;
			} else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public boolean editarOrdem(String valor) {
		int ordem = Integer.parseInt(valor);
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado.setOrdem(ordem);
		if (poDAO.editarOrdem(this.pontoSelecionado, this.rotaSelecionada)) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public Ponto consultarEndereco(String valor) {
		Ponto ponto = new Ponto();
		ponto.setEndereco(valor);
		PontoDAO poDAO = new PontoDAO();
		this.pontoSelecionado = poDAO.consultarEnderecoRota(ponto, this.rotaSelecionada, 2);
		return this.pontoSelecionado;
	}

	public ArrayList<Ponto> consultarOrdem(String valor) {
		int ordem = Integer.parseInt(valor);
		Ponto ponto = new Ponto();
		ponto.setOrdem(ordem);
		PontoDAO poDAO = new PontoDAO();
		ArrayList<Ponto> pontos = poDAO.consultarOrdem(this.rotaSelecionada, ponto, 2);
		return pontos;
	}

	/** Verificar erro metodo **/
	
	public ArrayList<Ponto> listarPontos() {
		RotaDAO rDAO = new RotaDAO();
		ArrayList<Ponto> pontos = rDAO.listarPontos(this.rotaSelecionada, 2);
		return pontos;
	}

	public boolean excluirPonto() {
		RotaDAO rDAO = new RotaDAO();
		if(rDAO.excluirPonto(this.rotaSelecionada, this.pontoSelecionado)) {
			return true;
		}
		else{
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
