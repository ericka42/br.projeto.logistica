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

public class FrmCadastrarProduto {

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
	private JCheckBox cbxFragil;
	private JComboBox<UnidadeMedida> cbMedida;
	private JComboBox<Peso> cbPeso;

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
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	private void initialize() {
		frmCadastrarProduto = new JFrame();
		frmCadastrarProduto.getContentPane().setBackground(new Color(255, 255, 153));
		frmCadastrarProduto.setTitle("Cadastrar Produto");
		frmCadastrarProduto.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCadastrarProduto.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		frmCadastrarProduto.setBounds(100, 100, 634, 430);
		frmCadastrarProduto.setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		frmCadastrarProduto.getContentPane().setLayout(null);

		JPanel pProdutos = new JPanel();
		pProdutos.setBackground(new Color(255, 255, 153));
		pProdutos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pProdutos.setBounds(10, 11, 598, 109);
		frmCadastrarProduto.getContentPane().add(pProdutos);
		pProdutos.setLayout(null);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 27, 46, 14);
		pProdutos.add(lblNome);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio.setBounds(10, 55, 74, 14);
		pProdutos.add(lblDescrio);

		JLabel lblQuantidade = new JLabel("Quantidade :");
		lblQuantidade.setBounds(10, 83, 97, 14);
		pProdutos.add(lblQuantidade);

		txtNome = new JTextField();
		txtNome.setBounds(91, 24, 231, 20);
		pProdutos.add(txtNome);
		txtNome.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(91, 52, 280, 20);
		pProdutos.add(txtDescricao);
		txtDescricao.setColumns(10);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(91, 80, 86, 20);
		pProdutos.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		cbxFragil = new JCheckBox("Fr\u00E1gil");
		cbxFragil.setBackground(new Color(255, 255, 153));
		cbxFragil.setBounds(336, 23, 97, 23);
		pProdutos.add(cbxFragil);

		JButton btnSalvar = new JButton("  Salvar");
		btnSalvar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/img-disquete.png")));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(478, 347, 130, 35);
		frmCadastrarProduto.getContentPane().add(btnSalvar);

		JButton btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastrarProduto.dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/img-cancela.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(10, 347, 137, 35);
		frmCadastrarProduto.getContentPane().add(btnCancelar);


		JButton btnNovo = new JButton("  Novo");
		btnNovo.setIcon(new ImageIcon(FrmCadastrarProduto.class.getResource("/br/projeto/logistica/icon/img-novo.png")));
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.setBounds(319, 347, 137, 35);
		frmCadastrarProduto.getContentPane().add(btnNovo);

		JPanel pPesoMedida = new JPanel();
		pPesoMedida.setBackground(new Color(255, 255, 153));
		pPesoMedida.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Peso & Medida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPesoMedida.setBounds(10, 131, 598, 102);
		frmCadastrarProduto.getContentPane().add(pPesoMedida);
		pPesoMedida.setLayout(null);

		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(10, 26, 46, 14);
		pPesoMedida.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(49, 23, 58, 20);
		pPesoMedida.add(txtPeso);
		txtPeso.setColumns(10);

		cbPeso = new JComboBox(Peso.values());
		cbPeso.setBounds(121, 23, 71, 20);
		pPesoMedida.add(cbPeso);

		JLabel lblAltura = new JLabel("Altura :");
		lblAltura.setBounds(459, 67, 46, 14);
		pPesoMedida.add(lblAltura);

		JLabel lblLargura = new JLabel("Largura :");
		lblLargura.setBounds(331, 67, 58, 14);
		pPesoMedida.add(lblLargura);

		JLabel lblComprimento = new JLabel("Comprimento :");
		lblComprimento.setBounds(190, 67, 85, 14);
		pPesoMedida.add(lblComprimento);

		cbMedida = new JComboBox(UnidadeMedida.values());
		cbMedida.setBounds(122, 64, 58, 20);
		pPesoMedida.add(cbMedida);

		JSeparator separator = new JSeparator();
		separator.setBounds(285, 11, 1, 109);
		pPesoMedida.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 51, 578, 2);
		pPesoMedida.add(separator_1);

		JLabel lblUnidadeMedida = new JLabel("Unidade  de Medida :");
		lblUnidadeMedida.setBounds(10, 67, 102, 14);
		pPesoMedida.add(lblUnidadeMedida);

		txtComprimento = new JTextField();
		txtComprimento.setBounds(269, 64, 52, 20);
		pPesoMedida.add(txtComprimento);
		txtComprimento.setColumns(10);

		txtLargura = new JTextField();
		txtLargura.setColumns(10);
		txtLargura.setBounds(386, 64, 52, 20);
		pPesoMedida.add(txtLargura);

		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(505, 64, 52, 20);
		pPesoMedida.add(txtAltura);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Associar Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 237, 300, 76);
		frmCadastrarProduto.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVinculo = new JButton("Vincula\u00E7\u00E3o");
		btnVinculo.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				FrmCadastroEmpresa fe = new FrmCadastroEmpresa();
				fe.main(null);
			}
		});
		btnVinculo.setBounds(77, 16, 146, 44);
		panel.add(btnVinculo);

		ProdutoController pc = new ProdutoController(txtNome, txtDescricao, txtQuantidade, txtPeso, txtComprimento, txtLargura, txtAltura, 
				txtID, txtProduto, cbxFragil, cbMedida, cbPeso);
		btnNovo.addActionListener(pc);
		btnSalvar.addActionListener(pc);
	}
}

