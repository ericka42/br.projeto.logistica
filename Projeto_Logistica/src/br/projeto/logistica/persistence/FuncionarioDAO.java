package br.projeto.logistica.persistence;

import java.sql.SQLException;

import br.projeto.logistica.model.Funcionario;

public interface FuncionarioDAO {
	
	public boolean autenticar(Funcionario f) throws SQLException;

}
