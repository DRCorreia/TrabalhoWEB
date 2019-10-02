package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Advogado;

public class AdvogadoDAO implements AdvogadoInDAO {
	
private Connection conexao = null;
	


      public AdvogadoDAO(Connection _conn)
          {
	       this.conexao = _conn;
          }       

	@Override
	public void Inserir(Advogado _objeto) throws SQLException {
        String SQL = "INSERT INTO advogado (id,nome, email, tel) VALUES (?,?, ?, ?)";
		
        PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId_adv());
		ps.setString(2, _objeto.getNome_adv());
		ps.setString(3, _objeto.getEmail_adv());
		ps.setString(4, _objeto.getTel_adv());
		
		ps.execute();

	}

	@Override
	public List<Advogado> listarTodos() throws SQLException {
		List<Advogado> adv = new ArrayList<Advogado>();
		ResultSet rs = null;
		
		String SQL = "SELECT id_adv, nome_adv, email_adv, tel_adv FROM advogado";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			
			Advogado advogado = new Advogado(id, nome, email, telefone);
			
			adv.add(advogado);
		}
		
		return adv;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
        String SQL = "DELETE FROM advogado WHERE id_adv = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Advogado _objeto) throws SQLException {
       String SQL = "UPDATE advogado SET nome_adv = ?, email_adv = ?, tel = ? WHERE id_adv = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome_adv());
		ps.setString(2, _objeto.getEmail_adv());
		ps.setString(3, _objeto.getTel_adv());
		ps.setInt(4, _objeto.getId_adv());  //<----
		
		return ps.execute();
	}

	@Override
	public Advogado buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		Advogado a = null;
		String SQL = "SELECT id_adv, nome_adv, email_adv, tel_adv FROM advogado WHERE id_adv = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
		
			
			a = new Advogado(id, nome, email, telefone);
		}
		
		return a;
	}

}
