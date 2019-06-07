package controlUsuario;

import model.*;

import java.util.ArrayList;

import dao.*;

public class ControlCidade {
	public Cidade pesquisarCidade(String nome, String uf){
		CidadeDAO cDAO = new CidadeDAO();
		Cidade c = new Cidade();
		c.setNome(nome);
		c.setUf(uf);
		c = cDAO.consultarNomeUf(c, 1);
		return c;
	}
	
	public boolean verificaId(Cidade c) {
		if(c.getId() == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public void respostaConsultaCidade(String nome, String uf) {
	Cidade c = this.pesquisarCidade(nome, uf);
		if(this.verificaId(c)) {
			
		}
	}
	
	public ArrayList<String> retornaInstituicoes(Cidade c){
		ArrayList<String> instituicoes = new ArrayList<String>();
		String nome = "";
		for(int i = 0; i < c.getInstituicoes().size(); i++) {
			nome = c.getInstituicoes().get(i).getNome();
			instituicoes.add(nome);
		}
		return instituicoes;
	}
}
