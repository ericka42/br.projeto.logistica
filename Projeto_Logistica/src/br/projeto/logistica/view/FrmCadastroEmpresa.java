package br.projeto.logistica.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class FrmCadastroEmpresa {
	
	
	private JFrame frame; 
	private JPanel contentPane;

	
	public FrmCadastroEmpresa() {
		frame =new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 767, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 731, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 30, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCnpj = new JLabel("Cnpj :");
		lblCnpj.setBounds(437, 30, 46, 14);
		panel.add(lblCnpj);
		
		JLabel lblInscrioEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual : ");
		lblInscrioEstadual.setBounds(10, 55, 118, 14);
		panel.add(lblInscrioEstadual);
		frame.setVisible(true);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new FrmCadastroEmpresa();
	}
}
