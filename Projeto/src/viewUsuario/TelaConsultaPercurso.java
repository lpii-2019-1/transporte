package viewUsuario;

import java.util.ArrayList;
import view.TelaFimOperacao;
import model.Instituicao;

public class TelaConsultaPercurso{
	public String telaIni = "\nDigite 1 para listar percursos ou 2 para pesquisar percuros: ";
	public String telaErro = "\nNao foi encontrado nenhum percurso com essas informacoes!\n"  + new TelaFimOperacao().telaIni;;
	public String telaConsulta;
	public void setTelaConsulta(ArrayList<String> percursos, Instituicao instituicao){
		this.telaConsulta = "\nInstituicao: " + instituicao.getNome();
		this.telaConsulta = "\n    Percursos: ";
		int i = 0;
		for(String p : percursos){
			i++;
			this.telaConsulta += "\n       " + i + " - Percurso: " + p;
		}
		this.telaConsulta += "\n       0 - Voltar \n\nDigite o numero correspondente: ";
	}
}