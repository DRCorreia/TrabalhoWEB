package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO implements ClienteInDAO {
	
private Connection conexao = null;
	
	public ClienteDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Cliente _objeto) throws SQLException {
        String SQL = "insert into cliente (id_cli,nome_cli,email_cli,tel_cli) values (?, ?, ?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1,_objeto.getId_cli());
		ps.setString(2, _objeto.getNome_cli());
		ps.setString(3, _objeto.getEmail_cli());
		ps.setString(4, _objeto.getTel_cli());

		ps.execute();

	}

	@Override
	public List<Cliente> listarTodos() throws SQLException {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs = null;
		
		String SQL = "select id_cli, nome_cli, email_cli, tel_cli from cliente";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			
			Cliente c = new Cliente(id, nome, email, telefone);
			
			clientes.add(c);
		}
		
		return clientes;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
        String SQL = "DELETE FROM cliente WHERE id_cli= ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Cliente _objeto) throws SQLException {
        String SQL = "UPDATE cliente SET nome_cli = ?, email_cli = ?, tel_cli = ? WHERE id_cli = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome_cli());
		ps.setString(2, _objeto.getEmail_cli());
		ps.setString(3, _objeto.getTel_cli());
		ps.setInt(4, _objeto.getId_cli());  //<----
		
		return ps.execute();
	}

	@Override
	public Cliente buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		Cliente c = null;
		String SQL = "SELECT id_cli, nome_cli, email_cli, tel_cli FROM cliente WHERE id_cli = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
		
			
			c = new Cliente(id, nome, email, telefone);
		}
		
		return c;
	}

}
