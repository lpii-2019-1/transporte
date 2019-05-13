package principal;
import java.util.Calendar;

public class Horario {
	private Calendar hrSaidaPrimeiroPonto;
	private Calendar hrRegresso;
	
	// getters e setters
	public Calendar getHrSaidaPrimeiroPonto() {
		return hrSaidaPrimeiroPonto;
	}
	public void setHrSaidaPrimeiroPonto(Calendar hrSaidaPrimeiroPonto) {
		this.hrSaidaPrimeiroPonto = hrSaidaPrimeiroPonto;
	}
	
	public Calendar getHrRegresso() {
		return hrRegresso;
	}
	public void setHrRegresso(Calendar hrRegresso) {
		this.hrRegresso = hrRegresso;
	}
	
	//metodos
	public boolean insereHrSaida(int hora, int minutos) {
		
		try {
			Calendar cal = Calendar.getInstance();

		    cal.set(Calendar.HOUR_OF_DAY, hora);
		    cal.set(Calendar.MINUTE, minutos);
		  	
			this.setHrSaidaPrimeiroPonto(cal);
			return true;
			
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public boolean insereHrRegresso(int hora, int minutos) {
		try {
			Calendar cal = Calendar.getInstance();
	
		    cal.set(Calendar.HOUR_OF_DAY, hora);
		    cal.set(Calendar.MINUTE, minutos);
		   
			this.setHrRegresso(cal);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
