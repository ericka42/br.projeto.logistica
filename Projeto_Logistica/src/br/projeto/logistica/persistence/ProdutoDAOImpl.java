package br.projeto.logistica.persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String sql= "INSERT INTO produto(nome, fragil, descricao, peso, pesagem, comprimento, altura, largura, unid_medida, quantidade)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getFragil());
		ps.setString(3, p.getDescricao());
		ps.setFloat(4, p.getPeso());
		ps.setString(5, p.getPesagem());
		ps.setFloat(6, p.getComprimento());
		ps.setFloat(7, p.getAltura());
		ps.setFloat(8, p.getLargura());
		ps.setString(9, p.getUniMedida());
		ps.setInt(10, p.getQuantidade());
		ps.execute();
		ps.close();
	}

	@Override
	public void alteraProduto(Produto p) throws SQLException {
//		String sql= "UPDATE produto SET nome=?,fragil=?,descricao=?,peso=?,medida=?,quantidade=? WHERE ID=?";
//		PreparedStatement ps =con.prepareStatement(sql);
//		ps.setString(1, p.getNome());
//		ps.setString(2, p.getFragil());
//		ps.setString(3, p.getDescricao());
//		ps.setFloat(4, p.getPeso());
//		ps.setString(5, p.getMedida());
//		ps.setInt(6, p.getQuantidade());
//		ps.execute();
//		ps.close();
	}

	@Override
	public Produto consultaProduto(String id) throws SQLException {
		String sql = "SELECT nome, fragil, descricao, peso, pesagem, comprimento, altura, largura, unid_medida, quantidade FROM produto where id = (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		Produto p = new Produto();
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			p.setNome(rs.getString("nome"));
			p.setFragil(rs.getString("fragil"));
			p.setDescricao(rs.getString("descricao"));
			p.setPeso(rs.getFloat("peso"));
			p.setPesagem(rs.getString("pesagem"));
			p.setComprimento(rs.getFloat("Comprimento"));
			p.setAltura(rs.getFloat("altura"));
			p.setLargura(rs.getFloat("largura"));
			p.setUniMedida(rs.getString("unid_medida"));
			p.setQuantidade(rs.getInt("quantidade"));
		}
		return p;
	}

	@Override
	public boolean excluirProduto(String id) throws SQLException {
		String sql = "DELETE produto WHERE id = (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.execute();
		ps.close();
		
		return true;
	}


}
