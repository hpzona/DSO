package controladora;

import modelo.Produto;
import modelo.Estoque;
import java.util.ArrayList;

import modelo.Modelo;
import visao.Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.JanelaCadastro;
import visao.JanelaConfirmarVenda;
import visao.JanelaEstoque;
import visao.JanelaVenda;


public class Controladora {

	private Modelo modelo;
        private Visao visao;
        
        private JanelaCadastro janelaCadastro;
        private JanelaConfirmarVenda janelaConfirmarVenda;
        private JanelaEstoque janelaEstoque;
        private JanelaVenda janelaVenda;
                          
	ArrayList<Produto> listaProdutos = new ArrayList<>();
	private Produto produto;
	private Estoque estoque;
        
        
	public Controladora(Visao visao, Modelo modelo) {

		this.modelo = modelo;
                this.visao = visao;
               
                this.visao.addBotaoExibirJanelaCadastroListener(new BotaoExibirJanelaCadastroListener());
                this.visao.addBotaoExibirJanelaEstoqueListener(new BotaoExibirJanelaEstoqueListener());
                this.visao.addBotaoExibirJanelaVendaListener(new BotaoExibirJanelaVendaListener());
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

        // ---------------------------------------------------------------------
        // ------------------------Listeners dos botões-------------------------
        // ---------------------------------------------------------------------

        //-------------------------------Cadastro-------------------------------
        //----------------------------------------------------------------------
        class BotaoExibirJanelaCadastroListener implements ActionListener{
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaCadastro janelaCadastro = new JanelaCadastro(visao, true);
                    janelaCadastro.setVisible(true);
                    janelaCadastro.addBotaoCadastrarListener(new BotaoCadastrarListener());
                }
       
        }
        
        class BotaoCadastrarListener implements ActionListener {
             @Override
             public void actionPerformed(ActionEvent e) {
            }
        }
        
        class BotaoCancelarCadastroListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }
        
        
        //-------------------------------Estoque--------------------------------
        //----------------------------------------------------------------------
        class BotaoExibirJanelaEstoqueListener implements ActionListener{
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaEstoque janelaEstoque = new JanelaEstoque(visao, true);
                    janelaEstoque.setVisible(true);
                    janelaEstoque.addBotaoFinalizarControleEstoqueListener(new BotaoFinalizarControleEstoqueListener());
                }
	}
        
        class BotaoFinalizarControleEstoqueListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }
              
        //--------------------------------Venda---------------------------------
        //----------------------------------------------------------------------
        class BotaoExibirJanelaVendaListener implements ActionListener{
            @Override
                public void actionPerformed(ActionEvent e) {
                    JanelaVenda janelaVenda = new JanelaVenda(visao, true);
                    janelaVenda.setVisible(true);
                    janelaVenda.addBotaoAdicionarAoCarrinhoListener(new BotaoAdicionarAoCarrinhoListener());
                    janelaVenda.addBotaoCancelarCompraListener(new BotaoCancelarCompraListener());
                    janelaVenda.addBotaoFinalizarCompraListener(new BotaoFinalizarCompraListener());
                }
	}
        
        class BotaoAdicionarAoCarrinhoListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }
        
        class BotaoCancelarCompraListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }
        
        class BotaoFinalizarCompraListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }
         
        //-----------------------Janela Confimar Venda--------------------------
        class BotaoCancelarVendaListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaConfirmarVenda janelaConfirmarVenda = new JanelaConfirmarVenda(visao, true);
                janelaConfirmarVenda.setVisible(true);
                janelaConfirmarVenda.addBotaoCancelarVendaListener(new BotaoCancelarVendaListener());
                janelaConfirmarVenda.addBotaoConcluirVendaListener(new BotaoConcluirVendaListener());
                janelaConfirmarVenda.addBotaoRemoverDaListaDeVendasListener(new BotaoRemoverDaListaDeVendasListener());
             }
        }
        
        class BotaoConcluirVendaListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }

        class BotaoRemoverDaListaDeVendasListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        }
        
}
