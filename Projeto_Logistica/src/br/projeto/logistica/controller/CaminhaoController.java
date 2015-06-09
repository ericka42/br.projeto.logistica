package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.Caminhao;
import br.projeto.logistica.persistence.CaminhaoDAO;
import br.projeto.logistica.persistence.CaminhaoDAOImpl;

public class CaminhaoController implements ActionListener {

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
				validaChassi(); // Implementar KeyListener
				salvarCaminhao(c);
				congelaCampo();
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
			alterarCaminhao(c);
		} else if ("  Nova Consulta".equals(cmd)) {
			limpaCampo();
		} else if ("  Excluir".equals(cmd)) {
			excluiCaminhao();
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
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		try {
			cDao.cadastrarCaminhao(ca);
			JOptionPane.showMessageDialog(null,
					"Caminhão Cadastrado com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
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
			cDao.alterarCaminhao(c);
			JOptionPane.showMessageDialog(null,
					"Caminhão Cadastrado com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
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
			txtPlaca.setEditable(false);
			txtRenavam.setText(c.getRenavam());
			txtChassi.setText(c.getChassi());
			txtModelo.setText(c.getModelo());
			txtMarca.setText(c.getMarca());
			txtCategoria.setText(c.getCategoria());
			txtAnoModelo.setText(String.valueOf(c.getAnoModelo()));
			txtEixo.setText(String.valueOf(c.getEixo()));
			txtCor.setText(c.getCor());
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
			ca = cDao.excluirCaminhao(txtPlaca.getText().replaceAll("-", ""));
			JOptionPane.showMessageDialog(null,
					"Caminhão Excluído com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void validaChassi() {
		int x = 0;
		String chassi = txtChassi.getText();
		if (chassi.length() == 17) {
			for (int i = 0; i < chassi.length(); i++) {
				char l = chassi.charAt(i);
				if (l == 'Q' || l == 'q' || l == 'O' || l == 'o' | l == 'I'
						|| l == 'i') {
					x += 1;
				}
			}
			if (x >= 1) {
				JOptionPane.showMessageDialog(null,
						"Chassi incorreto, digite novamente!", "Alerta",
						JOptionPane.INFORMATION_MESSAGE);
			} 
//			apresenta mensagem no console se o chassi está correto
//			else {
//				System.out.println("Chassi Correto");
//			}
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"Chassi é composto por 17 caracteres, \n verifique se preencheu corretamente!",
							"Alerta", JOptionPane.INFORMATION_MESSAGE);
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
	
}