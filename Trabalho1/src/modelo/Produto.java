package modelo;

public class Produto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int quantidade, valor;
	protected String descricao;
	
	public Produto(String descricao, int quantidade, int valor) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}