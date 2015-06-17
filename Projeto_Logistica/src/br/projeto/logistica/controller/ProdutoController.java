package br.projeto.logistica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ConstructorProperties;
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
	private JTextField txtID;
	private JTextField txtProduto;
	private JCheckBox cbxFragil;
	private JComboBox<UnidadeMedida> cbMedida;
	private JComboBox<Peso> cbPeso;
	
	/*
	 * Construtor 
	 * @param txtNome refere-se ao JTextField nome , txtDescricao refere-se ao JTextField descrição , 
	 * @param txtQuantidade refere-se ao JTextField quantidade , txtPeso refere-se ao JTextField Peso ,
	 * @param txtComprimento refere-se ao JTextField comprimento , txtLargura refere-se ao JTextField largura,
	 * @param txtAltura refere-se ao JTextField Altura, cbxFragil  refere-se ao JCheckBox Fragil, cbMedida refere-se ao JComboBox Medida,
	 * @param cbPeso refere-se ao JComboBox Peso.
	 */
	
	public ProdutoController(JTextField txtNome, JTextField txtDescricao, JTextField txtQuantidade, JTextField txtPeso, JTextField txtComprimento, 
			JTextField txtLargura, JTextField txtAltura, JTextField txtID, JTextField txtProduto, JCheckBox cbxFragil, JComboBox<UnidadeMedida> cbMedida, JComboBox<Peso> cbPeso) {
		
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
		this.txtID = txtID;
		this.txtProduto = txtProduto;
	}
	/*
	 * Metodo que dá a ação aos botões(non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
	
	/*
	 * Metodo que salva o produto
	 * @param Objeto produto
	 */
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
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/*
	 * Metodo que limpa os campos
	 */
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
	
	/*
	 * Metodo que consulta os produtos
	 */
	public void consultaProduto(){
		ProdutoDAO pDao = new ProdutoDAOImpl();
		Produto p = null;
		try {
			p = pDao.consultaProduto(txtID.getText());
			txtProduto.setText(p.getNome());
			txtDescricao.setText(p.getDescricao());
			txtQuantidade.setText(String.valueOf(p.getQuantidade()));
			if(p.getFragil() == "s"){
				cbxFragil.isSelected();
			}
			txtPeso.setText(String.valueOf(p.getPeso()));
			if(p.getPesagem() == "KG"){
				cbPeso.getSelectedItem().toString();
			} else {
				cbPeso.getSelectedItem().toString();
			}
			if(p.getUniMedida() == "mm"){
				cbMedida.getSelectedItem().toString();
			}else{
				cbMedida.getSelectedItem().toString();
			}
			txtComprimento.setText(String.valueOf(p.getComprimento()));
			txtLargura.setText(String.valueOf(p.getLargura()));
			txtAltura.setText(String.valueOf(p.getAltura()));
		} catch (SQLException e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
//					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void alterarProduto(Produto p) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	/*
	 * Metodo que exclui o produto
	 */
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


