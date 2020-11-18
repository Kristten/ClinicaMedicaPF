package dao;


import java.sql.PreparedStatement;

import domain.Medicos;
import conexao.ConexaoBD;

public class MedicoDao {
	public static void novaPessoa(Medicos m) {
		ConexaoBD conex = new ConexaoBD();
		try {
			conex.conexao();
			String sql = "insert into pessoa (nome, nascimento, bairro, cidade, cpf, especialidade, estado, enedereco1, crm, cep, ativo ) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conex.con.prepareStatement(sql);
			ps.setString(1, m.getNome());
			ps.setString(2, m.getDt_nascimento());
			ps.setString(3, m.getBairro());
			ps.setString(4, m.getCidade());
			ps.setString(5, m.getCpf());
			ps.setString(6, m.getEspecialidade());
			ps.setString(7, m.getEstado());
			ps.setString(8, m.getEndereco1());
			ps.setString(9, m.getCrm());
			ps.setString(10, m.getCep());
			ps.setString(11, m.isAtiva()?"S":"N");
			ps.executeUpdate();
			conex.desconecta();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
