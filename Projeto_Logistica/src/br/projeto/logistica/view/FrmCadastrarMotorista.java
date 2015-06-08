package br.projeto.logistica.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.UIManager;

import br.projeto.logistica.controller.ContatoMotoristaController;
import br.projeto.logistica.controller.MotoristaController;
import br.projeto.logistica.model.ContatoMotorista;
import br.projeto.logistica.persistence.MotoristaDAOImpl;

public class FrmCadastrarMotorista extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCnh;
	private JTextField txtCategoria;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastrarMotorista frame = new FrmCadastrarMotorista();
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
	public FrmCadastrarMotorista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro Motorista", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pDados = new JPanel();
		pDados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pDados.setBounds(10, 11, 711, 100);
		contentPane.add(pDados);
		pDados.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 32, 64, 14);
		pDados.add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf : ");
		lblCpf.setBounds(10, 60, 64, 14);
		pDados.add(lblCpf);
		
		JLabel lblCnh = new JLabel("Cnh :");
		lblCnh.setBounds(252, 57, 46, 14);
		pDados.add(lblCnh);
		
		JLabel lblCategoria = new JLabel("Categoria :");
		lblCategoria.setBounds(504, 57, 98, 14);
		pDados.add(lblCategoria);
		
		txtNome = new JTextField();
		txtNome.setBounds(53, 29, 472, 20);
		pDados.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(53, 57, 86, 20);
		pDados.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtCnh = new JTextField();
		txtCnh.setBounds(287, 57, 120, 20);
		pDados.add(txtCnh);
		txtCnh.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(579, 57, 34, 20);
		pDados.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JPanel pEndereco = new JPanel();
		pEndereco.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Endereço", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pEndereco.setBounds(10, 122, 711, 131);
		contentPane.add(pEndereco);
		pEndereco.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Logradouro :");
		lblLogradouro.setBounds(10, 26, 80, 14);
		pEndereco.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("N\u00BA :");
		lblNumero.setBounds(453, 26, 68, 14);
		pEndereco.add(lblNumero);
		
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(10, 51, 46, 14);
		pEndereco.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade :");
		lblCidade.setBounds(304, 51, 46, 14);
		pEndereco.add(lblCidade);
		
		JLabel lblCep = new JLabel("Cep :");
		lblCep.setBounds(10, 79, 46, 14);
		pEndereco.add(lblCep);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(94, 23, 335, 20);
		pEndereco.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(493, 23, 57, 20);
		pEndereco.add(txtNumero);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(66, 48, 219, 20);
		pEndereco.add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(360, 51, 219, 20);
		pEndereco.add(txtCidade);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(53, 76, 80, 20);
		pEndereco.add(txtCep);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(24, 376, 105, 47);
		contentPane.add(btnCancelar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovo.setBounds(442, 376, 105, 47);
		contentPane.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(589, 376, 105, 47);
		contentPane.add(btnSalvar);
		
		MotoristaController mc = new MotoristaController (txtNome,  txtCpf, txtCnh, txtCategoria ,txtLogradouro,txtNumero,txtBairro, txtCidade, txtCep);
		
		btnSalvar.addActionListener(mc);
		
		JPanel pContato= new JPanel();
		pContato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pContato.setBounds(10, 259, 711, 82);
		contentPane.add(pContato);
		pContato.setLayout(null);
		
		JButton btnCadastrarContato = new JButton("CadastrarContato");
		btnCadastrarContato.addActionListener(new ActionListener() {
			FrmContato telacontato= new  FrmContato();
			MotoristaDAOImpl busca = new MotoristaDAOImpl();
			public void actionPerformed(ActionEvent arg0) {
				int result = 0;
				try {
					
					System.out.println("ultimo achado"+busca.buscarUltimo(result));
				} catch (SQLException e) {
					System.out.println("ERRO!, dado não encontrado");
					e.printStackTrace();
				}
				telacontato.setVisible(true);
				
			}
		});
		btnCadastrarContato.setBounds(10, 21, 145, 50);
		pContato.add(btnCadastrarContato);
		
		
		
	
		
		
	}
}
