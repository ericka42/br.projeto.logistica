package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import br.projeto.logistica.model.ContatoMotorista;


public class ComboMotorista implements ActionListener{

	
	private JTextField txtTipo;
	private JComboBox<ContatoMotorista>cbTipo;
	private JButton btnVoltar;
	
	
	
	public ComboMotorista(JTextField txtTipo, JComboBox<ContatoMotorista> cbTipo) {
		this.txtTipo = txtTipo;
		this.cbTipo = cbTipo;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(cbTipo.getItemCount()>0){
			if(!btnVoltar.isSelected()){
				ContatoMotorista cm = new ContatoMotorista();
				cm= (ContatoMotorista)cbTipo.getSelectedItem();
				txtTipo.setText(String.valueOf(cm.getTipo()));
				
			}
		}
		
	}
	

}
