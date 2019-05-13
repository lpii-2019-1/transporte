package model;

import java.util.ArrayList;

import model.Instituicao;

public class Cidade{
	private int id = 0;
    private String nome;
    private String cep;
    private String uf;
    private ArrayList<Instituicao> instituicoes = new ArrayList<>();

    public Cidade(String nome, String cep, String uf){
        this.setNome(nome);
        this.setCep(cep);
        this.setUf(uf);
    }
    public Cidade(int id, String nome, String cep, String uf){
        this.setId(id);
        this.setNome(nome);
        this.setCep(cep);
        this.setUf(uf);
    }
    public Cidade() {
    	
    }
  	
  	public int getId(){
  		return this.id;
  	}
  	public void setId(int id){
  		this.id = id;
  	}

	public String getCep() {
		return this.cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf(){
		return this.uf;
	}
	public void setUf(String uf){
		this.uf = uf;
	}
	public ArrayList<Instituicao> getInstituicoes(){
		return this.instituicoes;
	}
	public void setInstituicoes(ArrayList<Instituicao> instituicoes){
		this.instituicoes = instituicoes;
	}

	public void inserirInstituicao(Instituicao instituicao){
		this.instituicoes.add(instituicao);
	}
	
	public Instituicao consultarInstituicao(String nome) {
		int a = 0;
		for(int i = 0; i < this.instituicoes.size(); i++) {
			if((this.instituicoes.get(i).getNome()) == nome){
				a = i;
			}
		}
		//index =	this.instituicoes.indexOf(this.instituicoes.get(a).getNome());
	
		return this.instituicoes.get(a);
	}
	
}