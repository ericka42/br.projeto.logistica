package br.projeto.logistica.persistence;

import java.sql.SQLException;

import br.projeto.logistica.model.Caminhao;
import br.projeto.logistica.model.Motorista;
import br.projeto.logistica.model.UsoCaminhao;

public interface UsoCaminhaoDAO {
	
	public void cadastraUsoCaminhao(Motorista m, Caminhao c, UsoCaminhao u) throws SQLException;

}
