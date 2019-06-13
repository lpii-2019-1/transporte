package viewUsuario;

import java.util.ArrayList;
import view.TelaFimOperacao;
import model.Rota;
import model.Horario;
import model.Instituicao;
import model.Ponto;

public class TelaConsultaRota{
	public String telaConsulta;
	public String telaErro = "\nNenhuma rota foi encontrada\n" + new TelaFimOperacao().telaIni;
	
	public void setTelaConsulta(ArrayList<Rota> rotas, Instituicao instituicao){
		if(rotas.get(0).getId() != 0){
			this.telaConsulta = "\nInstituicao: " + instituicao.getNome();
			int j = 0;
			int k;
			for(Rota r : rotas){
				j++;
				this.telaConsulta += "\n    " + j + " - Rota: De " + r.getInicio() + " ate " + r.getFim()+ ":";
				this.telaConsulta += "\n        Passando por ";
				k = 0;
				for(Instituicao i : r.getInstituicoes()){
					if(i.getId() != 0) {
						k++;
						if(r.getInstituicoes().size() == 1){
							this.telaConsulta += i.getNome() + ".";
						}
						else if(r.getInstituicoes().size() == k){
							this.telaConsulta += " e " + i.getNome();
						}
						else if(r.getInstituicoes().size() < k){
							this.telaConsulta += ", " + i.getNome();
						}
						else{
							this.telaConsulta += i.getNome();
						}
					}
				}
				this.telaConsulta += "\n        Pontos:";
				for(Ponto p : r.getPontos()){
					this.telaConsulta += "\n            " + p.getOrdem() + "º " + p.getEndereco();
				}
				this.telaConsulta += "\n        Horarios:";
				for(Horario h : r.getHorarios()){
					this.telaConsulta += "\n            Turno: " + h.getTurno().getTurno();
					this.telaConsulta += "\n            Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
					this.telaConsulta += "\n            Haririo de regresso: " + h.getHrRegresso();
				}
			}
			this.telaConsulta += "\n    0 - Voltar \n\nDigite o numero correspondente: ";
		}
		else{
			this.telaConsulta = telaErro;
		}
	}
}