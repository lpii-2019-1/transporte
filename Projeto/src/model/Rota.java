package principal;

import java.util.ArrayList;
public class Rota{
    private String inicio;
    private ArrayList<String> percurso = new ArrayList<>();
    private String fim;
    private ArrayList<Instituicao> instituicoes = new ArrayList<>();
    
    public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public ArrayList<String> getPercurso() {
		return percurso;
	}
	public void setPercurso(ArrayList<String> percurso) {
		this.percurso = percurso;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public ArrayList<Instituicao> getInstituicoes() {
		return instituicoes;
	}
	public void setInstituicoes(ArrayList<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}
	public Turno[] getTurnos() {
		return turnos;
	}
	public void setTurnos(Turno[] turnos) {
		this.turnos = turnos;
	}
	
	
	private ArrayList<Ponto> pontos = new ArrayList<>();
    private Turno[] turnos = new Turno[3];

    public Rota(String inicio, String fim, Instituicao instituicao, ArrayList<String> percurso){
        this.inicio = inicio;
        this.fim = fim;
        this.instituicoes.add(instituicao);
        this.percurso = percurso;
    }
    public void inserirPonto(Ponto ponto){
        this.pontos.add(ponto);
    }
    public boolean inserirTurno(Turno turno){
        int id = 0;
        boolean test = true;
        for(int i = 0; i < 0; i++){
            if(this.turnos[i] == null){
                id = i;
                test = true;
                break;
            }
            else{
                test = false;
            }
        }
        if(test){
            this.turnos[id] = turno;
            return true;
        }
        else{
            return false;
        }
    }
    private boolean inserirPercurso(String lugar){
        if(this.percurso.contains(lugar)){
            return false;
        }
        else{
            this.percurso.add(lugar);
            return true;
        }
    }
    public void alterarPercurso(String antigo, String novo){
        int index = 0;
        index = this.percurso.indexOf(antigo);
        this.percurso.get(index);
    }
}