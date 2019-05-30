package model;

public class Percurso {
	public int id = 0;
	public int ordem = 0;
	public String descricao;
	private int validacao = 0;
	
	public Percurso(int id, int ordem, String descricao) {
		this.id = id;
		this.ordem = ordem;
		this.descricao = descricao;
	}
	public Percurso(int ordem, String descricao) {
		this.ordem = ordem;
		this.descricao = descricao;
	}
	public Percurso() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getValidacao() {
		return validacao;
	}
	public void setValidacao(int validacao) {
		this.validacao = validacao;
	}
}
