package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Horario {
	private int id = 0;
	private Date hrSaidaPrimeiroPonto = new Date();
	private Date hrRegresso = new Date();
    public SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");
    
    public Horario(int id, String hrSaidaPrimeiroPonto, String hrRegresso){
    	this.id = id;
    	try {
			this.hrSaidaPrimeiroPonto = this.formatoDate.parse(hrSaidaPrimeiroPonto);
			this.hrRegresso = this.formatoDate.parse(hrRegresso);
		} catch (ParseException e) {
			e.printStackTrace();
		};
    }
    public Horario(String hrSaidaPrimeiroPonto, String hrRegresso){
    	try {
			this.hrSaidaPrimeiroPonto = this.formatoDate.parse(hrSaidaPrimeiroPonto);
			this.hrRegresso = this.formatoDate.parse(hrRegresso);
		} catch (ParseException e) {
			e.printStackTrace();
		};
    }
	public Horario(){
		
	}
	
    public int getId() {
    	return this.id;
    }
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getHrSaidaPrimeiroPonto() {
		return this.formatoDate.format(hrSaidaPrimeiroPonto);
	}
	public void setHrSaidaPrimeiroPonto(String hrSaidaPrimeiroPonto) {
		try {
			this.hrSaidaPrimeiroPonto = this.formatoDate.parse(hrSaidaPrimeiroPonto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getHrRegresso() {
		return this.formatoDate.format(hrRegresso);
	}

	public void setHrRegresso(String hrRegresso) {
		try {
			this.hrRegresso = this.formatoDate.parse(hrRegresso);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
