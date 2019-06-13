package controlAdm;

import model.Rota;
import model.Turno;

import java.util.ArrayList;

import dao.InstituicaoDAO;
import dao.PontoDAO;
import dao.RotaDAO;
import dao.TurnoDAO;
import model.Horario;
import model.Instituicao;
import model.Onibus;
import model.Ponto;

public class ControlAdmRota {
	private Onibus onibusSelecionado;
	public Onibus getOnibusSelecionado() {
		return onibusSelecionado;
	}
	public void setOnibusSelecionado(Onibus onibusSelecionado) {
		this.onibusSelecionado = onibusSelecionado;
	}
	private Rota rotaSelecionada;
	private ArrayList<Rota> listaDeRotas;
	private ArrayList<Ponto> pontosDaRota;
	private ArrayList<Instituicao> listaDeInstituicoes;
	
	public boolean inserirRota(ArrayList<String> dadosRota) {
		RotaDAO rDAO = new RotaDAO();
		this.rotaSelecionada =  new Rota(dadosRota.get(0), dadosRota.get(1), dadosRota.get(2));
		if(rDAO.inserirRota(this.rotaSelecionada, this.onibusSelecionado)) {
			return true;
		}else {
			return false;
		}
	
	}
	public Rota consultarIdentificador(String identificador) {
		int ident = Integer.parseInt(identificador);
		RotaDAO rDAO = new RotaDAO();
		Rota rota = new Rota();
		rota.setIdentificador(ident);
		this.rotaSelecionada = rDAO.consultarIdentificador(this.onibusSelecionado, rota, 2);
		return this.rotaSelecionada;
	}
	public ArrayList<Rota> consultarInicio(String inicio) {
		RotaDAO rDAO = new RotaDAO();
		Rota rota = new Rota();
		rota.setInicio(inicio);
		ArrayList<Rota> rotas = rDAO.consultarInicio(rota, 2);
		return rotas;
	}
	public ArrayList<Rota> consultarFim(String fim) {
		RotaDAO rDAO = new RotaDAO();
		Rota rota = new Rota();
		rota.setFim(fim);
		ArrayList<Rota> rotas = rDAO.consultarFim(rota, 2);
		return rotas;
	}
	public ArrayList<Rota> consultarPercurso(String percurso) {
		RotaDAO rDAO = new RotaDAO();
		Rota rota = new Rota();
		rota.setPercurso(percurso);
		ArrayList<Rota> rotas = rDAO.consultarPercurso(rota, 2);
		return rotas;
	}
	
	public ArrayList<Rota> consultarPonto(String endereco) {
		RotaDAO rDAO = new RotaDAO();
		PontoDAO pDAO = new PontoDAO();
		Ponto ponto = new Ponto();
		ponto.setEndereco(endereco);
		ponto = pDAO.consultarEndereco(ponto, 2);
		ArrayList<Rota> rotas = new ArrayList<Rota>();
		rotas = rDAO.consultarIdPonto(ponto, 2);
		return rotas;
	}
	
	public ArrayList<Rota> consultarInstituicao(String endereco) {
		RotaDAO rDAO = new RotaDAO();
		InstituicaoDAO iDAO = new InstituicaoDAO();
		Instituicao instituicao = new Instituicao();
		instituicao.setEndereco(endereco);
		instituicao = iDAO.consultarEndereco(instituicao, 2);
		ArrayList<Rota> rotas = new ArrayList<Rota>();
		rotas = rDAO.consultarIdInstituicao(instituicao, 2);
		return rotas;
	}
	
	public ArrayList<Rota> consultarTurno(String turno) {
		RotaDAO rDAO = new RotaDAO();
		TurnoDAO tDAO = new TurnoDAO();
		Turno turnoSel = new Turno();
		turnoSel.setTurno(turno);
		turnoSel = tDAO.consultarTurno(turnoSel);
		ArrayList<Rota> rotas = new ArrayList<Rota>();
		rotas = rDAO.consultarIdTurno(turnoSel, 2);
		return rotas;
	}
	
	public ArrayList<Rota> listarRotas(){	
		RotaDAO rDAO = new RotaDAO();
		this.listaDeRotas = rDAO.listarRotas(2);
		return this.listaDeRotas;
	}
	
