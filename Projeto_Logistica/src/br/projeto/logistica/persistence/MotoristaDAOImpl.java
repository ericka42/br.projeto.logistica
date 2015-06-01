package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.projeto.logistica.model.Motorista;

public  class MotoristaDAOImpl implements MotoristaDAO{
	
	private Connection con;
	
	public  MotoristaDAOImpl() {
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();	
	}	
		
	
	

	@Override
	public void cadastrarMotorista(Motorista m) throws SQLException {
		String sql= "INSERT INTO motorista(nome,cpf,cnh,categoria,logradouro,numero,bairro,cidade,cep) VALUES ?,?,?,?,?,?,?,?,?" ;
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

	@Override
	public void alterarMotorista(Motorista m) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Motorista consultarMotorista(Motorista m) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
