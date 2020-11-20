package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;


import domain.Pacientes;
import util.Conexao;


public class MedicoDao {
	public static void novaPessoa(Pacientes m) {
		Connection c = Conexao.conn();
		try {
		
			String sql = "insert into pessoa (nome, nascimento, bairro, cidade, cpf, estado, enedereco1, cep, ativo ) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, m.getNome());
			ps.setString(2, m.getNascimento());
			ps.setString(3, m.getBairro());
			ps.setString(4, m.getCidade());
			ps.setString(5, m.getCpf());
			ps.setString(6, m.getEstado());
			ps.setString(7, m.getEndereco1());
			ps.setString(8, m.getCep());
			ps.setString(9, m.isAtiva()?"S":"N");
			ps.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
