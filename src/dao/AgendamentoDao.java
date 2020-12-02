package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Agendamento;


import domain.Pessoa;
import util.Conexao;

public class AgendamentoDao {
	
	public static void novoAgendamento(Agendamento a) {
		Connection c = Conexao.conn();
		try {
			String sql = "insert into consultas (data, horario, paciente, nomePaciente) values (?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, a.getData());
			ps.setString(2, a.getHorario());
			ps.setInt(3, a.getPaciente().getId());
			ps.setString(4, a.getPaciente().getNome());
			ps.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Pessoa> listaTodas(String tipo){
		return listaTodas(false, tipo);
	}
	
	public static ArrayList<Pessoa> listaTodas(boolean ativo, String tipo){
		Connection c = Conexao.conn();
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		try {
			String sql = "select * from Pessoa where tipo =? order by nome";
			if(ativo)
				sql = "select * from Pessoa where tipo =? and ativo = 'S' order by nome";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, tipo);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setNascimento(rs.getString("nascimento"));
				lista.add(p);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static ArrayList<Pessoa> filtra(String filtro, String tipo){
		Connection c = Conexao.conn();
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		try {
			String sql = "select * from Pessoa where tipo =? and nome like '"+filtro+"' order by nome";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, tipo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setNascimento(rs.getString("nascimento"));
				lista.add(p);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
