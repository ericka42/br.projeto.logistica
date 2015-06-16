package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.Motorista;
import br.projeto.logistica.persistence.MotoristaDAO;
import br.projeto.logistica.persistence.MotoristaDAOImpl;

public class MotoristaController implements ActionListener, KeyListener{

	
	
	JTextField txtNome,txtCpf,txtCnh,txtCategoria,txtLogradouro ;
	JTextField txtNumero,txtBairro,txtCidade,txtCep;
	private JTextField txtMotorista;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbMotorista;
	private List<Motorista> lista = null;
	
	
	public MotoristaController(JTextField txtNome, JTextField txtCpf,
			JTextField txtCnh, JTextField txtCategoria,
			JTextField txtLogradouro, JTextField txtNumero,
			JTextField txtBairro, JTextField txtCidade, JTextField txtCep
			) {
		
		
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


	


	@SuppressWarnings("rawtypes")
	public MotoristaController(JTextField txtMotorista, JComboBox cmbMotorista) {
		this.txtMotorista = txtMotorista;
		this.cmbMotorista = cmbMotorista;
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
	
	private MotoristaDAO dao = new MotoristaDAOImpl();

	public List<Motorista> retornaListaMotorista(String nome){
		try {
			lista = dao.consultaNomeMotorista(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public void keyReleased(KeyEvent arg0) {
		try {
			lista = dao.consultaNomeMotorista(txtMotorista.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (lista != null){
			cmbMotorista.removeAllItems();
			cmbMotorista.addItem("--------------------");
			for (Motorista m : lista){
				cmbMotorista.addItem(m.getNome());
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
