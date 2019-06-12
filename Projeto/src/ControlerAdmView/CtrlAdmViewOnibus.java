package controlerAdmView;

import controlAdm.ControlAdmOnibus;
import view.*;
import viewAdministrador.TelaManter;
import viewAdministrador.TelaInicial;
import viewAdministrador.TelaOnibus;
import viewAdministrador.TelaRota;
import viewAdministrador.TelaHorario;
import viewAdministrador.TelaPonto;

public class CtrlAdmViewOnibus{
	public String tela;
	public int acesso2;
	public int acesso3;
	public int acesso4;
	public int acesso5;

	private ControlAdmOnibus controler = new ControlAdmOnibus();

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
						ArrayList<Onibus> consulta = controler.listarOnibuss();
						TelaOnibus tela = new TelaOnibus();
						tela.setTelaConsulta(consulta);
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
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = 0;
								break;
						}
						break;
					case 1:
						TelaOnibus tela = new TelaOnibus();
						ArrayList<Onibus> o = new ArrayList<Onibus>();
						o.add(controler.getCidadeSelecionada())
						tela.setTelaConsulta(o);
						this.tela =  tela2.telaConsulta;
						break;
					case 2:
						TelaOnibus tela2 = new TelaOnibus();
						tela2.setTelaConsulta(controler.consultarCorOnibus(entrada));
						this.tela =  tela2.telaConsulta;
						break;
					case 3:
						TelaOnibus tela3 = new TelaOnibus();
						tela3.setTelaConsulta(controler.consultarMotoristaOnibus(entrada));
						this.tela =  tela3.telaConsulta;
						break;
					case 4:
						TelaOnibus tela3 = new TelaOnibus();
						tela3.setTelaConsulta(controler.consultarTelefoneOnibus(entrada));
						this.tela =  tela3.telaConsulta;
						break;
					case 5:
						TelaOnibus tela3 = new TelaOnibus();
						tela3.setTelaConsulta(controler.consultarMensalidadeOnibus(entrada));
						this.tela =  tela3.telaConsulta;
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
						this.acesso2 = 0;
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
								this.tela = new TelaManter().telaEdicao;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaManter().telaEdicao;
								break;
							case 3:
								this.acesso3 = 3;
								this.tela = new TelaManter().telaEdicao;
								break;
							case 4:
								this.acesso3 = 4;
								this.tela = new TelaManter().telaEdicao;
								break;
							case 5:
								this.acesso3 = 5;
								this.tela = new TelaManter().telaEdicao;
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
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
									this.acesso4 = 1;
								}
								else{
									TelaOnibus tela = new TelaOnibus();
									ArrayList<Onibus> o = new ArrayList<Onibus>();
									o.add(controler.getCidadeSelecionada())
									tela.setTelaConsulta(o);
									this.tela =  tela2.telaConsulta;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarPlacaOnibus(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
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
									o.add(controler.getCidadeSelecionada())
									tela.setTelaConsulta(o);
									this.tela =  tela2.telaConsulta;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarCorOnibus(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
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
									o.add(controler.getCidadeSelecionada())
									tela.setTelaConsulta(o);
									this.tela =  tela2.telaConsulta;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarMotoristaOnibus(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
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
									o.add(controler.getCidadeSelecionada())
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarMensalidadeOnibus(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
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
									o.add(controler.getCidadeSelecionada())
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarTelefoneOnibus(entrada)){
										this.tela = new TelaFimOperacao().sucesso;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
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
									o.add(controler.getCidadeSelecionada())
									tela.setTelaConsulta(o);
									this.tela = tela.telaConsulta;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
							case 1:
								if(arg != 0){
									if(controler.editarValidacaoOnibus(entrada)){
										this.tela = new TelaFimOperacao.sucesso;
									}
									else{
										this.tela = new TelaFimOperacao.erro;	
									}
								else{
									this.tela = new TelaManter.telaIni;
									this.acesso2 = 0;
									this.acesso3 = 0;
								}
								break;
						}
						break;
				}
				break;
			case 4;
				if(arg != 0){
					if(controler.excluirOnibus(entrada)){
						this.tela = new TelaFimOperacao().sucesso;
					}
					else{
						this.tela = new TelaFimOperacao().erroExcluir;
						this.acesso2 = 0;
					}
				}
				else if (arg == 0){
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
								this.tela = new TelaRota().opcEdicao
								break;
							case 4:
								this.acesso3 = 6;
								this.tela = new TelaRota().
								break;
							case 5:
								this.acesso3 = 7;
								this.tela = new TelaRota().
								break;
							case 6:
								this.acesso3 = 8;
								this.tela = new TelaRota().
								break;
							case 7:
								this.acesso3 = 4;
								this.tela = new TelaRota().entrada;
								break;
							case 8:
								this.acesso3 = 5;
								TelaRota tela = new TelaRota();
								tela.setTelaConsulta(controlerRota.listarRotas(entrada));
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
						if(controler.consultarPlacaOnibus(entrada).getId() != 0){
							this.tela = new TelaRota().manterRota;
							this.acesso3 = -1;
						}
						else{
							TelaOnibus tela = new TelaOnibus();
							ArrayList<Onibus> o = new ArrayList<Onibus>();
							o.add(controler.getCidadeSelecionada())
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

										break;
									case 1:
										this.tela = new TelaManter().entrada;
										this.acesso4 = 1;
										break;
									case 2:
										this.tela = new TelaManter().entrada;
										this.acesso4 = 2;
										break;
									case 3:
										this.tela = new TelaManter().entrada;
										this.acesso4 = 3;
										break;
									case 4:
										this.tela = new TelaManter().entrada;
										this.acesso4 = 4;
										break;
									case 5:
										this.tela = new TelaManter().entrada;
										this.acesso4 = 5;
										break;
									case 6:
										this.tela = new TelaManter().entrada;
										this.acesso4 = 6;
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
								TelaInstituicao tela1 = new TelaInstituicao();
								tela1.setTelaConsulta(controler.controlerRota.consultarInicio(entrada));
								this.tela =  tela1.telaConsulta;
								break;
							case 2:
								TelaInstituicao tela2 = new TelaInstituicao();
								tela2.setTelaConsulta(controler.controlerRota.consultarFim(entrada));
								this.tela =  tela2.telaConsulta;
								break;
							case 3:
								TelaInstituicao tela3 = new TelaInstituicao();
								tela3.setTelaConsulta(controler.controlerRota.consultarPercurso(entrada));
								this.tela =  tela3.telaConsulta;
								break;
							case 4:
								TelaInstituicao tela4 = new TelaInstituicao();
								tela4.setTelaConsulta(controler.controlerRota.consultarPonto(entrada));
								this.tela =  tela4.telaConsulta;
								break;
							case 5:
								TelaInstituicao tela5 = new TelaInstituicao();
								tela5.setTelaConsulta(controler.controlerRota.consultarInstituicao(entrada));
								this.tela =  tela5.telaConsulta;
								break;
							case 6:
								TelaInstituicao tela6 = new TelaInstituicao();
								tela6.setTelaConsulta(controler.controlerRota.consultarTurno(entrada));
								this.tela =  tela6.telaConsulta;
								break;
						}
						break;
					case 2:
						String regex = "(( , )|( ,)|(, )|(,))";
						ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
						if(arg != 0){
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
										if(controlerRota.controlerIndentificador(entrada)){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarInicio(entrada){
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
										if(controlerRota.controlerIndentificador(entrada)){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarFim(entrada){
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
										if(controlerRota.controlerIndentificador(entrada)){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarPercurso(entrada){
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
										if(controlerRota.controlerIndentificador(entrada)){
											this.acesso6 = 1;
											this.tela = new TelaManter().telaEdicao;
										}
										break;
									case 1:
										if(arg != 0){
											if(controlerRota.editarValidacao(entrada){
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
							if(controlerRota.excluirRota(entrada)){
								this.tela = new TelaFimOperacao().sucesso;
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
							tela.setConsulta(controler.listarRota());
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
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 2:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 3:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 4:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 5:
										this.tela = new Tela().opcEdicaoRota;
										this.acesso5
										break;
									default:

										break;
								}
								break;
							case 0:
								if(controlerRota.consultarIndentificador(entrada).getId() != 0){
									this.tela = new TelaPoto().manterPonto;
									this.acesso4 = -1;
								}
								else{
									ArrayList<Rota> r = new ArrayList<Rota>();
									r.add(controladorRota.getRotaSelecionada());
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

												break;
										}
								}
								break;
							case 2:

								break;
							case 3:

								break;
							case 4:

								break;
							case 5:

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
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 2:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 3:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 4:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 5:
										this.tela = new Tela().opcEdicaoRota;
										this.acesso5
										break;
									default:

										break;
								}
								break;
							case 0:
								if(controlerRota.consultarIndentificador(entrada).getId() != 0){
									this.tela = new TelaInstituicao().manterPonto;
									this.acesso4 = -1;
								}
								else{
									ArrayList<Rota> r = new ArrayList<Rota>();
									r.add(controladorRota.getRotaSelecionada());
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

												break;
										}
								}
								break;
							case 2:

								break;
							case 3:

								break;
							case 4:

								break;
							case 5:

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
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 2:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 3:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 4:
										this.tela = new Tela().opcEdicaoRota;
										break;
									case 5:
										this.tela = new Tela().opcEdicaoRota;
										this.acesso5
										break;
									default:

										break;
								}
								break;
							case 0:
								if(controlerRota.consultarIndentificador(entrada).getId() != 0){
									this.tela = new TelaHorario().manterPonto;
									this.acesso4 = -1;
								}
								else{
									ArrayList<Rota> r = new ArrayList<Rota>();
									r.add(controladorRota.getRotaSelecionada());
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

												break;
										}
								}
								break;
							case 2:

								break;
							case 3:

								break;
							case 4:

								break;
							case 5:

								break;

						}
						break;
				}
				break;
		}
		break;

		return this.tela;
	}
}