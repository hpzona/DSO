package controladora;

import modelo.Produto;
import modelo.Estoque;
import java.util.ArrayList;

import modelo.Modelo;
import visao.JanelaCadastro;
import visao.JanelaConfirmarCompra;
import visao.JanelaVenda;
import visao.JanelaEstoque;
import visao.Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controladora {

	private Modelo modelo;
        private Visao visao;
	ArrayList<Produto> listaProdutos = new ArrayList<>();
	private Produto produto;
	private Estoque estoque;
	
	public Controladora(Visao visao, Modelo modelo) {

		this.modelo = modelo;
                this.visao = visao;
                
                this.visao.addCadastrarListener(new CadastrarListener());
                this.visao.addControlarEstoqueListener(new ControlarEstoqueListener());
                this.visao.addVenderListener(new VenderListener());
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
	
        class CadastrarListener implements ActionListener{
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaCadastro cad = new JanelaCadastro(visao, true);
                        cad.setVisible(true);
                }
	}
        
        class ControlarEstoqueListener implements ActionListener{
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaEstoque est = new JanelaEstoque(visao, true);
                        est.setVisible(true);
                }
	}
        
        class VenderListener implements ActionListener{
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaVenda ven = new JanelaVenda(visao, true);
                        ven.setVisible(true);
                }
	}
}
