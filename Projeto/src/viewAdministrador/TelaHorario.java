package viewAdministrador;

import view.Tela;
public class TelaHorario extends Tela{
	public TelaHorario(int identificador) {
		super(identificador);
	}

	public String opcoes = "\n1 - Turno \n2 - Horario de Saida \n3 - Horario de Regresso \n4 - Validacao \n0 - Sair";
	public String cadastro = "\nDigite o valores do Horario (Ex.: 14:00, 17:00, Matutino, Disponivel): ";
	public String Excluir = "\nDigite o nome e uf da cidade (Ex.: Ceres, GO): ";
	public String telaHorario;
}