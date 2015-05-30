package br.projeto.logistica.view;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.projeto.logistica.controller.CaminhaoController;

public class FrmCadastrarCaminhao extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAnoModelo;
	private JTextField txtRenavam;
	private JTextField txtPlaca;
	private JTextField txtChassi;
	private JTextField txtCategoria;
	private JTextField txtEixo;
	private JRadioButton rdbtnNovo;
	private JRadioButton rdbtnSemiNovo;
	private JTextField txtCor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastrarCaminhao frame = new FrmCadastrarCaminhao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCadastrarCaminhao() {
		setTitle("Cadastro Caminhão"); //alterei para caminhão, pois o cadastro, embora seja de inumeros caminhões, naquele momento é de apenas 1 caminhão.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 378);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setBounds(10, 27, 59, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setBounds(261, 27, 53, 14);
		contentPane.add(lblModelo);
		
		JLabel lblAnoModelo = new JLabel("Ano Modelo :");
		lblAnoModelo.setBounds(10, 75, 79, 14);
		contentPane.add(lblAnoModelo);
		
		JLabel lblRenavam = new JLabel("Renavam :");
		lblRenavam.setBounds(189, 75, 69, 14);
		contentPane.add(lblRenavam);
		
		JLabel lblPlaca = new JLabel("Placa :");
		lblPlaca.setBounds(10, 130, 46, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblChassi = new JLabel("Chassi :");
		lblChassi.setBounds(204, 130, 53, 14);
		contentPane.add(lblChassi);
		
		JLabel lblCategoria = new JLabel("Categoria :");
		lblCategoria.setBounds(10, 183, 69, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblQuantidadeDeEixo = new JLabel("Quantidade de Eixo :");
		lblQuantidadeDeEixo.setBounds(235, 183, 115, 14);
		contentPane.add(lblQuantidadeDeEixo);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(10, 223, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblCor = new JLabel("Cor :");
		lblCor.setBounds(283, 223, 46, 14);
		contentPane.add(lblCor);
		
		rdbtnNovo = new JRadioButton("Novo");
		rdbtnNovo.setBounds(53, 244, 69, 23);
		contentPane.add(rdbtnNovo);
		
		rdbtnSemiNovo = new JRadioButton("Semi - Novo");
		rdbtnSemiNovo.setBounds(136, 244, 93, 23);
		contentPane.add(rdbtnSemiNovo);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNovo);
		bg.add(rdbtnSemiNovo);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(67, 24, 162, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(324, 24, 135, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtAnoModelo = new JTextField();
		txtAnoModelo.setBounds(88, 72, 69, 20);
		contentPane.add(txtAnoModelo);
		txtAnoModelo.setColumns(10);
		
		txtRenavam = new JTextField();
		txtRenavam.setBounds(260, 72, 162, 20);
		contentPane.add(txtRenavam);
		txtRenavam.setColumns(10);
		
		txtPlaca = new JTextField();
		javax.swing.text.MaskFormatter placa;
		try {
			placa = new javax.swing.text.MaskFormatter("???-####");
			txtPlaca = new javax.swing.JFormattedTextField(placa);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtPlaca.setBounds(60, 127, 122, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtChassi = new JTextField();
		txtChassi.setBounds(258, 127, 211, 20);
		contentPane.add(txtChassi);
		txtChassi.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(79, 180, 135, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtEixo = new JTextField();
		txtEixo.setBounds(353, 180, 69, 20);
		contentPane.add(txtEixo);
		txtEixo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(324, 220, 115, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(369, 306, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(261, 306, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 306, 89, 23);
		contentPane.add(btnCancelar);
		
		CaminhaoController cController = new CaminhaoController(txtMarca, txtModelo, txtAnoModelo, txtRenavam, txtPlaca, txtChassi, txtCategoria, txtEixo, txtAnoModelo, rdbtnNovo, rdbtnSemiNovo);
		btnSalvar.addActionListener(cController);
		btnNovo.addActionListener(cController);
		btnCancelar.addActionListener(cController);
	}
}
