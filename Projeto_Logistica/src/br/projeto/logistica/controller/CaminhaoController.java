package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.projeto.logistica.model.Caminhao;
import br.projeto.logistica.persistence.CaminhaoDAO;
import br.projeto.logistica.persistence.CaminhaoDAOImpl;
import br.projeto.logistica.view.FrmCadastrarCaminhao;

public class CaminhaoController implements ActionListener{
	
	JTextField txtMarca;
	JTextField txtModelo;
	JTextField txtAnoModelo;
	JTextField txtRenavam;
	JTextField txtPlaca;
	JTextField txtChassi;
	JTextField txtCategoria;
	JTextField txtEixo;
	JTextField txtCor;
	JRadioButton rdbtnNovo;
	JRadioButton rdbtnSemiNovo;
	
	public CaminhaoController(JTextField txtMarca, JTextField txtModelo, JTextField txtAnoModelo,
			JTextField txtRenavam, JTextField txtPlaca, JTextField txtChassi, JTextField txtCategoria,
			JTextField txtEixo, JTextField txtCor, JRadioButton rdbtnNovo, JRadioButton rdbtnSemiNovo) {
		
		this.txtMarca = txtMarca;
		this.txtModelo = txtModelo;
		this.txtAnoModelo = txtAnoModelo;
		this.txtRenavam = txtRenavam;
		this.txtPlaca = txtPlaca;
		this.txtChassi = txtChassi;
		this.txtCategoria = txtCategoria;
		this.txtEixo = txtEixo;
		this.txtCor = txtCor;
		this.rdbtnNovo = rdbtnNovo;
		this.rdbtnSemiNovo = rdbtnSemiNovo;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Caminhao c = new Caminhao();
		
		if ("Salvar".equals(cmd)) {
			apresenta();
//			salvaCaminhao(c);
//			congelaCampo();
		}else{
			if ("Novo".equals(cmd)) {
				limpaCampo();
			}else{
				cancela();
			}
		}
	}


	private void salvaCaminhao(Caminhao c) {
		c.setPlaca(txtPlaca.getText().replace("-", ""));
		c.setRenavam(txtRenavam.getText());
		c.setChassi(txtChassi.getText());
		c.setCategoria(txtCategoria.getText());
		c.setModelo(txtModelo.getText());
		c.setMarca(txtMarca.getText());
		c.setAnoModelo(Integer.parseInt(txtAnoModelo.getText()));
		c.setEixo(Integer.parseInt(txtEixo.getText()));
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		try {
			cDao.cadastraCaminhao(c);
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso",
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}


	@SuppressWarnings("deprecation")
	private void congelaCampo() {
		txtAnoModelo.disable();
		txtCategoria.disable();
		txtChassi.disable();
		txtCor.disable();
		txtEixo.disable();
		txtMarca.disable();
		txtModelo.disable();
		txtPlaca.disable();
		txtRenavam.disable();
		rdbtnSemiNovo.disable();
		rdbtnNovo.disable();
	}


	private void limpaCampo() {
		txtAnoModelo.setText("");
		txtCategoria.setText("");
		txtChassi.setText("");
		txtCor.setText("");
		txtEixo.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtPlaca.setText("");
		txtRenavam.setText("");
		rdbtnNovo.isEnabled();
		rdbtnSemiNovo.isEnabled();
	}


	private void cancela() {
		FrmCadastrarCaminhao frm = new FrmCadastrarCaminhao();
		int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente Cancelar?", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(opc == JOptionPane.YES_OPTION){
			frm.dispose();
		}
	}
	
	public void apresenta(){
		System.out.println(txtPlaca.getText().replace("-", ""));
		System.out.println(txtRenavam.getText());
		System.out.println(txtChassi.getText());
		System.out.println(txtCategoria.getText());
		System.out.println(txtModelo.getText());
		System.out.println(txtMarca.getText());
		System.out.println(txtAnoModelo.getText());
		System.out.println(Integer.parseInt(txtEixo.getText()));
		System.out.println(rdbtnSemiNovo.getText());
		System.out.println(rdbtnNovo.getText());
	}
	
}
