package viewUsuario;

import java.util.ArrayList;
import view.TelaFim;
import model.Instituicao;
import model.Rota;

public class TelaConsultaPercurso extends TelaFim{
	public TelaConsultaPercurso(int identificador) {
		super(identificador);
	}

	public String telaIni = "\nDigite 1 para listar percursos ou 2 para pesquisar percuros: ";
	public String telaErro = "\nNao foi encontrado nenhum ponto com essas informacoes. \n\nDigite 1 para listar percursos ou 2 para pesquisar percurso: ";
	public String telaPercurso;
	public String telaRota;

	public void setTelaPercurso(ArrayList<Rota> rotas, Instituicao instituicao){
		this.telaRota = "\nInstituicao: " + instituicao.getNome();
		int i = 0;
		for(Rota r : rotas){
			i++;
			this.telaRota += "\n   " + i + " - Percurso: " + r.getPercurso();
		}
		this.telaRota += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
}