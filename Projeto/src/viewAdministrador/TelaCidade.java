package viewAdministrador;

import model.Cidade;
import model.Instituicao;
import view.Tela;

public class TelaCidade extends Tela{

	public TelaCidade(int identificador) {
		super(identificador);
	}

	public String opcoes = "\n1 - Nome \n2 - UF \n3 - Instituicoes \n4 - Validacao  \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores da Cidade (Ex.: Ceres, GO, Disponivel): ";
	public String Excluir = "\nDigite o nome e uf da cidade (Ex.: Ceres, GO): ";
	public String telaCidade;

	public void setTelaCidade(Cidade cidade){
		this.telaCidade = "\nNome: " + cidade.getNome();
		this.telaCidade += "\nUF: " + cidade.getUf();
		this.telaCidade += "\nInstituicoes: ";
		if(cidade.getInstituicoes().get(0) != null){
			int j = 0;
			for (Instituicao i : cidade.getInstituicoes()) {
				j++;
				this.telaCidade += "\n    Instituicao " + j + ": " + i.getNome();
			}
		}
		else{
			this.telaCidade += "Nao ha Instituicoes";
		}
		if(cidade.getValidacao() == 1){
			this.telaCidade += "\nDisponibilidade: Disponivel";	
		}
		else{
			this.telaCidade += "\nDisponibilidade: Indisponivel";	
		}
	}
}