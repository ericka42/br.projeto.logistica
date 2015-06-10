package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.Motorista;
import br.projeto.logistica.persistence.MotoristaDAO;
import br.projeto.logistica.persistence.MotoristaDAOImpl;

public class MotoristaController implements ActionListener{

	
	
	JTextField txtNome,txtCpf,txtCnh,txtCategoria,txtLogradouro ;
	JTextField txtNumero,txtBairro,txtCidade,txtCep;
	
	
	public MotoristaController(JTextField txtNome, JTextField txtCpf,
			JTextField txtCnh, JTextField txtCategoria,
			JTextField txtLogradouro, JTextField txtNumero,
			JTextField txtBairro, JTextField txtCidade, JTextField txtCep) {
		super();
		this.txtNome = txtNome;
		this.txtCpf = txtCpf;
		this.txtCnh = txtCnh;
		this.txtCategoria = txtCategoria;
		this.txtLogradouro = txtLogradouro;
		this.txtNumero = txtNumero;
		this.txtBairro = txtBairro;
		this.txtCidade = txtCidade;
		this.txtCep = txtCep;
	}


	


	public void actionPerformed(ActionEvent e) {
		String cmd =e.getActionCommand();
		Motorista m =new Motorista();
		if("Salvar".equals(cmd)){
			salvarMotorista(m);
		}
		
	
	}
	
	
	
	
	
	
	public void salvarMotorista(Motorista m){
		m.setNome(txtNome.getText());
		m.setCpf(txtCpf.getText());  
		m.setChn(txtCnh.getText());
		m.setCategoria(txtCategoria.getText());
		m.setLogradouro(txtLogradouro.getText());
		m.setNumero(Integer.parseInt(txtNumero.getText()));
		m.setBairro(txtBairro.getText());
		m.setCidade(txtCidade.getText());
		m.setCep(txtCep.getText());
		MotoristaDAO cDao=new MotoristaDAOImpl();
		try{
			cDao.cadastrarMotorista(m);
			JOptionPane.showMessageDialog(null,"Motorista Cadastrado com Sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void alterarMotorista(Motorista m){
		m.setNome(txtNome.getText());
		m.setCpf(txtCpf.getText());  
		m.setChn(txtCnh.getText());
		m.setCategoria(txtCategoria.getText());
		m.setLogradouro(txtLogradouro.getText());
		m.setNumero(Integer.parseInt(txtNumero.getText()));
		m.setBairro(txtBairro.getText());
		m.setCidade(txtCidade.getText());
		m.setCep(txtCep.getText());
		MotoristaDAO cDao=new MotoristaDAOImpl();
		try{
			cDao.cadastrarMotorista(m);
			JOptionPane.showMessageDialog(null,"Motorista Alterado com Sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
