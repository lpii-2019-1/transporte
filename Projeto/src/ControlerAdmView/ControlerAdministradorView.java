package controlerAdmView;

import java.util.ArrayList;
import java.util.Arrays;

import model.*;
import viewAdministrador.*;
import view.*;

public class ControlerAdministradorView{
	public boolean exit = false;
	public int acesso1;
	public CtrlAdmViewCidade cAVCidade = new CtrlAdmViewCidade();
	public CtrlAdmViewHorario cAVHorario = new CtrlAdmViewHorario();
	public CtrlAdmViewInstituicao cAVInstituicao = new CtrlAdmViewInstituicao();
	public CtrlAdmViewOnibus cAVOnibus = new CtrlAdmViewOnibus();
	public CtrlAdmViewPercurso cAVPercurso = new CtrlAdmViewPercurso();
	public CtrlAdmViewPonto cAVPonto = new CtrlAdmViewPonto();
	public CtrlAdmViewRota cAVRota = new CtrlAdmViewRota();
	public CtrlAdmViewTurno cAVTurno = new CtrlAdmViewTurno();

	public String tela = new TelaInicial().telaIni;

	private controlAdministrador controler;
	
	public controlerAdministradorView(controlAdministrador controler){
		this.controler = controler;
	}

	public void entrada(String entrada){
		int arg = -1;
        if(entrada.length() == 1){
            String s[] = entrada.split("[0-9]");
			if(s.length == 0){
				arg = Integer.parseInt(entrada);
                System.out.println(arg);
			}
		}
		switch(this.acesso1){
			//Retorno de fim de operacao ou argumento invalido
			case -1:
				switch(arg) {
					case 0:
						this.acesso1 = 0;
						this.exit = true;
						this.tela = new TelaFim().telaIni;
						break;
					case 1:
						this.acesso1 = 0;
						this.tela = new TelaInicial().telaIni;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso1 = -1;
						break;
				}
				break;
			//Tela Inicial
			case 0:
				switch(arg){
					case 0:
						//Retorna para tela inicial
						this.acesso1 = 0;
						this.tela = new TelaInicial().telaIni;
						break;
					case 1:
						//Vai para tela Manter Cidade
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 1;
						break;
					case 2:
						//Vai para tela Manter Horario
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 2;
						break;
					case 3:
						//Vai para tela Manter Instituicao
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 3;
						break;
					case 4:
						//Vai para tela Manter Onibus
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 4;
						break;
					case 5:
						//Vai para tela Manter Ponto
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 5;
						break;
					case 6:
						//Vai para tela Manter Cidade
						this.tela = new TelaManter().telaIni;
						this.acesso1 = 6;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso1 = -1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Cidade
			case 1:
				
			//Entra nas opcoes de Manter Horario
			case 2:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaHorario().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Instituicao
			case 3:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaInstituicao().opcConsulta;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Onibus
			case 4:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaOnibus().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Ponto
			case 5:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaPonto().opcoes;
						this.acesso1 = 1;
						break;
				}
				break;
			//Entra nas opcoes de Manter Rota
			case 6:
				switch(this.acesso2){
					case 0:
						this.acesso2 = 1;
						this.tela = new TelaManter().telaIni;
						break;
					case 1:
						//Vai para tela Cidade
						this.tela = new TelaCidade().opcConsulta;
						this.acesso1 = 1;
						break;
				}
				break;
			default:
				this.tela = new TelaArgInvalido().telaIni;
				this.acesso1 = -1;
				break;
		}
	}
}