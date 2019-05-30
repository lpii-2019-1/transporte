package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Instituicao;
import model.Onibus;
import model.Ponto;
import model.Rota;

public class RotaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public RotaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean inserirRota(Rota rota){
        try {
            String sql = "INSERT INTO rota (inicio, fim) VALUES (?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, rota.getInicio());
            this.stmt.setString(2, rota.getFim());
            this.stmt.execute();
            this. stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	private boolean editarRota(String campo, String valor, int id){
        try {
            String sql = "UPDATE rota SET " + campo + " = ? WHERE id = ?";
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
	public boolean editarInicio(Rota rota){
		return this.editarRota("inicio", rota.getInicio(), rota.getId());
	}

	public boolean editarFim(Rota rota){
		return this.editarRota("fim", rota.getFim(), rota.getId());
	}
	public boolean editarPercurso(Rota rota){
		return this.editarRota("fim", rota.getPercurso(), rota.getId());
	}
	public boolean editarIdOnibus(Onibus onibus, Rota rota){
        try {
            String sql = "UPDATE rota SET id_onibus = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, onibus.getId());
        	this.stmt.setInt(2, rota.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	private ArrayList<Rota> consultarRota(String campo, String valor){
		try {
			String sql = "SELECT * FROM rota WHERE " + campo + " = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            while(rs.next()) {
            	aux = false;
            	rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"));
            	rotas.add(rota);
            }
            if(aux) {
            	rotas.add(rota);
            }
            this.stmt.close();
            return rotas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Rota> consultarInicio(Rota rota){
		return this.consultarRota("inicio", rota.getInicio());
	}

	public ArrayList<Rota> consultarFim(Rota rota){
		return this.consultarRota("fim", rota.getFim());
	}
	
	public Rota consultarId(int id){
		try {
			String sql = "SELECT * FROM rota WHERE id = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Rota rota = new Rota();
            if(rs.next()) {
            	rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"));
            }
            this.stmt.close();
            return rota;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Rota> consultarIdOnibus(Onibus onibus) {
		try {
			String sql = "SELECT * FROM rota WHERE id_onibus = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, onibus.getId());
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            RotaDAO rDAO = new RotaDAO();
            while(rs.next()) {
            	aux = false;
            	rota = rDAO.consultarId(rs.getInt("id_rota"));
            	rotas.add(rota);
            }
            if(aux) {
            	rotas.add(rota);
            }
            this.stmt.close();
            return rotas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Rota> listarRotas(){
		try {
			String sql = "SELECT * FROM rota";
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            while(rs.next()) {
            	aux = false;
            	rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"));
            	rotas.add(rota);
            }
            if(aux) {
            	rotas.add(rota);
            }
            this.stmt.close();
            return rotas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Ponto> listarPontos(Rota rota){
		try {
			String sql = "SELECT * FROM rota_has_ponto WHERE id_rota = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, rota.getId());
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Ponto> pontos = new ArrayList<Ponto>();
            Ponto ponto = new Ponto();
            PontoDAO pDAO = new PontoDAO();
            while(rs.next()) {
            	aux = false;
            	ponto = pDAO.consultarId(rs.getInt("id_ponto"));
            	pontos.add(ponto);
            }
            if(aux) {
            	pontos.add(ponto);
            }
            this.stmt.close();
            return pontos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Instituicao> listarInstituicoes(Rota rota){
		try {
			String sql = "SELECT * FROM rota_has_instituicao WHERE id_rota = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, rota.getId());
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
            Instituicao instituicao = new Instituicao();
            InstituicaoDAO iDAO = new InstituicaoDAO();
            while(rs.next()) {
            	aux = false;
            	instituicao = iDAO.consultarId(rs.getInt("id_instituicao"));
            	instituicoes.add(instituicao);
            }
            if(aux) {
            	instituicoes.add(instituicao);
            }
            this.stmt.close();
            return instituicoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public boolean excluirRota(Rota rota){
		try {
			String sql = "DELETE rota WHERE id = ?";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, rota.getId());
			this.stmt.execute();
			this.stmt.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Rota> buscarPercursos(String busca){
		try {
			String sql = "SELECT * FROM rota WHERE LIKE(?)";
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, busca);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            while(rs.next()) {
            	aux = false;
            	rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"));
            	rotas.add(rota);
            }
            if(aux) {
            	rotas.add(rota);
            }
            this.stmt.close();
            return rotas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}