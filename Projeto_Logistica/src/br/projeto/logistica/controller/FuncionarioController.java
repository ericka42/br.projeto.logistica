package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.projeto.logistica.model.Funcionario;
import br.projeto.logistica.persistence.FuncionarioDAO;
import br.projeto.logistica.persistence.FuncionarioDAOImpl;
import br.projeto.logistica.view.FrmMenu;

public class FuncionarioController implements ActionListener{
	
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JFrame frame;
	
	/*
	 * Construtor
	 * @param txtUsusario refere-se ao JTextField Usuario, txtSenha refere-se ao JPasswordField Senha, frame refere-se ao JFrame frame
	 */
	public FuncionarioController(JTextField txtUsuario, JPasswordField txtSenha, JFrame frame) {
		this.txtUsuario = txtUsuario;
		this.txtSenha = txtSenha;
		this.frame = frame;
	}

	@Override
	/*
	 * Metodo que dá a ação aos botões(non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Funcionario f = new Funcionario();
		if("Entrar".equals(cmd)){
			autenticarFuncionario(f);
		}
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	/*
	 * Metodo que faz a aautenticação dos funcionarios
	 */
	public void autenticarFuncionario(Funcionario f) {
		f.setUsuario(txtUsuario.getText());
		f.setSenha(txtSenha.getText());
		FuncionarioDAO fDao = new FuncionarioDAOImpl();
		try {
			if(fDao.autenticar(f)){
				FrmMenu menu = new FrmMenu();
				menu.main(null);
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!","Digite os dados corretamente", JOptionPane.ERROR_MESSAGE);
				limparCampos();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/*
	 * Metodo que limpa os campos
	 */
	private void limparCampos() {
		txtUsuario.setText("");
		txtSenha.setText("");
	}

}
