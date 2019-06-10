package viewUsuario;

import java.util.ArrayList;
import view.TelaFimOperacao;
import model.Instituicao;

public class TelaConsultaInicioFim{
	public String telaIni = "\nDigite 1 para listar pontos ou 2 para pesquisar pontos: ";
	public String telaErro = "\nNao foi encontrado nenhum ponto com essas informacoes!\n" + new TelaFimOperacao().telaIni;
	public String telaConsulta;
	public void setTelaConsulta(ArrayList<ArrayList<String>> inicioFim, Instituicao instituicao){
		this.telaConsulta = "\nInstituicao: " + instituicao.getNome();
		this.telaConsulta = "\n    Rotas: ";
		int i = 0;
		for(ArrayList<String> ini : inicioFim){
			i++;
			this.telaConsulta += "\n       " + i + " - Rota:";
			this.telaConsulta += "\n           Inicio: " + ini.get(0);
			this.telaConsulta += "\n           Fim: " + ini.get(1);
		}
		this.telaConsulta += "\n       0 - Sair \n\nDigite o numero correspondente: ";
	}
}