package usuario;

import java.util.ArrayList;
import view.Tela;
import model.Rota;
import model.Instituicao;
import model.Ponto;

public class TelaConsultaRota extends Tela{
	public String telaRota;
	public void setTelaRota(ArrayList<Rota> rotas, Instituicao instituicao){
		this.telaRota = "\nInstituicao: " + instituicao.getNome();
		int j = 0;
		int k;
		for(Ponto r : rotas){
			j++;
			this.telaRota += "\n   " + i + " - Rota: De " + r.getInicio() + " até " + r.getFim()+ ":";
			this.telaRota += "\n    Passando por ";
			k = 0
			for(Instituicao i : r.getInstituicoes()){
				k++;
				if(i.getInstituicoes().size() == 1){
					this.telaRota += i.getNome() + ".";
				}
				else if(i.getInstituicoes().size() == k){
					this.telaRota += " e " + i.getNome();
				}
				else if(i.getInstituicoes().size() < k){
					this.telaRota += ", " + i.getNome();
				}
				else{
					this.telaRota += i.getNome();
				}
			}
			for()
		}
		this.telaRota += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
}