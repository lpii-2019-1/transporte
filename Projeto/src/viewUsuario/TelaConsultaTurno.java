package viewUsuario;

import view.TelaFimOperacao;

public class TelaConsultaTurno{
	public String telaErro = "\nNão há rotas para essa instituicao!\n" + new TelaFimOperacao().telaIni;
	public String telaIni = "\nOpcoes de consulta: \n    1 - Matutino\n    2 - Vespertino\n    3 - Noturno\n    0 - Sair \n\nDigite o numero correspondente: ";
}