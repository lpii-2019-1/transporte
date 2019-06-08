package usuario;

import java.util.ArrayList;
import view.Tela;
import model.Ponto;
import model.Instituicao;
import model.Rota

public class TelaConsultaOnibus extends Tela{
	public String telaOnibus;
	public void setTelaOnibus(Onibus onibus, Cidade cidade ,Instituicao instituicao, Rota rota){
		this.telaOnibus = "\nCidade: " + cidade.getNome();
		this.telaOnibus += "\nInstituicao: " + instituicao.getNome();
		this.telaOnibus += "\nRota: De " + rota.getInicio() + " ate " + rota.getFim();
		this.telaOnibus += "\nPercurso: " + rota.getPercurso();
		int i = 0;
		for(Ponto p : pontos){
			i++;
			this.telaOnibus += "\n   " + i + " - Ponto: " + p.getEndereco();
		}
		this.telaOnibus += "\n    0 - Sair \n\nDigite o numero correspondente: ";
	}
}