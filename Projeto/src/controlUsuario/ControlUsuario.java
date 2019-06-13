package controlUsuario;

import model.*;

import java.util.ArrayList;

import dao.*;

public class ControlUsuario {
	private ArrayList<Rota> rotasIntituicao;
	private ArrayList<Rota> rotasTurno;
	private ArrayList<Rota> rotasFim;
	
	private String turnoSelecionado;
	private Rota rotaSelecionada;
	private Cidade cidadeSelecionada;
	private Instituicao instituicaoSelecionada;
	private Onibus onibusSelecionado;
	private String percursoSelecionado;
	private Ponto pontoSelecionado;
	
	private ArrayList<ArrayList<String>> todosIniciosFim;
	private ArrayList<String> todosPercursos;
	private ArrayList<ArrayList<Ponto>> pontosTodasRotas;
	private ArrayList<Ponto> pontos;
	
	private static boolean compararArray(char[] aArray, char[] bArray) {
	    for(int i = 0; i < aArray.length; i++) {
	        if(aArray[i] != bArray[i]) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public Cidade pesquisarCidade(String nome, String uf){
		CidadeDAO cDAO = new CidadeDAO();
		Cidade c = new Cidade();
		c.setNome(nome);
		c.setUf(uf);
		c = cDAO.consultarNomeUf(c, 1);
		this.cidadeSelecionada = c;
	
		return this.cidadeSelecionada;
		
	}
	
	public void selecionarInstituicao(int i) {
		i--;
		this.instituicaoSelecionada = this.cidadeSelecionada.getInstituicoes().get(i);
		buscarRotasBanco();
	}
	
	private void buscarRotasBanco() {
		RotaDAO rDAO = new RotaDAO();
		this.rotasIntituicao  = rDAO.consultarIdInstituicao(this.instituicaoSelecionada, 1);
	}
	
	public void selecionarRota(int i) {
		i--;
		this.rotaSelecionada = this.rotasFim.get(i);
		buscarOnibus();
	}
	
	public boolean filtrarRotasTurno(int turno) {
		
		switch(turno) {
			case 1:
				this.turnoSelecionado = "Matutino";
				break;
			case 2:
				this.turnoSelecionado = "Vespertino";
				break;
			case 3: 
				this.turnoSelecionado = "Noturno";
				break;
		}
		boolean test = false;
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		for(int i = 0; i < this.rotasIntituicao.size(); i++) {
			for(int j = 0; j < this.rotasIntituicao.get(i).getHorarios().size(); j++) {
					if(compararArray(this.rotasIntituicao.get(i).getHorarios().get(j).getTurno().getTurno().toCharArray(), this.turnoSelecionado.toCharArray())) {
						auxRotas.add(this.rotasIntituicao.get(i));
						test = true;
						break;
					}	
			}
		}
		if(test) {
			this.rotasTurno = auxRotas;
			return true;
		}else {
			return false;
		}

	}

	public ArrayList<ArrayList<String>> listarInicioFimDiferentes() {
		ArrayList<ArrayList<String>> todosInicioFim = new  ArrayList<ArrayList<String>>();
		ArrayList<String> auxInicioFim = new ArrayList<String>();
		boolean test = true;
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			auxInicioFim.add(this.rotasTurno.get(i).getInicio());
			auxInicioFim.add(this.rotasTurno.get(i).getFim());			
			if(i == 0) {
				todosInicioFim.add(auxInicioFim);
			}
			for(int j = 0; j < todosInicioFim.size(); j++) {
				if(auxInicioFim.get(0) == todosInicioFim.get(j).get(0) && auxInicioFim.get(1) == todosInicioFim.get(j).get(1)) {
					test = false;
					break;
				}
			}
			if(test) {
				todosInicioFim.add(auxInicioFim);	
			}
		}
		this.todosIniciosFim = todosInicioFim;
		return this.todosIniciosFim;
	}
	
	public boolean filtrarRotasInicioFim(int x) {
		x--;
		String inicio = this.todosIniciosFim.get(x).get(0);
		String fim = this.todosIniciosFim.get(x).get(1);
		
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		boolean test = false;
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			if(compararArray(this.rotasTurno.get(i).getInicio().toCharArray(), inicio.toCharArray()) && compararArray(this.rotasTurno.get(i).getFim().toCharArray(), fim.toCharArray() )) {
				test = true;
				auxRotas.add(this.rotasTurno.get(i));
			}
		}
		this.rotasFim = new ArrayList<Rota>();
		this.rotasFim = auxRotas;
		if(test) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public void selecionarPercurso(int i) {
		i--;
		this.percursoSelecionado = this.todosPercursos.get(i);
		filtrarRotasPercurso();
	}
	
	private void filtrarRotasPercurso() {
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			if(this.rotasTurno.get(i).getPercurso() == percursoSelecionado) {
				auxRotas.add(this.rotasTurno.get(i));
			}
		}
		this.rotasFim = new ArrayList<Rota>();
		this.rotasFim = auxRotas;
	}
		
