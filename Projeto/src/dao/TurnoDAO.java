package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Turno;


public class TurnoDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public TurnoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean inserirTurno(Turno turno){
        try {
            String sql = "INSERT INTO turno (turno) VALUES (?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, turno.getTurno());
            this.stmt.execute();
            this. stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public boolean editarTurno(Turno turno){
        try {
            String sql = "UPDATE turno SET turno = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setString(1, turno.getTurno());
        	this.stmt.setInt(2, turno.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public Turno consutarTurno(Turno turnoSel){
		try {
			String sql = "SELECT * FROM turno WHERE turno = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, turnoSel.getTurno());
            ResultSet rs = stmt.executeQuery();
            Turno turno = new Turno();
            if(rs.next()) {
            	turno = new Turno(rs.getInt("id"), rs.getString("turno"));
            }
            this.stmt.close();
            return turno;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

    public Turno consutarId(int id){
        try {
            String sql = "SELECT * FROM turno WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Turno turno = new Turno();
            if(rs.next()) {
                turno = new Turno(rs.getInt("id"), rs.getString("turno"));
            }
            this.stmt.close();
            return turno;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public ArrayList<Turno> listarTurnos(){
		try {
			String sql = "SELECT * FROM turno";
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Turno> turnos = new ArrayList<Turno>(); 
            Turno turno = new Turno();
            while(rs.next()){
            	aux = false;
            	turno = new Turno(rs.getInt("id"), rs.getString("turno"));
            	turnos.add(turno);
            }
            if(aux) {
            	turnos.add(turno);
            }
            this.stmt.close();
            return turnos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public boolean excluirTurno(Turno turno){
        try {
            String sql = "DELETE turno WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, turno.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
