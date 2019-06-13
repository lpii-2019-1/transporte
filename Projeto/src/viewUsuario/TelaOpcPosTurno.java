package viewUsuario;

import view.TelaFimOperacao;

public class TelaOpcPosTurno{
	public String telaErro = "\nNao ha rotas para esse turno!\n" + new TelaFimOperacao().telaIni;
	public String telaIni = "\nOpcoes de consulta: \n    1 - Consultar pontos\n    2 - Consultar percursos\n    3 - Consultar Inicio e Fim\n    0 - Voltar \n\nDigite onumero correspondente a opcao desejada: ";
}