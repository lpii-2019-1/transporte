package viewUsuario;

import view.TelaFim;
import view.TelaFimOperacao;
import model.Cidade;
import model.Instituicao;

public class TelaConsultaInstituicao extends TelaFim{
	public String telaErro = "\nNenhuma insttuicao encontrada!\n" + new TelaFimOperacao().telaIni;
	public String telaConsulta;

	public void setTelaConsulta(Cidade cidade){
		if(cidade.getInstituicoes().get(0).getId() != 0){
			this.telaConsulta = "\n" + cidade.getNome() + "-" + cidade.getUf() + ": ";
			this.telaConsulta += "\n    Instituicoes: ";
			int j = 0;

			for (Instituicao i : cidade.getInstituicoes()) {
				j++;
				this.telaConsulta += "\n        " + j + " - " + i.getNome() + ":";
				this.telaConsulta += "\n            Endereco:" + i.getEndereco();
				this.telaConsulta += "\n            Telefone:" + i.getTelefone();
			}
			this.telaConsulta += "\n        0 - Voltar \n\nDigite o numero correspondente: ";
		}
		else{
			this.telaConsulta = telaErro;
		}
	}
}