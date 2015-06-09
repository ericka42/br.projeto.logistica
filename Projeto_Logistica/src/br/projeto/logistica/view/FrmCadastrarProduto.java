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

	private JFrame frmCadastrarProduto;
	private JTextField txtNomeEmp;
	private JTextField txtCodigoEmp;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeProduto;
	private JTextField txtDescrição;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastrarProduto window = new FrmCadastrarProduto();
					window.frmCadastrarProduto.setVisible(true);
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
		frmCadastrarProduto = new JFrame();
		frmCadastrarProduto.setTitle("Cadastrar Produto");
		frmCadastrarProduto.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCadastrarProduto.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		frmCadastrarProduto.setBounds(100, 100, 634, 471);
		frmCadastrarProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarProduto.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Produto :");
		lblNome.setBounds(10, 81, 105, 14);
		frmCadastrarProduto.getContentPane().add(lblNome);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o :");
		lblDescricao.setBounds(10, 106, 63, 14);
		frmCadastrarProduto.getContentPane().add(lblDescricao);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(10, 260, 46, 14);
		frmCadastrarProduto.getContentPane().add(lblPeso);
		
		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa :");
		lblNomeDaEmpresa.setBounds(10, 11, 105, 14);
		frmCadastrarProduto.getContentPane().add(lblNomeDaEmpresa);
		
		JLabel lblCodigoEmpresa = new JLabel("Codigo Empresa :");
		lblCodigoEmpresa.setBounds(315, 11, 97, 14);
		frmCadastrarProduto.getContentPane().add(lblCodigoEmpresa);
		
		JLabel lblMedida = new JLabel("Medida :");
		lblMedida.setBounds(10, 285, 63, 14);
		frmCadastrarProduto.getContentPane().add(lblMedida);
		
		JLabel lblCodigoProduto = new JLabel("Codigo Produto :");
		lblCodigoProduto.setBounds(10, 56, 97, 14);
		frmCadastrarProduto.getContentPane().add(lblCodigoProduto);
		
		JCheckBox chckbxFragil = new JCheckBox("Fr\u00E1gil");
		chckbxFragil.setBounds(353, 77, 97, 23);
		frmCadastrarProduto.getContentPane().add(chckbxFragil);
		
		txtNomeEmp = new JTextField();
		txtNomeEmp.setBounds(106, 8, 194, 20);
		frmCadastrarProduto.getContentPane().add(txtNomeEmp);
		txtNomeEmp.setColumns(10);
		
		txtCodigoEmp = new JTextField();
		txtCodigoEmp.setBounds(401, 8, 133, 20);
		frmCadastrarProduto.getContentPane().add(txtCodigoEmp);
		txtCodigoEmp.setColumns(10);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setBounds(106, 53, 86, 20);
		frmCadastrarProduto.getContentPane().add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(106, 78, 222, 20);
		frmCadastrarProduto.getContentPane().add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		txtDescrição = new JTextField();
		txtDescrição.setBounds(83, 106, 448, 140);
		frmCadastrarProduto.getContentPane().add(txtDescrição);
		txtDescrição.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(83, 257, 97, 20);
		frmCadastrarProduto.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(83, 282, 97, 20);
		frmCadastrarProduto.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/img-disquete.png")));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(488, 347, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/img-cancela.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(57, 347, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnCancelar);
		
		JButton btnBuscar = new JButton("\r\n");
		btnBuscar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/1432771351_Search.png")));
		btnBuscar.setBounds(544, 7, 53, 23);
		frmCadastrarProduto.getContentPane().add(btnBuscar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/img-novo.png")));
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.setBounds(333, 349, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnNovo);
		
		JLabel lblQuantidade = new JLabel("Quantidade :");
		lblQuantidade.setBounds(10, 310, 77, 14);
		frmCadastrarProduto.getContentPane().add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(83, 307, 97, 20);
		frmCadastrarProduto.getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
	}
}
