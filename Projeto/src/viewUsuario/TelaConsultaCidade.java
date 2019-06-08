package viewUsuario;

import view.Tela;

public class TelaConsultaCidade extends Tela{
	public TelaConsultaCidade(int identificador) {
		super(identificador);
	}
	public String telaIni = "\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaErro = "\nCidade não encontrada. \n\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
}