package controlAdm;

import model.Instituicao;
import model.Rota;

import java.util.ArrayList;

import dao.InstituicaoDAO;
import dao.RotaDAO;

public class ControlAdmInstituicaoRota {
	private Rota rotaSelecionada;
	private Instituicao instituicaoSelecionada;

	public ArrayList<Instituicao> consultarNome(String nome) {
		InstituicaoDAO iDAO = new InstituicaoDAO();
		Instituicao instituicao = new Instituicao();
		instituicao.setNome(nome);
		ArrayList<Instituicao> instituicoes = iDAO.consultarNome(instituicao, 2);
		boolean aux = false;
		for(Instituicao iR : this.rotaSelecionada.getInstituicoes()){
			for(Instituicao iD : instituicoes) {
				if(iR.getId() == iD.getId()){
					instituicoes.add(iR);
					aux = true;
				}
			}
		}
		if(aux){
			return instituicoes;			
		}
		instituicoes = new ArrayList<Instituicao>();
		instituicao = new Instituicao();
		instituicoes.add(instituicao);
		return instituicoes;
	}
	
	public ArrayList<Instituicao> consultarTelefone(String telefone) {
		InstituicaoDAO iDAO = new InstituicaoDAO();
		Instituicao instituicao = new Instituicao();
		instituicao.setTelefone(telefone);
		ArrayList<Instituicao> instituicoes = iDAO.consultarTelefone(instituicao, 2);
		boolean aux = false;
		for(Instituicao iR : this.rotaSelecionada.getInstituicoes()){
			for(Instituicao iD : instituicoes) {
				if(iR.getId() == iD.getId()){
					instituicoes.add(iR);
					aux = true;
				}
			}
		}
		if(aux){
			return instituicoes;			
		}
		instituicoes = new ArrayList<Instituicao>();
		instituicao = new Instituicao();
		instituicoes.add(instituicao);
		return instituicoes;
	}
	
	public Instituicao consultarEndereco(String endereco) {
		InstituicaoDAO iDAO = new InstituicaoDAO();
		Instituicao instituicao = new Instituicao();
		instituicao.setEndereco(endereco);
		this.instituicaoSelecionada = iDAO.consultarEndereco(instituicao, 2);
		for(Instituicao i : this.rotaSelecionada.getInstituicoes()) {
			if(i.getId() == this.instituicaoSelecionada.getId()){
				return this.instituicaoSelecionada;				
			}
		}
		return new Instituicao();
	}
		
	public boolean inserirInstituicao(String endereco) {
		RotaDAO rDAO = new RotaDAO();
		Instituicao instituicao = this.consultarEndereco(endereco);
		if(instituicao.getId() != 0) {
			if (rDAO.inserirInstituicaoRota(this.rotaSelecionada, instituicao)) {
				return true;
			} else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	 
	 public boolean excluirInstituicao() {
		RotaDAO rDAO = new RotaDAO();
		return rDAO.excluirInstituicao(this.rotaSelecionada, this.instituicaoSelecionada);
	 }
 
	 public ArrayList<Instituicao> listarInstituicoes(){
		 RotaDAO  rDAO = new RotaDAO();
		 ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
		 instituicoes = rDAO.listarInstituicoes(this.rotaSelecionada, 2);
		 return instituicoes;
		 
	 }
	 
	 public Instituicao getInstituicaoSelecionada() {
		return this.instituicaoSelecionada;
	 }
	 
	 public void setInstituicaoSelecionada(Instituicao i) {
			this.instituicaoSelecionada = i;
	 }
	
	 public Rota getRotaSelecionada() {
		 return rotaSelecionada;
	 }
	 public void setRotaSelecionada(Rota rotaSelecionada) {
		 this.rotaSelecionada = rotaSelecionada;
	 }
}
