package viewAdministrador;

import view.Tela;

public class TelaOnibus extends Tela{
	public TelaOnibus(int identificador) {
		super(identificador);
	}
	public String opcoes = "\n1 - Placa \n2 - Cor \n3 - Motorista \n4 - Rota \n5 - Mensalidade \n6 - Telefone \n7 - Validacao  \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores do onibus (Ex.: abc-1234, Cinza, Joao, 300.00, Disponivel): ";
	public String Excluir = "\nDigite o placa da onibus (Ex.: abc-1234): ";
	public String telaOnibus;

	public void setTelaOnibus(ArrayList<Onibus> onibuss){
		this.telaOnibus = "\nOnibus: ";
		for (Onibus o : onibuss) {
			this.telaOnibus += "\n    Placa: " + onibus.getPlaca();
			this.telaOnibus += "\n    Cor: " + onibus.getCor();
			this.telaOnibus += "\n    Motorista: " + onibus.getMotorista();
			this.telaOnibus += "\n    Telefone: " + onibus.getTelefone();
			this.telaOnibus += "\n    Mensalidade: " + onibus.getMensalidade();
			this.telaOnibus += "\n    Rotas: ";
			for (Rota r : onibus.getRotas()) {
				this.telaOnibus += "\n        Inicio: " + r.getInicio();
				this.telaOnibus += "\n        Fim: " + r.getFim();
				this.telaOnibus += "\n        Turnos: ";
				for (Horario h : r.getHorarios()) {
					this.telaOnibus += "\n            Turno: " + h.getTurno().getTurno();
					this.telaOnibus += "\n            Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
					this.telaOnibus += "\n            Haririo de regresso: " + h.getHrRegresso();
					this.telaOnibus += "\n            Disponibilidade: " + (h.getValidacao() == 1? "Disponivel": "Indisponivel");
					this.telaOnibus += "\n";
				}
				this.telaOnibus += "\n        Disponibilidade: " + (r.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaOnibus += "\n";
			}
			this.telaOnibus += "\n    Disponibilidade: " + (onibus.getValidacao() == 1? "Disponivel": "Indisponivel");
			this.telaOnibus += "\n";
		}
	}
}