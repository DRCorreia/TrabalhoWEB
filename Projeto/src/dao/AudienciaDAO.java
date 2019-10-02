package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Audiencia;
import model.Processo;
import model.Advogado;
import model.Cliente;

public class AudienciaDAO implements AudienciaInDAO {
	  private Connection conexao = null;
		
		public AudienciaDAO(Connection _conn) {
			this.conexao = _conn;
		}
	@Override
	public void Inserir(Audiencia _object) throws SQLException {
        String SQL = "INSERT INTO audiencia (id_audiencia, id_adv , id_cli , id_processo,nomeJuiz,data_audiencia) VALUES (?, ?, ?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _object.getId_audiencia());
		ps.setInt(2, _object.getAdv().getId_adv());
		ps.setInt(3, _object.getCli().getId_cli());
		ps.setInt(4, _object.getProcesso().getId_processo());
		ps.setString(5, _object.getNomeJuiz());
		ps.setDate(6,  new Date (_object.getData_audiencia().getTime()));
		ps.execute();

	}

	@Override
	public List<Audiencia> listarTodos() throws SQLException {
		List<Audiencia> audiencia = new ArrayList<Audiencia>();
		ResultSet rs = null;
		
		String SQL = "SELECT id_audiencia, id_adv, id_cli,id_processo , nomeJuiz , data FROM audiencia";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_audiencia= rs.getInt(1);
			int id_adv = rs.getInt(2);
			int id_cli = rs.getInt(3);
			int id_processo = rs.getInt(4);
			String nomeJuiz = rs.getString(5);
			Date data = rs.getDate(6);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			
			ProcessosDAO daoProcessos = new ProcessosDAO(conexao);
			Processo processos = daoProcessos.buscarPorId(id_processo);
			
			Audiencia a = new Audiencia(id_audiencia , adv , cli,processos,nomeJuiz,data);
			
			audiencia.add(a);
		}
		
		return audiencia;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		 String SQL = "DELETE FROM audiencia WHERE id_audiencia= ?";
			
			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
			ps.setInt(1, _id);
			
			return ps.execute();
	}

	@Override
	public Boolean Atualizar(Audiencia _object) throws SQLException {
        String SQL = "UPDATE audiencia SET id_adv = ?, id_cli = ? , id_processo = ?, nomeJuiz = ?,data=? WHERE id_audiencia = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
        ps.setInt(1, _object.getAdv().getId_adv());
        ps.setInt(2, _object.getCli().getId_cli());
        ps.setInt(3, _object.getProcesso().getId_processo());
        ps.setString(4, _object.getNomeJuiz());
        ps.setDate(5, new Date (_object.getData_audiencia().getTime()));
		return ps.execute();
	}

	@Override
	public Audiencia buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		Audiencia a = null;
		
		String SQL = "SELECT  id_audiencia,id_adv,id_cli,id_processo,nomeJuiz,data FROM audiencia WHERE id_audiencia = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id_audiencia = rs.getInt(1);
			int id_adv = rs.getInt(2);
			int id_cli = rs.getInt(3);
			int id_processo = rs.getInt(4);
			String nomeJuiz = rs.getString(5);
			Date data = rs.getDate(6);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			
			ProcessosDAO daoProcessos = new ProcessosDAO(conexao);
			Processo processos = daoProcessos.buscarPorId(id_processo);
			
			a = new Audiencia(id_audiencia,adv,cli,processos,nomeJuiz,data);
		}
		
		return a;
	}



	@Override
	public List<Audiencia> listarAudienciaPorCliente(int _idCliente) throws SQLException {
		List<Audiencia> audiencia = new ArrayList<Audiencia>();
		Audiencia a = new Audiencia();
		ResultSet rs = null;
		
		String SQL = "SELECT id_audiencia,id_adv,id_cli,id_processo,nomeJuiz,data FROM audiencia WHERE id_cli = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idCliente);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_audiencia = rs.getInt(1);
			int id_adv = rs.getInt(2);
			int id_cli = rs.getInt(3);
			int id_processo = rs.getInt(4);
			String nomeJuiz = rs.getString(5);
			Date data = rs.getDate(6);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			

			ProcessosDAO daoProcessos = new ProcessosDAO(conexao);
			Processo processos = daoProcessos.buscarPorId(id_processo);
			
			a = new Audiencia(id_audiencia,adv,cli,processos,nomeJuiz,data);
			audiencia.add(a);
		}
		
		return audiencia;
	}

	@Override
	public List<Audiencia> listarAudienciaPorAdvogado(int _idAdvogado) throws SQLException {
		List<Audiencia> audiencia = new ArrayList<Audiencia>();
		Audiencia a = new Audiencia();
		ResultSet rs = null;
		
		String SQL = "SELECT id_audiencia,id_adv,id_cli,id_processo,nomeJuiz,data FROM audiencia WHERE id_adv = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idAdvogado);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_audiencia = rs.getInt(1);
			int id_adv = rs.getInt(2);
			int id_cli = rs.getInt(3);
			int id_processo = rs.getInt(4);
			String nomeJuiz = rs.getString(5);
			Date data = rs.getDate(6);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			

			ProcessosDAO daoProcessos = new ProcessosDAO(conexao);
			Processo processos = daoProcessos.buscarPorId(id_processo);
			
			a = new Audiencia(id_audiencia,adv,cli,processos,nomeJuiz,data);
			audiencia.add(a);
		}
		
		return audiencia;
	}

	@Override
	public List<Audiencia> listarAudienciaporProcesso(int _idProcesso) throws SQLException {
		List<Audiencia> audiencia = new ArrayList<Audiencia>();
		Audiencia a = new Audiencia();
		ResultSet rs = null;
		
		String SQL = "SELECT id_audiencia,id_adv,id_cli,id_processo,nomeJuiz,data FROM audiencia WHERE id_processo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idProcesso);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id_audiencia = rs.getInt(1);
			int id_adv = rs.getInt(2);
			int id_cli = rs.getInt(3);
			int id_processo = rs.getInt(4);
			String nomeJuiz = rs.getString(5);
			Date data = rs.getDate(6);
			
			ClienteDAO daoCli = new ClienteDAO(conexao);
			Cliente cli = daoCli.buscarPorId(id_cli);
			
			AdvogadoDAO daoAdv = new AdvogadoDAO(conexao);
			Advogado adv = daoAdv.buscarPorId(id_adv);
			

			ProcessosDAO daoProcessos = new ProcessosDAO(conexao);
			Processo processos = daoProcessos.buscarPorId(id_processo);
			
			a = new Audiencia(id_audiencia,adv,cli,processos,nomeJuiz,data);
			audiencia.add(a);
		}
		
		return audiencia;
	}

}
