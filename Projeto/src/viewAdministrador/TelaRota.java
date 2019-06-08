package viewAdministrador;

import java.util.ArrayList;

import model.Horario;
import model.Instituicao;
import model.Ponto;
import model.Rota;
import view.Tela;

public class TelaRota extends Tela{
	public TelaRota(int identificador) {
		super(identificador);
	}
	public String opcoes = "\n1 - Inicio \n2 - Fim \n3 - Percurso \n4 - Pontos \n5 - Instituicoes \n6 - Horario \n7 - Validacao \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores do onibus (Ex.: Rua 1, UEG, BR - 153, Curumim, 00:00, 00:00, Disponivel): ";
	public String Excluir = "\nDigite o placa da onibus (Ex.: abc-1234): ";
	public String telaRota;
	public void setTelaRota(ArrayList<Rota> rotas){
		this.telaRota = "\nRotas:";
		for (Rota r: rotas) {
			this.telaRota += "\n    Inicio:" + r.getInicio();
			this.telaRota += "\n    Fim:" + r.getFim();
			this.telaRota += "\n    Instituicoes:";
			for(Instituicao i : r.getInstituicoes()){
				this.telaRota += "\n        Nome:" + i.getNome();
				this.telaRota += "\n        Endereco: " + i.getEndereco();
				this.telaRota += "\n        Telefone: " + i.getTelefone();
				this.telaRota += "\n        Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaRota += "\n";
			}
			this.telaRota += "\n    Pontos:";
			for(Ponto p : r.getPontos()){
				this.telaRota += "\n        Ordem:" + p.getOrdem(); 
				this.telaRota += "\n        Endereco:" + p.getEndereco();
				this.telaRota += "\n        Disponibilidade: " + (p.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaRota += "\n";
			}
			this.telaRota += "\n    Horarios:";
			for(Horario h : r.getHorarios()){
				this.telaRota += "\n        Turno: " + h.getTurno().getTurno();
				this.telaRota += "\n        Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
				this.telaRota += "\n        Haririo de regresso: " + h.getHrRegresso();
				this.telaRota += "\n        Disponibilidade: " + (h.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaRota += "\n";
			}
			this.telaRota += "\n    Disponibilidade: " + (r.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaRota += "\n";
		}
		this.telaRota += "\nDigite 0 para voltar: ";
	}
}