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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FrmCadastrarProduto {

	private JFrame frame;
	private JTextField txtNomeEmp;
	private JTextField txtCodigoEmp;
	private JTextField txtNomeProduto;
	private JTextField txtDescrição;

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 598, 171);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Produto :");
		lblNome.setBounds(10, 28, 105, 14);
		panel.add(lblNome);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o :");
		lblDescricao.setBounds(10, 52, 63, 14);
		panel.add(lblDescricao);
		
		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa :");
		lblNomeDaEmpresa.setBounds(10, 146, 105, 14);
		panel.add(lblNomeDaEmpresa);
		
		JLabel lblCodigoEmpresa = new JLabel("Codigo Empresa :");
		lblCodigoEmpresa.setBounds(321, 146, 97, 14);
		panel.add(lblCodigoEmpresa);
		
		JCheckBox chckbxFragil = new JCheckBox("Fr\u00E1gil");
		chckbxFragil.setBounds(352, 21, 97, 23);
		panel.add(chckbxFragil);
		
		txtNomeEmp = new JTextField();
		txtNomeEmp.setBounds(111, 140, 194, 20);
		panel.add(txtNomeEmp);
		txtNomeEmp.setColumns(10);
		
		txtCodigoEmp = new JTextField();
		txtCodigoEmp.setBounds(413, 140, 63, 20);
		panel.add(txtCodigoEmp);
		txtCodigoEmp.setColumns(10);
		
		txtDescrição = new JTextField();
		txtDescrição.setBounds(68, 50, 448, 56);
		panel.add(txtDescrição);
		txtDescrição.setColumns(10);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(102, 24, 245, 20);
		panel.add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		JButton btnBuscar = new JButton("\r\n");
		btnBuscar.setBounds(488, 137, 53, 23);
		panel.add(btnBuscar);
		btnBuscar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/1432771351_Search.png")));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(488, 347, 109, 35);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(57, 347, 109, 35);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.setBounds(333, 349, 109, 35);
		frame.getContentPane().add(btnNovo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Peso & Medida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 193, 598, 120);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(10, 26, 46, 14);
		panel_1.add(lblPeso);
	}
}
