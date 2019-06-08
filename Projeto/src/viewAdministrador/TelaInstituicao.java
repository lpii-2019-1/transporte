package viewAdministrador;

import java.util.ArrayList;

import model.Instituicao;

public class TelaInstituicao{
	public String opcoes = "\n1 - Nome \n2 - Endereco \n3 - Telefone \n4 - Validacao \n0 - Sair \n\nDigite o endereco instituicao: ";
	public String cadastro = "\nDigite o valores do instituicao (Ex.: IF Goiano, Meio do mato, 3353-1111, Disponivel): ";
	public String Excluir = "\nDigite o endereco da instituicao (Ex.: Meio do mato): ";
	public String telaInstituicao;

	public void setTelaCidade(ArrayList<Instituicao> instituicoes){
		this.telaInstituicao = "\nInstituicoes: ";
		for (Instituicao i : instituicoes) {
			this.telaInstituicao += "\n    Nome: " + i.getNome();
			this.telaInstituicao += "\n    Endereco: " + i.getEndereco();
			this.telaInstituicao += "\n    Telefone: " + i.getTelefone();
			this.telaInstituicao += "\n    Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaInstituicao += "\n";
		}
		this.telaInstituicao += "\nDigite 0 para voltar: ";
	}
}