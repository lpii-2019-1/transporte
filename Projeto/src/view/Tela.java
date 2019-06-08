<<<<<<< HEAD
package view;

public class Tela{
	
	private int identificador = 0;

	public Tela(int identificador){
		this.identificador = identificador;
	}
	public void setIdentificador(int identificador){
		this.identificador = identificador;
	}
	public int getIdentificador(){
		return this.identificador;
	}
=======
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
>>>>>>> cdfc8d46bdb81d99645173fd10d2d9a6efa433a4
}