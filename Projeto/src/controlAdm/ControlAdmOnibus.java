package controlAdm;

import model.Onibus;

import java.util.ArrayList;

import dao.OnibusDAO;

public class ControlAdmOnibus {
	
	private Onibus onibusSelecionado;
	private ArrayList<Onibus> listaDeOnibus;
	
	public ArrayList<Onibus> consultarCor(String cor){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setCor(cor);
		this.listaDeOnibus =  oDAO.consultarCor(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public ArrayList<Onibus> consultarMotorista(String motorista){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setMotorista(motorista);
		this.listaDeOnibus =  oDAO.consultarMotorista(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public ArrayList<Onibus> consultarPlaca(String placa){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setPlaca(placa);
		this.listaDeOnibus =  oDAO.consultarPlaca(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	
	public ArrayList<Onibus> consultarTelefone(String telefone){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setTelefone(telefone);
		this.listaDeOnibus =  oDAO.consultarTelefone(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public ArrayList<Onibus> consultarMensalidade(double mensalidade){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setMensalidade(mensalidade);
		this.listaDeOnibus =  oDAO.consultarMensalidade(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public ArrayList<Onibus> listarTodosOnibus(){
		OnibusDAO oDAO = new OnibusDAO();
		this.listaDeOnibus = oDAO.listarOnibus(2);
		return this.listaDeOnibus;
	}
}
