package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import domain.Agendamento;

import util.Conexao;

public class AgendaDao {

	public static ArrayList<Agendamento> buscaAgendamento(String dataFormatada){
		
		Connection c = Conexao.conn();
		ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
		try {
			String sql = "select * from consultas where data like '"+dataFormatada+"' order by nomePaciente";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Agendamento a = new Agendamento();
				a.setId(rs.getInt("id"));
				a.setNomePaciente(rs.getString("nomePaciente"));
				a.setHorario(rs.getString("horario"));
			
				lista.add(a);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public static void excluiAgendamento(Agendamento a) {
		Connection c = Conexao.conn();
		try {
			String sql = "delete from consultas where id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1,a.getId());
			ps.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
