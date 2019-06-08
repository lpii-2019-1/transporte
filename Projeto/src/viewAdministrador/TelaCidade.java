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

	public void setTelaCidade(ArrayList<Cidade> cidades){
		this.telaCidade = "Cidades: ";
		for (Cidade c : cidades) {			
			this.telaCidade += "\n    Nome: " + c.getNome();
			this.telaCidade += "\n    UF: " + c.getUf();
			this.telaCidade += "\n    Instituicoes: ";
			for (Instituicao i : c.getInstituicoes()) {
				this.telaCidade += "\n        Nome: " + i.getNome();
				this.telaCidade += "\n        Endereco: " + i.getEndereco();
				this.telaCidade += "\n        Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaCidade += "\n"
			}
			this.telaCidade += "\n    Disponibilidade: " + (c.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaCidade += "\n";
		}
	}
}