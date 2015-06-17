package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.projeto.logistica.controller.ProdutoController;
import br.projeto.logistica.model.Peso;
import br.projeto.logistica.model.UnidadeMedida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultarProduto {

	private JFrame frmCadastrarProduto;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtPeso;
	private JTextField txtComprimento;
	private JTextField txtLargura;
	private JTextField txtAltura;
	private JTextField txtID;
	private JTextField txtProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultarProduto window = new FrmConsultarProduto();
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
	public FrmConsultarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmCadastrarProduto = new JFrame();
		frmCadastrarProduto.getContentPane().setBackground(new Color(255, 255, 153));
		frmCadastrarProduto.setTitle("Alterar,Consultar e Excluir"
				+ " Produto");
		frmCadastrarProduto.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultarProduto.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		frmCadastrarProduto.setBounds(100, 100, 661, 449);
		frmCadastrarProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarProduto.getContentPane().setLayout(null);
		
		JPanel pProdutos = new JPanel();
		pProdutos.setBackground(new Color(255, 255, 153));
		pProdutos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pProdutos.setBounds(10, 11, 598, 156);
		frmCadastrarProduto.getContentPane().add(pProdutos);
		pProdutos.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 32, 46, 14);
		pProdutos.add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio.setBounds(10, 99, 74, 14);
		pProdutos.add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Unidades / Quantidade :");
		lblQuantidade.setBounds(10, 130, 127, 14);
		pProdutos.add(lblQuantidade);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 29, 231, 20);
		pProdutos.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(91, 96, 280, 20);
		pProdutos.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(147, 127, 86, 20);
		pProdutos.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JCheckBox cbxFragil = new JCheckBox("Fr\u00E1gil");
		cbxFragil.setBackground(new Color(255, 255, 153));
		cbxFragil.setBounds(256, 126, 66, 23);
		pProdutos.add(cbxFragil);
		
		JLabel lblID = new JLabel("ID Produto :");
		lblID.setBounds(342, 26, 86, 14);
		pProdutos.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(421, 23, 74, 20);
		pProdutos.add(txtID);
		txtID.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-pesquisa.png")));
		btnBuscar.setBounds(505, 23, 57, 23);
		pProdutos.add(btnBuscar);
		
		JLabel lblProduto = new JLabel("Produto :");
		lblProduto.setBounds(10, 63, 57, 14);
		pProdutos.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(66, 60, 256, 20);
		pProdutos.add(txtProduto);
		txtProduto.setColumns(10);
		
		JButton btnExcluir = new JButton("  Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExcluir.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-excluir.png")));
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(155, 369, 130, 35);
		frmCadastrarProduto.getContentPane().add(btnExcluir);
		
		
		JButton btnEditar = new JButton("  Editar");
		btnEditar.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-novo.png")));
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(510, 369, 125, 35);
		frmCadastrarProduto.getContentPane().add(btnEditar);
		
		JPanel pPesoMedida = new JPanel();
		pPesoMedida.setBackground(new Color(255, 255, 153));
		pPesoMedida.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Peso & Medida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPesoMedida.setBounds(10, 178, 598, 94);
		frmCadastrarProduto.getContentPane().add(pPesoMedida);
		pPesoMedida.setLayout(null);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(10, 26, 46, 14);
		pPesoMedida.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(49, 23, 58, 20);
		pPesoMedida.add(txtPeso);
		txtPeso.setColumns(10);
		
		JComboBox cbPeso = new JComboBox (Peso.values());
		cbPeso.setBounds(121, 23, 71, 20);
		pPesoMedida.add(cbPeso);
		
		JLabel lblAltura = new JLabel("Altura :");
		lblAltura.setBounds(475, 67, 46, 14);
		pPesoMedida.add(lblAltura);
		
		JLabel lblLargura = new JLabel("Largura :");
		lblLargura.setBounds(354, 67, 58, 14);
		pPesoMedida.add(lblLargura);
		
		JLabel lblComprimento = new JLabel("Comprimento :");
		lblComprimento.setBounds(206, 67, 85, 14);
		pPesoMedida.add(lblComprimento);
		
		JComboBox cbMedida = new JComboBox (UnidadeMedida.values());
		cbMedida.setBounds(122, 64, 58, 20);
		pPesoMedida.add(cbMedida);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 51, 578, 2);
		pPesoMedida.add(separator_1);
		
		JLabel lblUnidadeMedida = new JLabel("Unidade  de Medida :");
		lblUnidadeMedida.setBounds(10, 67, 102, 14);
		pPesoMedida.add(lblUnidadeMedida);
		
		txtComprimento = new JTextField();
		txtComprimento.setBounds(292, 64, 52, 20);
		pPesoMedida.add(txtComprimento);
		txtComprimento.setColumns(10);
		
		txtLargura = new JTextField();
		txtLargura.setColumns(10);
		txtLargura.setBounds(413, 64, 52, 20);
		pPesoMedida.add(txtLargura);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(523, 64, 52, 20);
		pPesoMedida.add(txtAltura);
		
		JButton btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastrarProduto.dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-cancela.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(10, 369, 125, 35);
		frmCadastrarProduto.getContentPane().add(btnCancelar);
		
		JPanel pAssociar = new JPanel();
		pAssociar.setBackground(new Color(255, 255, 153));
		pAssociar.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Associar Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pAssociar.setBounds(10, 283, 283, 75);
		frmCadastrarProduto.getContentPane().add(pAssociar);
		pAssociar.setLayout(null);
		
		JButton btnVinculo = new JButton("Vinculo");
		btnVinculo.setBounds(69, 21, 135, 43);
		pAssociar.add(btnVinculo);
		
		JButton btnNovaConsulta = new JButton("  Nova Consulta");
		btnNovaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovaConsulta.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-novaC.png")));
		btnNovaConsulta.setBounds(310, 369, 178, 35);
		frmCadastrarProduto.getContentPane().add(btnNovaConsulta);
		
		
		ProdutoController p = new ProdutoController(txtNome, txtDescricao, txtQuantidade, txtPeso, txtComprimento, txtLargura, txtAltura, txtID, txtProduto, cbxFragil, cbMedida, cbPeso);
		btnBuscar.addActionListener(p);
		btnEditar.addActionListener(p);
		btnExcluir.addActionListener(p);
		btnNovaConsulta.addActionListener(p);
	
	}
}
