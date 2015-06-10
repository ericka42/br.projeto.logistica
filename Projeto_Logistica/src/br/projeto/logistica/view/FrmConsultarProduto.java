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
	private void initialize() {
		frmCadastrarProduto = new JFrame();
		frmCadastrarProduto.setTitle("Alterar,Consultar e Excluir"
				+ " Produto");
		frmCadastrarProduto.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmConsultarProduto.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		frmCadastrarProduto.setBounds(100, 100, 634, 471);
		frmCadastrarProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarProduto.getContentPane().setLayout(null);
		
		JPanel pProdutos = new JPanel();
		pProdutos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pProdutos.setBounds(10, 11, 598, 134);
		frmCadastrarProduto.getContentPane().add(pProdutos);
		pProdutos.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 46, 46, 14);
		pProdutos.add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio.setBounds(10, 72, 74, 14);
		pProdutos.add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Unidades / Quantidade :");
		lblQuantidade.setBounds(10, 100, 127, 14);
		pProdutos.add(lblQuantidade);
		
		txtNome = new JTextField();
		txtNome.setBounds(91, 43, 231, 20);
		pProdutos.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(91, 69, 280, 20);
		pProdutos.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(147, 97, 86, 20);
		pProdutos.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JCheckBox cbxFragil = new JCheckBox("Fr\u00E1gil");
		cbxFragil.setBounds(256, 96, 66, 23);
		pProdutos.add(cbxFragil);
		
		JLabel lblID = new JLabel("Identifica\u00E7\u00E3o do Produto :");
		lblID.setBounds(10, 21, 143, 14);
		pProdutos.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(147, 18, 74, 20);
		pProdutos.add(txtID);
		txtID.setColumns(10);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(338, 42, 86, 23);
		pProdutos.add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-disquete.png")));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(486, 347, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExcluir.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-cancela.png")));
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(129, 347, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnExcluir);
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(FrmConsultarProduto.class.getResource("/br/projeto/logistica/icon/img-novo.png")));
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(358, 347, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnEditar);
		
		JPanel pPesoMedida = new JPanel();
		pPesoMedida.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Peso & Medida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPesoMedida.setBounds(10, 156, 598, 94);
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
		lblAltura.setBounds(459, 67, 46, 14);
		pPesoMedida.add(lblAltura);
		
		JLabel lblLargura = new JLabel("Largura :");
		lblLargura.setBounds(331, 67, 58, 14);
		pPesoMedida.add(lblLargura);
		
		JLabel lblComprimento = new JLabel("Comprimento :");
		lblComprimento.setBounds(190, 67, 85, 14);
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
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(10, 347, 109, 35);
		frmCadastrarProduto.getContentPane().add(btnCancelar);
		
		JPanel pAssociar = new JPanel();
		pAssociar.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Associar Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pAssociar.setBounds(10, 261, 283, 75);
		frmCadastrarProduto.getContentPane().add(pAssociar);
		pAssociar.setLayout(null);
		
		JButton btnVinculo = new JButton("Vinculo");
		btnVinculo.setBounds(69, 21, 135, 43);
		pAssociar.add(btnVinculo);
		
	
	}
}
