package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Ponto;
import model.Rota;

public class PontoDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public PontoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public boolean inserirPonto(Ponto ponto){
        try {
            String sql = "INSERT INTO ponto (endereco) VALUES ( ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, ponto.getEndereco());
            this.stmt.execute();
            this. stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public boolean editarEndereco(Ponto ponto){
        try {
            String sql = "UPDATE ponto SET endereco = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setString(1, ponto.getEndereco());
        	this.stmt.setInt(2, ponto.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editarValidacao(Ponto ponto){
        try {
            String sql = "UPDATE ponto SET validacao = ? WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, ponto.getValidacao());
            this.stmt.setInt(2, ponto.getId());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public Ponto consultarEndereco(Ponto pontoSel, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM ponto WHERE endereco = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM ponto WHERE endereco = ? AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM ponto WHERE endereco = ? ORDER BY ordem";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, pontoSel.getEndereco());
            ResultSet rs = stmt.executeQuery();
            Ponto ponto = new Ponto();
            if(rs.next()) {
            	ponto = new Ponto(rs.getInt("id"),  rs.getString("endereco"));
            }
            this.stmt.close();
            return ponto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public Ponto consultarId(int id, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM ponto WHERE id = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM ponto WHERE id = ? AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM ponto WHERE id = ?";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Ponto ponto = new Ponto();
            if(rs.next()) {
            	ponto = new Ponto(rs.getInt("id"),  rs.getString("endereco"));
            }
            this.stmt.close();
            return ponto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
    public ArrayList<Ponto> consultarIdRota(Rota rota, int comparador){
        try {
            String sql = "";
            switch(comparador) {
            case 0:
                sql = "SELECT * FROM rota_has_ponto WHERE id_rota = ? AND validacao = 0";
                break;
            case 1:
                sql = "SELECT * FROM rota_has_ponto WHERE id_rota = ? AND validacao = 1";
                break;
            case 2:
                sql = "SELECT * FROM rota_has_ponto WHERE id_rota = ?";
                break;
            }
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, rota.getId());
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            Ponto ponto = new Ponto();
            ArrayList<Ponto> pontos = new ArrayList<Ponto>();
            while(rs.next()) {
                aux = false;
                ponto = this.consultarId(rs.getInt("id_ponto"), comparador);
                ponto.setOrdem(rs.getInt("ordem"));
                pontos.add(ponto);
            }
            if(aux){
                pontos.add(ponto);
            }
            this.stmt.close();
            return pontos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	public ArrayList<Ponto> listarPontos(int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM ponto WHERE validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM ponto WHERE validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM ponto";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Ponto> pontos = new ArrayList<Ponto>(); 
            Ponto ponto = new Ponto();
            while(rs.next()) {
            	ponto = new Ponto(rs.getInt("id"),  rs.getString("endereco"));
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
	
	public boolean excluirPonto(Ponto ponto){
        try {
            String sql = "DELETE ponto WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, ponto.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
