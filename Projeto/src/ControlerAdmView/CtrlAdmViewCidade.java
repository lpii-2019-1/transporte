package controlerAdmView;

import java.util.ArrayList;
import java.util.Arrays;

import controlAdm.ControlAdmCidade;
import model.Cidade;
import view.TelaArgInvalido;
import view.TelaFimOperacao;
import viewAdministrador.TelaCidade;
import viewAdministrador.TelaInicial;
import viewAdministrador.TelaManter;

public class CtrlAdmViewCidade{
	public int acesso2;
	public int acesso3;
	public int acesso4;
	public int acesso5;

	private ControlAdmCidade controler = new ControlAdmCidade();
	
	public String tela;
	

	public String entrada(String entrada, int arg){
		switch(this.acesso2){
			//Tela de fim de operacao ou argumento invalido
			case -1:
				switch(arg) {
					case 0:
						this.acesso2 = 0;
						this.tela = new TelaInicial().telaIni;
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
						this.tela = new TelaInicial().telaIni;
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
						ArrayList<Cidade> consulta = controler.listarTodasCidades();//Metodo que lista cidade --M.W. deve setar
						TelaCidade tela = new TelaCidade();
						tela.setTelaConsulta(consulta);
						this.tela = tela.telaConsulta;
						this.acesso2 = 5;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIniAdm;
						this.acesso2 = -1;
						break;
				}
				break;
			//Vai para tela de consulta da opcao selecionada
			case 1:
				switch(this.acesso3){
					case -1:
						switch(arg) {
							case 0:
								this.acesso3 = 0;
								this.acesso2 = 0;
								this.tela = new TelaManter().telaIni;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIniAdm;
								this.acesso3 = -1;
								break;
						}
						break;
					case 0:
						switch(arg){
							case 0:
								this.acesso2 = 0;
								this.tela = new TelaInicial().telaIni;
								break;
							//Consulta por nome
							case 1:
								this.tela = new TelaCidade().consulta;
								this.acesso3 = 1;
								break;
							//Consulta por uf
							case 2:
								this.tela = new TelaCidade().consulta;
								this.acesso3 = 2;
								break;
							//Consulta por instituicao
							case 3:
								this.tela = new TelaCidade().consulta;
								this.acesso3 = 3;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIniAdm;
								this.acesso3 = -1;
								break;
						}
						break;
					case 1:
						TelaCidade tela = new TelaCidade();
						tela.setTelaConsulta(controler.consultarNome(entrada));
						this.tela = tela.telaConsulta;
						this.acesso3 = 4;
						break;
					case 2:
						TelaCidade tela1 = new TelaCidade();
						tela1.setTelaConsulta(controler.consultarUf(entrada));
						this.tela = tela1.telaConsulta;
						this.acesso3 = 4;
						break;
					case 3:
						TelaCidade tela2 = new TelaCidade();
						ArrayList<Cidade> c = new ArrayList<Cidade>();
						c.add(controler.consultarPorInstituicao(entrada));
						tela2.setTelaConsulta(c);
						this.tela = tela2.telaConsulta;
						this.acesso3 = 4;
						break;
					case 4:
						this.tela = new TelaManter().telaIni;
						this.acesso3 = 0;
						this.acesso2 = 0;
						break;

				}
				break;
			//Vai para tela entrada de dados a serem inseridos
			case 2:
				switch(this.acesso3){
					case -1:
						switch(arg) {
							case 0:
								this.acesso3 = 0;
								this.acesso2 = 0;
								this.tela = new TelaInicial().telaIni;
								break;
							case 1:
								this.acesso3 = 0;
								this.tela = new TelaCidade().cadastro;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIniAdm;
								this.acesso3 = -1;
								break;
						}
						break;
					case 0:
						String regex = "(( , )|( ,)|(, )|(,))";
						ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
						if(controler.inserirCidade(entradas)){
							this.tela = new TelaFimOperacao().sucesso;
							this.acesso3 = 1;
						}
						else{
							this.tela = new TelaFimOperacao().erro;
							this.acesso3 = 1;
						}
						break;
					case 1:
						if(arg == 0){
							this.tela = new TelaManter().telaIni;
							this.acesso3 = 0;
							this.acesso2 = 0;
						}
						break;
				}
				break;
			//Vai para tela opcoes de edicao
			case 3:
				switch(this.acesso3){
					case -1:
						switch(arg) {
							case 0:
								this.acesso3 = 0;
								this.acesso2 = 0;
								
								
								this.tela = new TelaInicial().telaIni;
								break;
							case 1:
								this.acesso3 = 0;
								this.tela = new TelaCidade().opcEdicao;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIniAdm;
								this.acesso3 = -1;
								break;
						}
						break;
					case 0:
						switch(arg){
							//Editrar nome cidade
							case 1:
								this.acesso3 = 1;
								this.tela = new TelaCidade().entrada;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaCidade().entrada;
								break;
							case 3:
								this.acesso3 = 3;
								this.tela = new TelaCidade().entrada;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIniAdm;
								this.acesso3 = -1;
								break;
						}
						break;
					case 1:
						switch(this.acesso4){
							case -1:
								switch(arg) {
									case 0:
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										this.tela = new TelaInicial().telaIni;
										break;
									case 1:
										this.acesso4 = 0;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIniAdm;
										this.acesso4 = -1;
										break;
								}
								break;
							case 0:
								String regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								controler.consultarCidadeNomeUf(entradas);
								this.tela = new TelaManter().telaEdicao;
								this.acesso4 = 1;
								break;
							case 1:
								controler.editarNomeCidade(entrada);
								this.tela = new TelaFimOperacao().telaIniAdm;
								acesso4 = 2;
								break;
							case 2:
								if(arg == 0){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
									this.tela = new TelaInicial().telaIni;
								}
								else if(arg == 1){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.tela = new TelaManter().telaEdicao;
								}
								break;
							default:
								this.tela =  new TelaArgInvalido().telaIniAdm;
								this.acesso4 = -1;
								break;
						}
						break;
					case 2:
						switch(this.acesso4){
							case -1:
								switch(arg) {
									case 0:
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										
										
										this.tela = new TelaInicial().telaIni;
										break;
									case 1:
										this.acesso4 = 0;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIniAdm;
										this.acesso4 = -1;
										break;
								}
								break;
							case 0:
								String regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								controler.consultarCidadeNomeUf(entradas);
								this.tela = new TelaManter().telaEdicao;
								this.acesso4 = 1;
								break;
							case 1:
								controler.editarUfCidade(entrada);
								this.tela = new TelaFimOperacao().telaIniAdm;
								this.acesso4 = 2;
								break;
							case 2:
								if(arg == 0){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
									this.tela = new TelaInicial().telaIni;
								}
								else if(arg == 1){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.tela = new TelaManter().telaEdicao;
								}
								break;
							default:
								this.tela =  new TelaArgInvalido().telaIniAdm;
								this.acesso4 = -1;
								break;
						}
						break;							
					case 3:
						switch(this.acesso4){
							case -1:
								switch(arg) {
									case 0:
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										
										
										this.tela = new TelaInicial().telaIni;
										break;
									case 1:
										this.acesso4 = 0;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIniAdm;
										this.acesso4 = -1;
										break;
								}
								break;
							case 0:
								String regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								controler.consultarCidadeNomeUf(entradas);
								this.tela = new TelaManter().telaEdicao;
								this.acesso4 = 1;
								break;
							case 1:
								controler.editarValidacaoCidade(entrada); //Metodo edita validacao da Cidade selecionada no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaFimOperacao().telaIniAdm;
								acesso4 = 2;
								break;
							case 2:
								if(arg == 0){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
									
									
									this.tela = new TelaInicial().telaIni;
								}
								else if(arg == 1){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.tela =  new TelaManter().telaEdicao;
								}
								break;
							default:
								this.tela =  new TelaArgInvalido().telaIniAdm;
								this.acesso4 = -1;
								break;
						}
						break;
				}
				break;
			case 4:
				if(arg != 0){
					String regex = "(( , )|( ,)|(, )|(,))";
					ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
					if(controler.consultarCidadeNomeUf(entradas).getId() != 0){
						if(controler.excluirCidade()){
							this.tela = new TelaFimOperacao().sucessoExcluir;
						}
						else{
							this.tela = new TelaFimOperacao().erroExcluir;
						}
					}
					else{
						this.tela = new TelaFimOperacao().erroExcluir;
					}
				}
				else{
					this.tela = new TelaManter().telaIni;
					this.acesso2 = 0;
				}
				break;
			case 5:
				this.tela = new TelaManter().telaIni;
				this.acesso2 = 0;
				break;
		}
		return this.tela;
	}
}