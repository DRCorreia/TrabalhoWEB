package dao;

import java.sql.SQLException;
import java.util.List;

import model.CausasFinalizadas;

public interface CausasFinalizadasInDAO {
void Inserir(CausasFinalizadas _objeto) throws SQLException;
	
	List<CausasFinalizadas> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(CausasFinalizadas _objeto) throws SQLException;
	
	CausasFinalizadas buscarPorId(int _id) throws SQLException;
}
