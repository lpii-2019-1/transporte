package controlAdm;

import model.Rota;

import java.util.ArrayList;

import dao.RotaDAO;
import model.Instituicao;
import model.Onibus;
import model.Ponto;

public class ControlAdmRota {
	private Rota rotaSelecionada;
	private ArrayList<Rota> listaDeRotas;
	private ArrayList<Ponto> pontosDaRota;
	private Ponto pontoSelecionado;
	private ArrayList<Instituicao> listaDeInstituicoes;
	private Instituicao instituicaoSelecionada;
	
	public boolean inserirRota(int id_onibus, ArrayList<String> dadosRota) {
		RotaDAO rDAO = new RotaDAO();
		this.rotaSelecionada =  new Rota(dadosRota.get(0), dadosRota.get(1), dadosRota.get(2));
		if(rDAO.inserirRota(this.rotaSelecionada, id_onibus)) {
			return true;
		}else {
			return false;
		}
	
	}
	public Rota consultarIdentificador(Onibus onibus, int identificador) {
		RotaDAO rDAO = new RotaDAO();
		this.rotaSelecionada = rDAO.consultarIdentificador(onibus, identificador, 2);
		return this.rotaSelecionada;
	}
	
	public ArrayList<Rota> listarRotas(){	
		RotaDAO rDAO = new RotaDAO();
		this.listaDeRotas = rDAO.listarRotas(2);
		return this.listaDeRotas;

	}
	
	public boolean excluirRota() {
		RotaDAO rDAO = new RotaDAO();
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
	/*---------------------------------------INSTITUICOES ---------------------------------------*/
	public boolean inserirInstituicao(String endereco) {
		RotaDAO rDAO = new RotaDAO();

		ControlAdmInstituicao ctrlInst = new ControlAdmInstituicao();
		Instituicao inst = new Instituicao();
		
		inst = ctrlInst.consultarEndereco(endereco);
		if(inst.getId() != 0) {
			if(rDAO.inserirInstituicaoRota(this.rotaSelecionada, inst)) {
				return true;
			}else {
				return false;
			}
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
	
	public boolean removerInstituicao() {
		RotaDAO rDAO = new RotaDAO();
		if(rDAO.excluirInstituicao(this.rotaSelecionada, this.instituicaoSelecionada)) {
			return true;
		}else {
			return false;
		}
	}
	
	/*---------------------------------------PONTOS---------------------------------------*/
	
	public boolean inserirPonto(String endereco) {
		RotaDAO rDAO = new RotaDAO();
		ControlAdmPonto ctrlPonto = new ControlAdmPonto();
		Ponto ponto =  new Ponto();
		ponto  =  ctrlPonto.consultarEndereco(endereco);
		if(ponto.getId() != 0) {
			if(rDAO.inserirPontoRota(this.rotaSelecionada, ponto)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public ArrayList<Ponto> getPontosDaRota() {
		return pontosDaRota;
	}
	public void setPontosDaRota(ArrayList<Ponto> pontosDaRota) {
		this.pontosDaRota = pontosDaRota;
	}
	public Ponto getPontoSelecionado() {
		return pontoSelecionado;
	}
	public void setPontoSelecionado(Ponto pontoSelecionado) {
		this.pontoSelecionado = pontoSelecionado;
	}

	public ArrayList<Ponto> listarPontosRota() {
		this.pontosDaRota = new ArrayList<Ponto>();
		for(int i = 0; i < this.rotaSelecionada.getPontos().size(); i++) {
			this.pontosDaRota.add(this.rotaSelecionada.getPontos().get(i));
		}
		return this.pontosDaRota;
	}
	
	public boolean selecionarPonto(String endereco) {
		boolean test = false;
		for(int i = 0; i < this.pontosDaRota.size(); i++) {
			if(this.pontosDaRota.get(i).getEndereco() == endereco) {
				this.pontoSelecionado = this.pontosDaRota.get(i);
				test = true;
				break;
			}
		}
		if(test) {
			return true;
		}else {
			return false;
		}
	}
	public boolean editarOrdemPonto(String ordem) {
		
		int ordemAux = Integer.parseInt(ordem);
		RotaDAO rDAO = new RotaDAO();
		this.pontoSelecionado.setOrdem(ordemAux);
		if(rDAO.editarPonto(this.rotaSelecionada, this.pontoSelecionado)) {
			return true;
		}else {
			return false;
		}
	}
	/*------------------------------------HORÁRIOS-------------------------------------------------------*/
	
	public boolean cadastrarHorario(ArrayList<String> valores){
		ControlAdmHorario ctrl = new ControlAdmHorario();
		ctrl.inserirHorario(this.rotaSelecionada.getId(), valores);
		return true;
	}
	/*--------------------------------------------------------------------------------------------------*/
	@SuppressWarnings("unused")  // Não sei o motivo dessa linha, mas comenta ea aí pra ver o que acontece com os contadores dos FORs
	public boolean editarValidacao(String validacao) {
		RotaDAO rDAO = new RotaDAO();
		boolean test1 = false, test2 = false, test3 = false;
		int validade = 0;
		if( validacao == "Disponivel"){
			validade = 1;
		}else {
			validade = 0;
		}
		if(validade == 1) {
			for(int i = 0; i < this.rotaSelecionada.getInstituicoes().size(); i++) {
				if(this.rotaSelecionada.getInstituicoes().get(i).getValidacao() == 1) {
					test1 = true;
					break;
				}
			}
			for(int j = 0; j < this.rotaSelecionada.getPontos().size(); j++) {
				if(this.rotaSelecionada.getPontos().get(j).getValidacao() == 1)
					test2 = true;
					break;
			}
			for(int k = 0; k < this.rotaSelecionada.getHorarios().size(); k++) {
				if(this.rotaSelecionada.getHorarios().get(k).getValidacao() == 1)
					test3 = true;
					break;
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
