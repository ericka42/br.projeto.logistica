package br.projeto.logistica.persistence;

import java.sql.SQLException;

import br.projeto.logistica.model.Produto;


public interface ProdutoDAO {
	
	public void cadastrarProduto(Produto p) throws SQLException;
	public void alteraProduto(Produto p) throws SQLException;
	public Produto consultaProduto(String id) throws SQLException;
	public boolean excluirProduto(String id) throws SQLException;
	

}
