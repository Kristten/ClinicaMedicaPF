package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
	public Statement stm;
	public ResultSet rs;
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho = "jdbc:mysql://localhost:3306/clinica";
	private String usuario = "root";
	private String senha = "qwer789456123";
	public Connection con;
	
	
	public void  conexao() {
		
		try {
			System.setProperty("JDBC.Drivers", driver);
			con = DriverManager.getConnection(caminho, usuario, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	public void desconecta() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
