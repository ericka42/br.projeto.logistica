package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.projeto.logistica.model.Caminhao;
import br.projeto.logistica.model.Motorista;
import br.projeto.logistica.model.UsoCaminhao;

public class UsoCaminhaoDAOImpl implements UsoCaminhaoDAO{
	
	private Connection con;
	
	public UsoCaminhaoDAOImpl() {
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();
	}

	@Override
	public void cadastraUsoCaminhao(Motorista m, Caminhao c, UsoCaminhao u) throws SQLException {
		String sql = "INSERT INTO usocaminhao (id_mot, id_placa, dt_retirada, hr_retirada, dt_retorno, hr_retorno) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, m.getId());
		ps.setString(2, c.getPlaca());
		ps.setString(3, u.getDataRetirada());
		ps.setString(4, u.getHoraRetirada());
		ps.setString(5, u.getDataRetorno());
		ps.setString(6, u.getHoraRetorno());
		ps.execute();
		ps.close();
	}

}
