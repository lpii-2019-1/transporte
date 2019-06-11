package controlerAdmView;

public class CtrlAdmViewInstituicao{
	public String acesso2;
	public String acesso3;
	public String acesso4;
	public String acesso5;

	public String entrada(){
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
						ArrayList<Instituicao> consulta = controler.listarInstituicaos();//#############Metodo que lista cidade --M.W. deve setar
						TelaInstituicao tela = new TelaInstituicao();
						tela.setTelaConsulta(consulta);
						this.tela = tela.telaConsulta;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
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
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = 0;
								break;
						}
						break;
					case 1:
						TelaInstituicao tela = TelaInstituicao();
						tela.setTelaConsulta(controler.consultarNomeInstituicao(entrada));
						this.tela =  tela.telaIni;
						break;
					case 2:
						TelaInstituicao tela = TelaInstituicao();
						tela.setTelaConsulta(controler.consultarEnderecoInstituicao(entrada));
						this.tela =  tela.telaIni;
						break;
					case 1:
						TelaInstituicao tela = TelaInstituicao();
						tela.setTelaConsulta(controler.consultarTelefoneInstituicao(entrada));
						this.tela =  tela.telaIni;
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
						this.acesso2 = 0;
					}
				}
				else if (arg == 0){
					this.tela = new TelaManter().telaIni;
					this.acesso2 = 0;
				}
			case 3:

		}
	}
}