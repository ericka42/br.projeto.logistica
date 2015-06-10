package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrmMenu {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu window = new FrmMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmMenu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("SGL - Sistema de Gestão Logística");
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		
		JButton btnCad_Cami = new JButton("Cadastrar Caminh\u00E3o");
		btnCad_Cami.setBounds(23, 43, 171, 62);
		btnCad_Cami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadastrarCaminhao fc = new FrmCadastrarCaminhao();
				fc.main(null);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnCad_Cami);
		
		JButton btnCon_Cami = new JButton("Consultar Caminh\u00E3o");
		btnCon_Cami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmConsultarCaminhao caminhao = new FrmConsultarCaminhao();
				caminhao.main(null);
			}
		});
		btnCon_Cami.setBounds(256, 43, 171, 62);
		frame.getContentPane().add(btnCon_Cami);
		
		JButton btnCad_Emp = new JButton("Cadastrar Empresa");
		btnCad_Emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadastroEmpresa empresa = new FrmCadastroEmpresa();
				empresa.main(null);
			}
		});
		btnCad_Emp.setBounds(23, 155, 171, 62);
		frame.getContentPane().add(btnCad_Emp);
		
		JButton btnCon_Emp = new JButton("Consultar Empresa");
		btnCon_Emp.setEnabled(false);
		btnCon_Emp.setBounds(256, 155, 171, 62);
		frame.getContentPane().add(btnCon_Emp);
		
		JButton btnCad_Prod = new JButton("Cadastrar Produto");
		btnCad_Prod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadastrarProduto produto = new FrmCadastrarProduto();
				produto.main(null);
			}
		});
		btnCad_Prod.setBounds(23, 258, 171, 62);
		frame.getContentPane().add(btnCad_Prod);
		
		JButton btnCon_Prod = new JButton("Consultar Produto");
		btnCon_Prod.setEnabled(false);
		btnCon_Prod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmConsultarProduto consulta = new FrmConsultarProduto();
				consulta.main(null);
			}
		});
		btnCon_Prod.setBounds(256, 258, 171, 62);
		frame.getContentPane().add(btnCon_Prod);
		
		JButton btnCad_Mot = new JButton("Cadastrar Motorista");
		btnCad_Mot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadastrarMotorista motorista = new FrmCadastrarMotorista();
				motorista.main(null);
			}
		});
		btnCad_Mot.setBounds(23, 354, 171, 62);
		frame.getContentPane().add(btnCad_Mot);
		
		JButton btnCon_Mot = new JButton("Consultar Motorista");
		btnCon_Mot.setEnabled(false);
		btnCon_Mot.setBounds(256, 354, 171, 62);
		frame.getContentPane().add(btnCon_Mot);
		
		JButton btnRota = new JButton("Rota");
		btnRota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCalculoDistancia rota = new FrmCalculoDistancia();
				rota.main(null);
			}
		});
		btnRota.setIcon(new ImageIcon(FrmMenu.class.getResource("/br/projeto/logistica/icon/1432949198_Compass.png")));
		btnRota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRota.setBounds(548, 78, 218, 101);
		frame.getContentPane().add(btnRota);
		
		JButton btnUsoCaminhao = new JButton("Movimenta\u00E7\u00E3o ");
		btnUsoCaminhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmUsoCaminho uso = new FrmUsoCaminho();
				uso.main(null);
			}
		});
		btnUsoCaminhao.setIcon(new ImageIcon(FrmMenu.class.getResource("/br/projeto/logistica/icon/1432771927_Truck.png")));
		btnUsoCaminhao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUsoCaminhao.setBounds(518, 262, 278, 124);
		frame.getContentPane().add(btnUsoCaminhao);
		frame.setBounds(100, 100, 868, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
