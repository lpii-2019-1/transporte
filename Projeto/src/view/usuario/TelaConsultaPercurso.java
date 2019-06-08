package usuario;

import java.util.ArrayList;
import view.Tela;
import model.Cidade;
import mode.Instituicao;

public class TelaConsultaPercurso extends Tela{
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