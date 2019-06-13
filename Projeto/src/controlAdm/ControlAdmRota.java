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
	
	public boolean cadastrarHorario(ArrayList<String> valores){
		ControlAdmHorario ctrl = new ControlAdmHorario();
		
		ctrl.inserirHorario(this.rotaSelecionada.getId(), valores);
		
		return true;
		
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
	/*---------------------------------------------------------------------------------*/
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
	/*--------------------------------------------------------------------------------------------*/
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
