package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.projeto.logistica.model.ContatoMotorista;

public class ContatoMotoristaDAOImpl implements ContatoMotoristaDAO{

	private Connection con;
	public ContatoMotoristaDAOImpl(){
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();
		
	}

	
	@Override
	public void cadastrarContatoMotorista(ContatoMotorista cm)
			throws SQLException {
		
		String sql= "INSERT INTO contato(id_mot,tipo, telefone, descricao, operadora) VALUES ?,?,?,?,?,?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, cm.getId_mot());
		ps.setString(2, cm.getTipo());
		ps.setString(3, cm.getTelefone());
		ps.setString(4, cm.getDescricao());
		ps.setString(5, cm.getOperadora());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void alterarContatoMotorista(ContatoMotorista cm) throws SQLException{
	String sql= "UPDATE contato SET (id_mot = ?,tipo = ?, telefone = ?, descricao = ?, operadora = ?) WHERE = id_contato";
	PreparedStatement ps= con.prepareStatement(sql);
	ps.setInt(1, cm.getId_mot());
	ps.setString(2, cm.getTipo());
	ps.setString(3, cm.getTelefone());
	ps.setString(4, cm.getDescricao());
	ps.setString(5, cm.getOperadora());
	ps.execute();
	ps.close();
		
	}

	@Override
	public void excluirContatoMotorista(ContatoMotorista cm)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultarContatoMotorista(ContatoMotorista cm)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
