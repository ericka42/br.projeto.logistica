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

public class FrmConsultarCaminhao {

	private JFrame frame;
	private JTextField txtModelo;
	private JTextField txtAnoModelo;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtChassi;
	private JTextField txtCor;
	private JTextField txtEixo;
	private JTextField txtRenavam;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JButton btnNovaConsulta;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JTextField txtCategoria;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultarCaminhao window = new FrmConsultarCaminhao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmConsultarCaminhao() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Consulta Caminhão");
		frame.setAutoRequestFocus(false);
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 632, 372);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria :");
		lblCategoria.setBounds(266, 114, 66, 14);
		frame.getContentPane().add(lblCategoria);
		
		JLabel lblModelo = new JLabel("Modelo : ");
		lblModelo.setBounds(10, 76, 52, 14);
		frame.getContentPane().add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano : ");
		lblAno.setBounds(330, 73, 34, 14);
		frame.getContentPane().add(lblAno);
		
		JLabel lblMarca = new JLabel("Marca : ");
		lblMarca.setBounds(10, 117, 46, 14);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblPlaca = new JLabel("Placa : ");
		lblPlaca.setBounds(10, 21, 46, 14);
		frame.getContentPane().add(lblPlaca);
		
		JLabel lblRenavam = new JLabel("Renavam :");
		lblRenavam.setBounds(10, 163, 66, 14);
		frame.getContentPane().add(lblRenavam);
		
		JLabel lblChassi = new JLabel("Chassi : ");
		lblChassi.setBounds(276, 160, 56, 14);
		frame.getContentPane().add(lblChassi);
		
		JLabel lblCor = new JLabel("Cor :");
		lblCor.setBounds(10, 212, 34, 14);
		frame.getContentPane().add(lblCor);
		
		JLabel lblQtdEixo = new JLabel("Qtd. Eixo :");
		lblQtdEixo.setBounds(219, 215, 66, 14);
		frame.getContentPane().add(lblQtdEixo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(72, 73, 195, 20);
		frame.getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtAnoModelo = new JTextField();
		txtAnoModelo.setBounds(374, 70, 86, 20);
		frame.getContentPane().add(txtAnoModelo);
		txtAnoModelo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(66, 114, 146, 20);
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
		txtPlaca.setBounds(54, 18, 96, 20);
		frame.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtRenavam = new JTextField();
		txtRenavam.setBounds(81, 160, 168, 20);
		frame.getContentPane().add(txtRenavam);
		txtRenavam.setColumns(10);
		
		txtChassi = new JTextField();
		txtChassi.setBounds(332, 157, 201, 20);
		frame.getContentPane().add(txtChassi);
		txtChassi.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(54, 209, 104, 20);
		frame.getContentPane().add(txtCor);
		txtCor.setColumns(10);
		
		txtEixo = new JTextField();
		txtEixo.setText("");
		txtEixo.setBounds(281, 212, 66, 20);
		frame.getContentPane().add(txtEixo);
		txtEixo.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(342, 111, 154, 20);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		btnCancelar = new JButton("  Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(FrmConsultarCaminhao.class.getResource("/br/projeto/logistica/icon/img-cancela.png")));
		btnCancelar.setBounds(10, 284, 120, 29);
		frame.getContentPane().add(btnCancelar);
		
		btnAlterar = new JButton("  Alterar");
		btnAlterar.setIcon(new ImageIcon(FrmConsultarCaminhao.class.getResource("/br/projeto/logistica/icon/img-alterar.png")));
		btnAlterar.setBounds(486, 284, 120, 29);
		frame.getContentPane().add(btnAlterar);
		
		btnNovaConsulta = new JButton("  Nova Consulta");
		btnNovaConsulta.setIcon(new ImageIcon(FrmConsultarCaminhao.class.getResource("/br/projeto/logistica/icon/img-novaC.png")));
		btnNovaConsulta.setBounds(307, 284, 153, 29);
		frame.getContentPane().add(btnNovaConsulta);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmConsultarCaminhao.class.getResource("/br/projeto/logistica/icon/img-pesquisa.png")));
		btnPesquisar.setBounds(173, 9, 46, 29);
		frame.getContentPane().add(btnPesquisar);
		
		btnExcluir = new JButton("  Excluir");
		btnExcluir.setIcon(new ImageIcon(FrmConsultarCaminhao.class.getResource("/br/projeto/logistica/icon/img-excluir.png")));
		btnExcluir.setBounds(153, 284, 129, 29);
		frame.getContentPane().add(btnExcluir);
		
		CaminhaoController cc = new CaminhaoController(txtModelo, txtAnoModelo, txtMarca, txtPlaca, txtRenavam, txtChassi, txtCor, txtEixo, txtCategoria);
		btnPesquisar.addActionListener(cc);
		btnAlterar.addActionListener(cc);
		btnNovaConsulta.addActionListener(cc);
		btnExcluir.addActionListener(cc);
		txtChassi.addKeyListener(cc);

	}
}
