package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.projeto.logistica.model.Peso;
import br.projeto.logistica.model.Produto;
import br.projeto.logistica.model.UnidadeMedida;
import br.projeto.logistica.persistence.ProdutoDAO;
import br.projeto.logistica.persistence.ProdutoDAOImpl;

public class ProdutoController implements ActionListener{

	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtPeso;
	private JTextField txtComprimento;
	private JTextField txtLargura;
	private JTextField txtAltura;
	private JCheckBox cbxFragil;
	private JComboBox<UnidadeMedida> cbMedida;
	private JComboBox<Peso> cbPeso;
	
	public ProdutoController(JTextField txtNome, JTextField txtDescricao, JTextField txtQuantidade, JTextField txtPeso, JTextField txtComprimento, 
			JTextField txtLargura, JTextField txtAltura, JCheckBox cbxFragil, JComboBox<UnidadeMedida> cbMedida, JComboBox<Peso> cbPeso) {
		
		this.txtNome = txtNome;
		this.txtDescricao = txtDescricao;
		this.txtQuantidade = txtQuantidade;
		this.txtPeso = txtPeso;
		this.txtComprimento = txtComprimento;
		this.txtLargura = txtLargura;
		this.txtAltura = txtAltura;
		this.cbxFragil = cbxFragil;
		this.cbMedida = cbMedida;
		this.cbPeso = cbPeso;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Produto p = new Produto();
		if ("  Salvar".equals(cmd)) {
			if (!"".equals(txtNome.getText())
					&& !"".equals(txtDescricao.getText())
					&& !"".equals(txtQuantidade.getText())
					&& !"".equals(txtPeso.getText())
					&& !"".equals(txtComprimento.getText())
					&& !"".equals(txtLargura.getText())
					&& !"".equals(txtAltura.getText())){
					salvarProduto(p);
			}else {
				JOptionPane.showMessageDialog(null,
						"Preencha os campos corretamente!", "Alerta!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if ("  Novo".equals(cmd)) {
			limpaCampo();
		} else if ("".equals(cmd)) {
			consultaProduto();
		} else if ("  Editar".equals(cmd)) {
			alterarProduto(p);
		} else if ("  Nova Consulta".equals(cmd)) {
			limpaCampo();
		} else if ("  Excluir".equals(cmd)) {
			excluiProduto();
		}
	}
	
	public void salvarProduto(Produto p){
		p.setNome(txtNome.getText());
		if(cbxFragil.isSelected()){
			p.setFragil("s");
		}else{
			p.setFragil("n");
		}
		p.setDescricao(txtDescricao.getText());
		p.setPeso(Float.parseFloat(txtPeso.getText()));
		if(cbPeso.getSelectedItem() != null){
			System.out.println(cbPeso.getSelectedItem().toString());
			p.setPesagem(cbPeso.getSelectedItem().toString());
		}
		p.setComprimento(Float.parseFloat(txtComprimento.getText()));
		p.setAltura(Float.parseFloat(txtAltura.getText()));
		p.setLargura(Float.parseFloat(txtLargura.getText()));
		if(cbMedida.getSelectedItem() != null){
			System.out.println(cbMedida.getSelectedItem().toString());
			p.setUniMedida(cbMedida.getSelectedItem().toString());
		}
		p.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
		ProdutoDAO pDao = new ProdutoDAOImpl();
		try {
			pDao.cadastrarProduto(p);
			JOptionPane.showMessageDialog(null,
					"Produto Cadastrado com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
//					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void limpaCampo() {
		txtNome.setText("");
		txtDescricao.setText("");
		txtPeso.setText("");
		txtComprimento.setText("");
		txtLargura.setText("");
		txtAltura.setText("");
		cbxFragil.setSelected(false);
		txtQuantidade.setText("");
	}
	
	public void consultaProduto(){
//		ProdutoDAO pDao = new ProdutoDAOImpl();
//		Produto p = null;
//		try {
//			p = pDao.consultaProduto(txtNome.getText());
//			txtNome.setEditable(false);
//			txtID.setText(Integer.toString(p.getId()));
//			txtDescricao.setText(p.getDescricao());
//			txtPeso.setText(Float.toString(p.getPeso()));
//			txtComprimento.setText(p.getComprimento());
//			txtLargura.setText(p.getLargura());
//			txtAltura.setText(p.getAltura());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void alterarProduto(Produto p) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	private void excluiProduto() {
		ProdutoDAO pDao = new ProdutoDAOImpl();
		boolean po;
		try {
			po = pDao.excluirProduto(txtNome.getText());
			JOptionPane.showMessageDialog(null,
					"Produto Excluído com Sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
		
}


