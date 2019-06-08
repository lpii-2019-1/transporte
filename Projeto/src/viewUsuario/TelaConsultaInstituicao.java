package viewUsuario;

import view.Tela;
import model.Cidade;
import model.Instituicao;

public class TelaConsultaInstituicao extends Tela{
	public TelaConsultaInstituicao(int identificador) {
		super(identificador);
	}

	public String telaIni = "\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaErro = "\nCidade não encontrada. \n\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaInstituicoes;

	public void setTelaInstituicao(Cidade cidade){
		this.telaInstituicoes += "\n " + cidade.getNome() + ": ";
		int j = 0;
		for (Instituicao i : cidade.getInstituicoes()) {
			j++;
			this.telaInstituicoes += "\n    " + j + " - " + i.getNome();
		}
		this.telaInstituicoes += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
}