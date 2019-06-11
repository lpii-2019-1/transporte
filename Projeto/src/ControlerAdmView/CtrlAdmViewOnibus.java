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
						TelaOnibus tela1 = new TelaOnibus();
						tela1.setTelaConsulta(controler.consultarPlacaOnibus(entrada));
						this.tela =  tela1.telaConsulta;
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
								}
								break;
						}
						break;
					case 2:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
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
								}
								break;
						}
						break;
					case 3:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
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
								}
								break;
						}
						break;
					case 5:
						switch(this.acesso4){
							case 0:
								if(controler.consultarPlaca(entrada).getId() != 0){
									this.tela = new TelaManter().telaEdicao;
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

						}
						break;
					case 0:
						if(controler.consultarPlacaOnibus(entrada).getId() != 0){
							this.tela = new TelaManter().telaIn;
							this.acesso3 = -1;
						}
						else{
							this.acesso3 = 0;
							this.acesso3 = 0;
						}
						break;
					case 1:
						switch(arg){
							case 0:
								this.acesso3 = 0;
								this.acesso2 = 0;
								this.tela = new TelaManter().telaIni;
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
				}
				break;
		}
		break;

		return this.tela;
	}
}