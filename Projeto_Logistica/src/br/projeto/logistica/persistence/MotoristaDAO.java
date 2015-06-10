package br.projeto.logistica.persistence;

import java.sql.SQLException;
import java.util.List;

import br.projeto.logistica.model.Motorista;

public interface MotoristaDAO {
	
	
	public void cadastrarMotorista(Motorista m) throws SQLException;
	public void alterarMotorista(Motorista m ) throws SQLException;
	public void excluirMotorista(Motorista m) throws SQLException;
	public Motorista consultarMotorista(Motorista m) throws SQLException;
	public int buscarUltimo() throws SQLException;
	public List<Motorista> consultaNomeMotorista(String nome) throws SQLException;
}
