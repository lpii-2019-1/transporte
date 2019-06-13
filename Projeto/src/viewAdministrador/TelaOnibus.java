package viewAdministrador;

import java.util.ArrayList;

import view.TelaFimOperacao;

import model.Horario;
import model.Onibus;
import model.Rota;

public class TelaOnibus{
	public String manterOnibus = "\nOpcoes: \n\n1 - Consutar \n2 - Cadastrar \n3 - Editar \n4 - Manter Rotas\n5 - Excluir \n6 - Listar \n0 - Voltar \n\nDigite o numero correspondente: ";
	public String opcEdicao = "\nOpcoes: \n\n1 - Placa \n2 - Cor \n3 - Motorista \n4 - Mensalidade \n5 - Telefone \n6 - Validacao  \n0 - Voltar \n\nDigite o numero correspondentes: ";
	public String opcConsulta = "\nOpcoes: \n\n1 - Placa \n2 - Cor \n3 - Motorista \n4 - Mensalidade \n5 - Telefone \n0 - Voltar \n\nDigite o numero correspondentes: ";
	public String cadastro = "\nDigite o valores do onibus (Ex.: abc-1234, Cinza, Joao, 300.00, Disponivel): ";
	public String entrada = "\nDigite o placa da onibus (Ex.: abc-1234): ";
	public String consulta = "\nDigite o valor da consulta: ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Onibus> onibuss){
		if(onibuss.get(0).getId() != 0){
			this.telaConsulta = "\nOnibus: ";
			for(Onibus o : onibuss) {
				this.telaConsulta += "\n    Placa: " + o.getPlaca();
				this.telaConsulta += "\n    Cor: " + o.getCor();
				this.telaConsulta += "\n    Motorista: " + o.getMotorista();
				this.telaConsulta += "\n    Telefone: " + o.getTelefone();
				this.telaConsulta += "\n    Mensalidade: " + o.getMensalidade();
				this.telaConsulta += "\n    Rotas: ";
				if(o.getRotas().get(0).getId() != 0){
					for(Rota r : o.getRotas()) {
						this.telaConsulta += "\n        Inicio: " + r.getInicio();
						this.telaConsulta += "\n        Fim: " + r.getFim();
						this.telaConsulta += "\n        Turnos: ";
						if(r.getHorarios().get(0).getId() != 0){
							for (Horario h : r.getHorarios()) {
								this.telaConsulta += "\n            Turno: " + h.getTurno().getTurno();
								this.telaConsulta += "\n            Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
								this.telaConsulta += "\n            Haririo de regresso: " + h.getHrRegresso();
								this.telaConsulta += "\n            Disponibilidade: " + (h.getValidacao() == 1? "Disponivel": "Indisponivel");
								this.telaConsulta += "\n";
							}
						}
						else {
							this.telaConsulta += "\n        Nao ha horarios!";
							this.telaConsulta += "\n";
						}	
						this.telaConsulta += "\n        Disponibilidade: " + (r.getValidacao() == 1? "Disponivel": "Indisponivel");
						this.telaConsulta += "\n";
					}
				}
				else {
					this.telaConsulta += "\n        Nao ha rotas!";
					this.telaConsulta += "\n";
				}
				this.telaConsulta += "\n    Disponibilidade: " + (o.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += "\nDigite 0 para voltar: ";
		}
		else{
			this.telaConsulta = "\nNao foi encontrado nenhum onibus! " + new TelaFimOperacao().telaIniAdm;
		}
	}
}