	public boolean excluirRota() {
		RotaDAO rDAO = new RotaDAO();
		ControlAdmInstituicaoRota ctrInt = new ControlAdmInstituicaoRota();
		ControlAdmHorario ctrHor = new ControlAdmHorario();
		ControlAdmPontoRota ctrPon = new ControlAdmPontoRota();
		if(this.rotaSelecionada.getInstituicoes().get(0).getId() != 0){
			for(Instituicao i: this.rotaSelecionada.getInstituicoes()){
				ctrInt.setInstituicaoSelecionada(i);
				ctrInt.excluirInstituicao();
			}
		}
		if(this.rotaSelecionada.getHorarios().get(0).getId() != 0){
			for(Horario h: this.rotaSelecionada.getHorarios()){
				ctrHor.setHorarioSelecionado(h);
				ctrHor.excluirHorario();
			}
		}
		if(this.rotaSelecionada.getPontos().get(0).getId() != 0){
			for(Ponto p: this.rotaSelecionada.getPontos()){
				ctrPon.setPontoSelecionado(p);
				ctrPon.excluirPonto();
			}
		}
		if(rDAO.excluirRota(this.rotaSelecionada)) {
			return true;
		}else {
			return false;
		}
	}

	
	public boolean editarPercurso(String percurso) {
		RotaDAO rDAO = new RotaDAO();

		this.rotaSelecionada.setPercurso(percurso);
		if(rDAO.editarPercurso(this.rotaSelecionada)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarInicio(String inicio) {
		RotaDAO rDAO = new RotaDAO();

		this.rotaSelecionada.setInicio(inicio);
		if(rDAO.editarInicio(this.rotaSelecionada)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarFim(String fim) {
		RotaDAO rDAO = new RotaDAO();

		this.rotaSelecionada.setFim(fim);
		if(rDAO.editarFim(this.rotaSelecionada)) {
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<Instituicao> listarinstituicoes() {
		this.listaDeInstituicoes = new ArrayList<Instituicao>();
		for(int i = 0; i < this.rotaSelecionada.getInstituicoes().size(); i++) {
			this.listaDeInstituicoes.add(this.rotaSelecionada.getInstituicoes().get(i));
		}
		return this.listaDeInstituicoes;
	}
	
	public ArrayList<Ponto> listarPontosRota() {
		this.pontosDaRota = new ArrayList<Ponto>();
		for(int i = 0; i < this.rotaSelecionada.getPontos().size(); i++) {
			this.pontosDaRota.add(this.rotaSelecionada.getPontos().get(i));
		}
		return this.pontosDaRota;
	}
	
	public boolean editarValidacao(String validacao) {
		RotaDAO rDAO = new RotaDAO();
		boolean test1 = false, test2 = false, test3 = false;
		int validade = 0;
		if(validacao.equalsIgnoreCase("Disponivel")){
			validade = 1;
		}else if(validacao.equalsIgnoreCase("Indisponivel")){
			validade = 0;
		}
		if(validade == 1) {
			for(int i = 0; i < this.rotaSelecionada.getInstituicoes().size(); i++) {
				if(this.rotaSelecionada.getInstituicoes().get(i).getValidacao() == 1) {
					test1 = true;
				}
			}
			for(int i = 0; i < this.rotaSelecionada.getPontos().size(); i++) {
				if(this.rotaSelecionada.getPontos().get(i).getValidacao() == 1)
					test2 = true;
			}
			for(int i = 0; i < this.rotaSelecionada.getHorarios().size(); i++) {
				if(this.rotaSelecionada.getHorarios().get(i).getValidacao() == 1)
					test3 = true;
			}
			
			if(test1 && test2 && test3) {
				this.rotaSelecionada.setValidacao(validade);
				if(rDAO.editarValidacao(this.rotaSelecionada)) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			this.rotaSelecionada.setValidacao(validade);
			if(rDAO.editarValidacao(this.rotaSelecionada)) {
				return true;
			}else {
				return false;
			}
		}	
	}
	
	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}
	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
	}
	public ArrayList<Rota> getListaDeRotas() {
		return listaDeRotas;
	}
	public void setListaDeRotas(ArrayList<Rota> listaDeRotas) {
		this.listaDeRotas = listaDeRotas;
	}

}
