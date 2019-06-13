package viewAdministrador;

import java.util.ArrayList;

import model.Horario;
import view.TelaFimOperacao;
public class TelaHorario{
	public String opcEdicao = "\nOpcoes: \n\nOpcoes: \n\n1 - Turno \n2 - Horario de Saida \n3 - Horario de Regresso \n4 - Validacao \n0 - Sair";
	public String opcConsulta = "\nOpcoes: \n\n1 - Horario de Saida \n2 - Horario de Regresso \n3 - Turno \n0 - Sair";
	public String cadastro = "\nDigite o valores do Horario (Ex.: 14:00, 17:00): ";
	public String entrada = "\nDigite o numero da rota (Ex.: 2, Matutino): ";
	public String consulta = "\nDigite o valor da consulta: ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Horario> horarios){
		if(horarios.get(0).getId() != 0){
			for(Horario h : horarios){
				this.telaConsulta = "\n    Horarios:";
				this.telaConsulta += "\n        Turno: " + h.getTurno().getTurno();
				this.telaConsulta += "\n        Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
				this.telaConsulta += "\n        Haririo de regresso: " + h.getHrRegresso();
				this.telaConsulta += "\n        Disponibilidade: " + (h.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += "\nDigite 0 para voltar: ";
		}
		else {
			this.telaConsulta = "\nNao foi encontrado nenhum horario! " + new TelaFimOperacao().telaIniAdm;
		}
	}
}