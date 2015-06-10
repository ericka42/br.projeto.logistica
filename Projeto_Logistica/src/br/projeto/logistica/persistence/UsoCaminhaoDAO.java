package br.projeto.logistica.persistence;

import java.sql.SQLException;

import br.projeto.logistica.model.UsoCaminhao;

public interface UsoCaminhaoDAO {
	
	public void cadastraUsoCaminhao(UsoCaminhao u) throws SQLException;

}
