package viewAdministrador;

import java.util.ArrayList;

import view.TelaFimOperacao;
import model.Cidade;
import model.Instituicao;

public class TelaCidade{
	public String opcEdicao = "\n1 - Nome \n2 - UF \n3 - Validacao  \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String opcConsulta = "\n1 - Nome \n2 - UF \n3 - Instituicao \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores da Cidade (Ex.: Ceres, GO, Disponivel): ";
	public String entrada = "\nDigite o nome e uf da cidade (Ex.: Ceres, GO): ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Cidade> cidades){
		this.telaConsulta = "Cidades: ";
		for (Cidade c : cidades) {			
			this.telaConsulta += "\n    Nome: " + c.getNome();
			this.telaConsulta += "\n    UF: " + c.getUf();
			this.telaConsulta += "\n    Instituicoes: ";
			for (Instituicao i : c.getInstituicoes()) {
				this.telaConsulta += "\n        Nome: " + i.getNome();
				this.telaConsulta += "\n        Endereco: " + i.getEndereco();
				this.telaConsulta += "\n        Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += "\n    Disponibilidade: " + (c.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaConsulta += "\n";
		}
		this.telaConsulta += new TelaFimOperacao().telaIni;
	}
}