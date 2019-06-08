package ControlerAdm;

import java.util.ArrayList;

import model.*;
import viewAdministrador.*;
import view.*;

public class ControlerAdministrador{
	public boolean exit = false;
	public int acesso1;
	public int acesso2;
	public int acesso3;
	public int acesso4;
	public int acesso5;

	public String tela = new TelaInicial().telaIni;

	public void entrada(String entrada){
		int arg = 0;
		arg = Integer.parseInt(entrada);
		switch(this.acesso1){
			//Retorno de fim de operacao ou argumento invalido
			case -1:
				switch(arg) {
					case 0:
						this.acesso1 = 0;
						this.exit = true;
						this.tela = new TelaFim().telaIni;
						break;
					case 1:
						this.acesso1 = 0;
						this.tela = new TelaInicial().telaIni;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso1 = -1;
						break;
				}
				break;
			//Tela Inicial
			case 0:
				switch(arg){
					case 0:
						//Retorna para tela inicial
						this.acesso1 = 0;
						this.tela = new TelaInicial().telaIni;
						break;
					case 1:
						//Vai para tela Manter Cidade
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 1;
						break;
					case 2:
						//Vai para tela Manter Horario
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 2;
						break;
					case 3:
						//Vai para tela Manter Instituicao
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 3;
						break;
					case 4:
						//Vai para tela Manter Onibus
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 4;
						break;
					case 5:
						//Vai para tela Manter Ponto
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 5;
						break;
					case 6:
						//Vai para tela Manter Cidade
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 6;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso1 = -1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Cidade
			case 1:
				switch(this.acesso2){
					//Tela de fim de operacao ou argumento invalido
					case -1:
						switch(arg) {
							case 0:
								this.acesso2 = 0;
								this.acesso1 = 0;
								this.tela = new TelaInicial().telaIni;
								break;
							case 1:
								this.acesso2 = 0;
								this.tela = new TelaManter().telaIni;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = -1;
								break;
						}
						break;
					case 0:
						switch(arg){
							//Retorna para tela inicial de Manter Cidade
							case 0:
								this.acesso2 = 0;
								this.tela = new TelaManter().telaIni;
								break;
							//Vai para tela de selecionar dados para consulta
							case 1:
								this.tela = new TelaCidade().opcConsulta;
								this.acesso2 = 1;
								break;
							//Vai para tela de entrada de dados para cadastro
							case 2:
								this.tela = new TelaCidade().cadastro;
								this.acesso2 = 2;
								break;
							//Vai para tela de selecionar dados para edicao
							case 3:
								this.tela = new TelaCidade().opcEdicao;
								this.acesso2 = 3;
								break;
							//Vai para tela de entrada de dados para exclusao
							case 4:
								this.tela = new TelaCidade().entrada;
								this.acesso2 = 4;
								break;
							//Vai para tela de Listagem
							case 5:
								ArrayList<Cidade> consulta = lista();//Metodo que lista cidade --M.W. deve setar
								TelaCidade tela = new TelaCidade();
								tela.setTelaConsulta(consulta);
								this.tela = tela.telaConsulta;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = -1;
								break;
						}
						break;
					//Vai para tela de consulta da opcao selecionada
					case 1:
						switch(arg){
							//Consulta por nome
							case 1:
								ArrayList<Cidade> consulta = lista(entrada);//Metodo que lista cidade por nome --M.W. deve setar, entrada corespone a string usada de parametro
								TelaCidade tela = new TelaCidade();
								tela.setTelaConsulta(consulta);
								this.tela = tela.telaConsulta;
								break;
							//Consulta por uf
							case 2:
								ArrayList<Cidade> consulta = lista(entrada);//Metodo que lista cidade por uf --M.W. deve setar, entrada corespone a string usada de parametro
								TelaCidade tela = new TelaCidade();
								tela.setTelaConsulta(consulta);
								this.tela = tela.telaConsulta;
								break;
							//Consulta por instituicao
							case 3:
								ArrayList<Cidade> consulta = lista(entrada);//Metodo que lista cidade por instituicao --M.W. deve setar, entrada corespone a string usada de parametro
								TelaCidade tela = new TelaCidade();
								tela.setTelaConsulta(consulta);
								this.tela = tela.telaConsulta;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = -1;
								break;
						}
						break;
					//Vai para tela entrada de dados a serem inseridos
					case 2:
						String regex = "((?<=,)|(?=, ))|\\s";
						ArrayList<String> entradas = entrada.spit(regex);
						if(inseri()){//Metodo insere dados na tabela Cidade --M.W. deve setar, entrada corespone a string usada de parametro

						}
						this.tela = new TelaCidade().e;
						this.acesso3 = 2;
						break;
					//Vai para tela opcoes de edicao
					case 3:
						//Vai para tela Cidade
						this.tela = new TelaCidade().opcEditar;
						this.acesso1 = 3;
						break;
				}
				break;
			//Entra nas opcoes de Manter Horario
			case 2:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaHorario().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Instituicao
			case 3:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaInstituicao().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Onibus
			case 4:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaOnibus().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Ponto
			case 5:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaPonto().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Rota
			case 6:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaCidade().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			default:
				this.tela = new ArgumentoInvalido().telaIni;
				this.acesso1 = -1;
				break;
		}
	}
}