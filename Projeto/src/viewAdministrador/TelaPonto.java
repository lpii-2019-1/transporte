package viewAdministrador;

import java.util.ArrayList;

import model.Ponto;
import view.TelaFimOperacao;

public class TelaPonto{
	public String opcEdicao = "\n1 - Endereco \n2 - Validacao \n0 - Voltar \n\nDigite o numero correspondente: ";
	public String cadastro = "\nDigite o valores do ponto (Ex.: Esquina, Disponivel): ";
	public String entrada = "\nDigite o endereco da ponto (Ex.: Esquina): ";
	public String telaPonto;

	public void setTelaPonto(ArrayList<Ponto> pontos){
		if(pontos.get(0).getId() != 0){
			this.telaPonto = "\nPontos: ";
			for (Ponto p : pontos) {
				this.telaPonto += (p.getOrdem() != 0 ? "\n    Ordem: " + p.getOrdem() : "");
				this.telaPonto += "\n    Endereco: " + p.getEndereco();
				this.telaPonto += "\n    Disponibilidade: " + (p.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaPonto += "\n";
			}
			this.telaPonto += "\nDigite 0 para voltar: ";
		}
		else{
			this.telaPonto = "\nNao foi encontrado nenhum pontos" + new TelaFimOperacao().telaIniAdm;
		}
	}
}