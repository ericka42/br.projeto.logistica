package br.projeto.logistica.persistence;

import java.sql.SQLException;

import br.projeto.logistica.model.Caminhao;

public interface CaminhaoDAO {
	
	public void cadastrarCaminhao(Caminhao c) throws SQLException;
	public void alterarCaminhao(Caminhao c) throws SQLException;
	public Caminhao consultaCaminhao(String placa) throws SQLException;
	public boolean excluirCaminhao(String placa) throws SQLException;
}
