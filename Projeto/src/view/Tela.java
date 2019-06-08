package view;

public class Tela{
	
	private int identificador = 0;

	public Tela(int identificador, String tela){
		this.identificador = identificador;
		this.tela = tela;
	}
	public void setIdentificador(int identificador){
		this.identificador = identificador;
	}
	public int getIdentificador(){
		return this.identificador;
	}
}