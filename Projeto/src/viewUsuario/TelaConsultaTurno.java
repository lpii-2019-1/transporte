package viewUsuario;

import view.TelaFim;

public class TelaConsultaTurno extends TelaFim{
	public TelaConsultaTurno(int identificador) {
		super(identificador);
	}

	public String telaIni = "\nTurnos: \n    1 - Matutino \n    2 - Vespertino \n    3 - Noturno \n    0 - Sair\n\nDigite o numero correspondente: ";
}