package controlerUserView;

import java.util.ArrayList;
import java.util.Arrays;

import controlUsuario.ControlUsuario;
import model.*;
import viewUsuario.*;
import view.*;

public class ControlerUsuarioView{
	public boolean exit = false;
	public int acesso1;
	public int acesso2;
	public int acesso3;
	public int acesso4;
	public int acesso5;
	public String tela = new TelaConsultaCidade().telaIni;
	private ControlUsuario controler;
	
	public ControlerUsuarioView(){
		this.controler = new ControlUsuario();
	}


	public void entrada(String entrada){
		int arg = -1;
        if(entrada.length() == 1){
            String s[] = entrada.split("[0-9]");
			if(s.length == 0){
				arg = Integer.parseInt(entrada);
			}
		}
		switch(this.acesso1){
			case -1:
				switch(arg) {
					case 0:
						this.acesso1 = 0;
						this.exit = true;
						this.tela = new TelaFim().telaIni;
						break;
					case 1:
						this.acesso1 = 0;
						this.tela = new TelaConsultaCidade().telaIni;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso1 = -1;
						break;
				}
				break;
			case 0:
				String regex = "(( , )|( ,)|(, )|(,))";
				ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
				Cidade c = this.controler.pesquisarCidade(entradas.get(0), entradas.get(1));
				if(c.getId() == 0){
					this.tela = new TelaConsultaCidade().telaErro;
					this.acesso1 = -1;
				}
				else{
					TelaConsultaInstituicao tela = new TelaConsultaInstituicao();
					tela.setTelaConsulta(this.controler.getCidadeSelecionada());
					this.tela = tela.telaConsulta;
					this.acesso1 = 1;
				}
				break;
			case 1:
				switch(this.acesso2){
					case -1:
						switch(arg) {
							case 0:
								this.acesso2 = 0;
								this.acesso1 = 0;
								this.exit = true;
								this.tela = new TelaFim().telaIni;
								break;
							case 1:
								TelaConsultaInstituicao tela = new TelaConsultaInstituicao();
								tela.setTelaConsulta(this.controler.getCidadeSelecionada());
								this.tela = tela.telaConsulta;
								this.acesso2 = 0;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = -1;
								break;
						}
						break;
					case 0:
						arg = Integer.parseInt(entrada);
						if(arg == 0){
							this.acesso1 = 0;
							this.tela = new TelaConsultaCidade().telaIni;
						}
						else if(arg == -1){
							this.acesso2 = -1;
							this.tela = new TelaArgInvalido().telaIni;
						}
						else{
							this.controler.selecionarInstituicao(arg);
							this.tela = new TelaConsultaTurno().telaIni;
							this.acesso2 = 1;
						}
						break;
					case 1:
						switch(this.acesso3){
							case -1:
								switch(arg) {
									case 0:
										this.acesso3 = 0;
										this.acesso2 = 0;
										this.acesso1 = 0;
										this.exit = true;
										this.tela = new TelaFim().telaIni;
										break;
									case 1:
										TelaConsultaInstituicao tela = new TelaConsultaInstituicao();
										tela.setTelaConsulta(this.controler.getCidadeSelecionada());
										this.tela = tela.telaConsulta;
										this.acesso3 = 0;
										this.acesso2 = 0;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIni;
										this.acesso3 = -1;
										break;
									}
								break;
							case 0:
								if(arg == 0){
									this.acesso2 = 0;
									TelaConsultaInstituicao tela = new TelaConsultaInstituicao();
									tela.setTelaConsulta(this.controler.getCidadeSelecionada());
									this.tela = tela.telaConsulta;
								}
								else if(arg == -1){
									this.acesso3 = -1;
									this.tela = new TelaArgInvalido().telaIni;
								}
								else{
									if(this.controler.filtrarRotasTurno(arg)){
										this.tela = new TelaOpcPosTurno().telaIni;
										this.acesso3 = 1;
									}
									else{
										this.acesso3 = 0;
										this.tela =  new TelaConsultaTurno().telaErro + new TelaConsultaTurno().telaIni;
									}
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
												this.acesso1 = 0;
												this.exit = true;
												this.tela = new TelaFim().telaIni;
												break;
											case 1:
												this.tela = new TelaConsultaTurno().telaIni;
												this.acesso4 = 0;
												this.acesso3 = 0;
												break;
											default:
												this.tela = new TelaArgInvalido().telaIni;
												this.acesso4 = -1;
												break;
										}
										break;
									case 0:
										switch(arg){
											case 0:
												this.acesso4 = 0;
												this.acesso3 = 0;
												this.tela = new TelaConsultaTurno().telaIni;
												break;
											case 1:
												TelaConsultaPonto tela1 = new TelaConsultaPonto();
												tela1.setTelaConsulta(this.controler.listarPontos(), this.controler.getInstituicaoSelecionada());
												this.tela = tela1.telaConsulta;
												this.acesso5 = 1;
												this.acesso4 = 1;												
												break;
											case 2:
												TelaConsultaPercurso tela2 = new TelaConsultaPercurso();
												tela2.setTelaConsulta(this.controler.listarPercursos(), this.controler.getInstituicaoSelecionada());
												this.tela = tela2.telaConsulta;
												this.acesso5 = 1;
												this.acesso4 = 2;
												break;
											case 3:
												TelaConsultaInicioFim tela3 = new TelaConsultaInicioFim();
												tela3.setTelaConsulta(this.controler.listarInicioFimDiferentes(), this.controler.getInstituicaoSelecionada());
												this.tela = tela3.telaConsulta;
												this.acesso5 = 1;
												this.acesso4 = 3;
												break;
											default:
												this.acesso4 = -1;
												this.tela = new TelaArgInvalido().telaIni;
												break;
										}
										break;
									case 1:
										switch(this.acesso5){
											case -1:
												switch(arg){
													case 0:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.acesso3 = 0;
														this.acesso2 = 0;
														this.acesso1 = 0;
														this.exit = true;
														this.tela = new TelaFim().telaIni;
														break;
													case 1:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.tela = new TelaConsultaTurno().telaIni;
														break;
													default:
														this.tela = new TelaArgInvalido().telaIni;
														this.acesso5 = -1;
														break;
												}
												break;
											case 0:
												arg = Integer.parseInt(entrada);
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													TelaConsultaPonto tela = new TelaConsultaPonto();
													tela.setTelaConsulta(this.controler.listarPontos(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
													this.acesso5 = 1;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.tela = new TelaOpcPosTurno().telaIni;
												}
												break;
											case 1:
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													this.controler.selecionarPonto(arg);
													TelaConsultaRota tela = new TelaConsultaRota();
													tela.setTelaConsulta(this.controler.getRotasFim(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
													this.acesso5 = 0;
													this.acesso4 = 4;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 1;
													TelaConsultaPonto tela = new TelaConsultaPonto();
													tela.setTelaConsulta(this.controler.listarPontos(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
												}
												break;
										}
										break;
									case 2:
										switch(this.acesso5){
											case -1:
												switch(arg){
													case 0:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.acesso3 = 0;
														this.acesso2 = 0;
														this.acesso1 = 0;
														this.exit = true;
														this.tela = new TelaFim().telaIni;
														break;
													case 1:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.tela = new TelaOpcPosTurno().telaIni;
														break;
													default:
														this.tela = new TelaArgInvalido().telaIni;
														this.acesso5 = -1;
														break;
												}
												break;
											case 0:
												arg = Integer.parseInt(entrada);
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													TelaConsultaPercurso tela = new TelaConsultaPercurso();
													tela.setTelaConsulta(this.controler.listarPercursos(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
													this.acesso5 = 1;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.tela = new TelaOpcPosTurno().telaIni;
												}
												break;
											case 1:
												arg = Integer.parseInt(entrada);
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													this.controler.selecionarPercurso(arg);
													TelaConsultaRota tela = new TelaConsultaRota();
													tela.setTelaConsulta(this.controler.getRotasFim(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
													this.acesso5 = 0;
													this.acesso4 = 4;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 2;
													TelaConsultaPercurso tela = new TelaConsultaPercurso();
													tela.setTelaConsulta(this.controler.listarPercursos(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
												}
												break;
										}
										break;
									case 3:
										switch(this.acesso5){
											case -1:
												arg = Integer.parseInt(entrada);
												switch(arg){
													case 0:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.acesso3 = 0;
														this.acesso2 = 0;
														this.acesso1 = 0;
														this.exit = true;
														this.tela = new TelaFim().telaIni;
														break;
													case 1:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.tela = new TelaOpcPosTurno().telaIni;
														break;
													default:
														this.tela = new TelaArgInvalido().telaIni;
														this.acesso5 = -1;
														break;
												}
												break;
											case 0:
												arg = Integer.parseInt(entrada);
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													TelaConsultaInicioFim tela = new TelaConsultaInicioFim();
													tela.setTelaConsulta(this.controler.listarInicioFimDiferentes(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
													this.acesso5 = 1;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.tela = new TelaOpcPosTurno().telaIni;
												}
												break;
											case 1:
												arg = Integer.parseInt(entrada);
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													this.controler.filtrarRotasInicioFim(arg);
													TelaConsultaRota tela = new TelaConsultaRota();
													tela.setTelaConsulta(this.controler.getRotasFim(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
													this.acesso5 = 0;
													this.acesso4 = 4;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 3;
													TelaConsultaInicioFim tela = new TelaConsultaInicioFim();
													tela.setTelaConsulta(this.controler.listarInicioFimDiferentes(), this.controler.getInstituicaoSelecionada());
													this.tela = tela.telaConsulta;
												}
												break;
										}
										break;
									//tela lista as rotas
									case 4:
										switch(this.acesso5){
											case -1:
												arg = Integer.parseInt(entrada);
												switch(arg){
													case 0:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.acesso3 = 0;
														this.acesso2 = 0;
														this.acesso1 = 0;
														this.exit = true;
														this.tela = new TelaFim().telaIni;
														break;
													case 1:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.tela = new TelaOpcPosTurno().telaIni;
														break;
													default:
														this.tela = new TelaArgInvalido().telaIni;
														this.acesso5 = -1;
														break;
												}
											case 0:
												arg = Integer.parseInt(entrada);
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													this.controler.selecionarRota(arg);
													TelaConsultaOnibus tela = new TelaConsultaOnibus();
													tela.setTelaConsulta(this.controler.getOnibusSelecionado(), this.controler.getCidadeSelecionada(), this.controler.getInstituicaoSelecionada(), this.controler.getRotaSelecionada());
													this.tela = tela.telaConsulta;
													this.acesso5 = 1;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.tela = new TelaOpcPosTurno().telaIni;
												}
												break;
											case 1:
												switch(arg){
													case 0:
														this.acesso5 = 0;
														this.acesso4 = 0;
														this.tela = new TelaOpcPosTurno().telaIni;
														break;
													case 1:
														TelaConsultaRota tela = new TelaConsultaRota();
														tela.setTelaConsulta(this.controler.getRotasFim(), this.controler.getInstituicaoSelecionada());
														this.tela = tela.telaConsulta;
														this.acesso5 = 1;
														break;
													default:
														this.tela = new TelaArgInvalido().telaIni;
														this.acesso5 = -1;
														break;
												}
												break;
										}
									break;
								}
								break;
						}
						break;
				}
				break;
		}
	}
}