package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		frame = new JFrame("Titulo da Aplicação");
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 506, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mnCadastro.add(mntmEmpresa);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mnCadastro.add(mntmProduto);
		
		JMenuItem mntmCaminho = new JMenuItem("Caminh\u00E3o");
		mntmCaminho.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				FrmCadastrarCaminhao frm = new FrmCadastrarCaminhao();
				frm.main(null);
			}
		});
		mnCadastro.add(mntmCaminho);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmEmpresa_1 = new JMenuItem("Empresa");
		mnConsulta.add(mntmEmpresa_1);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnConsulta.add(mntmProdutos);
		
		JMenuItem mntmCaminho_1 = new JMenuItem("Caminh\u00E3o");
		mntmCaminho_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				FrmConsultarCaminhao frm = new FrmConsultarCaminhao();
				frm.main(null);
			}
		});
		mnConsulta.add(mntmCaminho_1);
		
		JMenu mnRota = new JMenu("Rota");
		menuBar.add(mnRota);
		
		JMenuItem mntmCriarRota = new JMenuItem("Criar Rota");
		mnRota.add(mntmCriarRota);
		
		JMenuItem mntmConsultarRota = new JMenuItem("Consultar Rota");
		mnRota.add(mntmConsultarRota);
	}
}
