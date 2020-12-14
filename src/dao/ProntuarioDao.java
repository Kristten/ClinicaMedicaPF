package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Pessoa;
import domain.Prontuario;
import util.Conexao;

public class ProntuarioDao {
	public static void novoProntuario( Prontuario p) {
		Connection c = Conexao.conn();
		try {
			String sql = "insert into prontuario (data, descricao, id_paciente, sintomas, medicamentos) values (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getData());
			ps.setString(2, p.getDescricao());
			ps.setInt(3, p.getPaciente().getId());
			ps.setString(4, p.getSintomas());
			ps.setString(5, p.getMedicamentos());
			ps.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Prontuario> listaTodas(){
		Connection c = Conexao.conn();
		ArrayList<Prontuario> lista = new ArrayList<Prontuario>();
		try {
			String sql = "select * from prontuario ";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Prontuario p = new Prontuario();
				p.setId(rs.getInt("id"));
				p.setData(rs.getString("data"));
				p.setDescricao(rs.getString("descricao"));
				p.setSintomas(rs.getString("sintomas"));
				p.setMedicamentos(rs.getString("medicamentos"));
				p.setPaciente(PessoaDao.buscaPorId(rs.getInt("id_paciente"), true));
				lista.add(p);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static Prontuario listaUltimo(){
		Connection c = Conexao.conn();
		Prontuario p = new Prontuario();
		try {
			String sql = "select * from prontuario where id=(select max(id) from prontuario) ";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				p.setId(rs.getInt("id"));
				p.setData(rs.getString("data"));
				p.setDescricao(rs.getString("descricao"));
				p.setSintomas(rs.getString("sintomas"));
				p.setMedicamentos(rs.getString("medicamentos"));
				p.setPaciente(PessoaDao.buscaPorId(rs.getInt("id_paciente"), true));
				
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	


}
