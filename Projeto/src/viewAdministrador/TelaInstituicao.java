package viewAdministrador;

import view.Tela;

public class TelaInstituicao extends Tela{
	public String opcoes = "\n1 - Nome \n2 - Endereco \n3 - Telefone \n4 - Validacao \n0 - Sair \n\nDigite o endereco instituicao: ";
	public String cadastro = "\nDigite o valores do instituicao (Ex.: IF Goiano, Meio do mato, 3353-1111, Disponivel): ";
	public String Excluir = "\nDigite o endereco da instituicao (Ex.: Meio do mato): ";
	public String telaInstituicao;

	public setTelaCidade(Instituicao instituicao){
		this.telaInstituicao = "\nNome: " + instituicao.getNome();
		this.telaInstituicao += "\nEndereco: " + instituicao.getEndereco();
		this.telaInstituicao += "\nTelefone: " + instituicao.getTelefone();
		if(instituicao.getValidacao()){
			this.telaInstituicao += "\nDisponibilidade: Disponivel";	
		}
		else{
			this.telaInstituicao += "\nDisponibilidade: Indisponivel";	
		}
	}
}