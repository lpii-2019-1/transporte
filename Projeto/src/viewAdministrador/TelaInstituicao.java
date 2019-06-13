package viewAdministrador;

import java.util.ArrayList;
import view.TelaFimOperacao;

import model.Instituicao;

public class TelaInstituicao{
	public String manterInstituicao = "\nOpcoes: \n\n1 - Consultar \n2 - Inserir \n3 - Excluir \n4 - Listar";
	public String opcEdicao = "\nOpcoes: \n\n1 - Nome \n2 - Endereco \n3 - Telefone \n4 - Cidade \n5 - Validacao \n0 - Voltar \n\nDigite o numero correspondente: ";
	public String opcConsulta = "\nOpcoes: \n\n1 - Nome \n2 - Endereco \n3 - Telefone \n0 - Voltar \n\nDigite o numero correspondente: ";
	public String cadastro = "\nDigite o valores do instituicao (Ex.: IF Goiano, Meio do mato, 3353-1111, Ceres, GO, Disponivel): ";
	public String entrada = "\nDigite o endereco da instituicao (Ex.: Meio do mato): ";
	public String consulta = "\nDigite o valor da consulta: ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Instituicao> instituicoes){
		if(instituicoes.get(0).getId() != 0){
			this.telaConsulta = "\nInstituicoes: ";
			for (Instituicao i : instituicoes) {
				this.telaConsulta += "\n    Nome: " + i.getNome();
				this.telaConsulta += "\n    Endereco: " + i.getEndereco();
				this.telaConsulta += "\n    Telefone: " + i.getTelefone();
				this.telaConsulta += "\n    Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += "\nDigite 0 para voltar: ";
		}
		else{
			this.telaConsulta = "\nNao foi encontrada nenhuma instituicao! " + new TelaFimOperacao().telaIniAdm;
		}
	}
}