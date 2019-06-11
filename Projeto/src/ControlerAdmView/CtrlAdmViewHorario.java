package controlerAdmView;

public class CtrlAdmViewHorario{
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
						this.tela = new TelaHorario().opcConsulta;
						this.acesso2 = 1;
						break;
					//Vai para tela de entrada de dados para cadastro
					case 2:
						this.tela = new TelaHorario().cadastro;
						this.acesso2 = 2;
						break;
					//Vai para tela de selecionar dados para edicao
					case 3:
						this.tela = new TelaHorario().opcEdicao;
						this.acesso2 = 3;
						break;
					//Vai para tela de entrada de dados para exclusao
					case 4:
						this.tela = new TelaHorario().entrada;
						this.acesso2 = 4;
						break;
					//Vai para tela de Listagem
					case 5:
						ArrayList<Horario> consulta = controler.listarHorarios();//#############Metodo que lista cidade --M.W. deve setar
						TelaHorario tela = new TelaHorario();
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
								this.tela = new TelaHorario().entrada;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaHorario().entrada;
								break;
							case 3:
								this.acesso3 = 3;
								this.tela = new TelaHorario().entrada;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso2 = 0;
								break;
						}
						break;
					case 1:
						if(controler.selecionarHorario(entrada)){
							TelaHorario tela = TelaHorario();
							tela.setTelaConsulta(controler.getHorario);
							this.tela = 
						}
						break;
				}
				break;
		}
	}
}