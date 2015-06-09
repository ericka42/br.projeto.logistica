package br.projeto.logistica.persistence;

import java.sql.SQLException;

import br.projeto.logistica.model.Empresa;


public interface EmpresaDAO {

	public void cadastrarEmpresa(Empresa emp) throws SQLException;
	public void alterarEmpresa(Empresa emp) throws SQLException;
	public Empresa consultaEmpresa(String cnpj) throws SQLException;
	public Empresa excluirEmpresa(String cnpj)throws SQLException;
	
	
}
