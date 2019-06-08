package viewAdministrador;

import view.Tela;

import java.util.ArrayList;

import model.Ponto;

public class TelaPonto extends Tela{
	public TelaPonto(int identificador) {
		super(identificador);
	}
	public String opcoes = "\n1 - Ordem \n2 - Endereco \n3 - Validacao \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores do ponto (Ex.: 1, Esquina, Disponivel): ";
	public String Excluir = "\nDigite o endereco da ponto (Ex.: Esquina): ";
	public String telaPonto;

	public void setTelaPonto(ArrayList<Ponto> pontos){
		this.telaPonto = "\nPontos: ";
		for (Ponto p : pontos) {
			this.telaPonto += "\n    Ordem: " + p.getOrdem();
			this.telaPonto += "\n    Endereco: " + p.getEndereco();
			this.telaPonto += "\n    Disponibilidade: " + (p.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaPonto += "\n";
		}
		this.telaPonto += "\nDigite 0 para voltar: ";
	}
}