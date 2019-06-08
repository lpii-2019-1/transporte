<<<<<<< HEAD
package viewUsuario;

import java.util.ArrayList;
import view.Tela;
import model.Cidade;
import mode.Instituicao;

public class TelaConsultaInstituicao extends Tela{
	public String telaIni = "\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaErro = "\nCidade não encontrada. \n\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaInstituicoes;

	public void setTelaInstituicao(Cidade cidade){
		this.telaInstituicoes += "\n " + cidade.getNome() + ": ";
		int i = 0;
		for (Instituicao i : cidades.getInstituicao()) {
			i++;
			this.telaInstituicoes += "\n    " + i + " - " + i.getNome();
		}
		this.telaInstituicoes += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
=======
package viewUsuario;

import java.util.ArrayList;
import view.Tela;
import model.Cidade;
import mode.Instituicao;

public class TelaConsultaInstituicao extends Tela{
	public String telaIni = "\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaErro = "\nCidade não encontrada. \n\nDigite o nome de uma cidade (Ex.: Ceres GO): ";
	public String telaInstituicoes;

	public void setTelaInstituicao(Cidade cidade){
		this.telaInstituicoes += "\n " + cidade.getNome() + ": ";
		int i = 0;
		for (Instituicao i : cidades.getInstituicao()) {
			i++;
			this.telaInstituicoes += "\n    " + i + " - " + i.getNome();
		}
		this.telaInstituicoes += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
>>>>>>> cdfc8d46bdb81d99645173fd10d2d9a6efa433a4
}