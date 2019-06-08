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

	public void setTelaCidade(ArrayList<Instituicao> instituicoes){
		this.telaInstituicao = "\nInstituicoes: ";
		for (Instituicao i : instituicoes) {
			this.telaInstituicao += "\n    Nome: " + instituicao.getNome();
			this.telaInstituicao += "\n    Endereco: " + instituicao.getEndereco();
			this.telaInstituicao += "\n    Telefone: " + instituicao.getTelefone();
			this.telaInstituicao += "\n    Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaInstituicao += "\n";
		}
	}
}