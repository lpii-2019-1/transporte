package controlAdm;

import model.Rota;

import java.util.ArrayList;

import dao.RotaDAO;

import model.Onibus;

public class ControlAdmRota {
	private Rota rotaSelecionada;
	private ArrayList<Rota> listaDeRotas;
	
	
	public void inserirRota(Onibus onibus, ArrayList<String> dadosRota) { // Consertar esse método
		RotaDAO rDAO = new RotaDAO();
		this.rotaSelecionada =  new Rota(dadosRota.get(0), dadosRota.get(1), dadosRota.get(2));
		
		rDAO.inserirRota(this.rotaSelecionada); /////////// Consertar esse método no DAO para receber um onibus
		
		if(dadosRota.size() == 4) {
			
		}
	}
	public Rota consultarIdentificador(Onibus onibus, int identificador) {
		RotaDAO rDAO = new RotaDAO();
		this.rotaSelecionada = rDAO.consultarIdentificador(onibus, identificador, 2);
		return this.rotaSelecionada;
	}
	
	public ArrayList<Rota> listarRotas(){	
		RotaDAO rDAO = new RotaDAO();
		this.listaDeRotas = rDAO.listarRotas(2);
		return this.listaDeRotas;

	}
	
	public boolean excluirRota() {
		RotaDAO rDAO = new RotaDAO();
		if(rDAO.excluirRota(this.rotaSelecionada)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}
	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
	}
	public ArrayList<Rota> getListaDeRotas() {
		return listaDeRotas;
	}
	public void setListaDeRotas(ArrayList<Rota> listaDeRotas) {
		this.listaDeRotas = listaDeRotas;
	}

	
}
