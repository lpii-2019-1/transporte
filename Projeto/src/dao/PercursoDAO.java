package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Percurso;


public class PercursoDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public PercursoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean inserirPercurso(Percurso percurso){
        try {
            String sql = "INSERT INTO percurso (ordem, descricao) VALUES (?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, percurso.getOrdem());
            this.stmt.setString(2, percurso.getDescricao());
            this.stmt.execute();
            this. stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public boolean editarOrdem(Percurso percurso){
		try {
            String sql = "UPDATE percurso SET ordem = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, percurso.getOrdem());
        	this.stmt.setInt(2, percurso.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public boolean editarDescricao(Percurso percurso){
		try {
            String sql = "UPDATE percurso SET ordem = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setString(1, percurso.getDescricao());
        	this.stmt.setInt(2, percurso.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public Percurso consutarPercurso(Percurso percursoSel){
		try {
			String sql = "SELECT * FROM Percurso WHERE decricao = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, percursoSel.getDescricao());
            ResultSet rs = stmt.executeQuery();
            Percurso percurso = new Percurso();
            if(rs.next()) {
            	percurso = new Percurso(rs.getInt("id"),  rs.getInt("ordem"), rs.getString("descricao"));
            }
            this.stmt.close();
            return percurso;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public Percurso pesquisarPercurso(Percurso percursoSel){
		try {
			String sql = "SELECT * FROM Percurso WHERE decricao LIKE(?)";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, percursoSel.getDescricao());
            ResultSet rs = stmt.executeQuery();
            Percurso percurso = new Percurso();
            if(rs.next()) {
            	percurso = new Percurso(rs.getInt("id"),  rs.getInt("ordem"), rs.getString("descricao"));
            }
            this.stmt.close();
            return percurso;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Percurso> listarPercursos(){
		try {
			String sql = "SELECT * FROM Percurso WHERE decricao = ?";
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Percurso> percursos = new ArrayList<Percurso>();
            Percurso percurso = new Percurso();
            while(rs.next()) {
            	aux = false;
            	percurso = new Percurso(rs.getInt("id"),  rs.getInt("ordem"), rs.getString("descricao"));
            	percursos.add(percurso);
            }
            if(aux) {
            	percursos.add(percurso);
            }
            this.stmt.close();
            return percursos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public boolean excluirPercurso(Percurso percurso){
        try {
            String sql = "DELETE percurso WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, percurso.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public Percurso consultarId(int id){
		try {
			String sql = "SELECT * FROM percurso WHERE id = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Percurso percurso = new Percurso();
            if(rs.next()) {
            	percurso = new Percurso(rs.getInt("id"), rs.getInt("ordem"), rs.getString("endereco"));
            }
            this.stmt.close();
            return percurso;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
