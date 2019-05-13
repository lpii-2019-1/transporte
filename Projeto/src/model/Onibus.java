package model;

import java.util.ArrayList;

public class Onibus {
	public int id = 0;
	public String placa;
	public String cor;
	public String motorista;
	public double mensalidade;
	public ArrayList<Rota> rotas;
		
	public Onibus(int id, String placa, String cor, String motorista, double mensalidade) {
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.motorista = motorista;
		this.mensalidade = mensalidade;
	}
	public Onibus(String placa, String cor, String motorista, double mensalidade) {
		this.placa = placa;
		this.cor = cor;
		this.motorista = motorista;
		this.mensalidade = mensalidade;
	}
	public Onibus() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public ArrayList<Rota> getRotas() {
		return rotas;
	}
	public void setRotas(ArrayList<Rota> rotas) {
		this.rotas = rotas;
	}
	
	public String getMotorista() {
		return motorista;
	}
	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
	
	public double getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	public void inserirRota(Rota rota) {
		this.rotas.add(rota);
	}
}
