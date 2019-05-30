package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Horario;
import model.Onibus;
import model.Rota;


public class OnibusDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public OnibusDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean inserirOnibus(Onibus onibus){
        try {
            String sql = "INSERT INTO onibus (placa, cor, motorista, mensalidade) VALUES (?, ?, ?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, onibus.getPlaca());
            this.stmt.setString(2, onibus.getCor());
            this.stmt.setString(3, onibus.getMotorista());
            this.stmt.setDouble(4, onibus.getMensalidade());
            this.stmt.execute();
            this. stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	private boolean editarOnibus(String campo, String valor, int id){
        try {
            String sql = "UPDATE onibus SET " + campo + " = ? WHERE id = ?";
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
	
	public boolean editarPlaca(Onibus onibus){
		return this.editarOnibus("placa", onibus.getPlaca(), onibus.getId());
	}

	public boolean editarCor(Onibus onibus){
		return this.editarOnibus("cor", onibus.getCor(), onibus.getId());
	}
	
	public boolean editarMotorista(Onibus onibus){
		return this.editarOnibus("motorista", onibus.getMotorista(), onibus.getId());
	}
	
	public boolean editarMensalidade(Onibus onibus){
        try {
            String sql = "UPDATE onibus SET mensalidade = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setDouble(1, onibus.getMensalidade());
        	this.stmt.setInt(2, onibus.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	private ArrayList<Onibus> consutarOnibus(String campo, String valor){
		try {
			String sql = "SELECT * FROM onibus WHERE " + campo + " = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Onibus> onibuss = new ArrayList<Onibus>();
            Onibus onibus = new Onibus();
            while(rs.next()) {
            	aux = false;
            	onibus = new Onibus(rs.getInt("id"),  rs.getString("placa"), rs.getString("cor"), rs.getString("Motorista"), rs.getDouble("mensalidade"));
            	onibuss.add(onibus);
            }
            if(aux) {
            	onibuss.add(onibus);
            }
            this.stmt.close();
            return onibuss;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Onibus> consutarPlaca(Onibus onibus){
		return this.consutarOnibus("placa", onibus.getPlaca());
	}

	public ArrayList<Onibus> consutarCor(Onibus onibus){
		return this.consutarOnibus("cor", onibus.getCor());
	}
	
	public ArrayList<Onibus> consutarMotorista(Onibus onibus){
		return this.consutarOnibus("motorista", onibus.getMotorista());
	}
	
	public ArrayList<Onibus> consutarMensalidade(Onibus onibusSel){
		try {
			String sql = "SELECT * FROM onibus WHERE mensalidade = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setDouble(1, onibusSel.getMensalidade());
	        ResultSet rs = stmt.executeQuery();
	        boolean aux = true;
	        ArrayList<Onibus> onibuss = new ArrayList<Onibus>();
	        Onibus onibus = new Onibus();
	        while(rs.next()) {
	        	aux = false;
	        	onibus = new Onibus(rs.getInt("id"),  rs.getString("placa"), rs.getString("cor"), rs.getString("Motorista"), rs.getDouble("mensalidade"));
	        	onibuss.add(onibus);
	        }
	        if(aux) {
	        	onibuss.add(onibus);
	        }
	        this.stmt.close();
	        return onibuss;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public ArrayList<Onibus> listarOnibus(){
		try {
			String sql = "SELECT * FROM onibus";
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Onibus> onibuss = new ArrayList<Onibus>();
            Onibus onibus = new Onibus();
            while(rs.next()) {
            	aux = false;
            	onibus = new Onibus(rs.getInt("id"),  rs.getString("placa"), rs.getString("cor"), rs.getString("Motorista"), rs.getDouble("mensalidade"));
            	onibuss.add(onibus);
            }
            if(aux) {
            	onibuss.add(onibus);
            }
            this.stmt.close();
            return onibuss;
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
