package usuario;

import view.Tela;
import model.Cidade;
import mode.Instituicao;

public class TelaConsultaInstituicao extends Tela{
	public String telaIni = "\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaErro = "\nCidade não encontrada. \n\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaInstituicoes;

	public setTelaInstituicao(Cidade cidade){
		this.telaInstituicoes += "\n " + cidade.getNome() + ": ";
		int i = 0;
		for (Instituicao i : cidades.getInstituicao()) {
			i++;
			this.telaCidade += "\n"+ i +" - " + i.getNome();
		}
		this.telaCidade += "\n0 - Sair \n\nDigite o numero correspondente: ";
	}
}