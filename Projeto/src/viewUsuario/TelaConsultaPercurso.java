package viewUsuario;

import java.util.ArrayList;
import view.Tela;
import model.Cidade;
import model.Instituicao;

public class TelaConsultaPercurso extends Tela{
	public String telaIni = "\nDigite 1 para listar percursos ou 2 para pesquisar percuros: ";
	public String telaErro = "\nNao foi encontrado nenhum ponto com essas informacoes. \n\nDigite 1 para listar percursos ou 2 para pesquisar percurso: ";
	public String telaPercurso;

	public void setTelaPercurso(ArrayList<Rota> rotas, Instituicao instituicao){
		this.telaRota = "\nInstituicao: " + instituicao.getNome();
		int i = 0;
		for(Ponto r : rotas){
			i++;
			this.telaPonto += "\n   " + i + " - Percurso: " + r.getPercurso();
		}
		this.telaPonto += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
}