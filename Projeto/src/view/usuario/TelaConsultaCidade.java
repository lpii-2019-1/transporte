package usuario;

import view.Tela;
import model.Cidade;
import mode.Instituicao;

public class TelaConsultaCidade extends Tela{
	public String telaIni = "\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaErro = "\nCidade não encontrada. \n\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaCidade = "\nCidades: ";

	public setTelaCidade(ArrayList<Cidade> cidades){
		int i = 0;
		for (Cidade c : cidades) {
			i++;
			this.telaCidade += "\n"+ i +" - " + cidade.getNome() + " - " + cidade.getUf();
		}
		this.telaCidade += "\n0 - Sair \n\nDigite o numero correspondente: ";
	}
}