package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.projeto.logistica.controller.CaminhaoController;

public class FrmCadastrarCaminhao {

	private JFrame frame;
	private JTextField txtModelo;
	private JTextField txtAnoModelo;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtChassi;
	private JTextField txtCor;
	private JTextField txtEixo;
	private JTextField txtRenavam;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnNovo;
	private JTextField txtCategoria;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastrarCaminhao window = new FrmCadastrarCaminhao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmCadastrarCaminhao() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Cadastro Caminhão");
		frame.setAutoRequestFocus(false);
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 486, 421);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo : ");
		lblModelo.setBounds(10, 26, 52, 14);
		frame.getContentPane().add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano : ");
		lblAno.setBounds(303, 26, 34, 14);
		frame.getContentPane().add(lblAno);
		
		JLabel lblMarca = new JLabel("Marca : ");
		lblMarca.setBounds(10, 79, 46, 14);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblPlaca = new JLabel("Placa : ");
		lblPlaca.setBounds(248, 76, 46, 14);
		frame.getContentPane().add(lblPlaca);
		
		JLabel lblRenavam = new JLabel("Renavam :");
		lblRenavam.setBounds(10, 170, 66, 14);
		frame.getContentPane().add(lblRenavam);
		
		JLabel lblChassi = new JLabel("Chassi : ");
		lblChassi.setBounds(10, 221, 52, 14);
		frame.getContentPane().add(lblChassi);
		
		JLabel lblCor = new JLabel("Cor :");
		lblCor.setBounds(10, 266, 34, 14);
		frame.getContentPane().add(lblCor);
		
		JLabel lblQtdEixo = new JLabel("Qtd. Eixo :");
		lblQtdEixo.setBounds(228, 266, 66, 14);
		frame.getContentPane().add(lblQtdEixo);
		
		JLabel lblCategoria = new JLabel("Categoria :");
		lblCategoria.setBounds(10, 129, 66, 14);
		frame.getContentPane().add(lblCategoria);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(72, 23, 195, 20);
		frame.getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtAnoModelo = new JTextField();
		txtAnoModelo.setBounds(342, 23, 86, 20);
		frame.getContentPane().add(txtAnoModelo);
		txtAnoModelo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(54, 76, 146, 20);
		frame.getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPlaca = new JTextField();
		javax.swing.text.MaskFormatter placa;
		try {
			placa = new javax.swing.text.MaskFormatter("???-####");
			txtPlaca = new javax.swing.JFormattedTextField(placa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtPlaca.setBounds(291, 73, 96, 20);
		frame.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtRenavam = new JTextField();
		txtRenavam.setBounds(86, 167, 168, 20);
		frame.getContentPane().add(txtRenavam);
		txtRenavam.setColumns(10);
		
		txtChassi = new JTextField();
		txtChassi.setBounds(66, 218, 201, 20);
		frame.getContentPane().add(txtChassi);
		txtChassi.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(54, 263, 104, 20);
		frame.getContentPane().add(txtCor);
		txtCor.setColumns(10);
		
		txtEixo = new JTextField();
		txtEixo.setText("");
		txtEixo.setBounds(291, 263, 66, 20);
		frame.getContentPane().add(txtEixo);
		txtEixo.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(72, 126, 161, 20);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		btnSalvar = new JButton("  Salvar");
		//btnSalvar.setIcon(new ImageIcon(FrmCadastrarCaminhao.class.getResource("/img/img-disquete.png")));
		btnSalvar.setBounds(351, 340, 109, 29);
		frame.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		//btnCancelar.setIcon(new ImageIcon(FrmCadastrarCaminhao.class.getResource("/img/img-cancela.png")));
		btnCancelar.setBounds(10, 340, 120, 29);
		frame.getContentPane().add(btnCancelar);
		
		btnNovo = new JButton("  Novo ");
		//btnNovo.setIcon(new ImageIcon(FrmCadastrarCaminhao.class.getResource("/img/img-novo.png")));
		btnNovo.setBounds(212, 340, 120, 29);
		frame.getContentPane().add(btnNovo);
		
		CaminhaoController cc = new CaminhaoController(txtModelo, txtAnoModelo, txtMarca, txtPlaca, txtRenavam, txtChassi, txtCor, txtEixo, txtCategoria);
		btnSalvar.addActionListener(cc);
		btnNovo.addActionListener(cc);
		
	}
}
