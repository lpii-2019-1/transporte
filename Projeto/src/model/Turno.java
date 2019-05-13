package model;


public class Turno{
	private int id = 0;
    private String turno;   
    
    public Turno(int id, String turno){
    	this.id = id;
        this.turno = turno;  
    }
    public Turno(String turno){
        this.turno = turno;  
    }
    public Turno(){
    	
    }

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTurno() {
		return this.turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
}