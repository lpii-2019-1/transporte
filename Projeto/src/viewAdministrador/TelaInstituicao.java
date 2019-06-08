<<<<<<< HEAD
package viewAdministrador;

import model.Instituicao;
import view.Tela;

public class TelaInstituicao extends Tela{
	public TelaInstituicao(int identificador) {
		super(identificador);
	}

	public String opcoes = "\n1 - Nome \n2 - Endereco \n3 - Telefone \n4 - Validacao \n0 - Sair \n\nDigite o endereco instituicao: ";
	public String cadastro = "\nDigite o valores do instituicao (Ex.: IF Goiano, Meio do mato, 3353-1111, Disponivel): ";
	public String Excluir = "\nDigite o endereco da instituicao (Ex.: Meio do mato): ";
	public String telaInstituicao;

	public void setTelaCidade(Instituicao instituicao){
		this.telaInstituicao = "\nNome: " + instituicao.getNome();
		this.telaInstituicao += "\nEndereco: " + instituicao.getEndereco();
		this.telaInstituicao += "\nTelefone: " + instituicao.getTelefone();
		if(instituicao.getValidacao() == 1){
			this.telaInstituicao += "\nDisponibilidade: Disponivel";	
		}
		else{
			this.telaInstituicao += "\nDisponibilidade: Indisponivel";	
		}
	}
=======
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
>>>>>>> cdfc8d46bdb81d99645173fd10d2d9a6efa433a4
}