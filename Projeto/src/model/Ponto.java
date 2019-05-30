package model;

public class Ponto{
	private int id = 0;
	private String endereco;
	private int validacao = 0;
	
    public Ponto(int id, String endereco){
        this.id = id;
        this.endereco = endereco;
    }
    public Ponto(String endereco){
        this.endereco = endereco;
    }
    public Ponto() {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getValidacao() {
		return validacao;
	}
	public void setValidacao(int validacao) {
		this.validacao = validacao;
	}
}