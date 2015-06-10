package br.projeto.logistica.model;

public class Produto {
	private int id;
	private String nome;
	private String fragil;
	private String descricao;
	private float peso;
	private String pesagem;
	private String uniMedida;
	private int quantidade;
	private Float comprimento;
	private Float largura;
	private Float altura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFragil() {
		return fragil;
	}
	public void setFragil(String fragil) {
		this.fragil = fragil;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getPesagem() {
		return pesagem;
	}
	public void setPesagem(String pesagem) {
		this.pesagem = pesagem;
	}
	public String getUniMedida() {
		return uniMedida;
	}
	public void setUniMedida(String uniMedida) {
		this.uniMedida = uniMedida;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Float getComprimento() {
		return comprimento;
	}
	public void setComprimento(Float comprimento) {
		this.comprimento = comprimento;
	}
	public Float getLargura() {
		return largura;
	}
	public void setLargura(Float largura) {
		this.largura = largura;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	
}
