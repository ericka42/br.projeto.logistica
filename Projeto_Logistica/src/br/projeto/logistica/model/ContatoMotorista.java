package br.projeto.logistica.model;

public class ContatoMotorista {
	private int id_mot;
	private int id_contato;
	private String tipo;
	private String telefone;
	private String descricao;
	private String Operadora;
	
	


	public int getId_mot() {
		return id_mot;
	}


	public void setId_mot(int id_mot) {
		this.id_mot = id_mot;
	}


	public int getId_contato() {
		return id_contato;
	}


	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getOperadora() {
		return Operadora;
	}


	public void setOperadora(String operadora) {
		Operadora = operadora;
	}
	
	
	
	
	
	
	
	
	

}
