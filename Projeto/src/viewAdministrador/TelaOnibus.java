<<<<<<< HEAD
package viewAdministrador;

import view.Tela;

public class TelaOnibus extends Tela{
	public TelaOnibus(int identificador) {
		super(identificador);
	}
	public String opcoes = "\n1 - Placa \n2 - Cor \n3 - Motorista \n4 - Rota \n5 - Mensalidade \n6 - Validacao  \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores do onibus (Ex.: abc-1234, Cinza, Joao, 300.00, Disponivel): ";
	public String Excluir = "\nDigite o placa da onibus (Ex.: abc-1234): ";
=======
package viewAdministrador;

import view.Tela;

public class TelaOnibus extends Tela{
	public String opcoes = "\n1 - Placa \n2 - Cor \n3 - Motorista \n4 - Rota \n5 - Mensalidade \n6 - Validacao  \n0 - Sair \n\nDigite o nome de uma cidade: ";
	public String cadastro = "\nDigite o valores do onibus (Ex.: abc-1234, Cinza, Joao, 300.00, Disponivel): ";
	public String Excluir = "\nDigite o placa da onibus (Ex.: abc-1234): ";
>>>>>>> cdfc8d46bdb81d99645173fd10d2d9a6efa433a4
}