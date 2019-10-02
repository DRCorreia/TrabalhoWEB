package dao;
import model.Cliente;
import model.Advogado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Processo;
public class ProcessosDAO implements ProcessosInDAO {

    private Connection conexao = null;
	
	public ProcessosDAO(Connection _conn) {
		this.conexao = _conn;
	}
	@Override
	public void Inserir(Processo _objeto) throws SQLException {	
        String SQL = "INSERT INTO processos (id_processo, id_cli ,id_adv,tipo_processo,situacao_processo) VALUES (?, ?, ?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId_processo());
		ps.setInt(2, _objeto.getCliente().getId_cli());
		ps.setInt(3, _objeto.getAdvogado().getId_adv());
		ps.setString(4, _objeto.getTipo_processo());
		ps.setString(5, _objeto.getSituacao_processo());
		
		ps.execute();
	}

	@Override
	public List<Processo> listarTodos() throws SQLException {
		List<Processo> processos = new ArrayList<Processo>();
		ResultSet rs = null;
		
		String SQL = "SELECT id_processo, id_cli , id_adv , tipo_processo , situacao_processo FROM processos";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			int id_cli = rs.getInt(2);
			int id_adv = rs.getInt(3);
			String tipo_processo = rs.getString(4);
			String situacao_processo = rs.getString(5);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			
			Processo p = new Processo(id , cli, adv, tipo_processo , situacao_processo);
			
			processos.add(p);
		}
		
		return processos;
	}


	@Override
	public Boolean Excluir(int _id) throws SQLException {
		  String SQL = "DELETE FROM processos WHERE id_processo = ?";
			
			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
			ps.setInt(1, _id);
			
			return ps.execute();
	}

	@Override
	public Boolean Atualizar(Processo _objeto) throws SQLException {
        String SQL = "UPDATE processos SET id_cli = ?, id_adv = ? , tipo_processo = ?, situacao_processo = ? WHERE id_processo= ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCliente().getId_cli());
		ps.setInt(2, _objeto.getAdvogado().getId_adv());
		ps.setString(3, _objeto.getTipo_processo());
		ps.setString(4, _objeto.getSituacao_processo());
		ps.setInt(5, _objeto.getId_processo());
		
		return ps.execute();
	}

	@Override
	public List<Processo> listarProcessosPorCliente(int _idCliente) throws SQLException {

		List<Processo> processos = new ArrayList<Processo>();
		ResultSet rs = null;
		
		String SQL = "SELECT id_processo, id_cli, id_adv , tipo_processo, situacao_processo FROM processos WHERE id_cli = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idCliente);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_processo = rs.getInt(1);
			int id_cli = rs.getInt(2);
			int id_adv = rs.getInt(3);
			String tipo_processo = rs.getString(4);
			String situacao_processo = rs.getString(5);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			
			Processo p = new Processo(id_processo , cli, adv, tipo_processo , situacao_processo);
			
			processos.add(p);
		}
		
		return processos;
	}


	@Override
	public List<Processo> listarProcessosPorAdvogado(int _idAdvogado) throws SQLException {
		List<Processo> processos = new ArrayList<Processo>();
		ResultSet rs = null;
		
		String SQL = "SELECT id_processo, id_cli, id_adv , tipo_processo, situacao_processo FROM processos WHERE id_adv = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idAdvogado);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_processo = rs.getInt(1);
			int id_cli = rs.getInt(2);
			int id_adv = rs.getInt(3);
			String tipo_processo = rs.getString(4);
			String situacao_processo = rs.getString(5);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			
			Processo p = new Processo(id_processo , cli, adv, tipo_processo , situacao_processo);
			
			processos.add(p);
		}
		
		return processos;
	}

	
	@Override
	public Processo buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		Processo p = null;
		
		String SQL = "SELECT id_processo,id_cli, id_adv, tipo_processo, situacao_processo FROM processos WHERE id_processo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id_processo = rs.getInt(1);
			int id_cli = rs.getInt(2);
			int id_adv = rs.getInt(3);
			String tipo_processo = rs.getString(4);
			String situacao_processo = rs.getString(5);
		
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			
			p = new Processo(id_processo , cli, adv, tipo_processo , situacao_processo);
		}
		
		return p;
	}

}
