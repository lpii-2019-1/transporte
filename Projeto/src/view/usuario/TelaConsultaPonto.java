package usuario;

import java.util.ArrayList;
import view.Tela;
import model.Ponto;
import mode.Instituicao;

public class TelaConsultaPonto extends Tela{
	public String telaPonto;
	public void setTelaPonto(ArrayList<Ponto> pontos, Instituicao instituicao){
		this.telaPonto = "\nInstituicao: " + instituicao.getNome();
		int i = 0;
		for(Ponto p : pontos){
			i++;
			this.telaPonto += "\n   " + i + " - Ponto: " + p.getEndereco();
		}
		this.telaPonto += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
}