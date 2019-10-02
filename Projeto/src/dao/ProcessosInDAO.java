package dao;
import java.sql.SQLException;
import java.util.List;
import model.Processo;
public interface ProcessosInDAO {
	
    void Inserir(Processo _object) throws SQLException;
	
	List<Processo> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Processo _object) throws SQLException;
	
	Processo buscarPorId(int _id) throws SQLException;
	
    List<Processo> listarProcessosPorCliente(int _idCliente) throws SQLException;
    
    List<Processo> listarProcessosPorAdvogado(int _idAdvogado) throws SQLException;
}
