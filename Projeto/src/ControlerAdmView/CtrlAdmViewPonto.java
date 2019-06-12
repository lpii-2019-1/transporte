package controlerAdmView;

import controlAdm.ControlAdmPonto;
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
						ArrayList<Ponto> consulta = controler.listarPontos();
						TelaPonto tela = new TelaPonto();
						tela.setTelaConsulta(consulta);
						this.tela = tela.telaConsulta;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso2 = 0;
						break;
				}
				break;
			case 1:
				TelaPonto tela1 = new TelaPonto();
				tela1.setTelaConsulta(controler.consultarEnderecoPonto(entrada));
				this.tela =  tela1.telaConsulta;
				break;
			case 2:
				if(arg != 0){
					String regex = "(( , )|( ,)|(, )|(,))";
					ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
					if(controler.inserirPonto(entradas)){
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
								this.tela = new TelaManter().telaEdicao;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaManter().telaEdicao;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = 0;
								break;
						}
						break;
					case 1:
						if(arg != 0){
							if(controler.editarEnderecoPonto(entrada)){
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
					case 2:
						agr = Integer.parseInt(entrada);
						if(arg != 0){
							if(controler.editarValidacaoPonto(arg)){
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
			case 4:
				String regex = "(( , )|( ,)|(, )|(,))";
				ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
				if(arg != 0){
					if(controler.excluirPonto(entradas)){
						this.tela = new TelaFimOperacao().sucesso;
					}
					else{
						this.tela = new TelaFimOperacao().erroExcluir;
						this.acesso2 = 0;
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
					tela.setConsulta(controler.listarInstituicoes());
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