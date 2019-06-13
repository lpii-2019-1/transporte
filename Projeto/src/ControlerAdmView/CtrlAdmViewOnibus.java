package controlerAdmView;

import java.util.ArrayList;
import java.util.Arrays;

import controlAdm.*;
import view.*;
import viewAdministrador.*;
import model.*;


public class CtrlAdmViewOnibus{
	public String tela;
	public int acesso2;
	public int acesso3;
	public int acesso4;
	public int acesso5;
	public int acesso6;

	private ControlAdmOnibus controler = new ControlAdmOnibus();
	private ControlAdmRota controlerRota = new ControlAdmRota();
	private ControlAdmPontoRota controlerPonto = new ControlAdmPontoRota();
	private ControlAdmInstituicaoRota controlerInstituicao = new ControlAdmInstituicaoRota();
	private ControlAdmHorario controlerHorario = new ControlAdmHorario();

	public String entrada(String entrada, int arg){

		this.tela = new TelaOnibus().manterOnibus;

		switch(this.acesso2){
			case 0:
				switch(arg){
					case 0:
						this.acesso2 = 0;
						this.tela = new TelaInicial().telaIni;
						break;
					case 1:
						this.tela = new TelaOnibus().opcConsulta;
						this.acesso2 = 1;
						break;
					case 2:
						this.tela = new TelaOnibus().cadastro;
						this.acesso2 = 2;
						break;
					case 3:
						this.tela = new TelaOnibus().opcEdicao;
						this.acesso2 = 3;
						break;
					case 4:
						this.tela = new TelaOnibus().entrada;
						this.acesso2 = 6;
						break;
					case 5:
						this.tela = new TelaOnibus().entrada;
						this.acesso2 = 4;
						break;
					case 6:
						TelaOnibus tela = new TelaOnibus();
						tela.setTelaConsulta(controler.listarTodosOnibus());
						this.tela = tela.telaConsulta;
						this.acesso2 = 5;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso2 = 0;
						break;
				}
				break;
			case 1:
				switch(this.acesso3){
					case 0:
						switch(arg){
							case 0:
								this.acesso2 = 0;
								this.tela = new TelaOnibus().manterOnibus;
								break;
							case 1:
								this.tela = new TelaOnibus().consulta;
								this.acesso3 = 1;
								break;
							case 2:
								this.tela = new TelaOnibus().consulta;
								this.acesso3 = 2;
								break;
							case 3:
								this.tela = new TelaOnibus().consulta;
								this.acesso3 = 3;
								break;
							case 4:
								this.tela = new TelaOnibus().consulta;
								this.acesso3 = 4;
								break;
							case 5:
								this.tela = new TelaOnibus().consulta;
								this.acesso3 = 5;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = 0;
								break;
						}
						break;
					case 1:
						TelaOnibus tela1 = new TelaOnibus();
						ArrayList<Onibus> o = new ArrayList<Onibus>();
						o.add(controler.consultarPlaca(entrada));
						tela1.setTelaConsulta(o);
						this.tela = tela1.telaConsulta;
						this.acesso3 = 6;
						break;
					case 2:
						TelaOnibus tela2 = new TelaOnibus();
						tela2.setTelaConsulta(controler.consultarCor(entrada));
						this.tela = tela2.telaConsulta;
						this.acesso3 = 6;
						break;
					case 3:
						TelaOnibus tela3 = new TelaOnibus();
						tela3.setTelaConsulta(controler.consultarMotorista(entrada));
						this.tela = tela3.telaConsulta;
						this.acesso3 = 6;
						break;
					case 4:
						TelaOnibus tela4 = new TelaOnibus();
						tela4.setTelaConsulta(controler.consultarTelefone(entrada));
						this.tela = tela4.telaConsulta;
						this.acesso3 = 6;
						break;
					case 5:
						TelaOnibus tela5 = new TelaOnibus();
						tela5.setTelaConsulta(controler.consultarMensalidade(entrada));
						this.tela = tela5.telaConsulta;
						this.acesso3 = 6;
						break;
					case 6:
						this.tela = new TelaOnibus().manterOnibus;
						this.acesso3 = 0;
						this.acesso2 = 0;
						break;
				}
				break;
			case 2:
				if(arg != 0){
					String regex = "(( , )|( ,)|(, )|(,))";
					ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
					if(controler.inserirOnibus(entradas)){
						this.tela = new TelaFimOperacao().sucesso;
					}
					else{
						this.tela = new TelaFimOperacao().erro;
					}
				}
				else if (arg == 0){
					this.tela = new TelaOnibus().manterOnibus;
					this.acesso2 = 0;
				}
			case 3:
				switch(this.acesso3){
					case 0:
						switch(arg){
							case 0:
								this.acesso2 = 0;
								this.tela = new TelaOnibus().manterOnibus;
								break;
							case 1:
								this.acesso3 = 1;
								this.tela = new TelaOnibus().entrada;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaOnibus().entrada;
								break;
							case 3:
								this.acesso3 = 3;
								this.tela = new TelaOnibus().entrada;
								break;
							case 4:
								this.acesso3 = 4;
								this.tela = new TelaOnibus().entrada;
								break;
							case 5:
								this.acesso3 = 5;
								this.tela = new TelaOnibus().entrada;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIniAdm;
								this.acesso2 = 0;
								this.acesso3 = 0;
								break;
						}
						break;
					case 1:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
									this.acesso4 = 1;
								}
								else{
									TelaOnibus tela = new TelaOnibus();
									ArrayList<Onibus> o = new ArrayList<Onibus>();
									o.add(controler.getOnibusSelecionado());
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarPlaca(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso2 = 0;
									this.acesso3 = 0;
									this.acesso4 = 0;
								}
								break;
						}
						break;
					case 2:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
									this.acesso4 = 1;
								}
								else{
									TelaOnibus tela = new TelaOnibus();
									ArrayList<Onibus> o = new ArrayList<Onibus>();
									o.add(controler.getOnibusSelecionado());
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarCor(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso2 = 0;
									this.acesso3 = 0;
									this.acesso4 = 0;
								}
								break;
						}
						break;
					case 3:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
									this.acesso4 = 1;
								}
								else{
									TelaOnibus tela = new TelaOnibus();
									ArrayList<Onibus> o = new ArrayList<Onibus>();
									o.add(controler.getOnibusSelecionado());
									tela.setTelaConsulta(o);
									this.tela =  tela.telaConsulta;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarMotorista(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
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
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
									this.acesso4 = 1;
								}
								else{
									TelaOnibus tela = new TelaOnibus();
									ArrayList<Onibus> o = new ArrayList<Onibus>();
									o.add(controler.getOnibusSelecionado());
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarMensalidade(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso2 = 0;
									this.acesso3 = 0;
									this.acesso4 = 0;
								}
								break;
						}
						break;
					case 5:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
									this.acesso4 = 1;
								}
								else{
									TelaOnibus tela = new TelaOnibus();
									ArrayList<Onibus> o = new ArrayList<Onibus>();
									o.add(controler.getOnibusSelecionado());
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
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
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso2 = 0;
									this.acesso3 = 0;
								}
								break;
						}
						break;
					case 6:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
									this.acesso4 = 1;
								}
								else{
									TelaOnibus tela = new TelaOnibus();
									ArrayList<Onibus> o = new ArrayList<Onibus>();
									o.add(controler.getOnibusSelecionado());
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
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
									this.tela = new TelaOnibus().manterOnibus;
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
					if(controler.consultarPlaca(entrada).getId() != 0){
						if(controler.excluirOnibus()){
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
					this.tela = new TelaOnibus().manterOnibus;
					this.acesso2 = 0;
				}
				break;
			case 5:
				if (arg == 0){
					this.tela = new TelaOnibus().manterOnibus;
					this.acesso2 = 0;
				}
				break;
			case 6:
				switch(this.acesso3){
					case -1:
						switch(arg){
							case 1:
								this.acesso3 = 1;
								this.tela = new TelaRota().opcConsulta;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaRota().entrada;
								break;
							case 3:
								this.acesso3 = 3;
								this.tela = new TelaRota().opcEdicao;
								break;
							case 4:
								this.acesso3 = 6;
								this.tela = new TelaRota().entrada;
								break;
							case 5:
								this.acesso3 = 7;
								this.tela = new TelaRota().entrada;
								break;
							case 6:
								this.acesso3 = 8;
								this.tela = new TelaRota().entrada;
								break;
							case 7:
								this.acesso3 = 4;
								this.tela = new TelaRota().entrada;
								break;
							case 8:
								this.acesso3 = 5;
								TelaRota tela = new TelaRota();
								tela.setTelaConsulta(controlerRota.listarRotas());
								this.tela = tela.telaConsulta;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso3 = 0;
								this.acesso2 = 0;
								break;
						}
						break;
					case 0:
						if(controler.consultarPlaca(entrada).getId() != 0){
							controlerRota.setOnibusSelecionado(controler.consultarPlaca(entrada));
							this.tela = new TelaRota().manterRota;
							this.acesso3 = -1;
						}
						else{
							TelaOnibus tela = new TelaOnibus();
							ArrayList<Onibus> o = new ArrayList<Onibus>();
							o.add(controler.getOnibusSelecionado());
							tela.setTelaConsulta(o);
							this.tela = tela.telaConsulta;
							this.acesso2 = 0;
							this.acesso3 = 0;
						}
						break;
					case 1:
						switch(this.acesso4){
							case 0:
								switch(arg){
									case 0:
										this.tela = new TelaOnibus().manterOnibus;
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										break;
									case 1:
										this.tela = new TelaRota().consulta;
										this.acesso4 = 2;
										break;
									case 2:
										this.tela = new TelaRota().consulta;
										this.acesso4 = 2;
										break;
									case 3:
										this.tela = new TelaRota().consulta;
										this.acesso4 = 3;
										break;
									case 4:
										this.tela = new TelaRota().consulta;
										this.acesso4 = 4;
										break;
									case 5:
										this.tela = new TelaRota().consulta;
										this.acesso4 = 5;
										break;
									case 6:
										this.tela = new TelaRota().consulta;
										this.acesso4 = 6;
										break;
									case 7:
										this.tela = new TelaRota().consulta;
										this.acesso4 = 7;
									default:
										this.tela = new TelaArgInvalido().telaIni;
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										break;
								}
								break;
							case 1:
								TelaRota tela = new TelaRota();
								ArrayList<Rota> r = new ArrayList<Rota>();
								r.add(controlerRota.consultarIdentificador(entrada));
								tela.setTelaConsulta(r);
								this.tela =  tela.telaConsulta;
								this.acesso4 = 8;
								break;
							case 2:
								TelaRota tela1 = new TelaRota();
								tela1.setTelaConsulta(controlerRota.consultarInicio(entrada));
								this.tela =  tela1.telaConsulta;
								this.acesso4 = 8;
								break;
							case 3:
								TelaRota tela2 = new TelaRota();
								tela2.setTelaConsulta(controlerRota.consultarFim(entrada));
								this.tela =  tela2.telaConsulta;
								this.acesso4 = 8;
								break;
							case 4:
								TelaRota tela3 = new TelaRota();
								tela3.setTelaConsulta(controlerRota.consultarPercurso(entrada));
								this.tela =  tela3.telaConsulta;
								this.acesso4 = 8;
								break;
							case 5:
								TelaRota tela4 = new TelaRota();
								tela4.setTelaConsulta(controlerRota.consultarPonto(entrada));
								this.tela =  tela4.telaConsulta;
								this.acesso4 = 8;
								break;
							case 6:
								TelaRota tela5 = new TelaRota();
								tela5.setTelaConsulta(controlerRota.consultarInstituicao(entrada));
								this.tela =  tela5.telaConsulta;
								this.acesso4 = 8;
								break;
							case 7:
								TelaRota tela6 = new TelaRota();
								tela6.setTelaConsulta(controlerRota.consultarTurno(entrada));
								this.tela =  tela6.telaConsulta;
								this.acesso4 = 8;
								break;
							case 8:
								this.tela = new TelaOnibus().manterOnibus;
								this.acesso4 = 0;
								this.acesso3 = 0;
								this.acesso2 = 0;
								break;
						}
						break;
					case 2:
						if(arg != 0){
							String regex = "(( , )|( ,)|(, )|(,))";
							ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
							if(controlerRota.inserirRota(entradas)){
								this.tela = new TelaFimOperacao().sucesso;
							}
							else{
								this.tela = new TelaFimOperacao().erro;
							}
						}else{
							this.tela = new TelaOnibus().manterOnibus;
							this.acesso2 = 0;
							this.acesso3 = 0;
							this.acesso4 = 0;
						}
						break;
					case 3:
						switch(this.acesso5){
							case 0:
								switch(arg){
									case 0:
										this.acesso5 = 0;
										this.acesso4 = 0;
										this.acesso2 = 0;
										this.acesso2 = 0;
										this.tela = new TelaOnibus().manterOnibus;
										break;
									case 1:
										this.acesso5 = 1;
										this.tela = new TelaManter().telaEdicao;
										break;
									case 2:
										this.acesso5 = 2;
										this.tela = new TelaManter().telaEdicao;
										break;
									case 3:
										this.acesso5 = 3;
										this.tela = new TelaManter().telaEdicao;
										break;
									case 4:
										this.acesso5 = 4;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIni;
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										break;
								}
								break;
							case 1:
								switch(this.acesso6){
									case 0:
										if(controlerRota.consultarIdentificador(entrada).getId() != 0){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarInicio(entrada)){
												this.tela = new TelaFimOperacao().sucesso;
											}
											else{
												this.tela = new TelaFimOperacao().erro;	
											}
										}
										else{
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso6 = 0;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
							case 2:
								switch(this.acesso6){
									case 0:
										if(controlerRota.consultarIdentificador(entrada).getId() != 0){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarFim(entrada)){
												this.tela = new TelaFimOperacao().sucesso;
											}
											else{
												this.tela = new TelaFimOperacao().erro;	
											}
										}
										else{
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso6 = 0;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
							case 3:
								switch(this.acesso6){
									case 0:
										if(controlerRota.consultarIdentificador(entrada).getId() != 0){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarPercurso(entrada)){
												this.tela = new TelaFimOperacao().sucesso;
											}
											else{
												this.tela = new TelaFimOperacao().erro;	
											}
										}
										else{
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso6 = 0;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
							case 4:
								switch(this.acesso6){
									case 0:
										if(controlerRota.consultarIdentificador(entrada).getId() != 0){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarValidacao(entrada)){
												this.tela = new TelaFimOperacao().sucesso;
											}
											else{
												this.tela = new TelaFimOperacao().erro;	
											}
										}
										else{
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso6 = 0;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
						}
						break;
					case 4:
						if(arg != 0){
							if(controlerRota.consultarIdentificador(entrada).getId() != 0) {
								if(controlerRota.excluirRota()){
									this.tela = new TelaFimOperacao().sucesso;
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
							this.tela = new TelaOnibus().manterOnibus;
							this.acesso5 = 0;
							this.acesso4 = 0;
							this.acesso3 = 0;
							this.acesso2 = 0;
						}
						break;
					case 5:
						if(arg != 0){
							TelaRota tela = new TelaRota();
							tela.setTelaConsulta(controlerRota.listarRotas());
							this.tela = tela.telaConsulta;
						}
						else if (arg == 0){
							this.tela = new TelaOnibus().manterOnibus;
							this.acesso5 = 0;
							this.acesso4 = 0;
							this.acesso3 = 0;
							this.acesso2 = 0;
						}
						break;
					//------------------------------------------------Manter Ponto----------------------------------
					case 6:
						switch(this.acesso4){
							case -1:
								switch(arg){
									case 0:
										this.tela = new TelaOnibus().manterOnibus;
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										break;
									case 1:
										this.tela = new TelaPontoRota().opcConsulta;
										this.acesso4 = 1;
										break;
									case 2:
										this.tela = new TelaPontoRota().cadastro;
										this.acesso4 = 2;
										break;
									case 3:
										this.tela = new TelaPontoRota().opcEdicao;
										this.acesso4 = 3;
										break;
									case 4:
										this.tela = new TelaPontoRota().entrada;
										this.acesso4 = 4;
										break;
									case 5:
										TelaPontoRota tela = new TelaPontoRota();
										tela.setTelaConsulta(controlerPonto.listarPontos());
										this.acesso4 = 5;
										break;
									default:

										break;
								}
								break;
							case 0:
								if(controlerRota.consultarIdentificador(entrada).getId() != 0){
									this.tela = new TelaPontoRota().manterPonto;
									this.acesso4 = -1;
								}
								else{
									ArrayList<Rota> r = new ArrayList<Rota>();
									r.add(controlerRota.getRotaSelecionada());
									TelaRota tela = new TelaRota();
									tela.setTelaConsulta(r);
									this.tela = tela.telaConsulta;
								}
								break;
							case 1:
								switch(this.acesso5){
									case 0:
										switch(arg){
											case 0:
												this.tela = new TelaOnibus().manterOnibus;
												this.acesso5 = 0;
												this.acesso4 = 0;
												this.acesso3 = 0;
												this.acesso2 = 0;
												break;
											case 1:
												this.acesso5 = 1;
												this.tela = new TelaPontoRota().consulta;
												break;
											case 2:
												this.acesso5 = 1;
												this.tela = new TelaPontoRota().consulta;
												break;
										}
										break;
									case 1:
										if(arg != 0){
											TelaPontoRota tela = new TelaPontoRota();
											tela.setTelaConsulta(controlerPonto.consultarOrdem(entrada));
											this.tela = tela.telaConsulta;
										}
										else{
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
									case 2:
										if(arg != 0){
											TelaPontoRota tela = new TelaPontoRota();
											ArrayList<Ponto> p = new ArrayList<Ponto>();
											p.add(controlerPonto.consultarEndereco(entrada));
											tela.setTelaConsulta(p);
											this.tela = tela.telaConsulta;
										}
										else{
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
							case 2:
								if(arg != 0){
									String regex = "(( , )|( ,)|(, )|(,))";
									ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
									if(controlerPonto.inserirPonto(entradas)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().sucesso;
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
								//===============Editar Ponto==============
							case 3:
								switch(this.acesso5){
									case 0:
										switch(arg){
											case 0:
												this.tela = new TelaOnibus().manterOnibus;
												this.acesso5 = 0;
												this.acesso4 = 0;
												this.acesso3 = 0;
												this.acesso2 = 0;
												break;
											case 1:
												this.acesso5 = 1;
												this.tela = new TelaManter().telaEdicao;
												break;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerPonto.editarOrdem(entrada)){
												this.tela = new TelaFimOperacao().sucesso;
											}
											else{
												this.tela = new TelaFimOperacao().erro;
											}
										}
										else{
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
								//======================Excluir Ponto===============
							case 4:
								if(arg != 0){
									if(controlerPonto.consultarEndereco(entrada).getId() != 0) {
										if(controlerPonto.excluirPonto()){
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
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 5:
								if(arg != 0){
									TelaPontoRota tela = new TelaPontoRota();
									tela.setTelaConsulta(controlerPonto.listarPontos());
									this.tela = tela.telaConsulta;
								}
								else if (arg == 0){
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso5 = 0;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;

						}
						break;
					//------------------------------------------------Manter Instituicao----------------------------------
					case 7:
						switch(this.acesso4){
							case -1:
								switch(arg){
									case 0:
										this.tela = new TelaOnibus().manterOnibus;
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										break;
									case 1:
										this.tela = new TelaInstituicao().opcConsulta;
										this.acesso4 = 1;
										break;
									case 2:
										this.tela = new TelaInstituicao().entrada;
										this.acesso4 = 2;
										break;
									case 3:
										TelaInstituicao tela = new TelaInstituicao();
										tela.setTelaConsulta(controlerInstituicao.listarInstituicoes());
										this.tela = tela.telaConsulta;
										this.acesso4 = 4;
										break;
									default:

										break;
								}
								break;
							case 0:
								if(controlerRota.consultarIdentificador(entrada).getId() != 0){
									controlerInstituicao.setRotaSelecionada(controlerRota.consultarIdentificador(entrada));
									this.tela = new TelaInstituicao().manterInstituicao;
									this.acesso4 = -1;
								}
								else{
									ArrayList<Rota> r = new ArrayList<Rota>();
									r.add(controlerRota.getRotaSelecionada());
									TelaRota tela = new TelaRota();
									tela.setTelaConsulta(r);
									this.tela = tela.telaConsulta;
								}
								break;
							case 1:
								switch(this.acesso5){
									case 0:
										switch(arg){
											case 0:
												this.tela = new TelaOnibus().manterOnibus;
												this.acesso5 = 0;
												this.acesso4 = 0;
												this.acesso3 = 0;
												this.acesso2 = 0;
												break;
											case 1:
												this.tela = new TelaInstituicao().consulta;
												this.acesso5 = 1;
												break;
											case 2:
												this.tela = new TelaInstituicao().consulta;
												this.acesso5 = 2;
												break;
											case 3:
												this.tela = new TelaInstituicao().consulta;
												this.acesso5 = 3;
												break;
											default:

												break;
										}
										break;
									case 1:
										if(arg != 0){
											TelaInstituicao tela = new TelaInstituicao();
											tela.setTelaConsulta(controlerInstituicao.consultarNome(entrada));
											this.tela = tela.telaConsulta;
										}
										else if (arg == 0){
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
									case 2:
										if(arg != 0){
											TelaInstituicao tela = new TelaInstituicao();
											ArrayList<Instituicao> i = new ArrayList<Instituicao>();
											i.add(controlerInstituicao.consultarEndereco(entrada));
											tela.setTelaConsulta(i);
											this.tela = tela.telaConsulta;
										}
										else if (arg == 0){
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
									case 3:
										if(arg != 0){
											TelaInstituicao tela = new TelaInstituicao();
											tela.setTelaConsulta(controlerInstituicao.consultarTelefone(entrada));
											this.tela = tela.telaConsulta;
										}
										else if (arg == 0){
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
							case 2:
								if(arg != 0){
									if(controlerInstituicao.inserirInstituicao(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().sucesso;
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 3:
								if(arg != 0){
									if(controlerInstituicao.consultarEndereco(entrada).getId() != 0) {
										if(controlerInstituicao.excluirInstituicao()){
											this.tela = new TelaFimOperacao().sucesso;
										}
										else{
											this.tela = new TelaFimOperacao().sucesso;
										}
									}
									else {
										this.tela = new TelaFimOperacao().sucesso;
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 4:
								if(arg != 0){
									TelaInstituicao tela = new TelaInstituicao();
									tela.setTelaConsulta(controlerInstituicao.listarInstituicoes());
									this.tela = tela.telaConsulta;
								}
								else if (arg == 0){
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso5 = 0;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;

						}
						break;
					//------------------------------------------------Manter Horario----------------------------------
					case 8:
						switch(this.acesso4){
							case -1:
								switch(arg){
									case 0:
										this.tela = new TelaOnibus().manterOnibus;
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										break;
									case 1:
										this.tela = new TelaHorario().opcConsulta;
										this.acesso4 = 1;
										break;
									case 2:
										this.tela = new TelaHorario().cadastro;
										this.acesso4 = 2;
										break;
									case 3:
										this.tela = new TelaHorario().opcEdicao;
										this.acesso4 = 3;
										break;
									case 4:
										this.tela = new TelaHorario().entrada;
										this.acesso4 = 4;
										break;
									case 5:
										TelaHorario tela = new TelaHorario();
										tela.setTelaConsulta(controlerHorario.listarHorarios());
										this.tela = tela.telaConsulta;
										this.acesso4 = 5; 
										break;
									default:

										break;
								}
								break;
							case 0:
								if(controlerRota.consultarIdentificador(entrada).getId() != 0){
									controlerHorario.setRotaSelecionada(controlerRota.consultarIdentificador(entrada));
									this.tela = new TelaManter().telaIni;
									this.acesso4 = -1;
								}
								else{
									ArrayList<Rota> r = new ArrayList<Rota>();
									r.add(controlerRota.getRotaSelecionada());
									TelaRota tela = new TelaRota();
									tela.setTelaConsulta(r);
									this.tela = tela.telaConsulta;
								}
								break;
								//==================Consultar Horario=================
							case 1:
								switch(this.acesso5){
									case 0:
										switch(arg){
											case 0:
												this.tela = new TelaOnibus().manterOnibus;
												this.acesso5 = 0;
												this.acesso4 = 0;
												this.acesso3 = 0;
												this.acesso2 = 0;
												break;
											case 1:
												this.tela = new TelaHorario().consulta;
												this.acesso5 = 1;
												break;
											case 2:
												this.tela = new TelaHorario().consulta;
												this.acesso5 = 2;
												break;
											case 3:
												this.tela = new TelaHorario().consulta;
												this.acesso5 = 3;
												break;
											default:

												break;
										}
										break;
									case 1:
										if(arg != 0){
											TelaHorario tela = new TelaHorario();
											tela.setTelaConsulta(controlerHorario.consultarHrSaida(entrada));
											this.tela = tela.telaConsulta;
										}
										else if (arg == 0){
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
									case 2:
										if(arg != 0){
											TelaHorario tela = new TelaHorario();
											tela.setTelaConsulta(controlerHorario.consultarHrRegresso(entrada));
											this.tela = tela.telaConsulta;
										}
										else if (arg == 0){
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
									case 3:
										if(arg != 0){
											TelaHorario tela = new TelaHorario();
											tela.setTelaConsulta(controlerHorario.consultarTurno(entrada));
											this.tela = tela.telaConsulta;
										}
										else if (arg == 0){
											this.tela = new TelaOnibus().manterOnibus;
											this.acesso5 = 0;
											this.acesso4 = 0;
											this.acesso3 = 0;
											this.acesso2 = 0;
										}
										break;
								}
								break;
							case 2:							
								if(arg != 0){
									String regex = "(( , )|( ,)|(, )|(,))";
									ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
									if(controlerHorario.inserirHorario(entradas)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;
									}
								}
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
								//=================Editar Horario=================
							case 3:
								switch(this.acesso5){
									case 0:
										switch(arg){
											case 0:
												this.tela = new TelaOnibus().manterOnibus;
												this.acesso5 = 0;
												this.acesso4 = 0;
												this.acesso3 = 0;
												this.acesso2 = 0;
												break;
											case 1:
												this.acesso5 = 1;
												this.tela = new TelaManter().telaEdicao;
												break;
											case 2:
												this.acesso5 = 2;
												this.tela = new TelaManter().telaEdicao;
												break;
											case 3:
												this.acesso5 = 3;
												this.tela = new TelaManter().telaEdicao;
												break;
										}
										break;
									case 1:
										switch(this.acesso6){
											case 0:
												this.tela = new TelaManter().telaEdicao;
												this.acesso6 = 1;
												break;
											case 1:
												if(arg != 0){
													if(controlerHorario.editarHrSaida(entrada)){
														this.tela = new TelaFimOperacao().sucesso;
													}
													else{
														this.tela = new TelaFimOperacao().erro;
													}
												}
												else{
													this.tela = new TelaOnibus().manterOnibus;
													this.acesso6 = 0;
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.acesso3 = 0;
													this.acesso2 = 0;
												}
												break;
										}
										break;
									case 2:
										switch(this.acesso6){
											case 0:
												this.tela = new TelaManter().telaEdicao;
												this.acesso6 = 1;
												break;
											case 1:
												if(arg != 0){
													if(controlerHorario.editarHrRegresso(entrada)){
														this.tela = new TelaFimOperacao().sucesso;
													}
													else{
														this.tela = new TelaFimOperacao().erro;
													}
												}
												else{
													this.tela = new TelaOnibus().manterOnibus;
													this.acesso6 = 0;
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.acesso3 = 0;
													this.acesso2 = 0;
												}
												break;
										}
										break;
									case 3:
										switch(this.acesso6){
											case 0:
												this.tela = new TelaManter().telaEdicao;
												this.acesso6 = 1;
												break;
											case 1:
												if(arg != 0){
													if(controlerHorario.editarValidacao(entrada)){
														this.tela = new TelaFimOperacao().sucesso;
													}
													else{
														this.tela = new TelaFimOperacao().erro;
													}
												}
												else{
													this.tela = new TelaOnibus().manterOnibus;
													this.acesso6 = 0;
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.acesso3 = 0;
													this.acesso2 = 0;
												}
												break;
										}
										break;
								}
								break;
								//=================Excluir Horario=================
							case 4:
								if(arg != 0){
									String regex = "(( , )|( ,)|(, )|(,))";
									ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
									if(controlerHorario.consultarHrSaidaRegresso(entradas).getId() != 0) {
										if(controlerHorario.excluirHorario()){
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
								else{
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 5:
								if(arg != 0){
									TelaHorario tela = new TelaHorario();
									tela.setTelaConsulta(controlerHorario.listarHorarios());
									this.tela = tela.telaConsulta;
								}
								else if (arg == 0){
									this.tela = new TelaOnibus().manterOnibus;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
						}
						break;
				}
				break;
		}
		return this.tela;
	}
}