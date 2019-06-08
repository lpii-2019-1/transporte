package viewUsuario;

import java.util.ArrayList;
import view.TelaFim;
import model.Ponto;
import model.Instituicao;

public class TelaConsultaPonto extends TelaFim{
	public TelaConsultaPonto(int identificador) {
		super(identificador);
	}
	public String telaIni = "\nDigite 1 para listar pontos ou 2 para pesquisar pontos: ";
	public String telaErro = "\nNao foi encontrado nenhum ponto com essas informacoes. \n\nDigite 1 para listar pontos ou 2 para pesquisar pontos: ";
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