package controlAdm;

import model.Horario;
import model.Rota;

import java.util.ArrayList;

import java.text.SimpleDateFormat;

import dao.HorarioDAO;

public class ControlAdmHorario {
	
	private Horario horarioSelecionado;
	private ArrayList<Horario> horarios;
	
	
	
	public ArrayList<Horario>  consultarHorarioPorRota(Rota rota) {
		HorarioDAO hDAO = new HorarioDAO();
		this.horarios =  hDAO.consultarIdRota(rota, 2);
		return this.horarios;
	}
	
	public void inserirHorario(int id_rota, ArrayList<String> valores) {
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
			
			hDAO.inserirHorario(id_rota, this.horarioSelecionado, turno);
		}catch(Exception e) {
            throw new RuntimeException(e);
            	
		}
		
	}
	
	public void editarHrRegresso(String horario) {
		HorarioDAO hDAO = new HorarioDAO();
		
		this.horarioSelecionado.setHrRegresso(horario);
		hDAO.editarHrRegresso(this.horarioSelecionado);
	}
	public void editarHrSaidaPrimeiroPont(String horario) {
		HorarioDAO hDAO = new HorarioDAO();
		this.horarioSelecionado.setHrSaidaPrimeiroPonto(horario);
		hDAO.editarHrSaidaPrimeiroPonto(this.horarioSelecionado);
	}
	
	public Horario getHorarioSelecionado() {
		return horarioSelecionado;
	}

	public void setHorarioSelecionado(Horario horarioSelecionado) {
		this.horarioSelecionado = horarioSelecionado;
	}

}
