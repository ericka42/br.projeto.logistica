package br.projeto.logistica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FrmCadastrarProduto {

	private JFrame frame;
	private JTextField txtNomeEmp;
	private JTextField txtCodigoEmp;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeProduto;
	private JTextField txtDescrição;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastrarProduto window = new FrmCadastrarProduto();
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
	public FrmCadastrarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCadastrarProduto.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		frame.setBounds(100, 100, 634, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Produto :");
		lblNome.setBounds(10, 81, 105, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o :");
		lblDescricao.setBounds(10, 106, 63, 14);
		frame.getContentPane().add(lblDescricao);
		
		JCheckBox chckbxFragil = new JCheckBox("Fr\u00E1gil");
		chckbxFragil.setBounds(353, 77, 97, 23);
		frame.getContentPane().add(chckbxFragil);
		
		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa :");
		lblNomeDaEmpresa.setBounds(10, 11, 105, 14);
		frame.getContentPane().add(lblNomeDaEmpresa);
		
		txtNomeEmp = new JTextField();
		txtNomeEmp.setBounds(106, 8, 194, 20);
		frame.getContentPane().add(txtNomeEmp);
		txtNomeEmp.setColumns(10);
		
		JLabel lblCodigoEmpresa = new JLabel("Codigo Empresa :");
		lblCodigoEmpresa.setBounds(315, 11, 97, 14);
		frame.getContentPane().add(lblCodigoEmpresa);
		
		txtCodigoEmp = new JTextField();
		txtCodigoEmp.setBounds(401, 8, 133, 20);
		frame.getContentPane().add(txtCodigoEmp);
		txtCodigoEmp.setColumns(10);
		
		JLabel lblCodigoProduto = new JLabel("Codigo Produto :");
		lblCodigoProduto.setBounds(10, 56, 97, 14);
		frame.getContentPane().add(lblCodigoProduto);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setBounds(106, 53, 86, 20);
		frame.getContentPane().add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(106, 78, 222, 20);
		frame.getContentPane().add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		txtDescrição = new JTextField();
		txtDescrição.setBounds(69, 103, 448, 140);
		frame.getContentPane().add(txtDescrição);
		txtDescrição.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(10, 260, 46, 14);
		frame.getContentPane().add(lblPeso);
		
		textField_5 = new JTextField();
		textField_5.setBounds(69, 257, 97, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho :");
		lblTamanho.setBounds(10, 285, 63, 14);
		frame.getContentPane().add(lblTamanho);
		
		textField_6 = new JTextField();
		textField_6.setBounds(69, 282, 97, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/1432771715_file_add.png")));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(69, 347, 109, 35);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(447, 347, 109, 35);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnNewButton = new JButton("\r\n");
		btnNewButton.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/1432771351_Search.png")));
		btnNewButton.setBounds(544, 7, 53, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
