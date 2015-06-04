package br.projeto.logistica.persistence;

import java.sql.SQLException;

import br.projeto.logistica.model.ContatoMotorista;


public interface ContatoMotoristaDAO {
	
	public void cadastrarContatoMotorista( ContatoMotorista cm) throws SQLException;
	public void alterarContatoMotorista(ContatoMotorista cm ) throws SQLException;
	public void excluirContatoMotorista(ContatoMotorista cm) throws SQLException;
	public void consultarContatoMotorista(ContatoMotorista cm) throws SQLException;

}