	public void pegarPontosTodasRotas() {
		ArrayList<ArrayList<Ponto>> pontosTodasRotas = new ArrayList<ArrayList<Ponto>> ();
		ArrayList<Ponto> pontosCadaRota = new ArrayList<Ponto>();
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			for(int j = 0; j < this.rotasTurno.get(i).getPontos().size(); j++) {
				pontosCadaRota.add(this.rotasTurno.get(i).getPontos().get(j));
			}
			pontosTodasRotas.add(pontosCadaRota);
		}
		this.pontosTodasRotas = pontosTodasRotas;
	}
	public ArrayList<Ponto>  listarPontos(){
		ArrayList<Ponto> pontosSeparados = new ArrayList<Ponto>();
		ArrayList<Ponto> pontosDiferentes = new ArrayList<Ponto>();
		for (Rota r : this.rotasTurno) {
			for (Ponto p : r.getPontos()) {
					pontosSeparados.add(p);
			}
		}
		boolean aux = true;
		for(int i = 0; i < pontosSeparados.size(); i++){
			aux = true;
			for(int j = 0; j < pontosDiferentes.size(); j++){
				if(pontosSeparados.get(i).getId() == pontosDiferentes.get(j).getId()){
					aux = false;
				}
			}
			if(aux){
				pontosDiferentes.add(pontosSeparados.get(i));
			}
		}
		this.pontos = pontosDiferentes;
		return pontosDiferentes;
	}
	/*
	public ArrayList<Ponto>  listarPontos() {
		ArrayList<Ponto> pontos = new ArrayList<Ponto>();
		Ponto auxPonto = new Ponto();
		boolean test = true;
		for(int i = 0; i < this.pontosTodasRotas.size(); i++) {
			for(int j = 0; j < this.pontosTodasRotas.get(i).size(); j++) {
				auxPonto = this.pontosTodasRotas.get(i).get(j);
				if(i == 0 && j == 0) {
					pontos.add(auxPonto);
				}
				else {
					for(int k = 0; k < pontos.size(); k++) {
						if(auxPonto.getId() == pontos.get(k).getId()) {
							test = false;
							break;
						}
					}
				}
				if(test) {
					pontos.add(auxPonto);
				}
			}
		}
		this.pontos = pontos;
		return this.pontos;
	}
	*/
	
	public void selecionarPonto(int i) {
		i--;
		this.pontoSelecionado = this.pontos.get(i);
		filtrarRotasPonto();
	}
	
	private void filtrarRotasPonto() {
		ArrayList<Rota> rotas = new ArrayList<Rota>();
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			for(int j = 0; j < this.rotasTurno.get(i).getPontos().size(); j++) {
				if(this.pontoSelecionado.getId() == this.rotasTurno.get(i).getPontos().get(j).getId()) {
					rotas.add(this.rotasTurno.get(i));
				}
			}
		}
		this.rotasFim = rotas;
	}
	
	public 	ArrayList<String> listarPercursos() {
		ArrayList<String> percursos = new ArrayList<String>();
		String auxPercurso = "";
		boolean test = true;
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			auxPercurso = this.rotasTurno.get(i).getPercurso();
			if(i == 0) {		
				percursos.add(auxPercurso);
			}
			for(int j = 0; j < percursos.size(); j++) {
				if(auxPercurso == percursos.get(j)) {
					test = false;
					break;
				}
			}
			if(test) {
				percursos.add(auxPercurso);
			}
		}
		this.todosPercursos = percursos;
		return this.todosPercursos;
	}
	
	private void buscarOnibus() {
		RotaDAO rDAO = new RotaDAO();
		this.onibusSelecionado = rDAO.listarOnibus(this.rotaSelecionada, 1); 
	}

	/*Getters e Setters*/
	
	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}

	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
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

	public Onibus getOnibusSelecionado() {
		return onibusSelecionado;
	}

	public void setOnibusSelecionado(Onibus onibusSelecionado) {
		this.onibusSelecionado = onibusSelecionado;
	}
	
	public String getTurnoSelecionado() {
		return turnoSelecionado;
	}

	public void setTurnoSelecionado(String turnoSelecionado) {
		this.turnoSelecionado = turnoSelecionado;
	}

	public ArrayList<Rota> getRotasIntituicao() {
		return rotasIntituicao;
	}

	public void setRotasIntituicao(ArrayList<Rota> rotasIntituicao) {
		this.rotasIntituicao = rotasIntituicao;
	}

	public ArrayList<Rota> getRotasTurno() {
		return rotasTurno;
	}

	public void setRotasTurno(ArrayList<Rota> rotasTurno) {
		this.rotasTurno = rotasTurno;
	}

	public ArrayList<Rota> getRotasFim() {
		return rotasFim;
	}

	public void setRotasFim(ArrayList<Rota> rotasFim) {
		this.rotasFim = rotasFim;
	}

	public String getPercursoSelecionado() {
		return percursoSelecionado;
	}

	public void setPercursoSelecionado(String percursoSelecionado) {
		this.percursoSelecionado = percursoSelecionado;
	}

	public Ponto getPontoSelecionado() {
		return pontoSelecionado;
	}

	public void setPontoSelecionado(Ponto pontoSelecionado) {
		this.pontoSelecionado = pontoSelecionado;
	}

	public ArrayList<ArrayList<String>> getTodosIniciosFim() {
		return todosIniciosFim;
	}

	public void setTodosIniciosFim(ArrayList<ArrayList<String>> todosIniciosFim) {
		this.todosIniciosFim = todosIniciosFim;
	}

	public ArrayList<String> getTodosPercursos() {
		return todosPercursos;
	}

	public void setTodosPercursos(ArrayList<String> todosPercursos) {
		this.todosPercursos = todosPercursos;
	}

	public ArrayList<ArrayList<Ponto>> getPontosTodasRotas() {
		return pontosTodasRotas;
	}

	public void setPontosTodasRotas(ArrayList<ArrayList<Ponto>> pontosTodasRotas) {
		this.pontosTodasRotas = pontosTodasRotas;
	}

	public ArrayList<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}

}