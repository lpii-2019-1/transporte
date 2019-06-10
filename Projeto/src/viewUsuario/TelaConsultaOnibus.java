package viewUsuario;

import model.Cidade;
import model.Instituicao;
import model.Onibus;
import model.Rota;

public class TelaConsultaOnibus{
	public String telaConsulta;
	
	public void setTelaConsulta(Onibus onibus, Cidade cidade, Instituicao instituicao, Rota rota){
		this.telaConsulta = "\nCidade: " + cidade.getNome();
		this.telaConsulta += "\nInstituicao: " + instituicao.getNome();
		this.telaConsulta += "\nRota: De " + rota.getInicio() + " ate " + rota.getFim();
		this.telaConsulta += "\nPercurso: " + rota.getPercurso();
		this.telaConsulta += "\nOnibus:";
		this.telaConsulta += "\n    Motorista: " + onibus.getMotorista();
		this.telaConsulta += "\n    Placa: " + onibus.getPlaca();
		this.telaConsulta += "\n    Cor: " + onibus.getCor();
		this.telaConsulta += "\n    Mensalidade: " + onibus.getMensalidade();
		this.telaConsulta += "\n    Telefone: " + onibus.getTelefone();
		this.telaConsulta += "\n\nDigite 0 para Sair do programa ou 1 para selecionar outra rota: ";
	}
}