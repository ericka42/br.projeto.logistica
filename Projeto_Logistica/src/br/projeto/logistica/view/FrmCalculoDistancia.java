package br.projeto.logistica.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.projeto.logistica.api.googleMaps.DistanciaWS;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmCalculoDistancia {

	private JFrame frame;
	private JTextField txtOrigem;
	private JTextField txtDestino;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCalculoDistancia window = new FrmCalculoDistancia();
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
	public FrmCalculoDistancia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pOrigemDestino = new JPanel();
		pOrigemDestino.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Origem & Destino", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pOrigemDestino.setBounds(10, 10, 533, 103);
		frame.getContentPane().add(pOrigemDestino);
		pOrigemDestino.setLayout(null);
		
		JLabel lblOrigem = new JLabel("Origem :");
		lblOrigem.setBounds(10, 24, 46, 14);
		pOrigemDestino.add(lblOrigem);
		
		JLabel lblDestino = new JLabel("Destino :");
		lblDestino.setBounds(10, 58, 46, 14);
		pOrigemDestino.add(lblDestino);
		
		txtOrigem = new JTextField();
		txtOrigem.setBounds(62, 21, 461, 20);
		pOrigemDestino.add(txtOrigem);
		txtOrigem.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setColumns(10);
		txtDestino.setBounds(62, 55, 461, 20);
		pOrigemDestino.add(txtDestino);
		
		JPanel pDistancia = new JPanel();
		pDistancia.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dist\u00E2ncia M\u00EDnima", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pDistancia.setBounds(10, 123, 267, 92);
		frame.getContentPane().add(pDistancia);
		pDistancia.setLayout(null);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtResultado.setEditable(false);
		txtResultado.setBounds(10, 22, 247, 59);
		pDistancia.add(txtResultado);
		txtResultado.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(287, 135, 133, 72);
		frame.getContentPane().add(btnCalcular);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 255, 89, 48);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(331, 255, 89, 48);
		frame.getContentPane().add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(440, 255, 89, 48);
		frame.getContentPane().add(btnSalvar);
		
		DistanciaWS acao = new DistanciaWS(txtOrigem, txtDestino, txtResultado);
		btnCalcular.addActionListener(acao);
	}
}
