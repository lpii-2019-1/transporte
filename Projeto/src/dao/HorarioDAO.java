package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Horario;


public class HorarioDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public HorarioDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean inserirHorario(Horario horario){
        try {
            String sql = "INSERT INTO horario (horario_saida, horario_regresso) VALUES (?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, horario.getHrSaidaPrimeiroPonto());
            this.stmt.setString(2, horario.getHrRegresso());
            this.stmt.execute();
            this. stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	private boolean editarHorario(String campo, String valor, int id){
        try {
            String sql = "UPDATE horario SET " + campo + " = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setString(1, valor);
        	this.stmt.setInt(2, id);
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	public boolean editarHrSaidaPrimeiroPonto(Horario horario){
		return this.editarHorario("horario_saida", horario.getHrSaidaPrimeiroPonto(), horario.getId());
	}

	public boolean editarHrRegresso(Horario horario){
		return this.editarHorario("horario_Regresso", horario.getHrRegresso(), horario.getId());
	}
	
	private ArrayList<Horario> consutarHorario(String campo, String valor){
		try {
			String sql = "SELECT * FROM horario WHERE " + campo + " = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Horario> horarios = new ArrayList<Horario>();
            Horario horario = new Horario();
            while(rs.next()) {
            	aux = false;
            	horario = new Horario(rs.getInt("id"),  rs.getString("horario_saida"), rs.getString("horario_regresso"));
            	horarios.add(horario);
            }
            if(aux) {
            	horarios.add(horario);
            }
            this.stmt.close();
            return horarios;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Horario> consultarHrSaidaPrimeiroPonto(Horario horario){
		return this.consutarHorario("horario_saida", horario.getHrSaidaPrimeiroPonto());
	}

	public ArrayList<Horario> consultarHrRegresso(Horario horario){
		return this.consutarHorario("horario_regresso", horario.getHrRegresso());
	}
	
	public ArrayList<Horario> listarHorarios(){
		try {
			String sql = "SELECT * FROM horario";
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Horario> horarios = new ArrayList<Horario>();
            Horario horario = new Horario();
            while(rs.next()) {
            	aux = false;
            	horario = new Horario(rs.getInt("id"),  rs.getString("horario_saida"), rs.getString("horario_regresso"));
            	horarios.add(horario);
            }
            if(aux) {
            	horarios.add(horario);
            }
            this.stmt.close();
            return horarios;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public Horario consultarId(int id){
		try {
			String sql = "SELECT * FROM ponto WHERE id = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Horario horario = new Horario();
            if(rs.next()) {
            	horario = new Horario(rs.getInt("id"),  rs.getString("horario_saida"), rs.getString("horario_regresso"));
            }
            this.stmt.close();
            return horario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public boolean excluirHorario(Horario horario){
        try {
            String sql = "DELETE horario WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, horario.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
