package viewAdministrador;

import java.util.ArrayList;

import model.Horario;
import model.Rota;
public class TelaHorario{
	public String opcEdicao = "\n1 - Turno \n2 - Horario de Saida \n3 - Horario de Regresso \n4 - Validacao \n0 - Sair";
	public String opcConsulta = "\n1 - Turno \n2 - Horario de Saida \n3 - Horario de Regresso \n0 - Sair";
	public String cadastro = "\nDigite o valores do Horario (Ex.: 14:00, 17:00, Matutino, Disponivel): ";
	public String entrada = "\nDigite o numero da rota (Ex.: 2, Matutino): ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Rota> rotas){
		for(Rota r : rotas){
			this.telaConsulta = "\n    Horarios:";
			for(Horario h : r.getHorarios()){
				this.telaConsulta += "\n        Turno: " + h.getTurno().getTurno();
				this.telaConsulta += "\n        Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
				this.telaConsulta += "\n        Haririo de regresso: " + h.getHrRegresso();
				this.telaConsulta += "\n        Disponibilidade: " + (h.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
		}

		this.telaConsulta += "\nDigite 0 para voltar: ";
	}
}