<<<<<<< HEAD
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


=======
package viewAdministrador;

import view.Tela;

public class TelaHorario extends Tela{
	public String opcoes = "\n1 - Turno \n2 - Horario de Saida \n3 - Horario de Regresso \n4 - Validacao \n0 - Sair";
	public String cadastro = "\nDigite o valores do Horario (Ex.: 14:00, 17:00, Matutino, Disponivel): ";
	public String Excluir = "\nDigite o nome e uf da cidade (Ex.: Ceres, GO): ";
	public String telaHorario;

	public setTelaHorario(Horario horario){
			this.telaHorario = "\nNome: " + horario.getNome();
			this.telaHorario += "\nUF: " + cidade.getUf();
			this.telaHorario += "\nInstituicoes: ";
			if(cidade.getInstituicoes().get(0) != NULL){
				int j = 0;
				for (Instituicao i : cidade.getInstituicoes()) {
					j++;
					this.telaHorario += "\n    Instituicao " + j + ": " + i.getNome();
				}
			}
			else{
				this.telaHorario += "Nao ha Instituicoes";
			}
			if(cidade.getValidacao()){
				this.telaHorario += "\nDisponibilidade: Disponivel";	
			}
			else{
				this.telaHorario += "\nDisponibilidade: Indisponivel";	
			}
	}
>>>>>>> cdfc8d46bdb81d99645173fd10d2d9a6efa433a4
}