package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Cidade;
import model.Instituicao;
import model.Rota;

public class InstituicaoDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	public InstituicaoDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public boolean inserirInstituicao(Instituicao instituicao){
        try {
            String sql = "INSERT INTO instituicao (nome, telefone, endereco) VALUES (?, ?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, instituicao.getNome());
            this.stmt.setString(2, instituicao.getTelefone());
            this.stmt.setString(3, instituicao.getEndereco());
            this.stmt.execute();
            this. stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	private boolean editarInstituicao(String campo, String valor, int id){
        try {
            String sql = "UPDATE instituicao SET " + campo + " = ? WHERE id = ?";
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

    public boolean editarNome(Instituicao instituicao){
		return this.editarInstituicao("nome", instituicao.getNome(), instituicao.getId());
	}

	public boolean editarTelefone(Instituicao instituicao){
		return this.editarInstituicao("telefone", instituicao.getTelefone(), instituicao.getId());
	}

	public boolean editarEndereco(Instituicao instituicao){
		return this.editarInstituicao("endereco", instituicao.getEndereco(), instituicao.getId());
	}

	public boolean editarIdCidade(Instituicao instituicao, Cidade cidade){
        try {
            String sql = "UPDATE instituicao SET id_cidade = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, cidade.getId());
            this.stmt.setInt(2, instituicao.getId());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

    public boolean editarValidacao(Instituicao instituicao){
        try {
            String sql = "UPDATE instituicao SET validacao = ? WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, instituicao.getValidacao());
            this.stmt.setInt(2, instituicao.getId());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
	private ArrayList<Instituicao> consultarInstituicoes(String campo, String valor, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM instituicao WHERE " + campo + " = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM instituicao WHERE " + campo + " = ?  AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM instituicao WHERE " + campo + " = ?";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
            Instituicao instituicao = new Instituicao();
            boolean aux1 = true;
            while(rs.next()) {
            	aux1 = false;
                instituicao = new Instituicao(rs.getInt("id"), rs.getString("nome"), rs.getString("cep"), rs.getString("uf"));
                instituicoes.add(instituicao);
            }
            if(aux1) {
            	instituicoes.add(instituicao);
            }
            this.stmt.close();
            return instituicoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
		

	public ArrayList<Instituicao> consultarNome(Instituicao instituicao, int comparador){
		return this.consultarInstituicoes("nome", instituicao.getNome(), comparador);
	}

	public Instituicao consultarTelefone(Instituicao instituicao, int comparador){
		return this.consultarInstituicoes("telefone", instituicao.getTelefone(), comparador).get(0);
	}

	public Instituicao consultarEndereco(Instituicao instituicao, int comparador){
		return this.consultarInstituicoes("endereco", instituicao.getEndereco(), comparador).get(0);
	}
	
	public ArrayList<Instituicao> consultarIdCidade(Cidade cidade, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM instituicao WHERE id_cidade = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM instituicao WHERE id_cidade = ?  AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM instituicao WHERE id_cidade = ?";
				break;
        	}
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, cidade.getId());
            ResultSet rs = this.stmt.executeQuery();
            ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
            Instituicao instituicao = new Instituicao();
            boolean aux1 = true;
            while(rs.next()) {
            	aux1 = false;
                instituicao = new Instituicao(rs.getInt("id"), rs.getString("nome"), rs.getString("cep"), rs.getString("uf"));
                instituicoes.add(instituicao);
            }
            if(aux1) {
            	instituicoes.add(instituicao);
            }
            this.stmt.close();
            return instituicoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

    public ArrayList<Instituicao> consultarIdRota(Rota rota, int comparador){
        try {
            String sql = "";
            switch(comparador) {
            case 0:
                sql = "SELECT * FROM rota_has_instituicao WHERE id_rota = ? AND validacao = 0";
                break;
            case 1:
                sql = "SELECT * FROM rota_has_instituicao WHERE id_rota = ?  AND validacao = 1";
                break;
            case 2:
                sql = "SELECT * FROM rota_has_instituicao WHERE id_rota = ?";
                break;
            }
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, rota.getId());
            ResultSet rs = this.stmt.executeQuery();
            ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
            Instituicao instituicao = new Instituicao();
            boolean aux1 = true;
            while(rs.next()) {
                aux1 = false;
                instituicao = this.consultarId(rs.getInt("id_instituicao"), comparador);
                instituicoes.add(instituicao);
            }
            if(aux1) {
                instituicoes.add(instituicao);
            }
            this.stmt.close();
            return instituicoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	public ArrayList<Instituicao> listarInstituicoes(int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM instituicao WHERE validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM instituicao WHERE validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM instituicao";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = this.stmt.executeQuery();
            boolean aux = true; 
            ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
            Instituicao instituicao = new Instituicao();
            while(rs.next()) {
                aux = false;
            	instituicao = new Instituicao(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("endereco"));
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
	
	public Instituicao consultarId(int id, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM ponto WHERE id = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM ponto WHERE id = ?  AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM ponto WHERE id = ?";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Instituicao instituicao = new Instituicao();
            if(rs.next()) {
            	instituicao = new Instituicao(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("endereco"));
            }
            this.stmt.close();
            return instituicao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public boolean excluirInstituicao(Instituicao instituicao){
        try {
            String sql = "DELETE instituicao WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, instituicao.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
