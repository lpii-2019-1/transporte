package viewUsuario;

import java.util.ArrayList;
import view.TelaFimOperacao;
import model.Ponto;
import model.Instituicao;

public class TelaConsultaPonto{
	public String telaIni = "\nDigite 1 para listar pontos ou 2 para pesquisar pontos: ";
	public String telaErro = "\nNao foi encontrado nenhum ponto com essas informacoes!\n" + new TelaFimOperacao().telaIni;
	public String telaConsulta;
	public void setTelaConsulta(ArrayList<Ponto> pontos, Instituicao instituicao){
		this.telaConsulta = "\nInstituicao: " + instituicao.getNome();
		this.telaConsulta = "\n    Pontos: ";
		int i = 0;
		for(Ponto p : pontos){
			i++;
			this.telaConsulta += "\n       " + i + " - Ponto: " + p.getEndereco();
		}
		this.telaConsulta += "\n       0 - Voltar \n\nDigite o numero correspondente: ";
	}
}