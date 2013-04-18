package controladora;

import modelo.Produto;
import modelo.Estoque;
import java.util.ArrayList;

import modelo.ServicosPersistencia;

public class ServicosLogica {

	ServicosPersistencia persistencia;
	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	Produto produto;
	Estoque estoque;
	
	public ServicosLogica(ServicosPersistencia persistencia) {

		this.persistencia = persistencia;
	}
	
	public void AbrirArquivo(String arquivo)
	{
		persistencia.AbrirArquivo(arquivo);
	}
	
	public void AdicionarProduto(String descricao, int quantidade, int valor) {
		
		int quantidadeEmEstoque;
		
		// se o produto não existir adiciona-lo... {  
			produto = new Produto(descricao, quantidade, valor);
			estoque.AlterarQuantidadeEmEstoque(produto,quantidade);
		// }
		// else {
			quantidadeEmEstoque = estoque.VerificarQuantidadeEmEstoque(produto);
			quantidadeEmEstoque += quantidade;
			estoque.AlterarQuantidadeEmEstoque(produto,quantidadeEmEstoque);
		// }
		
		listaProdutos.add(produto);
		persistencia.RegistrarEmArquivo(listaProdutos);
	}
	
	public void VenderProduto(Produto produto, int quantidade) {
		
		int quantidadeEmEstoque;
		
		quantidadeEmEstoque = estoque.VerificarQuantidadeEmEstoque(produto);
		quantidadeEmEstoque -= quantidade;
		estoque.AlterarQuantidadeEmEstoque(produto,quantidadeEmEstoque);
		
		// tem que atualizar array list ... listaProdutos.add(produto);
		
		persistencia.RegistrarEmArquivo(listaProdutos);
		
	}
	
	public void AlterarQuantidadeEmEstoque(String descricao, int quantidade) {
		
		
	}
}
