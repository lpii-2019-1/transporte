package controlAdm;

import model.Cidade;


import java.util.ArrayList;

import dao.CidadeDAO;

public class controlAdmCidade {
	private Cidade cidadeSelecionada;
	
	
	public void selecionarCidade(ArrayList<String> valores) { // nome, uf
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada =  new Cidade(valores.get(0), valores.get(1));
		this.cidadeSelecionada = cDAO.consultarNomeUf(this.cidadeSelecionada, 2 );
	}
	
	public void editarNomeCidade(String nome) {
		CidadeDAO cDAO = new CidadeDAO();
		this.cidadeSelecionada.setNome(nome);
		cDAO.editarNome(this.cidadeSelecionada);
	}

	public boolean inserirCidade(ArrayList<String> valores) { //nome, uf e talvez Disponibilidade
		String nome  = valores.get(0);
		String uf = valores.get(1);
		CidadeDAO cDAO = new CidadeDAO();
		
		Cidade c = new Cidade(nome, uf);
		c = cDAO.consultarNomeUf(c, 2);
		if(c.getId() ==0) {
			cDAO.inserirCidade(c);
					
			if(valores.size() == 3) {
				if(valores.get(2) == "Disponivel") {
					c.setValidacao(1);
					cDAO.editarValidacao(c);
				}else {
					cDAO.editarValidacao(c);
				}
			}
			return true;
		}else {
			return false;
		}
	}
	
	
	//Getters and Setters
	
	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}


	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}
}
