package ControlerAdmView;

import java.util.ArrayList;
import java.util.Arrays;

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
	public String tela = new TelaConsultaCidade().telaIni;;
	private ControlUsuario controler;
	
	public ControlerUsuarioView(ControlUsuario controler){
		this.controler = controler;
	}


	entrada(entrada){
		int arg = -1;
        if(entrada.length() == 1){
            String s[] = entrada.split("[0-9]");
			if(s.length == 0){
				arg = Integer.parseInt(entrada);
                System.out.println(arg);
			}
		}
		switch(this.acesso1){
			case: -1:
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
				Cidade c = controler.consultarNomeUfCidade();
				if(c.getId() == 0){
					this.tela = new TelaConsultaCidade().telaErro;
					this.acesso1 = -1;
				}
				else{
					TelaConsultaInstituicao tela = new TelaConsultaInstituicao();
					tela.setTelaConsulta(controler.getCidadeSelecionada());//############################  M.W.
					this.tela = tela.telaConsulta;
					this.acesso1 = 1;
				}
				break;
			case 1:
				switch(thisacesso2){
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
								tela.setTelaConsulta(controler.getCidadeSelecionada());//############################  M.W.
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
						if(arg == 0){
							this.acesso1 = 0
							this.tela = new TelaConsultaCidade().telaIni;
						}
						else if(arg == -1){
							this.acesso2 = -1;
							this.tela = new TelaArgInvalido().telaIni;
						}
						else{
							controler.selecionarInstituicao(arg);//############################  M.W.
							if(controler.getInstituicaoSelecionada().getId() != 0){//############################  M.W.
								TelaConsultaTurno tela = new TelaConsultaTurno();
								tela.setTelaConsulta(controler.getTurnosInstituicaoSelecionada());//############################  M.W.
								this.tela = tala.telaConsulta;
								this.acesso2 = 1;
							}
							else{
								this.acesso2 = -1;
								this.tela = new TelaArgInvalido().telaIni;
							}
						}
						break;
					case 1:
						switch(this.acesso3){
							case 0:
								if(arg == 0){
									this.acesso2 = 0;
									TelaConsultaInstituicao tela = new TelaConsultaInstituicao();
									tela.setTelaConsulta(controler.getCidadeSelecionada());//############################  M.W.
									this.tela = tela.telaConsulta;
								}
								else if(arg == -1){
									this.acesso3 = -1;
									this.tela = new TelaArgInvalido().telaIni;
								}
								else{
									controler.selecionarTurno(arg);//############################  M.W.
									if(controler.getTurnoSelecionado().getId() != 0){//############################  M.W.
										this.tela = new TelaOpcPosTurno().telaIni;
										this.acesso3 = 1;
									}
									else{
										this.acesso3 = -1;
										this.tela = new TelaArgInvalido().telaIni;
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
												TelaConsultaTurno tela = new TelaConsultaTurno();
												tela.setTelaConsulta(controler.getTurnosInstituicaoSelecionada());//############################  M.W.
												this.tela = tala.telaConsulta;
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
												this.tela = new TelaConsultaCidade().telaIni;
												break;
											case 1:
												this.tela = TelaConsultaPonto().telaIni
												this.acesso4 = 1;												
												break;
											case 2:
												this.tela = TelaConsultaPonto().telaIni
												this.acesso4 = 2;
												break;
											case 3:
												this.tela = TelaConsultaPonto().telaIni
												this.acesso4 = 3;
												break;
											default:
												this.acesso3 = -1;
												this.tela = new TelaArgInvalido().telaIni;
												break;
										}
										break;
									case 1:
										switch(this.acesso5){
											case -1:
												switch(){
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
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													TelaConsulta tela = new TelaConsulta();
													tela.setTelaConsulta(controler.getRota);
													this.tela = tela.telaConsulta;
													this.acesso5 = 1;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.tela = new TelaOpcPosTurno().telaIni;
												}
												break;
										}
										break;
									case 2:
										switch(this.acesso5){
											case -1:
												switch(){
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
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													TelaConsulta tela = new TelaConsulta();
													tela.setTelaConsulta(controler.getRota);
													this.tela = tela.telaConsulta;
													this.acesso5 = 1;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.tela = new TelaOpcPosTurno().telaIni;
												}
												break;
										}
										break;
									case 3:
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
												if(arg == -1){
													this.tela = new TelaArgInvalido().telaIni;
													this.acesso5 = -1;
												}
												else if(arg != 0){
													TelaConsulta tela = new TelaConsulta();
													tela.setTelaConsulta(controler.getRota);
													this.tela = tela.telaConsulta;
													this.acesso5 = 1;
												}
												else{
													this.acesso5 = 0;
													this.acesso4 = 0;
													this.tela = new TelaOpcPosTurno().telaIni;
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