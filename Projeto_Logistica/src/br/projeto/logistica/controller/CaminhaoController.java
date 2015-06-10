package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.Caminhao;
import br.projeto.logistica.persistence.CaminhaoDAO;
import br.projeto.logistica.persistence.CaminhaoDAOImpl;

public class CaminhaoController implements ActionListener, KeyListener {

	private JTextField txtModelo;
	private JTextField txtAnoModelo;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtRenavam;
	private JTextField txtChassi;
	private JTextField txtCor;
	private JTextField txtEixo;
	private JTextField txtCategoria;

	public CaminhaoController(JTextField txtModelo, JTextField txtAnoModelo,
			JTextField txtMarca, JTextField txtPlaca, JTextField txtRenavam,
			JTextField txtChassi, JTextField txtCor, JTextField txtEixo,
			JTextField txtCategoria) {

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

	public CaminhaoController() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Caminhao c = new Caminhao();
		if ("  Salvar".equals(cmd)) {
			if (!"".equals(txtModelo.getText())
					&& !"".equals(txtAnoModelo.getText())
					&& !"".equals(txtCategoria.getText())
					&& !"".equals(txtChassi.getText())
					&& !"".equals(txtCor.getText())
					&& !"".equals(txtEixo.getText())
					&& !"".equals(txtMarca.getText())
					&& !"".equals(txtPlaca.getText())
					&& !"".equals(txtRenavam.getText())) {
				salvarCaminhao(c);
			} else {
				JOptionPane.showMessageDialog(null,
						"Preencha os campos corretamente!", "Alerta!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if ("  Novo".equals(cmd)) {
			descongelaCampo();
			limpaCampo();
		} else if ("".equals(cmd)) {
			consultaCaminhao();
		} else if ("  Alterar".equals(cmd)) {
			if (!"".equals(txtModelo.getText())
					&& !"".equals(txtAnoModelo.getText())
					&& !"".equals(txtCategoria.getText())
					&& !"".equals(txtChassi.getText())
					&& !"".equals(txtCor.getText())
					&& !"".equals(txtEixo.getText())
					&& !"".equals(txtMarca.getText())
					&& !"".equals(txtPlaca.getText())
					&& !"".equals(txtRenavam.getText())) {
				alterarCaminhao(c);
			}else{
				JOptionPane.showMessageDialog(null,
						"Impossível alterar, existe(m) campo(s) vazio(s)!", "Alerta!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if ("  Nova Consulta".equals(cmd)) {
			limpaCampo();
		} else if ("  Excluir".equals(cmd)) {
			if (!"".equals(txtModelo.getText())
					&& !"".equals(txtAnoModelo.getText())
					&& !"".equals(txtCategoria.getText())
					&& !"".equals(txtChassi.getText())
					&& !"".equals(txtCor.getText())
					&& !"".equals(txtEixo.getText())
					&& !"".equals(txtMarca.getText())
					&& !"".equals(txtPlaca.getText())
					&& !"".equals(txtRenavam.getText())) {
				excluiCaminhao();
			}else{
				JOptionPane.showMessageDialog(null,
						"Preencha os campos para a exclusão!", "Alerta!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	public void salvarCaminhao(Caminhao ca) {
		ca.setPlaca(txtPlaca.getText().replaceAll("-", ""));
		ca.setRenavam(txtRenavam.getText());
		ca.setChassi(txtChassi.getText());
		ca.setModelo(txtModelo.getText());
		ca.setMarca(txtMarca.getText());
		ca.setCategoria(txtCategoria.getText());
		ca.setAnoModelo(Integer.parseInt(txtAnoModelo.getText()));
		ca.setEixo(Integer.parseInt(txtEixo.getText()));
		ca.setCor(txtCor.getText());
		boolean validaCha = validaChassi();
		if (validaCha == true){
			CaminhaoDAO cDao = new CaminhaoDAOImpl();
			try {
				cDao.cadastrarCaminhao(ca);
				JOptionPane.showMessageDialog(null,
						"Caminhão Cadastrado com Sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
				congelaCampo();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void alterarCaminhao(Caminhao c) {
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
			int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente Alterar?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(opc == JOptionPane.OK_OPTION){
				cDao.alterarCaminhao(c);
				JOptionPane.showMessageDialog(null,
						"Caminhão Cadastrado com Sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void consultaCaminhao() {
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		Caminhao c = null;
		try {
			c = cDao.consultaCaminhao(txtPlaca.getText().replaceAll("-", ""));
			if(c == null){
				JOptionPane.showMessageDialog(null, "Placa não encontrada!");
			}else{
				txtPlaca.setEditable(false);
				txtRenavam.setText(c.getRenavam());
				txtChassi.setText(c.getChassi());
				txtModelo.setText(c.getModelo());
				txtMarca.setText(c.getMarca());
				txtCategoria.setText(c.getCategoria());
				txtAnoModelo.setText(String.valueOf(c.getAnoModelo()));
				txtEixo.setText(String.valueOf(c.getEixo()));
				txtCor.setText(c.getCor());
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@SuppressWarnings("unused")
	public void excluiCaminhao() {
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		boolean ca;
		try {
			int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(opc == JOptionPane.OK_OPTION){
				ca = cDao.excluirCaminhao(txtPlaca.getText().replaceAll("-", ""));
				limpaCampo();
				JOptionPane.showMessageDialog(null,
						"Caminhão Excluído com Sucesso!", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public boolean validaChassi() {
		String chassi = txtChassi.getText();
		if (chassi.length() < 17) {
			JOptionPane
			.showMessageDialog(
					null,
					"Chassi é composto por 17 caracteres, \n verifique se preencheu corretamente!",
					"Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	public void congelaCampo() {
		txtAnoModelo.setEditable(false);
		txtChassi.setEditable(false);
		txtCor.setEditable(false);
		txtEixo.setEditable(false);
		txtMarca.setEditable(false);
		txtModelo.setEditable(false);
		txtPlaca.setEditable(false);
		txtRenavam.setEditable(false);
		txtCategoria.setEditable(false);
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
		txtCategoria.setText("");
		liberaTxtPlaca();
	}

	public void descongelaCampo() {
		txtAnoModelo.setEditable(true);
		txtChassi.setEditable(true);
		txtCor.setEditable(true);
		txtEixo.setEditable(true);
		txtMarca.setEditable(true);
		txtModelo.setEditable(true);
		txtPlaca.setEditable(true);
		txtRenavam.setEditable(true);
		txtCategoria.setEditable(true);
	}

	public void liberaTxtPlaca() {
		txtPlaca.setEditable(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		txtChassi.setText(txtChassi.getText().replaceAll("[Q,q,O,o,I,i]", ""));
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}