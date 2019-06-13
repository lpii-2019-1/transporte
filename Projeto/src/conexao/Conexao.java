package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String DSN = "jdbc:mysql://localhost:3306/transporte";
	//private static final String DSN = "jdbc:mysql://localhost:3306/transporte?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public Connection getConexao() {
		try {
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
