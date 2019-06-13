package model;

import java.util.ArrayList;

public class Rota{
	private int id = 0;
    private String inicio;
    private String fim;
    private ArrayList<Ponto> pontos = new ArrayList<Ponto>();
    private String percurso;
    private ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
    private ArrayList<Horario> horarios = new ArrayList<Horario>();
    private int validacao = 0;
    private int identificador;
    
	public Rota(int id, String inicio, String fim, String percurso) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.percurso = percurso;
	}
	public Rota(String inicio, String fim, String percurso) {
		this.inicio = inicio;
		this.fim = fim;
		this.percurso = percurso;
	}
	public Rota(int id, String inicio, String fim, String percurso, int identificador) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.percurso = percurso;
		this.identificador = identificador;
	}
	
	public Rota(int id, String inicio, String fim, String percurso, int identificador, int validacao) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.percurso = percurso;
		this.identificador = identificador;
	}
	public Rota() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	public ArrayList<Instituicao> getInstituicoes() {
		return instituicoes;
	}
	public void setInstituicoes(ArrayList<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	public ArrayList<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(ArrayList<Horario> horarios) {
		this.horarios = horarios;
	}
	
	public void inserirPonto(Ponto ponto) {
		this.pontos.add(ponto);
	}
	
	public void inserirInstituicao(Instituicao instituicao) {
		this.instituicoes.add(instituicao);
	}
	
	public void inserirHorario(Horario horario) {
		this.horarios.add(horario);
	}
	public int getValidacao() {
		return validacao;
	}
	public void setValidacao(int validacao) {
		this.validacao = validacao;
	}
	
	public String getPercurso() {
		return percurso;
	}
	public void setPercurso(String percurso) {
		this.percurso = percurso;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}