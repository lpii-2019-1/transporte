package model;

import java.util.ArrayList;

public class Onibus {
	private int id = 0;
	private String placa;
	private String cor;
	private String motorista;
	private double mensalidade;
	private String telefone;
	private ArrayList<Rota> rotas;
	private int validacao = 0;
		
	public Onibus(int id, String placa, String cor, String motorista, double mensalidade, String telefone) {
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.motorista = motorista;
		this.mensalidade = mensalidade;
		this.telefone = telefone;
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

	public String getTelefone(){
		return this.telefone;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public void inserirRota(Rota rota) {
		this.rotas.add(rota);
	}
	public int getValidacao() {
		return validacao;
	}
	public void setValidacao(int validacao) {
		this.validacao = validacao;
	}
}
