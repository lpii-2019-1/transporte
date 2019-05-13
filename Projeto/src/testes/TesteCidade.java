package testes;

import model.Instituicao;
import model.Cidade;
import dao.CidadeDAO;
import dao.InstituicaoDAO;

public class TesteCidade{

	public static void main(String[] args){
		CidadeDAO cDAO = new CidadeDAO();
		InstituicaoDAO iDAO = new InstituicaoDAO();

		Cidade c1 = new Cidade("Ceres", "76300000", "GO");
		Instituicao i1 = new Instituicao("IF Goiano Ceres", "62 3307-7100", "ifgoiano.ceres@ifgoiano.edu.br");
		
		if(cDAO.consultarCep(c1).getId() == 0) {
			cDAO.inserirCidade(c1);
		}
		c1 = cDAO.consultarCep(c1);
		if(iDAO.consultarTudo(i1).getId() == 0) {
			iDAO.inserirInstituicao(i1);
		}
		i1 = iDAO.consultarTudo(i1);
		if(c1.getId() != 0) {
			iDAO.editarIdCidade(i1, c1);
		}
	}
}