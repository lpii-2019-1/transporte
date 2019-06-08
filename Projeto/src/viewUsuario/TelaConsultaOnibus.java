package viewUsuario;

import view.Tela;
import model.Cidade;
import model.Instituicao;
import model.Onibus;
import model.Rota;

public class TelaConsultaOnibus extends Tela{
	public TelaConsultaOnibus(int identificador) {
		super(identificador);
	}
	public String telaOnibus;
	public void setTelaOnibus(Onibus onibus, Cidade cidade, Instituicao instituicao, Rota rota){
		this.telaOnibus = "\nCidade: " + cidade.getNome();
		this.telaOnibus += "\nInstituicao: " + instituicao.getNome();
		this.telaOnibus += "\nRota: De " + rota.getInicio() + " ate " + rota.getFim();
		this.telaOnibus += "\nPercurso: " + rota.getPercurso();
		this.telaOnibus += "\nOnibus:";
		this.telaOnibus += "\n    Motorista: " + onibus.getMotorista();
		this.telaOnibus += "\n    Placa: " + onibus.getPlaca();
		this.telaOnibus += "\n    Cor: " + onibus.getCor();
		this.telaOnibus += "\n    Mensalidade: " + onibus.getMensalidade();
		this.telaOnibus += "\n    Telefone: " + onibus.getTelefone();
		this.telaOnibus += "\n\nDigite 0 para Sair do programa ou 1 para selecionar outra rota: ";
	}
}