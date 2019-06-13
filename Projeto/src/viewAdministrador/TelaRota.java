package viewAdministrador;

import java.util.ArrayList;

import model.Horario;
import model.Instituicao;
import model.Ponto;
import model.Rota;
import view.TelaFimOperacao;

public class TelaRota{
	public String manterRota = "\nOpcoes: \n\n1 - Consutar \n2 - Cadastrar \n3 - Editar \n4 - Manter Pontos \n5 - Manter Instituicoes \n6 - Manter Horario \n7 - Excluir \n8 - Listar \n0 - Voltar \n\nDigite o numero correspondente: ";
	public String opcEdicao = "\nOpcoes: \n\n1 - Inicio \n2 - Fim \n3 - Percurso \n4 - Validacao \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String opcConsulta = "\nOpcoes: \n\n1 - Inicio \n2 - Fim \n3 - Percurso \n4 - Pontos \n5 - Instituicoes \n6 - Turno \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores do onibus (Ex.: Rua 1, UEG, BR - 153, Curumim, 00:00, 00:00, Disponivel): ";
	public String entrada = "\nDigite o identificador da rota: ";
	public String consulta = "\nDigite o valor da consulta: ";
	public String telaConsulta;
	
	public void setTelaConsulta(ArrayList<Rota> rotas){
		if(rotas.get(0).getId() != 0){
			this.telaConsulta = "\nRotas:";
			for (Rota r: rotas) {
				this.telaConsulta += "\n    Inicio:" + r.getInicio();
				this.telaConsulta += "\n    Fim:" + r.getFim();
				this.telaConsulta += "\n    Instituicoes:";
				if(r.getInstituicoes().get(0).getId() != 0) {
					for(Instituicao i : r.getInstituicoes()){
						this.telaConsulta += "\n        Nome:" + i.getNome();
						this.telaConsulta += "\n        Endereco: " + i.getEndereco();
						this.telaConsulta += "\n        Telefone: " + i.getTelefone();
						this.telaConsulta += "\n        Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
						this.telaConsulta += "\n";
					}
				}
				else {
					this.telaConsulta += "\n        Nao ha instituicoes!";
					this.telaConsulta += "\n";
				}
				this.telaConsulta += "\n    Pontos:";
				if(r.getPontos().get(0).getId() != 0) {
					for(Ponto p : r.getPontos()){
						this.telaConsulta += "\n        Ordem:" + p.getOrdem(); 
						this.telaConsulta += "\n        Endereco:" + p.getEndereco();
						this.telaConsulta += "\n        Disponibilidade: " + (p.getValidacao() == 1? "Disponivel": "Indisponivel");
						this.telaConsulta += "\n";
					}
				}
				else {
					this.telaConsulta += "\n        Nao ha pontos!";
					this.telaConsulta += "\n";
				}
				this.telaConsulta += "\n    Horarios:";
				if(r.getHorarios().get(0).getId() != 0) {
					for(Horario h : r.getHorarios()){
						this.telaConsulta += "\n        Turno: " + h.getTurno().getTurno();
						this.telaConsulta += "\n        Haririo de partida: " + h.getHrSaidaPrimeiroPonto();
						this.telaConsulta += "\n        Haririo de regresso: " + h.getHrRegresso();
						this.telaConsulta += "\n        Disponibilidade: " + (h.getValidacao() == 1? "Disponivel": "Indisponivel");
						this.telaConsulta += "\n";
					}
				}
				else {
					this.telaConsulta += "\n        Nao ha horarios!";
					this.telaConsulta += "\n";
				}
				this.telaConsulta += "\n    Disponibilidade: " + (r.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += "\nDigite 0 para voltar: ";
		}
		else {
			this.telaConsulta = "\nNao foi encontrada nenhuma rota! " + new TelaFimOperacao().telaIniAdm;
		}
	}
}