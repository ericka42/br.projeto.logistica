package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.projeto.logistica.model.Caminhao;

public class CaminhaoDAOImpl implements CaminhaoDAO{
	
	private Connection con;
	
	public CaminhaoDAOImpl() {
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();
	}

	@Override
	public void cadastrarCaminhao(Caminhao c) throws SQLException {
		String sql = "INSERT INTO caminhao (placa, renavam, chassi, modelo, marca, categoria, anomodelo, eixo, cor) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getPlaca());
		ps.setString(2, c.getRenavam());
		ps.setString(3, c.getChassi());
		ps.setString(4, c.getModelo());
		ps.setString(5, c.getMarca());
		ps.setString(6, c.getCategoria());
		ps.setInt(7, c.getAnoModelo());
		ps.setInt(8, c.getEixo());
		ps.setString(9, c.getCor());
		ps.execute();
		ps.close();
	}

	@Override
	public void alterarCaminhao(Caminhao c) throws SQLException {
		String sql = "UPDATE caminhao SET renavam = ?, chassi = ?, modelo = ?, marca = ?, categoria = ?, anomodelo = ?, eixo = ?, cor = ? WHERE placa = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,  c.getRenavam());
		ps.setString(2, c.getChassi());
		ps.setString(3, c.getModelo());
		ps.setString(4, c.getMarca());
		ps.setString(5, c.getCategoria());
		ps.setInt(6, c.getAnoModelo());
		ps.setInt(7, c.getEixo());
		ps.setString(8, c.getCor());
		ps.execute();
		ps.close();
	}

	@Override
	public Caminhao consultaCaminhao(String placa) throws SQLException {
		String sql = "SELECT renanvam, chassi, modelo, marca, categoria, anomodelo eixo, cor WHERE placa = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		Caminhao c = new Caminhao();
		ps.setString(1, placa);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			c.setRenavam(rs.getString("renavam"));
			c.setChassi(rs.getString("chassi"));
			c.setModelo(rs.getString("modelo"));
			c.setMarca(rs.getString("marca"));
			c.setCategoria(rs.getString("categoria"));
			c.setAnoModelo(rs.getInt("anomodelo"));
			c.setEixo(rs.getInt("eixo"));
			c.setCor(rs.getString("cor"));
		}
		return c;
	}

}
