package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmLogin {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public FrmLogin() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame("Nome do sistema");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 516, 317);
		frame.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeDaAplicao = new JLabel("NOME DO SISTEMA");
		lblNomeDaAplicao.setBounds(42, 26, 162, 32);
		frame.getContentPane().add(lblNomeDaAplicao);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(64, 100, 62, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(64, 144, 50, 14);
		frame.getContentPane().add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(118, 97, 180, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(118, 141, 143, 20);
		frame.getContentPane().add(txtSenha);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(FrmLogin.class.getResource("/br/projeto/logistica/icon/img-login.png")));
		lblImg.setBounds(352, 62, 104, 115);
		frame.getContentPane().add(lblImg);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(32, 217, 104, 34);
		frame.getContentPane().add(btnSair);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(364, 218, 104, 33);
		frame.getContentPane().add(btnEntrar);
		
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				FrmMenu fr = new FrmMenu();
				fr.main(null);
				frame.dispose();
			}
		});
		
	}
	
}