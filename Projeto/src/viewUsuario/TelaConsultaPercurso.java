package viewUsuario;

import java.util.ArrayList;
import view.TelaFim;
import model.Instituicao;
import model.Rota;

public class TelaConsultaPercurso{
	public String telaIni = "\nDigite 1 para listar percursos ou 2 para pesquisar percuros: ";
	public String telaErro = "\nNao foi encontrado nenhum percurso com essas informacoes!\n"  + new TelaFimOperacao().telaIni;;
	public String telaConsulta;
	public void setTelaConsulta(ArrayList<Rota> rotas, Instituicao instituicao){
		if(rotas.get(0).getId() != 0){
			this.telaConsulta = "\nInstituicao: " + instituicao.getNome();
			this.telaConsulta = "\n    Percursos: ";
			int i = 0;
			for(Rota r : rotas){
				i++;
				this.telaConsulta += "\n       " + i + " - Percurso: " + r.getPercurso();
			}
			this.telaConsulta += "\n        0 - Sair \n\nDigite o numero correspondente: ";
		}
		else{
			this.telaConsulta = telaErro;
		}
	}
}