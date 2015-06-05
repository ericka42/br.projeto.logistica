package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.ContatoMotorista;
import br.projeto.logistica.model.Motorista;
import br.projeto.logistica.persistence.ContatoMotoristaDAO;
import br.projeto.logistica.persistence.ContatoMotoristaDAOImpl;
import br.projeto.logistica.persistence.MotoristaDAO;
import br.projeto.logistica.persistence.MotoristaDAOImpl;

public class ContatoMotoristaController implements ActionListener{
	
	
	JTextField txtTipo,txtFone,txtOperadora,txtDescricao,txtIDMot;
	JLabel lblTipo,lblFone,lblOperadora,lblDescricao;
		
	
	
	
	
	
	public ContatoMotoristaController(JTextField txtTipo, JTextField txtFone,
			JTextField txtOperadora, JTextField txtDescricao,JTextField txtIDMot) {
		this.txtIDMot = txtIDMot;
		this.txtTipo = txtTipo;
		this.txtFone = txtFone;
		this.txtOperadora = txtOperadora;
		this.txtDescricao = txtDescricao;
   
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void salvarContatoMotorista(ContatoMotorista cm){
		MotoristaDAOImpl mdao = new MotoristaDAOImpl();
		
		cm.getId_mot();
		cm.setTipo(txtTipo.getText());
		cm.setTelefone(txtFone.getText());
		cm.setOperadora(txtOperadora.getText());
		cm.setDescricao(txtDescricao.getText());
		
		ContatoMotoristaDAO cDao=new ContatoMotoristaDAOImpl();
		try{
			cDao.cadastrarContatoMotorista(cm);
			JOptionPane.showMessageDialog(null,"Contato Cadastrado com Sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}
		
	}


