package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.Caminhao;
import br.projeto.logistica.persistence.CaminhaoDAO;
import br.projeto.logistica.persistence.CaminhaoDAOImpl;

public class CaminhaoController implements ActionListener{
	
	private JTextField txtModelo;
	private JTextField txtAnoModelo;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtRenavam;
	private JTextField txtChassi; 
	private JTextField txtCor;
	private JTextField txtEixo;
	private JTextField txtCategoria;
	
	public CaminhaoController(JTextField txtModelo, JTextField txtAnoModelo, JTextField txtMarca, JTextField txtPlaca, JTextField txtRenavam, JTextField txtChassi,
			JTextField txtCor, JTextField txtEixo, JTextField txtCategoria) {
		
		this.txtModelo = txtModelo;
		this.txtAnoModelo = txtAnoModelo;
		this.txtMarca = txtMarca;
		this.txtPlaca = txtPlaca;
		this.txtRenavam = txtRenavam;
		this.txtChassi = txtChassi;
		this.txtCor = txtCor;
		this.txtEixo = txtEixo;
		this.txtCategoria = txtCategoria;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Caminhao c = new Caminhao();
		if("  Salvar".equals(cmd)){
			salvarCaminhao(c);
			congelaCampo();
		}else if("  Novo".equals(cmd)){
				limpaCampo();
			}
		
	}

	public void salvarCaminhao(Caminhao c) {
		c.setPlaca(txtPlaca.getText().replaceAll("-", ""));
		c.setRenavam(txtRenavam.getText());
		c.setChassi(txtChassi.getText());
		c.setModelo(txtModelo.getText());
		c.setMarca(txtMarca.getText());
		c.setCategoria(txtCategoria.getText());
		c.setAnoModelo(Integer.parseInt(txtAnoModelo.getText()));
		c.setEixo(Integer.parseInt(txtEixo.getText()));
		c.setCor(txtCor.getText());
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		try {
			cDao.cadastrarCaminhao(c);
			JOptionPane.showMessageDialog(null, "Caminhão Cadastrado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void alterarCaminhao(Caminhao c){
		c.setPlaca(txtPlaca.getText().replaceAll("-", ""));
		c.setRenavam(txtRenavam.getText());
		c.setChassi(txtChassi.getText());
		c.setModelo(txtModelo.getText());
		c.setMarca(txtMarca.getText());
		c.setAnoModelo(Integer.parseInt(txtAnoModelo.getText()));
		c.setEixo(Integer.parseInt(txtEixo.getText()));
		c.setCor(txtCor.getText());
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		try {
			cDao.alterarCaminhao(c);
			JOptionPane.showMessageDialog(null, "Caminhão Cadastrado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void consultaCaminhao(){
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		Caminhao c = null;
		try {
			c = cDao.consultaCaminhao(txtPlaca.getText().replaceAll("-", ""));
			txtModelo.setText(c.getModelo());
			txtAnoModelo.setText(String.valueOf(c.getAnoModelo()));
			txtMarca.setText(c.getMarca());
//			Terminar de fazer a consulta!!!!
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@SuppressWarnings("deprecation")
	public void congelaCampo() {
		txtAnoModelo.disable();
		txtChassi.disable();
		txtCor.disable();
		txtEixo.disable();
		txtMarca.disable();
		txtModelo.disable();
		txtPlaca.disable();
		txtRenavam.disable();
	}

	public void limpaCampo() {
		txtAnoModelo.setText("");
		txtChassi.setText("");
		txtCor.setText("");
		txtEixo.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtPlaca.setText("");
		txtRenavam.setText("");
	}

}