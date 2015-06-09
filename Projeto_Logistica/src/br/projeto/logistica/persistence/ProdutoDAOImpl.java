package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.projeto.logistica.model.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {
	
	private Connection con;
	
	public ProdutoDAOImpl() {
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();	
	}

	@Override
	public void cadastrarProduto(Produto p) throws SQLException {
		String sql= "INSERT INTO produto(nome,fragil,descricao,peso,medida,quantidade) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getFragil());
		ps.setString(3, p.getDescricao());
		ps.setFloat(4, p.getPeso());
		ps.setString(5, p.getMedida());
		ps.setInt(6, p.getQuantidade());
		ps.execute();
		ps.close();
	}

	@Override
	public void alteraProduto(Produto p) throws SQLException {
		String sql= "UPDATE produto SET nome=?,fragil=?,descricao=?,peso=?,medida=?,quantidade=? WHERE ID=?";
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getFragil());
		ps.setString(3, p.getDescricao());
		ps.setFloat(4, p.getPeso());
		ps.setString(5, p.getMedida());
		ps.setInt(6, p.getQuantidade());
		ps.execute();
		ps.close();
	}

	@Override
	public Produto consultaProduto(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
