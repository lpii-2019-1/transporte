package viewAdministrador;

import java.util.ArrayList;

import model.Instituicao;

public class TelaInstituicao{
	public String opcEdicao = "\n1 - Nome \n2 - Endereco \n3 - Telefone \n4 - Validacao \n0 - Sair \n\nDigite o numero correspondente: ";
	public String opcCidade = "\n1 - Inserir \n2 - Excluir \n0 - Sair \n\nDigite o numero correspondente: ";
	public String opcConsulta = "\n1 - Nome \n2 - Endereco \n3 - Telefone \n0 - Sair \n\nDigite o endereco instituicao: ";
	public String cadastro = "\nDigite o valores do instituicao (Ex.: IF Goiano, Meio do mato, 3353-1111, Disponivel): ";
	public String entrada = "\nDigite o endereco da instituicao (Ex.: Meio do mato): ";
	public String telaConsulta;

	public void setTelaCidade(ArrayList<Instituicao> instituicoes){
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
}