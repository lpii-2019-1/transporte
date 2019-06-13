package controlAdm;

import model.Horario;
import model.Rota;
import model.Turno;

import java.util.ArrayList;

import java.text.SimpleDateFormat;

import dao.HorarioDAO;
import dao.RotaDAO;
import dao.TurnoDAO;

public class ControlAdmHorario {
	private Rota rotaSelecionada;

	private Horario horarioSelecionado;
	
	public boolean inserirHorario(ArrayList<String> valores) {
		try {
			int turno = 0;
			HorarioDAO hDAO = new HorarioDAO();
			this.horarioSelecionado = new Horario();
			this.horarioSelecionado.setHrSaidaPrimeiroPonto(valores.get(0));
			this.horarioSelecionado.setHrRegresso(valores.get(1));
			
			SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm");
			
			if(this.horarioSelecionado.getHrRegressoDate().getTime() < sdf.parse("12:00").getTime()) {
				turno = 1;
			}else if(this.horarioSelecionado.getHrRegressoDate().getTime() < sdf.parse("18:00").getTime()){
				turno = 2;
			}else if(this.horarioSelecionado.getHrRegressoDate().getTime() < sdf.parse("23:59").getTime()){
				turno = 3;
			}
			return hDAO.inserirHorario(this.rotaSelecionada, this.horarioSelecionado, turno);
		}catch(Exception e) {
            throw new RuntimeException(e);
            	
		}
		
	}
	
	public ArrayList<Horario> consultarHrRegresso(String hr) {
		HorarioDAO hDAO = new HorarioDAO();
		Horario horario = new Horario();
		ArrayList<Horario> horarios = new ArrayList<Horario>();
		horario.setHrRegresso(hr);
		boolean aux = true;
		for(Horario hR : this.rotaSelecionada.getHorarios()){
			for(Horario hD : hDAO.consultarHrRegresso(horario, 2)){
				if(hD.getId() == hR.getId()) {
					aux = false;
					horarios.add(hR);
				}
			}
		}
		if(aux){
			return horarios;
		}
		horarios.add(horario);
		return horarios;
	}
	
	public ArrayList<Horario> consultarTurno(String turnoS) {
		HorarioDAO hDAO = new HorarioDAO();
		TurnoDAO tDAO = new TurnoDAO();
		Turno turno = new Turno(turnoS);
		Horario horario = new Horario();
		ArrayList<Horario> horarios = new ArrayList<Horario>();
		boolean aux = true;
		for(Horario hR : this.rotaSelecionada.getHorarios()){
			for(Horario hD : hDAO.consultarIdTurno(tDAO.consultarTurno(turno), 2)){
				if(hD.getId() == hR.getId()) {
					aux = false;
					horarios.add(hR);
				}
			}
		}
		if(aux){
			return horarios;
		}
		horarios.add(horario);
		return horarios;
	}
	
	public ArrayList<Horario> consultarHrSaida(String hr) {
		HorarioDAO hDAO = new HorarioDAO();
		Horario horario = new Horario();
		ArrayList<Horario> horarios = new ArrayList<Horario>();
		horario.setHrSaidaPrimeiroPonto(hr);
		boolean aux = true;
		for(Horario hR : this.rotaSelecionada.getHorarios()){
			for(Horario hD : hDAO.consultarHrSaidaPrimeiroPonto(horario, 2)){
				if(hD.getId() == hR.getId()) {
					aux = false;
					horarios.add(hR);
				}
			}
		}
		if(aux){
			return horarios;
		}
		horarios.add(horario);
		return horarios;
	}
	
	public Horario consultarHrSaidaRegresso(ArrayList<String> valeres) {
		HorarioDAO hDAO = new HorarioDAO();
		Horario horario = new Horario();
		horario.setHrRegresso(valeres.get(0));
		horario.setHrSaidaPrimeiroPonto(valeres.get(1));
		for(Horario hR : this.rotaSelecionada.getHorarios()){
			for(Horario hD : hDAO.consultarHrSaidaRegresso(horario, 2)){
				if(hD.getId() == hR.getId()){
					this.horarioSelecionado = hR;
					horario = hR;
				}
			}
		}
		return horario;
	}
	
	public boolean editarHrRegresso(String horario) {
		HorarioDAO hDAO = new HorarioDAO();
		this.horarioSelecionado.setHrRegresso(horario);
		return hDAO.editarHrRegresso(this.horarioSelecionado);
	}
	public boolean editarHrSaida(String horario) {
		HorarioDAO hDAO = new HorarioDAO();
		this.horarioSelecionado.setHrSaidaPrimeiroPonto(horario);
		return hDAO.editarHrSaidaPrimeiroPonto(this.horarioSelecionado);
	}
	
	public ArrayList<Horario> listarHorarios(){
		ArrayList<Horario> horarios = new ArrayList<Horario>();
		for(Horario h : this.rotaSelecionada.getHorarios()){
			horarios.add(h);
		}
		return horarios;
	}
	
	public boolean editarValidacao(String validacao) {
		HorarioDAO hDAO = new HorarioDAO();
		if(validacao.equalsIgnoreCase("Disponivel")) {
			this.horarioSelecionado.setValidacao(1);
			if(hDAO.editarValidacao(this.horarioSelecionado)) {
				return true;
			}else {
				return false;
			}
		}
		else if(validacao.equalsIgnoreCase("Indisponivel")){
			this.horarioSelecionado.setValidacao(0);
			if(hDAO.editarValidacao(this.horarioSelecionado)) {
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean excluirHorario() {
		RotaDAO rDAO = new RotaDAO();
		if(rDAO.consultarIdHorario(this.horarioSelecionado, 2).getId() != 0) {
			rDAO.excluirHorario(this.rotaSelecionada, this.horarioSelecionado);
		}
		HorarioDAO iDAO = new HorarioDAO();
		if (iDAO.excluirHorario(this.horarioSelecionado)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Horario getHorarioSelecionado() {
		return horarioSelecionado;
	}

	public void setHorarioSelecionado(Horario horarioSelecionado) {
		this.horarioSelecionado = horarioSelecionado;
	}
	
	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}

	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
	}


}
