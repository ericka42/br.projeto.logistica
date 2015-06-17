package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.ContatoMotorista;
import br.projeto.logistica.persistence.ContatoMotoristaDAO;
import br.projeto.logistica.persistence.ContatoMotoristaDAOImpl;

public class ContatoMotoristaController implements ActionListener{
	
	
	JTextField txtFone,txtDescricao,txtIDMot;
	@SuppressWarnings("rawtypes")
	JComboBox cbTipoFone, cbOperadora;	
	
	@SuppressWarnings("rawtypes")
	/*
	 * Construtor
	 */
	public ContatoMotoristaController( JTextField txtFone,JTextField txtDescricao,
		JTextField txtIDMot,JComboBox cbTipoFone,JComboBox cbOperadora) {
		
		this.txtIDMot = txtIDMot;
		this.cbTipoFone = cbTipoFone;
		this.txtFone = txtFone;
		this.cbOperadora = cbOperadora;
		this.txtDescricao = txtDescricao;
   
	}

	
	
	

	@Override
	/*
	 * Metodo que dá a ação aos botões(non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd =e.getActionCommand();
		ContatoMotorista cm = new ContatoMotorista();
		if("salvar".equals(cmd)){
			salvarContatoMotorista(cm);	
		} else if("CadastrarContato".equals(cmd)){

			salvarContatoMotorista(cm);
			System.out.println("salvou antes de adicionar");
		}
		
		
	}
	/*
	 * Metodo que salva o contado do motorista
	 * @param objeto ContatoMotorista
	 */
	public void salvarContatoMotorista(ContatoMotorista cm){
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


