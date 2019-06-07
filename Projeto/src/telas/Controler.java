package telas;

public class Controler {
	private int tela = 0;
                                                                                                                                                                                                              	public int getTela() {
		return tela;
	}

	private String opcoes = "Escolha uma das opcoes: \n\n1 - Onibus\n2 - Rota \n3 - Instituicao \n4 - Ponto \n5 - Horario \n6 - Cidade \n\n >: ";
	private String tPrincipal = "Escolha uma das opcoes: \n\n1 - Consultar \n2 - Cadastrar \n3 - Editar\n4 - Excluir\n0 - Sair \n\n >: ";
	private String tConsultar = opcoes;
	private String tCadastrar = opcoes;
	private String tEditar = opcoes;
	private String tDeletar = opcoes;
	
	public void setTela(int tela) {
		this.tela = tela;
	}
	public String getOpcoes() {
		return opcoes;
	}
	public void setOpcoes(String opcoes) {
		this.opcoes = opcoes;
	}
	public String gettPrincipal() {
		return tPrincipal;
	}
	public void settPrincipal(String tPrincipal) {
		this.tPrincipal = tPrincipal;
	}
	public String gettConsultar() {
		return tConsultar;
	}
	public void settConsultar(String tConsultar) {
		this.tConsultar = tConsultar;
	}
	public String gettCadastrar() {
		return tCadastrar;
	}
	public void settCadastrar(String tCadastrar) {
		this.tCadastrar = tCadastrar;
	}
	public String gettEditar() {
		return tEditar;
	}
	public void settEditar(String tEditar) {
		this.tEditar = tEditar;
	}
	public String gettDeletar() {
		return tDeletar;
	}
	public void settDeletar(String tDeletar) {
		this.tDeletar = tDeletar;
	}
    public String tela(){
       String retorno = null;
       int op = this.tela;
       switch(op) {
	    	case 0: 
	    		retorno = this.tPrincipal;
	    		break;
	    	case 1:
	    		retorno  = this.tCadastrar;
    			break;
    		case 2:
    			retorno = this.tConsultar;
    			break;
    		case 3:
    			retorno = this.tEditar;
    			break;
    		case 4:
    			retorno = this.tDeletar;
    			break;
    		default:
    			retorno  = "Opção inválida!";
    	}
    	return retorno;
    }
    public void entrada(String opcao) { 
    	int op = Integer.parseInt(opcao);
    	if(this.tela == 0) {
    		switch(op) {
    			case 1:
    				this.tela = 1;
    				break;
    			case 2:
    				this.tela = 2;
    				break;
    			case 3:
    				this.tela = 3;
    				break;
    			case 4:
    				this.tela = 4;
    				break;
    		}
    	}
    }
    
}
