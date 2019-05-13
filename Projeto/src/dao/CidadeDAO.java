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
            String sql = "INSERT INTO cidade (nome, cep, uf) VALUES (?, ?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, cidade.getNome());
            this.stmt.setString(2, cidade.getCep());
            this.stmt.setString(3, cidade.getUf());
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

	public boolean editarCep(Cidade cidade){
		return this.editarCidade("cep", cidade.getCep(), cidade.getId());
	}

	private ArrayList<Cidade> consultarCidade(String campo, String valor){
		try {
			String sql = "SELECT * FROM cidade WHERE " + campo + " = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Cidade> cidades = new ArrayList<Cidade>();
            boolean aux = true;
            Cidade cidade = new Cidade();
            while(rs.next()) {
            	aux = false;
                cidade = new Cidade(rs.getInt("id"), rs.getString("nome"), rs.getString("cep"), rs.getString("uf"));
                cidade.setInstituicoes(this.listarInstituicoes(cidade));
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

	public ArrayList<Cidade> consutarNome(Cidade cidade){
		return this.consultarCidade("nome", cidade.getNome());
	}

	public ArrayList<Cidade> consultarUf(Cidade cidade){
		return this.consultarCidade("uf", cidade.getUf());
	}

	public Cidade consultarCep(Cidade cidade){
		return this.consultarCidade("cep", cidade.getCep()).get(0);
	}

	public ArrayList<Cidade> listarCidades(){
		try {
			String sql = "SELECT * FROM cidade";
            this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Cidade> cidades = new ArrayList<Cidade>();
            while(rs.next()) {
                Cidade cidade = new Cidade(rs.getInt("id"), rs.getString("nome"), rs.getString("cep"), rs.getString("uf"));
                cidade.setInstituicoes(this.listarInstituicoes(cidade));
                cidades.add(cidade);
            }
            this.stmt.close();
            return cidades;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public ArrayList<Instituicao> listarInstituicoes(Cidade cidade){
		InstituicaoDAO iDAO = new InstituicaoDAO();
		return iDAO.consutarIdCidade(cidade);
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