package controlAdm;

import model.Cidade;

import model.Instituicao;

import java.util.ArrayList;

import dao.InstituicaoDAO;

public class ControlAdmInstituicao {
	
	/*
	 * PROVAVELMENTE VAI TER QUE CRIAR UM MÉTODO PARA PESQUISAR CIDADE POR INSTITUICAO NO CidadeDAO
	 * ESSE MÉTODO SERÁ PARA MOSTRAR PARA O ADM DE QUAL CIDADE A INSTITUICAO PESQUISADA É;
	 * E VAI SER USADO PARA EDITAR DE QUAL CIDADE ESSA INSTITUICAO É;
	 * PARA ISSO É PRECISO FAZER UM METODO QUE FAÇA A SEGUNTE CONSULTA NO BANCO
	 * M.D DECIDA AÍ SE VAI USAR
	 * 
	 * SELECT c.nome, c.uf FROM cidade c 
		INNER JOIN instituicao i
		ON c.id = i.id_cidade
		WHERE i.nome = 'UEG';
		que seria o sql a baixo
	 *  
	 *  */
	// String sql ="SELECT c.nome, c.uf FROM cidade c INNER JOIN instituicao i ON c.id = i.id_cidade WHERE i.nome = ?" ;

			
	
	private Cidade cidadeSelecionada;
	

	private Instituicao instituicaoSelecionada;
	private ArrayList<Instituicao> instituicoes;
	
	public void selecionarInstituicao(int i) {
		i--;
		this.instituicaoSelecionada = this.instituicoes.get(i);
	}
	public ArrayList<Instituicao> consultarNome(String nome) {
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicaoSelecionada.setNome(nome);
		this.instituicoes = iDAO.consultarNome(this.instituicaoSelecionada, 2);
		return this.instituicoes;
	}
	
	public Instituicao consultarEndereco(String endereco) {
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicaoSelecionada.setEndereco(endereco);
		this.instituicaoSelecionada = iDAO.consultarEndereco(this.instituicaoSelecionada, 2);
		return this.instituicaoSelecionada;
	}
	
	public Instituicao consultarTelefone(String telefone) {
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicaoSelecionada.setTelefone(telefone);
		this.instituicaoSelecionada = iDAO.consultarTelefone(this.instituicaoSelecionada, 2);
		return this.instituicaoSelecionada;
	}
	
	public ArrayList<Instituicao> consultarIdCidade(ArrayList<String> valoresCidade) {
		ControlAdmCidade ctrlCidade = new ControlAdmCidade();
		this.cidadeSelecionada =  ctrlCidade.consultarCidadeNomeUf(valoresCidade);
		InstituicaoDAO  iDAO =new InstituicaoDAO();
		this.instituicoes = iDAO.consultarIdCidade(this.cidadeSelecionada, 2);	
		return this.instituicoes;
	}
	
	 public boolean inserirInstituicao(ArrayList<String> valores) {// Se a Instituicao n existir no banco o método insere e retorna true//Se ela existir, não insere e retorna false
		this.instituicaoSelecionada = new Instituicao(valores.get(0), valores.get(1), valores.get(2));
		ControlAdmCidade ctrlCidade = new ControlAdmCidade();
		
		ArrayList<String> dadosCidade = new ArrayList<String> ();
		dadosCidade.add(valores.get(3));
		dadosCidade.add(valores.get(4));
		
		this.cidadeSelecionada = ctrlCidade.consultarCidadeNomeUf(dadosCidade);
		if(this.cidadeSelecionada.getId() == 0) {

			InstituicaoDAO  iDAO =new InstituicaoDAO();
			Instituicao auxInstituicao = new Instituicao();
			auxInstituicao = consultarEndereco(this.instituicaoSelecionada.getEndereco());
			if(auxInstituicao.getId() == 0) {
				iDAO.inserirInstituicao(this.instituicaoSelecionada);
				if(valores.size() == 5) {
					if(valores.get(4) == "Disponivel") {
						this.instituicaoSelecionada = consultarEndereco(this.instituicaoSelecionada.getEndereco());
						this.instituicaoSelecionada.setValidacao(1);
						iDAO.editarValidacao(this.instituicaoSelecionada);
					}
				}
				
				return true;
			}else {
				return false;
			}
		
		}else {
			return false;
		}
		
		 
	 }
	 public boolean editarNome(String nome) {
		 this.instituicaoSelecionada.setNome(nome);
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 if(iDAO.editarNome(this.instituicaoSelecionada)) {
			return true; 
		 }else {
			 return false;
		 }
	 }
	 public boolean editarEndereco(String endereco) {
		 this.instituicaoSelecionada.setEndereco(endereco);
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 if(iDAO.editarEndereco(this.instituicaoSelecionada)) {
			 return true; 
		 }else {
			 return false;
		 } 
	 }
	 
	 public boolean editarTelefone(String telefone) {
		 this.instituicaoSelecionada.setTelefone(telefone);
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 if(iDAO.editarTelefone(this.instituicaoSelecionada)) {
			 return true; 
		 }else {
			 return false;
		 }
	 }
	 public boolean editarIdCidade(ArrayList<String> cidade) {
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 ControlAdmCidade ctrlCidade = new ControlAdmCidade();
		 ctrlCidade.consultarCidadeNomeUf(cidade);
		 if(iDAO.editarIdCidade(this.instituicaoSelecionada, this.cidadeSelecionada)) {
			 return true; 
		 }else {
			 return false;
		 }
	 }
	 public void editarValidacao(String validacao) {
		 int validade = 0;
		 if(validacao == "Disponivel") {
			 validade = 1;
		 }
		 this.instituicaoSelecionada.setValidacao(validade);
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 iDAO.editarValidacao(this.instituicaoSelecionada);

	 }
	 
	 public boolean excluirInstituicao() {
		 InstituicaoDAO  iDAO =new InstituicaoDAO();

		 if(iDAO.excluirInstituicao(this.instituicaoSelecionada)) {
			 return true;
		 }else {
			 return false;
		 }
	 }
 
	 public ArrayList<Instituicao> listarInstituicaoes(){
		 InstituicaoDAO  iDAO =new InstituicaoDAO();
		 this.instituicoes = new ArrayList<Instituicao>();
		 this.instituicoes = iDAO.listarInstituicoes(2);
		 return this.instituicoes;
		 
	 }
	 
	 public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	 }
	 public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	 }
	 public Instituicao getInstituicaoSelecionada() {
		return instituicaoSelecionada;
	 }
	 public void setInstituicaoSelecionada(Instituicao instituicaoSelecionada) {
		this.instituicaoSelecionada = instituicaoSelecionada;
	 }
	 public ArrayList<Instituicao> getInstituicoes() {
		return instituicoes;
	 }
	 public void setInstituicoes(ArrayList<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	 }
	
}
