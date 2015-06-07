package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
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
	
	
	JTextField txtFone,txtDescricao,txtIDMot;
	JLabel lblTipo,lblFone,lblOperadora,lblDescricao;
	JComboBox cbTipoFone, cbOperadora;	
	
	
	
	
	
	public ContatoMotoristaController( JTextField txtFone,JTextField txtDescricao,
		JTextField txtIDMot,JComboBox cbTipoFone,JComboBox cbOperadora) {
		
		this.txtIDMot = txtIDMot;
		this.cbTipoFone = cbTipoFone;
		this.txtFone = txtFone;
		this.cbOperadora = cbOperadora;
		this.txtDescricao = txtDescricao;
   
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void salvarContatoMotorista(ContatoMotorista cm){
		MotoristaDAOImpl mdao = new MotoristaDAOImpl();
		
		cm.setId_mot(txtIDMot.getHeight());
		cm.setTipo(cbTipoFone.getSelectedItem().toString());
		cm.setTelefone(txtFone.getText());
		cm.setOperadora(cbOperadora.getSelectedItem().toString());
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


