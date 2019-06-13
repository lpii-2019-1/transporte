package controlerAdmView;

import java.util.ArrayList;

import controlAdm.ControlAdmPonto;
import model.Ponto;
import view.*;
import viewAdministrador.TelaManter;
import viewAdministrador.TelaInicial;
import viewAdministrador.TelaPonto;

public class CtrlAdmViewPonto{
	public String tela;
	public int acesso2;
	public int acesso3;
	public int acesso4;
	public int acesso5;

	private ControlAdmPonto controler = new ControlAdmPonto();

	public String entrada(String entrada, int arg){

		this.tela = new TelaManter().telaIni;

		switch(this.acesso2){
			case 0:
				switch(arg){
					case 0:
						this.acesso2 = 0;
						this.tela = new TelaInicial().telaIni;
						break;
					case 1:
						this.tela = new TelaPonto().entrada;
						this.acesso2 = 1;
						break;
					case 2:
						this.tela = new TelaPonto().cadastro;
						this.acesso2 = 2;
						break;
					case 3:
						this.tela = new TelaPonto().opcEdicao;
						this.acesso2 = 3;
						break;
					case 4:
						this.tela = new TelaPonto().entrada;
						this.acesso2 = 4;
						break;
					case 5:
						TelaPonto tela = new TelaPonto();
						tela.setTelaConsulta(controler.listarPontos());
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
				if(arg != 0){
					TelaPonto tela1 = new TelaPonto();
					ArrayList<Ponto> p = new ArrayList<Ponto>();
					p.add(controler.consultarEndereco(entrada));
					tela1.setTelaConsulta(p);
					this.tela =  tela1.telaConsulta;
				}else{
					this.tela = new TelaManter().telaIni;
					this.acesso2 = 0;
				}
				break;
			case 2:
				if(arg != 0){
					if(controler.inserirPonto(entrada)){
						this.tela = new TelaFimOperacao().sucesso;
					}
					else{
						this.tela = new TelaFimOperacao().erro;
						this.acesso2 = 0;
					}
				}
				else if (arg == 0){
					this.tela = new TelaManter().telaIni;
					this.acesso2 = 0;
				}
			case 3:
				switch(this.acesso3){
					case 0:
						switch(arg){
							case 0:
								this.acesso2 = 0;
								this.tela = new TelaManter().telaIni;
								break;
							case 1:
								this.acesso3 = 1;
								this.tela = new TelaPonto().entrada;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaPonto().entrada;
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
								if(arg != 0){
									if(controler.consultarEndereco(entrada).getId() != 0){
										this.tela = new TelaManter().telaEdicao;
										this.acesso4 = 1;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
									}
								}
								else{
									this.tela = new TelaManter().telaIni;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
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
									this.acesso3 = 0;
									this.acesso2 = 0;
								}
								break;
						}
						break;
					case 2:
						switch(this.acesso4){
							case 0:
								if(arg != 0){
									if(controler.consultarEndereco(entrada).getId() != 0){
										this.tela = new TelaManter().telaEdicao;
										this.acesso4 = 1;
									}
									else{
										this.tela = new TelaFimOperacao().erro;	
									}
								}
								else{
									this.tela = new TelaManter().telaIni;
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
									this.tela = new TelaManter().telaIni;
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
					if(controler.consultarEndereco(entrada).getId() != 0){
						if(controler.excluirPonto()){
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
				else if (arg == 0){
					this.tela = new TelaManter().telaIni;
					this.acesso2 = 0;
				}
				break;
			case 5:
				if(arg != 0){
					TelaPonto tela = new TelaPonto();
					tela.setTelaConsulta(controler.listarPontos());
					this.tela = tela.telaConsulta;
				}
				else if (arg == 0){
					this.tela = new TelaManter().telaIni;
					this.acesso2 = 0;
				}
			break;
		}

		return this.tela;
	}
}