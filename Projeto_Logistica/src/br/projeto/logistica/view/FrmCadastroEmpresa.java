package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FrmCadastroEmpresa {
	
	
	private JFrame frame; 
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtInsc;
	private JTextField txtCnpj;
	private JTextField txtRamo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtComplemento;

	
	public FrmCadastroEmpresa() {
		frame =new JFrame("Cadastrar Empresa");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 719, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 683, 93);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 30, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCnpj = new JLabel("Cnpj :");
		lblCnpj.setBounds(437, 30, 46, 14);
		panel.add(lblCnpj);
		
		JLabel lblInscrioEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual : ");
		lblInscrioEstadual.setBounds(10, 55, 118, 14);
		panel.add(lblInscrioEstadual);
		
		JLabel lblRamo = new JLabel("Ramo : ");
		lblRamo.setBounds(312, 55, 46, 14);
		panel.add(lblRamo);
		
		txtNome = new JTextField();
		txtNome.setBounds(47, 27, 369, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtInsc = new JTextField();
		txtInsc.setBounds(119, 52, 153, 20);
		panel.add(txtInsc);
		txtInsc.setColumns(10);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(475, 27, 153, 20);
		panel.add(txtCnpj);
		
		txtRamo = new JTextField();
		txtRamo.setBounds(351, 52, 277, 20);
		panel.add(txtRamo);
		txtRamo.setColumns(10);
		
		JPanel pEndereco = new JPanel();
		pEndereco.setBackground(new Color(255, 255, 153));
		pEndereco.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Endereço", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pEndereco.setBounds(10, 115, 683, 116);
		contentPane.add(pEndereco);
		pEndereco.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Logradouro :");
		lblLogradouro.setBounds(10, 26, 80, 14);
		pEndereco.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("N\u00BA :");
		lblNumero.setBounds(453, 26, 68, 14);
		pEndereco.add(lblNumero);
		
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(371, 54, 46, 14);
		pEndereco.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade :");
		lblCidade.setBounds(10, 88, 46, 14);
		pEndereco.add(lblCidade);
		
		JLabel lblCep = new JLabel("Cep :");
		lblCep.setBounds(307, 85, 67, 14);
		pEndereco.add(lblCep);
		
		textField = new JTextField();
		textField.setBounds(94, 23, 335, 20);
		textField.setColumns(10);
		pEndereco.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(493, 23, 57, 20);
		textField_1.setColumns(10);
		pEndereco.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(427, 51, 219, 20);
		textField_2.setColumns(10);
		pEndereco.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 82, 219, 20);
		textField_3.setColumns(10);
		pEndereco.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(350, 82, 86, 20);
		textField_4.setColumns(10);
		pEndereco.add(textField_4);
		
		JLabel lblComplemento = new JLabel("Complemento :");
		lblComplemento.setBounds(10, 54, 86, 14);
		pEndereco.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(94, 51, 250, 20);
		pEndereco.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JPanel pContato = new JPanel();
		pContato.setBackground(new Color(255, 255, 153));
		pContato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pContato.setBounds(10, 242, 683, 93);
		contentPane.add(pContato);
		pContato.setLayout(null);
		
		JButton btnContato = new JButton("Cadastrar Contato");
		btnContato.setBounds(10, 23, 158, 59);
		pContato.add(btnContato);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(10, 359, 89, 48);
		contentPane.add(btnCancelar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(442, 359, 89, 48);
		contentPane.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(583, 359, 89, 48);
		contentPane.add(btnSalvar);
		frame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new FrmCadastroEmpresa();
	}
}
