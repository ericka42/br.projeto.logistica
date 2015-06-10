package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.projeto.logistica.controller.MotoristaController;
import br.projeto.logistica.controller.UsoCaminhaoController;

public class FrmUsoCaminho {

	private JFrame frame;
	private JTextField txtMotorista;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtCategoria;
	private JTextField txtDataRetirada;
	private JTextField txtHoraRetirada;
	private JTextField txtDataRetorno;
	private JTextField txtHoraRetorno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsoCaminho window = new FrmUsoCaminho();
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
	public FrmUsoCaminho() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame("Movimentação de Caminhão");
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 616, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeMotorista = new JLabel("Nome Motorista :");
		lblNomeMotorista.setBounds(10, 27, 111, 14);
		frame.getContentPane().add(lblNomeMotorista);
		
		JLabel lblPlacaDoCaminho = new JLabel("Placa do Caminh\u00E3o :");
		lblPlacaDoCaminho.setBounds(10, 79, 127, 14);
		frame.getContentPane().add(lblPlacaDoCaminho);
		
		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setBounds(10, 134, 58, 14);
		frame.getContentPane().add(lblModelo);
		
		JLabel lblCategoria = new JLabel("Categoria :");
		lblCategoria.setBounds(295, 134, 68, 14);
		frame.getContentPane().add(lblCategoria);
		
		JLabel lblData = new JLabel("Data :");
		lblData.setBounds(58, 221, 46, 14);
		frame.getContentPane().add(lblData);
		
		JLabel lblHora = new JLabel("Hora :");
		lblHora.setBounds(58, 251, 46, 14);
		frame.getContentPane().add(lblHora);
		
		JLabel lblData_1 = new JLabel("Data :");
		lblData_1.setBounds(352, 218, 46, 14);
		frame.getContentPane().add(lblData_1);
		
		JLabel lblHora_1 = new JLabel("Hora :");
		lblHora_1.setBounds(352, 248, 46, 14);
		frame.getContentPane().add(lblHora_1);
		
		JLabel lblRetiradoEm = new JLabel("Retirado em :");
		lblRetiradoEm.setBounds(48, 193, 94, 14);
		frame.getContentPane().add(lblRetiradoEm);
		
		JLabel lblPrevisoDeRetorno = new JLabel("Previs\u00E3o de Retorno :");
		lblPrevisoDeRetorno.setBounds(322, 193, 134, 14);
		frame.getContentPane().add(lblPrevisoDeRetorno);
		
		JComboBox cmbMotorista = new JComboBox();
		cmbMotorista.setBounds(283, 24, 258, 20);
		frame.getContentPane().add(cmbMotorista);
		
		txtMotorista = new JTextField();
		txtMotorista.setBounds(118, 24, 134, 20);
		frame.getContentPane().add(txtMotorista);
		txtMotorista.setColumns(10);
		
		txtPlaca = new JTextField();
		javax.swing.text.MaskFormatter placa;
		try {
			placa = new javax.swing.text.MaskFormatter("???-####");
			txtPlaca = new javax.swing.JFormattedTextField(placa);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtPlaca.setBounds(128, 76, 111, 20);
		frame.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		txtModelo.setBounds(67, 131, 185, 20);
		frame.getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setBounds(373, 131, 168, 20);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtDataRetirada = new JTextField();
		txtDataRetirada.setBounds(102, 218, 111, 20);
		frame.getContentPane().add(txtDataRetirada);
		txtDataRetirada.setColumns(10);
		
		txtHoraRetirada = new JTextField();
		txtHoraRetirada.setBounds(102, 248, 86, 20);
		frame.getContentPane().add(txtHoraRetirada);
		txtHoraRetirada.setColumns(10);
		
		txtDataRetorno = new JTextField();
		txtDataRetorno.setBounds(398, 215, 121, 20);
		frame.getContentPane().add(txtDataRetorno);
		txtDataRetorno.setColumns(10);
		
		txtHoraRetorno = new JTextField();
		txtHoraRetorno.setBounds(398, 245, 86, 20);
		frame.getContentPane().add(txtHoraRetorno);
		txtHoraRetorno.setColumns(10);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmUsoCaminho.class.getResource("/br/projeto/logistica/icon/img-pesquisa.png")));
		btnPesquisar.setBounds(262, 68, 46, 28);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnSalvar = new JButton("  Salvar");
		btnSalvar.setIcon(new ImageIcon(FrmUsoCaminho.class.getResource("/br/projeto/logistica/icon/img-disquete.png")));
		btnSalvar.setBounds(472, 301, 118, 29);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnNovo = new JButton("  Novo");
		btnNovo.setIcon(new ImageIcon(FrmUsoCaminho.class.getResource("/br/projeto/logistica/icon/img-novo.png")));
		btnNovo.setBounds(341, 301, 121, 29);
		frame.getContentPane().add(btnNovo);
		
		JButton btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(FrmUsoCaminho.class.getResource("/br/projeto/logistica/icon/img-cancela.png")));
		btnCancelar.setBounds(10, 301, 127, 29);
		frame.getContentPane().add(btnCancelar);
		
		MotoristaController cm = new MotoristaController(txtMotorista, cmbMotorista);
		txtMotorista.addKeyListener((KeyListener) cm);
		
		
		UsoCaminhaoController ucc = new UsoCaminhaoController(txtMotorista, txtPlaca, txtModelo, txtCategoria, txtDataRetirada, txtHoraRetirada, txtDataRetorno, txtHoraRetorno, cmbMotorista);
		btnNovo.addActionListener(ucc);
		btnPesquisar.addActionListener(ucc);
		btnSalvar.addActionListener(ucc);
	}
}
