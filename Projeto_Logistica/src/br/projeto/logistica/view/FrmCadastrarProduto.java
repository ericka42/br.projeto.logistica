package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FrmCadastrarProduto {

	private JFrame frmCadastrarProduto;
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 598, 171);
		frmCadastrarProduto.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Produto :");
		lblNome.setBounds(10, 28, 105, 14);
		panel.add(lblNome);
		lblNome.setBounds(10, 81, 105, 14);
		frmCadastrarProduto.getContentPane().add(lblNome);
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o :");
		lblDescricao.setBounds(10, 52, 63, 14);
		panel.add(lblDescricao);
		lblDescricao.setBounds(10, 106, 63, 14);
		frmCadastrarProduto.getContentPane().add(lblDescricao);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(10, 260, 46, 14);
		frmCadastrarProduto.getContentPane().add(lblPeso);
		
		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa :");
		lblNomeDaEmpresa.setBounds(10, 146, 105, 14);
		panel.add(lblNomeDaEmpresa);
		lblNomeDaEmpresa.setBounds(10, 11, 105, 14);
		frmCadastrarProduto.getContentPane().add(lblNomeDaEmpresa);
		
		JLabel lblCodigoEmpresa = new JLabel("Codigo Empresa :");
		lblCodigoEmpresa.setBounds(321, 146, 97, 14);
		panel.add(lblCodigoEmpresa);
		lblCodigoEmpresa.setBounds(315, 11, 97, 14);
		frmCadastrarProduto.getContentPane().add(lblCodigoEmpresa);
		
		JLabel lblMedida = new JLabel("Medida :");
		lblMedida.setBounds(10, 285, 63, 14);
		frmCadastrarProduto.getContentPane().add(lblMedida);
		
		JLabel lblCodigoProduto = new JLabel("Codigo Produto :");
		lblCodigoProduto.setBounds(10, 56, 97, 14);
		frmCadastrarProduto.getContentPane().add(lblCodigoProduto);
		JCheckBox chckbxFragil = new JCheckBox("Fr\u00E1gil");
		chckbxFragil.setBounds(352, 21, 97, 23);
		panel.add(chckbxFragil);
		chckbxFragil.setBounds(353, 77, 97, 23);
		frmCadastrarProduto.getContentPane().add(chckbxFragil);
		txtNomeEmp = new JTextField();
		txtNomeEmp.setBounds(111, 140, 194, 20);
		panel.add(txtNomeEmp);
		txtNomeEmp.setBounds(106, 8, 194, 20);
		frmCadastrarProduto.getContentPane().add(txtNomeEmp);
		txtNomeEmp.setColumns(10);
		txtCodigoEmp = new JTextField();
		txtCodigoEmp.setBounds(413, 140, 63, 20);
		panel.add(txtCodigoEmp);
		txtCodigoEmp.setBounds(401, 8, 133, 20);
		frmCadastrarProduto.getContentPane().add(txtCodigoEmp);
		txtCodigoEmp.setColumns(10);
		
		
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(106, 78, 222, 20);
		frmCadastrarProduto.getContentPane().add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		txtDescrição = new JTextField();
		txtDescrição.setBounds(68, 50, 448, 56);
		panel.add(txtDescrição);
		txtDescrição.setBounds(83, 106, 448, 140);
		frmCadastrarProduto.getContentPane().add(txtDescrição);
		txtDescrição.setColumns(10);
		
		
		
		JButton btnBuscar = new JButton("\r\n");
		btnBuscar.setBounds(488, 137, 53, 23);
		panel.add(btnBuscar);
		btnBuscar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/1432771351_Search.png")));
		
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
		
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/img-novo.png")));
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.setBounds(333, 349, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnNovo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Peso & Medida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 193, 598, 120);
		frmCadastrarProduto.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JLabel lblQuantidade = new JLabel("Quantidade :");
		lblQuantidade.setBounds(10, 310, 77, 14);
		frmCadastrarProduto.getContentPane().add(lblQuantidade);
		
		lblPeso.setBounds(10, 26, 46, 14);
		panel_1.add(lblPeso);
		
	}
}
