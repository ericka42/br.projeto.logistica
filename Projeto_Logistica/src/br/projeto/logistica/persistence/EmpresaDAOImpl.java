package br.projeto.logistica.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.projeto.logistica.model.Empresa;

public class EmpresaDAOImpl implements EmpresaDAO{

	
	private Connection con;
	
	public EmpresaDAOImpl() {
		GenericDAO gDao = new GenericDAOImpl();
		con = gDao.getConnection();
	}
	
	
	
	
	@Override
	public void cadastrarEmpresa(Empresa emp) throws SQLException {
		String sql= "INSERT INTO empresa"
	    + "(cnpj,nome,insc_estadual,ramo,logradouro,num,complemento,bairro,cidade,cep,informacao)"
	    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getCnpj());
		ps.setString(2,emp.getNome());
		ps.setString(3, emp.getInscEstadual());
		ps.setString(4, emp.getRamo());
		ps.setString(5,emp.getLogradouro());
		ps.setInt(6,emp.getNumero());
		ps.setString(7,emp.getComplemento());
		ps.setString(8, emp.getBairro());
		ps.setString(9, emp.getCidade());
		ps.setString(10,emp.getCep());
		ps.setString(11, emp.getInformacao());
		ps.execute();
		ps.close();
		
		
		
		
	}

	@Override
	public void alterarEmpresa(Empresa emp) throws SQLException {
		String sql=
		"UPDATE empresa "
		+ "SET nome=?,insc_estadual=?,ramo=?,logradouro=?,num=?,complemento=?,bairro=?,cidade=?,cep=?,informacao=? "
		+ "WHERE cnpj=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,emp.getNome());
		ps.setString(2, emp.getInscEstadual());
		ps.setString(3, emp.getRamo());
		ps.setString(4,emp.getLogradouro());
		ps.setInt(5,emp.getNumero());
		ps.setString(6,emp.getComplemento());
		ps.setString(7, emp.getBairro());
		ps.setString(8, emp.getCidade());
		ps.setString(9,emp.getCep());
		ps.setString(10, emp.getInformacao());
		ps.execute();
		ps.close();
	}

	@Override
	public Empresa consultaEmpresa(String cnpj) throws SQLException {
		String sql="SELECT "
		+ "nome,insc_estadual,ramo,logradouro,num,complemento,bairro,cidade,cep,informacao"
		+ "FROM empresa WHERE cnpj =?";
		PreparedStatement ps = con.prepareStatement(sql);
		Empresa emp= new Empresa();
		ps.setString(1, cnpj);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			emp.setNome(rs.getString("nome"));
			emp.setInscEstadual(rs.getString("insc_estadual"));
			emp.setRamo(rs.getString("ramo"));
			emp.setLogradouro(rs.getString("logradouro"));
			emp.setNumero(rs.getInt("num"));
			emp.setComplemento(rs.getString("complemento"));
			emp.setBairro(rs.getString("bairro"));
			emp.setCidade(rs.getString("cidade"));
			emp.setCep(rs.getString("cep"));
			emp.setInformacao(rs.getString("informacao"));
		}
		return emp;
	}

	@Override
	public Empresa excluirEmpresa(String cnpj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
