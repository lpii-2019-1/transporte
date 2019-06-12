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
            String sql = "INSERT INTO rota (inicio, fim, percurso) VALUES (?, ?)";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, rota.getInicio());
            this.stmt.setString(2, rota.getFim());
            this.stmt.setString(3, rota.getPercurso());
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

    public boolean editarPonto(Rota rota, Ponto ponto){
        try {
            String sql = "UPDATE rota_has_ponto SET ordem = ? WHERE id_rota = ? AND id_ponto = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, ponto.getOrdem());
            this.stmt.setInt(2, rota.getId());
            this.stmt.setInt(3, ponto.getId());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
	
    public boolean editarValidacao(Rota rota){
        try {
            String sql = "UPDATE rota SET validacao = ? WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, rota.getValidacao());
            this.stmt.setInt(2, rota.getId());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
	private ArrayList<Rota> consultarRota(String campo, String valor, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM rota WHERE " + campo + " = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM rota WHERE " + campo + " = ? AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM rota WHERE " + campo + " = ?";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            InstituicaoDAO iDAO = new InstituicaoDAO();
            PontoDAO pDAO = new PontoDAO();
            HorarioDAO hDAO = new HorarioDAO();
            while(rs.next()) {
            	aux = false;
            	rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"), rs.getString("percurso"), rs.getInt("identificador"));
                rota.setInstituicoes(iDAO.consultarIdRota(rota, comparador));
                rota.setPontos(pDAO.consultarIdRota(rota, comparador));
                rota.setHorarios(hDAO.consultarIdRota(rota, comparador));
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
	
	public Rota consultarIdentificador(Onibus onibus, int identificador, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM rota WHERE id_onibus = ? AND identificador = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM rota WHERE id_onibus = ? AND identificador = ? AND validacao = 1";
    			break;
			
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, onibus.getId());
			this.stmt.setInt(2, identificador);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            Rota rota = new Rota();
            InstituicaoDAO iDAO = new InstituicaoDAO();
            PontoDAO pDAO = new PontoDAO();
            HorarioDAO hDAO = new HorarioDAO();
            while(rs.next()) {
            	aux = false;
            	rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"), rs.getString("percurso"), rs.getInt("identificador"));
                rota.setInstituicoes(iDAO.consultarIdRota(rota, comparador));
                rota.setPontos(pDAO.consultarIdRota(rota, comparador));
                rota.setHorarios(hDAO.consultarIdRota(rota, comparador));
       
            }
            if(aux) {
            	rota = new Rota();
            }
            this.stmt.close();
            return rota;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	
	public ArrayList<Rota> consultarInicio(Rota rota, int comparador){
		return this.consultarRota("inicio", rota.getInicio(), comparador);
	}

	public ArrayList<Rota> consultarFim(Rota rota, int comparador){
		return this.consultarRota("fim", rota.getFim(), comparador);
	}
	
	public Rota consultarId(int id, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM rota WHERE id = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM rota WHERE id = ? AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM rota WHERE id = ?";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Rota rota = new Rota();
            InstituicaoDAO iDAO = new InstituicaoDAO();
            PontoDAO pDAO = new PontoDAO();
            HorarioDAO hDAO = new HorarioDAO();
            if(rs.next()){
                rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"), rs.getString("percurso"));
                rota.setInstituicoes(iDAO.consultarIdRota(rota ,comparador));
                rota.setPontos(pDAO.consultarIdRota(rota ,comparador));
                rota.setHorarios(hDAO.consultarIdRota(rota, comparador));
            }
            this.stmt.close();
            return rota;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Rota> consultarIdOnibus(int id, int comparador) {
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM rota WHERE id_onibus = ? AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM rota WHERE id_onibus = ? AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM rota WHERE id_onibus = ?";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            RotaDAO rDAO = new RotaDAO();
            InstituicaoDAO iDAO = new InstituicaoDAO();
            PontoDAO pDAO = new PontoDAO();
            HorarioDAO hDAO = new HorarioDAO();
            while(rs.next()) {
            	aux = false;
            	rota = rDAO.consultarId(rs.getInt("id"), comparador);
            	rota.setInstituicoes(iDAO.consultarIdRota(rota ,comparador));
                rota.setPontos(pDAO.consultarIdRota(rota ,comparador));
                rota.setHorarios(hDAO.consultarIdRota(rota, comparador));
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
	public ArrayList<Rota> consultarIdInsituicao(Instituicao instituicao, int comparador){
        try {         
            String sql = "SELECT * FROM rota_has_instituicao WHERE id_instituicao = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, instituicao.getId());
            ResultSet rs = this.stmt.executeQuery();
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            boolean aux1 = true;
            while(rs.next()) {
                aux1 = false;
                rota = this.consultarId(rs.getInt("id_rota"), comparador);
                rotas.add(rota);
            }
            if(aux1) {
                rotas.add(rota);
            }
            this.stmt.close();
            return rotas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public ArrayList<Rota> listarRotas(int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM rota WHERE validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM rota WHERE validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM rota";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            InstituicaoDAO iDAO = new InstituicaoDAO();
            PontoDAO pDAO = new PontoDAO();
            HorarioDAO hDAO = new HorarioDAO();
            while(rs.next()) {
                aux = false;
                rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"), rs.getString("getPercurso"));
                rota.setInstituicoes(iDAO.consultarIdRota(rota ,comparador));
                rota.setPontos(pDAO.consultarIdRota(rota ,comparador));
                rota.setHorarios(hDAO.consultarIdRota(rota, comparador));
                rotas.add(rota);
            }
            if(aux){
                rotas.add(rota);
            }
            this.stmt.close();
            return rotas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

    public Onibus listarOnibus(Rota rota, int comparador) {
        try {
            String sql = "";
            switch(comparador) {
            case 0:
                sql = "SELECT * FROM rota WHERE id = ? AND validacao = 0";
                break;
            case 1:
                sql = "SELECT * FROM rota WHERE id = ? AND validacao = 1";
                break;
            case 2:
                sql = "SELECT * FROM rota WHERE id = ?";
                break;
            }
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, rota.getId());
            ResultSet rs = stmt.executeQuery();
            Onibus onibus = new Onibus();
            OnibusDAO oDAO = new OnibusDAO();
            if(rs.next()){
                onibus = oDAO.consultarId(rs.getInt("id_onibus"), comparador);
            }
            this.stmt.close();
            return onibus;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } 
	
	public ArrayList<Ponto> listarPontos(Rota rota, int comparador){
		try {
            PontoDAO pDAO = new PontoDAO();
            ArrayList<Ponto> pontos = pDAO.consultarIdRota(rota, comparador);
            return pontos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	public ArrayList<Instituicao> listarInstituicoes(Rota rota, int comparador){
		try {
            InstituicaoDAO iDAO = new InstituicaoDAO();
			ArrayList<Instituicao> instituicoes = iDAO.consultarIdRota(rota, comparador);
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

    public boolean excluirPonto(Rota rota, Ponto ponto){
        try {
            String sql = "DELETE rota_has_ponto WHERE id_rota = ? AND id_ponto = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, rota.getId());
            this.stmt.setInt(2, ponto.getId());
            this.stmt.execute();
            this.stmt.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public ArrayList<Rota> buscarPercursos(String busca, int comparador){
		try {
			String sql = "";
			switch(comparador) {
    		case 0:
    			sql = "SELECT * FROM rota WHERE LIKE(?) AND validacao = 0";
    			break;
			case 1:
				sql = "SELECT * FROM rota WHERE LIKE(?) AND validacao = 1";
    			break;
			case 2:
				sql = "SELECT * FROM rota WHERE LIKE(?)";
				break;
        	}
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setString(1, busca);
            ResultSet rs = stmt.executeQuery();
            boolean aux = true;
            ArrayList<Rota> rotas = new ArrayList<Rota>();
            Rota rota = new Rota();
            while(rs.next()) {
            	aux = false;
            	rota = new Rota(rs.getInt("id"),  rs.getString("inicio"), rs.getString("fim"), rs.getString("percurso"));
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