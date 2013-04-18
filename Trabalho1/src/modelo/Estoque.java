package modelo;

public class Estoque {

	public Estoque() {
		
	}
	
	public void AlterarQuantidadeEmEstoque(Produto produto, int quantidade) {
	
		produto.setQuantidade(quantidade);
	}
	
	public int VerificarQuantidadeEmEstoque(Produto produto) {
		
		return produto.getQuantidade();
	}
}
