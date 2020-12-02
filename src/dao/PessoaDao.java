package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Pessoa;
import util.Conexao;

public class PessoaDao {
	public static void novaPessoa(Pessoa p) {
		Connection c = Conexao.conn();
		try {
			String sql = "insert into pessoa (nome, sexo, nascimento, bairro, cidade, cpf, estado, endereco1, cep, ativo, tipo ) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getSexo());
			ps.setString(3, p.getNascimento());
			ps.setString(4, p.getBairro());
			ps.setString(5, p.getCidade());
			ps.setString(6, p.getCpf());
			ps.setString(7, p.getEstado());
			ps.setString(8, p.getEndereco1());
			ps.setString(9, p.getCep());
			ps.setString(10, p.isAtiva()?"S":"N");
			ps.setString(11, p.getTipo());
			ps.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void alteraPessoa(Pessoa p) {
		Connection c = Conexao.conn();
		try {
			String sql = "update pessoa set nome=?, sexo=?, nascimento=?, bairro= ?, cidade=?, cpf=?, estado=?, endereco1=?, cep=?, ativo =?  where id=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getSexo());
			ps.setString(3, p.getNascimento());
			ps.setString(4, p.getBairro());
			ps.setString(5, p.getCidade());
			ps.setString(6, p.getCpf());
			ps.setString(7, p.getEstado());
			ps.setString(8, p.getEndereco1());
			ps.setString(9, p.getCep());
			ps.setString(10, p.isAtiva()?"S":"N");
			ps.setInt(11, p.getId());
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
				p.setTipo(rs.getString("tipo"));
				p.setAtiva(rs.getString("ativo").equals("S")?true:false);
				lista.add(p);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static Pessoa buscaPorId(int id, boolean ativo){
		Connection c = Conexao.conn();
		Pessoa p = new Pessoa();
		try {
			String sql = "select * from Pessoa where id = ?";
			if(ativo)
				sql = "select * from Pessoa where id = ? and ativo = 'S'";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setNascimento(rs.getString("nascimento"));
				p.setTipo(rs.getString("tipo"));
				p.setAtiva(rs.getString("ativo").equals("S")?true:false);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
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
				p.setNascimento(rs.getString("dt_nascimento"));
				p.setTipo(rs.getString("tipo"));
				p.setAtiva(rs.getString("ativo").equals("S")?true:false);
				lista.add(p);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
