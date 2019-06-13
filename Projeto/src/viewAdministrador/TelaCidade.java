package viewAdministrador;

import java.util.ArrayList;

import view.TelaFimOperacao;
import model.Cidade;
import model.Instituicao;

public class TelaCidade{
	public String opcEdicao = "\nOpcoes: \n\n1 - Nome \n2 - UF \n3 - Validacao  \n0 - Sair \n\nDigite o numero correspondente: ";
	public String opcConsulta = "\nOpcoes: \n\n1 - Nome \n2 - UF \n3 - Instituicao \n0 - Sair \n\nDigite o numero correspondente: ";
	public String cadastro = "\nDigite o valores da Cidade (Ex.: Ceres, GO, Disponivel): ";
	public String entrada = "\nDigite o nome e uf da cidade (Ex.: Ceres, GO): ";
	public String consulta = "\nDigite o valor da consulta: ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Cidade> cidades){
		if(cidades.get(0).getId() != 0){
			this.telaConsulta = "Cidades: ";
			for (Cidade c : cidades) {			
				this.telaConsulta += "\n    Nome: " + c.getNome();
				this.telaConsulta += "\n    UF: " + c.getUf();
				this.telaConsulta += "\n    Instituicoes: ";
				if(c.getInstituicoes().get(0).getId() != 0){
					for (Instituicao i : c.getInstituicoes()) {
						this.telaConsulta += "\n        Nome: " + i.getNome();
						this.telaConsulta += "\n        Endereco: " + i.getEndereco();
						this.telaConsulta += "\n        Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
						this.telaConsulta += "\n";
					}
				}
				else{
					this.telaConsulta += "\n        Nao ha instituicoes!";
					this.telaConsulta += "\n";
				}
				this.telaConsulta += "\n    Disponibilidade: " + (c.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += new TelaFimOperacao().telaIniAdm;
		}
		else {
			this.telaConsulta = "\nNao foi encontrada nenhuma cidade! " + new TelaFimOperacao().telaIniAdm;
		}
	}
}