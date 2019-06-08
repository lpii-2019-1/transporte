package viewUsuario;

import java.util.ArrayList;
import view.Tela;
import model.Rota;
import model.Horario;
import model.Instituicao;
import model.Ponto;

public class TelaConsultaRota extends Tela{
	public TelaConsultaRota(int identificador) {
		super(identificador);
	}
	public String telaRota;
	public void setTelaRota(ArrayList<Rota> rotas, Instituicao instituicao){
		this.telaRota = "\nInstituicao: " + instituicao.getNome();
		int j = 0;
		int k;
		for(Rota r : rotas){
			j++;
			this.telaRota += "\n   " + j + " - Rota: De " + r.getInicio() + " até " + r.getFim()+ ":";
			this.telaRota += "\n    Passando por ";
			k = 0;
			for(Instituicao i : r.getInstituicoes()){
				k++;
				if(r.getInstituicoes().size() == 1){
					this.telaRota += i.getNome() + ".";
				}
				else if(r.getInstituicoes().size() == k){
					this.telaRota += " e " + i.getNome();
				}
				else if(r.getInstituicoes().size() < k){
					this.telaRota += ", " + i.getNome();
				}
				else{
					this.telaRota += i.getNome();
				}
			}
			this.telaRota += "\nPontos:";
			for(Ponto p : r.getPontos()){
				this.telaRota += "\n    " + p.getOrdem() + "º " + p.getEndereco();
			}
			this.telaRota += "\nHorarios:";
			for(Horario h : r.getHorarios()){
				this.telaRota += "\n    Turno: " + h.getTurno().getTurno();
				this.telaRota += "\n    Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
				this.telaRota += "\n    Haririo de regresso: " + h.getHrRegresso();
			}
		}
		this.telaRota += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
}