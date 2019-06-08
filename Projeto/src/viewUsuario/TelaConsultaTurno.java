package viewUsuario;

import java.util.ArrayList;

import model.Turno;
import view.TelaFimOperacao;

public class TelaConsultaTurno{
	public String telaErro = "\nNão há rotas para essa instituicao!\n" + new TelaFimOperacao().telaIni;
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Turno> turnos){
		if(turnos.get(0).getId() != 0){
			this.telaConsulta = "\nTurnos: ";
			int i = 0;
			for (Turno t : turnos) {
				i++;
				this.telaConsulta += "\n    " + i + " - " + t.getTurno();
			}
			this.telaConsulta += "\n\nDigite o numero correspondente: ";
		}
		else{
			this.telaConsulta = telaErro;
		}
	}
}