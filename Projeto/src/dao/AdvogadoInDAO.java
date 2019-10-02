package dao;

import java.sql.SQLException;
import java.util.List;

import model.Advogado;

public interface AdvogadoInDAO {
	void Inserir(Advogado _objeto) throws SQLException;
	
	List<Advogado> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Advogado _objeto) throws SQLException;
	
	Advogado buscarPorId(int _id) throws SQLException;
}
