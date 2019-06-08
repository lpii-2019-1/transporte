package viewAdministrador;

import view.Tela;

import java.util.ArrayList;

import model.Horario;
public class TelaHorario extends Tela{
	public TelaHorario(int identificador) {
		super(identificador);
	}

	public String opcoes = "\n1 - Turno \n2 - Horario de Saida \n3 - Horario de Regresso \n4 - Validacao \n0 - Sair";
	public String cadastro = "\nDigite o valores do Horario (Ex.: 14:00, 17:00, Matutino, Disponivel): ";
	public String Excluir = "\nDigite o nome e uf da cidade (Ex.: Ceres, GO): ";
	public String telaHorario;

	public void setTelaHorario(ArrayList<Horario> horarios){
		this.telaHorario = "\nHorarios:";
		for(Horario h : horarios){
			this.telaHorario += "\n        Turno: " + h.getTurno().getTurno();
			this.telaHorario += "\n        Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
			this.telaHorario += "\n        Haririo de regresso: " + h.getHrRegresso();
			this.telaHorario += "\n        Disponibilidade: " + (h.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaHorario += "\n";
		}
		this.telaHorario += "\nDigite 0 para voltar: ";
	}
}