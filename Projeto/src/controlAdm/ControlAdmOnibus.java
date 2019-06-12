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
	
	public Onibus consultarPlaca(String placa){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setPlaca(placa);
		this.onibusSelecionado =  oDAO.consultarPlaca(this.onibusSelecionado, 2).get(0);
		return this.onibusSelecionado;
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
	
	public boolean inserirOnibus(ArrayList<String> valores) {//Placa, cor, motorista, telefone5
		OnibusDAO oDAO = new OnibusDAO();

		if(consultarPlaca(valores.get(0)).getId() == 0) {
			this.onibusSelecionado = new Onibus();
			this.onibusSelecionado.setPlaca(valores.get(0));
			this.onibusSelecionado.setCor(valores.get(1));
			this.onibusSelecionado.setMotorista(valores.get(2));
			this.onibusSelecionado.setTelefone(valores.get(3));
			oDAO.inserirOnibus(this.onibusSelecionado);
			if(valores.size() == 5) {
				if(valores.get(4) == "Disponivel") {
					this.onibusSelecionado = consultarPlaca(this.onibusSelecionado.getPlaca());
					this.onibusSelecionado.setValidacao(1);
					oDAO.editarValidacao(this.onibusSelecionado);
						return true;
					}else {
						return false;
					}
				}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cadastrarRotaOnibus(ArrayList<String> dadosRota) {
		ControlAdmRota ctrlRota = new ControlAdmRota();
		if(ctrlRota.inserirRota(this.onibusSelecionado.getId(), dadosRota)) {
			return true;
		}else {
			return false;
		}
	}
}
