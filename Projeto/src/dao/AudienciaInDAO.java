package dao;

import java.sql.SQLException;
import java.util.List;

import model.Audiencia;

public interface AudienciaInDAO {
	 void Inserir(Audiencia _object) throws SQLException;
		
		List<Audiencia> listarTodos() throws SQLException;
		
		Boolean Excluir(int _id) throws SQLException;
		
		Boolean Atualizar(Audiencia _object) throws SQLException;
		
		Audiencia buscarPorId(int _id) throws SQLException;
		
	    List<Audiencia> listarAudienciaPorCliente(int _idCliente) throws SQLException;
	    
	    List<Audiencia> listarAudienciaPorAdvogado(int _idAdvogado) throws SQLException;
	    
	    List<Audiencia> listarAudienciaporProcesso(int _idProcesso) throws SQLException;
}
