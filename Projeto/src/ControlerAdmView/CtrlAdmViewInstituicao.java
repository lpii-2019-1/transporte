package controlerAdmView;

import java.util.ArrayList;
import java.util.Arrays;

import controlAdm.ControlAdmInstituicao;

import view.*;
import viewAdministrador.TelaManter;
import viewAdministrador.TelaInicial;
import viewAdministrador.TelaInstituicao;

import model.Instituicao;

public class CtrlAdmViewInstituicao{
	public String tela;
	public int acesso2;
	public int acesso3;
	public int acesso4;
	public int acesso5;

	private ControlAdmInstituicao controler = new ControlAdmInstituicao();

	public String entrada(String entrada, int arg){

		this.tela = new TelaManter().telaIni;

		switch(this.acesso2){
			case 0:
				switch(arg){
					//Retorna para tela inicial de Manter Cidade
					case 0:
						this.acesso2 = 0;
						this.tela = new TelaInicial().telaIni;
						break;
					//Vai para tela de selecionar dados para consulta
					case 1:
						this.tela = new TelaInstituicao().opcConsulta;
						this.acesso2 = 1;
						break;
					//Vai para tela de entrada de dados para cadastro
					case 2:
						this.tela = new TelaInstituicao().cadastro;
						this.acesso2 = 2;
						break;
					//Vai para tela de selecionar dados para edicao
					case 3:
						this.tela = new TelaInstituicao().opcEdicao;
						this.acesso2 = 3;
						break;
					//Vai para tela de entrada de dados para exclusao
					case 4:
						this.tela = new TelaInstituicao().entrada;
						this.acesso2 = 4;
						break;
					//Vai para tela de Listagem
					case 5:
						ArrayList<Instituicao> consulta = controler.listarInstituicoes();
						TelaInstituicao tela = new TelaInstituicao();
						tela.setTelaConsulta(consulta);
						this.tela = tela.telaConsulta;
						this.acesso2 = 5;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIniAdm;
						this.acesso2 = 0;
						break;
				}
				break;
			//Vai para tela de consulta da opcao selecionada
				case 1:
					switch(this.acesso3){
						case 0:
							switch(arg){
								case 0:
									this.acesso2 = 0;
									this.tela = new TelaManter().telaIni;
									break;
								case 1:
									this.acesso3 = 1;
									this.tela = new TelaInstituicao().consulta;
									break;
								case 2:
									this.acesso3 = 2;
									this.tela = new TelaInstituicao().consulta;
									break;
								case 3:
									this.acesso3 = 3;
									this.tela = new TelaInstituicao().consulta;
									break;
								default:
									this.tela = new TelaArgInvalido().telaIni;
									this.acesso2 = 0;
									break;
							}
							break;
						case 1:
							TelaInstituicao tela1 = new TelaInstituicao();
							tela1.setTelaConsulta(controler.consultarNome(entrada));
							this.tela =  tela1.telaConsulta;
							this.acesso3 = 4;
							break;
						case 2:
							TelaInstituicao tela2 = new TelaInstituicao();
							ArrayList<Instituicao> i = new ArrayList<Instituicao>();
							i.add(controler.consultarEndereco(entrada));
							tela2.setTelaConsulta(i);
							this.tela =  tela2.telaConsulta;
							this.acesso3 = 4;
							break;
						case 3:
							TelaInstituicao tela3 = new TelaInstituicao();
							tela3.setTelaConsulta(controler.consultarTelefone(entrada));
							this.tela =  tela3.telaConsulta;
							this.acesso3 = 4;
							break;
						case 4:
							this.tela =  new TelaManter().telaIni;
							this.acesso3 = 0;
							this.acesso2 = 0;
							break;
					}
					break;
				case 2:
					if(arg != 0){
						String regex = "(( , )|( ,)|(, )|(,))";
						ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
						if(controler.inserirInstituicao(entradas)){
							this.tela = new TelaFimOperacao().sucesso;
						}
						else{
							this.tela = new TelaFimOperacao().erro;
						}
					}
					else{
						this.tela = new TelaManter().telaIni;
						this.acesso2 = 0;
					}
					break;
				case 3:
					switch(this.acesso3){
						case 0:
							switch(arg){
								case 0:
									this.acesso3 = 0;
									this.acesso2 = 0;
									this.tela = new TelaManter().telaIni;
									break;
								case 1:
									this.acesso3 = 1;
									this.tela = new TelaInstituicao().entrada;
									break;
								case 2:
									this.acesso3 = 2;
									this.tela = new TelaInstituicao().entrada;
									break;
								case 3:
									this.acesso3 = 3;
									this.tela = new TelaInstituicao().entrada;
									break;
								case 4:
									this.acesso3 = 4;
									this.tela = new TelaInstituicao().entrada;
									break;
								case 5:
									this.acesso3 = 5;
									this.tela = new TelaInstituicao().entrada;
									break;
								default:
									this.tela = new TelaArgInvalido().telaIni;
									this.acesso2 = 0;
									break;
							}
							break;
						case 1:
							switch(this.acesso4){
								case 0:
									if(controler.consultarEndereco(entrada).getId() != 0){
										this.tela = new TelaManter().telaEdicao;
										this.acesso4 = 1;
									}
									break;
								case 1:
									if(arg != 0){
										if(controler.editarNome(entrada)){
											this.tela = new TelaFimOperacao().sucesso;
										}
										else{
											this.tela = new TelaFimOperacao().erro;	
										}
									}
									else{
										this.tela = new TelaManter().telaIni;
										this.acesso4 = 0;
										this.acesso2 = 0;
										this.acesso3 = 0;
									}
									break;
							}
							break;
						case 2:
							switch(this.acesso4){
								case 0:
									if(controler.consultarEndereco(entrada).getId() != 0){
										this.tela = new TelaManter().telaEdicao;
										this.acesso4 = 1;
									}
									break;
								case 1:
									if(arg != 0){
										if(controler.editarEndereco(entrada)){
											this.tela = new TelaFimOperacao().sucesso;
										}
										else{
											this.tela = new TelaFimOperacao().erro;	
										}
									}
									else{
										this.tela = new TelaManter().telaIni;
										this.acesso4 = 0;
										this.acesso2 = 0;
										this.acesso3 = 0;
									}
									break;
							}
							break;
						case 3:
							switch(this.acesso4){
								case 0:
									if(controler.consultarEndereco(entrada).getId() != 0){
										this.tela = new TelaManter().telaEdicao;
										this.acesso4 = 1;
									}
									break;
								case 1:
									if(arg != 0){
										if(controler.editarTelefone(entrada)){
											this.tela = new TelaFimOperacao().sucesso;
										}
										else{
											this.tela = new TelaFimOperacao().erro;	
										}
									}
									else{
										this.tela = new TelaManter().telaIni;
										this.acesso4 = 0;
										this.acesso2 = 0;
										this.acesso3 = 0;
									}
									break;
							}
							break;
						case 4:
							switch(this.acesso4){
								case 0:
									if(controler.consultarEndereco(entrada).getId() != 0){
										this.tela = new TelaManter().telaEdicao;
										this.acesso4 = 1;
									}
									break;
								case 1:
									if(arg != 0){
										String regex = "(( , )|( ,)|(, )|(,))";
										ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
										if(controler.editarIdCidade(entradas)){
											this.tela = new TelaFimOperacao().sucesso;
										}
										else{
											this.tela = new TelaFimOperacao().erro;	
										}
									}
									else{
										this.tela = new TelaManter().telaIni;
										this.acesso4 = 0;
										this.acesso2 = 0;
										this.acesso3 = 0;
									}
									break;
							}
							break;
						case 5:
							switch(this.acesso4){
								case 0:
									if(controler.consultarEndereco(entrada).getId() != 0){
										this.tela = new TelaManter().telaEdicao;
										this.acesso4 = 1;
									}
									break;
								case 1:
									if(arg != 0){
										if(controler.editarValidacao(entrada)){
											this.tela = new TelaFimOperacao().sucesso;
										}
										else{
											this.tela = new TelaFimOperacao().erro;	
										}
									}
									else{
										this.tela = new TelaManter().telaIni;
										this.acesso4 = 0;
										this.acesso2 = 0;
										this.acesso3 = 0;
									}
									break;
							}
							break;		
					}
					break;
				case 4:
					if(arg != 0){
						if(controler.consultarEndereco(entrada).getId() != 0) {
							if(controler.excluirInstituicao()){
								this.tela = new TelaFimOperacao().sucessoExcluir;
							}
							else{
								this.tela = new TelaFimOperacao().erroExcluir;
							}
						}
						else {
							this.tela = new TelaFimOperacao().erroExcluir;
						}
					}
					else if (arg == 0){
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