package controlUsuario;

import model.*;

import java.util.ArrayList;

import dao.*;

public class ControlUsuario {
	
	private Rota rotaSelecionada;
	private Cidade cidadeSelecionada;
	private Instituicao instituicaoSelecionada;
	private ArrayList<Rota> rotas;
	private Onibus onibusSelecionado;
	/*------------ M�todos para pesquisar cidade e retornar institui��es ------------*/
	
	public ArrayList<Instituicao> pesquisarCidade(String nome, String uf){
		CidadeDAO cDAO = new CidadeDAO();
		Cidade c = new Cidade();
		c.setNome(nome);
		c.setUf(uf);
		c = cDAO.consultarNomeUf(c, 1);
		this.cidadeSelecionada = c;
		return this.cidadeSelecionada.getInstituicoes();
	}
	
	public boolean verificaId(Cidade c) {
		if(c.getId() == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public void selecionarInstituicao(int i) {
		i--;
		this.instituicaoSelecionada = this.cidadeSelecionada.getInstituicoes().get(i);
		
	}
	/*------------------------------------------------------------------------------------*/
	
	public ArrayList<Rota> buscarRotas() {
		RotaDAO rDAO = new RotaDAO();
		this.rotas  = rDAO.consultarIdInstituicao(this.instituicaoSelecionada); //FALTA CRIAR ESSE M�TODO NO InstituicaoDAO
		return this.rotas;
	}
	
	public void selecionarRota(int i) {
		i--;
		this.rotaSelecionada = this.rotas.get(i);
	}
/*----------------------------------------------------------------------------------------------*/
	public ArrayList<ArrayList<Horario>> listarTurnosDasRotas() {
		ArrayList<ArrayList<Horario>> turnosTodasRotas = new  ArrayList<ArrayList<Horario>>();
		ArrayList<Horario> turnosCadaRota = new ArrayList<Horario>();
		
		for(int i = 0; i < this.rotas.size(); i++) {
			
			for(int j = 0; j < 3; j++) {
				if(this.rotas.get(j) != null) {
					turnosCadaRota.add(this.rotas.get(j).getHorarios().get(j));
				}
			}
			turnosTodasRotas.add(turnosCadaRota);
		}
		return turnosTodasRotas;
	}
/*----------------------------------------------------------------------------------------------*/
	public ArrayList<Horario> listarTurnos(String turno) {
		ArrayList<Horario> turnos = new ArrayList<Horario>();
		for(int i = 0; i < this.rotas.size(); i++) {
			for(int j = 0; j < 3; j++) {
				if(this.rotas.get(i).getHorarios().get(j) != null) {
					if(this.rotas.get(i).getHorarios().get(j).getTurno().getTurno() == turno) {
						turnos.add(this.rotas.get(i).getHorarios().get(j));
					}
				}
			}
			
		}
		return turnos;
	}

	/*M�todos para Filtrar rotas por inicio e fim, percurso e ponto*/	
	
	public void filtrarRotasTurno(String turno, String ida, String volta) {
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		Horario auxHr = new Horario();
		for(int i = 0; i < this.rotas.size(); i++) {
			for(int j = 0; j < 3; j++) {
				auxHr.setHrSaidaPrimeiroPonto(this.rotas.get(i).getHorarios().get(j).getHrSaidaPrimeiroPonto());
				auxHr.setHrRegresso(this.rotas.get(i).getHorarios().get(j).getHrRegresso());
				auxHr.setTurno(this.rotas.get(i).getHorarios().get(j).getTurno());
				if(auxHr.getTurno().getTurno() == turno && auxHr.getHrSaidaPrimeiroPonto() == ida && auxHr.getHrRegresso() == volta) {
					auxRotas.add(this.rotas.get(i));
				}
			}
		}
		this.rotas = new ArrayList<Rota>();
		this.rotas = auxRotas;
	}
	
	public void filtrarRotasInicioFim(String inicio, String fim) {
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		for(int i = 0; i < this.rotas.size(); i++) {
			if(this.rotas.get(i).getInicio() == inicio && this.rotas.get(i).getFim() == fim) {
				auxRotas.add(this.rotas.get(i));
			}
		}
		this.rotas = new ArrayList<Rota>();
		this.rotas = auxRotas;
	}
	
	public void filtrarRotasPercurso(String percurso) {
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		for(int i = 0; i < this.rotas.size(); i++) {
			if(this.rotas.get(i).getPercurso() == percurso) {
				auxRotas.add(this.rotas.get(i));
			}
		}
		this.rotas = new ArrayList<Rota>();
		this.rotas = auxRotas;
	}
	
	public ArrayList<ArrayList<Ponto>> listarPontos() {
		ArrayList<ArrayList<Ponto>> pontosTodasRotas = new ArrayList<ArrayList<Ponto>> ();
		ArrayList<Ponto> pontosCadaRota = new ArrayList<Ponto>();
		for(int i = 0; i < this.rotas.size(); i++) {
			for(int j = 0; j < this.rotas.get(i).getPontos().size(); i++) {
				pontosCadaRota.add(this.rotas.get(i).getPontos().get(j));
			}
			pontosTodasRotas.add(pontosCadaRota);
		}
		return pontosTodasRotas;
	}
	
	public 	ArrayList<String> listarPercursos() {
		ArrayList<String> percursos = new ArrayList<String>();
		for(int i = 0; i < this.rotas.size(); i++) {
			percursos.add(this.rotas.get(i).getPercurso());		
		}
		return percursos;
	}
	public void buscarOnibus() {
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = oDAO.consultarIdRota(this.rotaSelecionada, 1); // FALTA CRIAR ESSE M�TODO NO onibusDAO
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

	public ArrayList<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(ArrayList<Rota> rotas) {
		this.rotas = rotas;
	}

	public Onibus getOnibusSelecionado() {
		return onibusSelecionado;
	}

	public void setOnibusSelecionado(Onibus onibusSelecionado) {
		this.onibusSelecionado = onibusSelecionado;
	}
	
}

