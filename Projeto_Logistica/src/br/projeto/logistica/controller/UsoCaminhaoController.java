package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.Caminhao;
import br.projeto.logistica.model.Motorista;
import br.projeto.logistica.model.UsoCaminhao;
import br.projeto.logistica.persistence.CaminhaoDAO;
import br.projeto.logistica.persistence.CaminhaoDAOImpl;
import br.projeto.logistica.persistence.UsoCaminhaoDAO;
import br.projeto.logistica.persistence.UsoCaminhaoDAOImpl;

public class UsoCaminhaoController implements ActionListener {
	
	private JTextField txtMotorista;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtCategoria;
	private JTextField txtDataRetirada;
	private JTextField txtHoraRetirada;
	private JTextField txtDataRetorno;
	private JTextField txtHoraRetorno;
	private JComboBox<Motorista> cmbMotorista;
	private List<Motorista> lista;
	
	
	/*
	 * Construtor
	 */
	public UsoCaminhaoController(JTextField txtMotorista, JTextField txtPlaca, JTextField txtModelo, JTextField txtCategoria, JTextField txtDataRetirada,
			JTextField txtHoraRetirada, JTextField txtDataRetorno, JTextField txtHoraRetorno, JComboBox<Motorista> cmbMotorista, List<Motorista> lista) {
		this.txtMotorista = txtMotorista;
		this.txtPlaca = txtPlaca;
		this.txtModelo = txtModelo;
		this.txtCategoria = txtCategoria;
		this.txtDataRetirada = txtDataRetirada;
		this.txtHoraRetirada = txtHoraRetirada;
		this.txtDataRetorno = txtDataRetorno;
		this.txtHoraRetorno = txtHoraRetorno;
		this.cmbMotorista = cmbMotorista;
		this.lista = lista;
	}

	@Override
	/*
	 * Metodo que dá a ação aos botões(non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Motorista m = new Motorista();
		Caminhao c = new Caminhao();
		UsoCaminhao u = new UsoCaminhao();
		String cmd = e.getActionCommand();
		if("  Novo".equals(cmd)){
			limpaCampos();
		}else if("  Salvar".equals(cmd)){
			salvaMovimentacao(m, c, u);
		}else if("".equals(cmd)){
			pesquisaPlaca();
		}
	}
	/*
	 * Metodo que limpa os campos
	 */
	public void limpaCampos() {
		txtMotorista.setText("");
		txtPlaca.setText("");
		txtModelo.setText("");
		txtCategoria.setText("");
		txtDataRetirada.setText("");
		txtHoraRetirada.setText("");
		txtDataRetorno.setText("");
		txtHoraRetorno.setText("");
		cmbMotorista.removeAllItems();
	}
	
	/*
	 * Metodo que salva a movimentação
	 */
	public void salvaMovimentacao(Motorista m, Caminhao c, UsoCaminhao u) {
		if(cmbMotorista.getSelectedItem() != null || !cmbMotorista.getSelectedItem().equals("--------------------")){
			for (Motorista mo : lista){
				if (cmbMotorista.getSelectedItem().toString().equals(mo.getNome())){
					m.setId(mo.getId());
				}
			}
		}
		c.setPlaca(txtPlaca.getText().replaceAll("-", ""));
		u.setDataRetirada(txtDataRetirada.getText());
		u.setHoraRetirada(txtHoraRetirada.getText());
		u.setDataRetorno(txtDataRetorno.getText());
		u.setHoraRetorno(txtHoraRetorno.getText());
		UsoCaminhaoDAO uDao = new UsoCaminhaoDAOImpl();
		try {
			uDao.cadastraUsoCaminhao(m, c, u);
			JOptionPane.showMessageDialog(null,
					"Caminhão Cadastrado com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Metodo que pesquisa a placa
	 */
	public void pesquisaPlaca() {
		CaminhaoDAO cDao = new CaminhaoDAOImpl();
		Caminhao c = null;
		try {
			c = cDao.consultaCaminhao(txtPlaca.getText().replaceAll("-", ""));
			if(c == null){
				JOptionPane.showMessageDialog(null, "Placa não encontrada!");
			}else{
				txtModelo.setText(c.getModelo());
				txtCategoria.setText(c.getCategoria());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
