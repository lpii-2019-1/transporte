package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Cidade;
import model.Instituicao;

public class CidadeDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	public CidadeDAO() {
		Conexao conn = new Conexao();
        this.conexao = conn.getConexao();
    }

	public boolean inserirCidade(Cidade cidade){
        try {
        	String sql = "INSERT INTO cidade (nome,  uf) VALUES (?, ?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, cidade.getNome());
            this.stmt.setString(2, cidade.getUf());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

    private boolean editarCidade(String campo, String valor, int id){
        try {
        	String sql = "UPDATE cidade SET " + campo + " = ? WHERE id = ?";
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

	public boolean editarNome(Cidade cidade){
		return this.editarCidade("nome", cidade.getNome(), cidade.getId());
	}

	public boolean editarUf(Cidade cidade){
		return this.editarCidade("uf", cidade.getUf(), cidade.getId());
	}
	
	public boolean editarValidacao(Cidade cidade){
        try {
            String sql = "UPDATE cidade SET validacao = ? WHERE id = ?";
        	this.stmt = this.conexao.prepareStatement(sql);
        	this.stmt.setInt(1, cidade.getValidacao());
        	this.stmt.setInt(2, cidade.getId());
        	this.stmt.execute();
        	this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	private ArrayList<Cidade> consultarCidade(String campo, String valor, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM cidade WHERE " + campo + " = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM cidade WHERE " + campo + " = ? AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM cidade WHERE " + campo + " = ?";
				break;
        	}
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Cidade> cidades = new ArrayList<Cidade>();
            boolean aux = true;
            Cidade cidade = new Cidade();
            while(rs.next()) {
            	aux = false;
                cidade = new Cidade(rs.getInt("id"), rs.getString("nome"), rs.getString("uf"));
                cidade.setInstituicoes(this.listarInstituicoes(cidade, comparador));
                cidades.add(cidade);
            }
            if(aux) {
            	cidades.add(cidade);
            }
            this.stmt.close();
            return cidades;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public Cidade consultarNomeUf(Cidade cidade, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM cidade WHERE nome = ? AND uf = ? AND  validacao = 0";
    			break;
			case 1:
    			sql = "SELECT * FROM cidade WHERE nome = ? AND uf = ? AND  validacao = 1";
    			break;
			case 2:
    			sql = "SELECT * FROM cidade WHERE nome = ? AND uf = ?";
				break;
        	}
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, cidade.getNome());
            this.stmt.setString(2, cidade.getUf());
            ResultSet rs = stmt.executeQuery();  
            boolean aux = true;    
            while(rs.next()) {
            	aux = false;
                cidade = new Cidade(rs.getInt("id"), rs.getString("nome"), rs.getString("uf"));
                cidade.setInstituicoes(this.listarInstituicoes(cidade, comparador));
            }
            if(aux) {
            	cidade = new Cidade();// Recebendo nova cidade para setar o id para zero
            }
            this.stmt.close();
            return cidade;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	

	public ArrayList<Cidade> consultarNome(Cidade cidade, int comparador){
		return this.consultarCidade("nome", cidade.getNome(), comparador);
	}

	public ArrayList<Cidade> consultarUf(Cidade cidade, int comparador){
		return this.consultarCidade("uf", cidade.getUf(), comparador);
	}
	
	public Cidade consultarInstituicao(Instituicao instituicao, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM cidade INNER JOIN instituicao ON cidade.id = id_cidade AND instituicao.id = ? AND instituicao.validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM cidade INNER JOIN instituicao ON cidade.id = id_cidade AND instituicao.id = ? AND instituicao.validacao = 0";
    			break;
			case 2:
				sql = "SELECT * FROM cidade INNER JOIN instituicao ON cidade.id = id_cidade AND instituicao.id = ?";
				break;
        	}
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, instituicao.getId());
            ResultSet rs = stmt.executeQuery();
            Cidade cidade = new Cidade();
            if(rs.next()) {
                cidade = new Cidade(rs.getInt("cidade.id"), rs.getString("cidade.nome"), rs.getString("uf"));
                cidade.setInstituicoes(this.listarInstituicoes(cidade, comparador));
            }
            this.stmt.close();
            return cidade;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public ArrayList<Cidade> listarCidades(int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM cidade WHERE validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM cidade WHERE validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM cidade WHERE";
				break;
        	}
            this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Cidade> cidades = new ArrayList<Cidade>();
            while(rs.next()) {
                Cidade cidade = new Cidade(rs.getInt("id"), rs.getString("nome"), rs.getString("uf"));
                cidade.setInstituicoes(this.listarInstituicoes(cidade, comparador));
                cidades.add(cidade);
            }
            this.stmt.close();
            return cidades;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public ArrayList<Instituicao> listarInstituicoes(Cidade cidade, int comparador){
		InstituicaoDAO iDAO = new InstituicaoDAO();
		return iDAO.consultarIdCidade(cidade, comparador);
	}

	public boolean excluirCidade(Cidade cidade){
        try {
            String sql = "DELETE cidade WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, cidade.getId());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}