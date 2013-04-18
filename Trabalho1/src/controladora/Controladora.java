package controladora;

import modelo.Produto;
import modelo.Estoque;
import java.util.ArrayList;

import modelo.Modelo;
import visao.Visao;

public class Controladora {

	Modelo modelo;
        Visao visao;
	ArrayList<Produto> listaProdutos = new ArrayList<>();
	Produto produto;
	Estoque estoque;
	
	public Controladora(Visao visao, Modelo modelo) {

		this.modelo = modelo;
                this.visao = visao;
	}
	
	public void AbrirArquivo(String arquivo)
	{
		modelo.AbrirArquivo(arquivo);
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
		modelo.RegistrarEmArquivo(listaProdutos);
	}
	
	public void VenderProduto(Produto produto, int quantidade) {
		
		int quantidadeEmEstoque;
		
		quantidadeEmEstoque = estoque.VerificarQuantidadeEmEstoque(produto);
		quantidadeEmEstoque -= quantidade;
		estoque.AlterarQuantidadeEmEstoque(produto,quantidadeEmEstoque);
		
		// tem que atualizar array list ... listaProdutos.add(produto);
		
		modelo.RegistrarEmArquivo(listaProdutos);
		
	}
	
	public void AlterarQuantidadeEmEstoque(String descricao, int quantidade) {
		
		
	}
}
