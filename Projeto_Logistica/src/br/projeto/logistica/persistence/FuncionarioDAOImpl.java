package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.projeto.logistica.model.Funcionario;

public class FuncionarioDAOImpl implements FuncionarioDAO{
	
	private Connection con;
	
	public FuncionarioDAOImpl() {
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();
	}

	@Override
	public boolean autenticar(Funcionario f) throws SQLException {
		String sql = "SELECT usuario, senha FROM funcionario WHERE usuario = (?) and senha = (?)";
		PreparedStatement ps;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getUsuario());
			ps.setString(2, f.getSenha());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}
		} catch (SQLException e){
			return false;
		}
	}

}
