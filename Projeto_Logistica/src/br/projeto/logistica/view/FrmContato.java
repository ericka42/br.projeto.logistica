package br.projeto.logistica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.projeto.logistica.controller.MotoristaController;
import br.projeto.logistica.model.Operadora;
import br.projeto.logistica.model.TipoFone;
import br.projeto.logistica.persistence.MotoristaDAO;
import br.projeto.logistica.persistence.MotoristaDAOImpl;

public class FrmContato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIDMot;
	private JTextField txtFone;
	private JTextField txtDescricao;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmContato frame = new FrmContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrmContato() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pContato = new JPanel();
		pContato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "CadastrarContato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pContato.setBounds(10, 11, 474, 140);
		contentPane.add(pContato);
		pContato.setLayout(null);
		
		JLabel lblIdMotorista = new JLabel("ID Motorista :");
		lblIdMotorista.setBounds(10, 21, 79, 14);
		pContato.add(lblIdMotorista);
		
		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(10, 46, 46, 14);
		pContato.add(lblTipo);
		
		JLabel lblFone = new JLabel("Fone :");
		lblFone.setBounds(145, 46, 46, 14);
		pContato.add(lblFone);
		
		JLabel lblOperadora = new JLabel("Operadora :");
		lblOperadora.setBounds(315, 46, 73, 14);
		pContato.add(lblOperadora);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o :");
		lblDescricao.setBounds(10, 71, 79, 14);
		pContato.add(lblDescricao);
		
		txtIDMot = new JTextField();
		txtIDMot.setEditable(false);
		txtIDMot.setBounds(80, 18, 46, 20);
		pContato.add(txtIDMot);
		txtIDMot.setColumns(10);
		
		MotoristaDAO mDao = new MotoristaDAOImpl();
		try {
			txtIDMot.setText(String.valueOf(mDao.buscarUltimo()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JComboBox<TipoFone> cbTipo = new JComboBox<TipoFone>(TipoFone.values());
		cbTipo.setBounds(44, 46, 82, 20);
		pContato.add(cbTipo);
		
		txtFone = new JTextField();
		txtFone.setBounds(186, 43, 119, 20);
		pContato.add(txtFone);
		txtFone.setColumns(10);
		
		JComboBox<Operadora> cbOperadora = new JComboBox<Operadora>(Operadora.values());
		cbOperadora.setBounds(388, 43, 76, 20);
		pContato.add(cbOperadora);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(75, 68, 315, 20);
		pContato.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/projeto/logistica/icon/img-disquete.png")));
		btnSalvar.setBounds(354, 156, 110, 51);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBounds(20, 156, 89, 51);
		btnVoltar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/projeto/logistica/icon/1433897020_undo.png")));
		btnVoltar.setBounds(20, 156, 121, 51);
		contentPane.add(btnVoltar);
		
		
	}
}
