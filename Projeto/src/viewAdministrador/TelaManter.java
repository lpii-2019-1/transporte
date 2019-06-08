package viewAdministrador;

import view.Tela;

public class TelaManter extends Tela{
	public TelaManter(int identificador) {
		super(identificador);
	}

	public String tela = "\n1 - Consutar \n2 - Cadastrar \n3 - Editar \n4 - Excluir \n5 - Listar \n0 - Sair";
}