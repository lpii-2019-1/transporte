package model;

import java.util.ArrayList;

import model.Instituicao;

public class Cidade{
	private int id = 0;
    private String nome;
    private String uf;
    private ArrayList<Instituicao> instituicoes = new ArrayList<>();
    private int validacao = 0;

    public Cidade(String nome, String uf){
        this.setNome(nome);
        this.setUf(uf);
    }
    public Cidade(int id, String nome, String uf){
        this.setId(id);
        this.setNome(nome);
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
	public int getValidacao() {
		return validacao;
	}
	public void setValidacao(int validacao) {
		this.validacao = validacao;
	}
	
}