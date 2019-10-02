package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CausasFinalizadas;
import model.Processo;

public class CausasFinalizadasDAO implements CausasFinalizadasInDAO {
	private Connection conexao = null;
	public CausasFinalizadasDAO(Connection _conn) {
		this.conexao = _conn;
	}
	@Override
	public void Inserir(CausasFinalizadas _objeto) throws SQLException {
        String SQL = "INSERT INTO causas_finalizadas (id_processo, veredito) VALUES (?, ?)";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _objeto.getProcesso().getId_processo());
		ps.setString(2, _objeto.getVeredito());
	}

	@Override
	public List<CausasFinalizadas> listarTodos() throws SQLException {
		List<CausasFinalizadas> cf = new ArrayList<CausasFinalizadas>();
		ResultSet rs = null;
		
		String SQL = "SELECT id_processo, veredito FROM causas_finalizadas";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_processo = rs.getInt(1);
			String veredito = rs.getString(2);
			
			ProcessosDAO processos = new ProcessosDAO(conexao);
			Processo p = processos.buscarPorId(id_processo);
			CausasFinalizadas causas = new CausasFinalizadas(p , veredito);
			
			cf.add(causas);
		}
		
		return cf;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM causasfinalizadas WHERE id_processo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(CausasFinalizadas _objeto) throws SQLException {
        String SQL = "UPDATE causasfinalizadas SET veredito = ? WHERE id_processo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getVeredito());
		
		return ps.execute();
	}

	@Override
	public CausasFinalizadas buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		CausasFinalizadas cf = null;
		String SQL = "SELECT id_processo, veredito WHERE id_processo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id_processo = rs.getInt(1);
			String veredito = rs.getString(2);

			ProcessosDAO processos = new ProcessosDAO(conexao);
			Processo p = processos.buscarPorId(id_processo);
		
		
			
		     cf = new CausasFinalizadas(p , veredito);
		}
		
		return cf;
	}

}
