package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.projeto.logistica.model.ContatoMotorista;
import br.projeto.logistica.model.Motorista;

public  class MotoristaDAOImpl implements MotoristaDAO{
	
	private Connection con;
	
	public  MotoristaDAOImpl() {
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();	
	}	
		
	
	

	@Override
	public void cadastrarMotorista(Motorista m) throws SQLException {
		String sql= "INSERT INTO motorista(nome,cpf,cnh,categoria,logradouro,numero,bairro,cidade,cep) VALUES (?,?,?,?,?,?,?,?,?)" ;
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, m.getNome());
		ps.setString(2, m.getCpf());
		ps.setString(3, m.getChn());
		ps.setString(4, m.getCategoria());
		ps.setString(5, m.getLogradouro());
		ps.setInt(6, m.getNumero());
		ps.setString(7, m.getBairro());
		ps.setString(8,m.getCidade());
		ps.setString(9, m.getCep());
		ps.execute();
		ps.close();
		
	}

	
	
	public int buscarUltimo() throws SQLException{
//		String sql= "SELECT TOP (1) WITH TIES ID FROM motorista ORDER BY ID DESC"; 
		String sql = "SELECT MAX(ID) AS ultimoid FROM motorista";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ContatoMotorista cms= new ContatoMotorista();
		while(rs.next()){
//			cms.setId_mot (rs.getInt (1));
			cms.setId_mot(rs.getInt("ultimoid"));
		}
		
		return cms.getId_mot();
	}
	
	
	
	@Override
	public void alterarMotorista(Motorista m) throws SQLException {
		String sql="UPDATE motorista SET nome=?,cpf=?,cnh=?,categoria=?,logradouro=?,numero=?,bairro=?,cidade=?,cep=? WHERE ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, m.getNome());
		ps.setString(2, m.getCpf());
		ps.setString(3, m.getChn());
		ps.setString(4, m.getCategoria());
		ps.setString(5, m.getLogradouro());
		ps.setInt(6, m.getNumero());
		ps.setString(7, m.getBairro());
		ps.setString(8,m.getCidade());
		ps.setString(9, m.getCep());
		ps.execute();
		ps.close();
	}

	@Override
	public Motorista consultarMotorista(Motorista m) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}




	@SuppressWarnings("unused")
	@Override
	public void excluirMotorista(Motorista m) throws SQLException {
		String sql= "DELETE motorista WHERE id = ?";
		
	}
	
	@Override
	public List<Motorista> consultaNomeMotorista(String nome)
			throws SQLException {
		String sql = "SELECT id, nome FROM motorista WHERE nome like (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%".concat(nome.concat("%")));
		ResultSet rs = ps.executeQuery();
		List<Motorista> lista = new ArrayList<Motorista>();
		while (rs.next()) {
			Motorista m = new Motorista();
			m.setId(rs.getInt("id"));
			m.setNome(rs.getString("nome"));
			lista.add(m);
		}
		return lista;
	}

}
