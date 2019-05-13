package principal;

import java.sql.Time;

public class Turno{
    private String turno;
    private String hrPrimeiroPonto;
    private String hrRetorno;

    public Turno(String turno, String horaPP, String horaR){
        this.turno = turno;
        this.hrPrimeiroPonto = horaPP;
        this.hrRetorno = horaR;
    }

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getHrPrimeiroPonto() {
		return hrPrimeiroPonto;
	}

	public void setHrPrimeiroPonto(String hrPrimeiroPonto) {
		this.hrPrimeiroPonto = hrPrimeiroPonto;
	}

	public String getHrRetorno() {
		return hrRetorno;
	}

	public void setHrRetorno(String hrRetorno) {
		this.hrRetorno = hrRetorno;
	}
}