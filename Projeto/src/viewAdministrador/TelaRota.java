package viewAdministrador;

import view.Tela;

public class TelaRota extends Tela{
	public String opcoes = "\n1 - Inicio \n2 - Fim \n3 - Percurso \n4 - Pontos \n5 - Instituicoes \n6 - Horario \n7 - Validacao \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores do onibus (Ex.: Rua 1, UEG, BR - 153, Curumim, 00:00, 00:00, Disponivel): ";
	public String Excluir = "\nDigite o placa da onibus (Ex.: abc-1234): ";
	public String telaRota;
	public void setTelaRota(Rota rotas){
		int k = 0;
		this.telaRota += "\nInicio:" + r.getInicio();
		this.telaRota += "\nFim:" + r.getFim();
		this.telaRota += "\nInstituicoes:";
		k = 0
		for(Instituicao i : r.getInstituicoes()){
			k++;
			this.telaRota += "Instituicao " + k + ":" + i.getNome();
		}
		this.telaRota += "\nPontos:";
		for(Ponto p : r.getPontos()){
			this.telaRota += "\n    " + p.getOrdem() + "º " + p.getEndereco();
		}
		this.telaRota += "\nHorarios:";
		for(Haririo h : r.getHorarios()){
			this.telaRota += "\n    Turno: " + h.getTurno().getTurno();
			this.telaRota += "\n    Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
			this.telaRota += "\n    Haririo de regresso: " + h.getHrRegresso();
		}
	}
}