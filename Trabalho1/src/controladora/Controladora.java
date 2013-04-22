package controladora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import modelo.Produto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import modelo.Modelo;
import visao.JanelaConfirmarCompra;
import visao.JanelaEstoque;
import visao.JanelaRegistro;
import visao.JanelaVenda;
import modelo.ListaProduto;
import visao.Visao;

public class Controladora {

	Modelo modelo;
        Visao visao;
        JanelaVenda janelaVenda;
        JanelaEstoque janelaEstoque;
        JanelaRegistro janelaRegistro;
        JanelaConfirmarCompra janelaConfirmarCompra;
        ListaProduto listaProdutos, listaCarrinho; 
        
	public Controladora(Visao visao, Modelo modelo) throws IOException {

		this.modelo = modelo;
                this.visao = visao;
                ArrayList<Produto> arrayListProdutos = null;
                
                
                //this.listaCarrinho = new ListaProduto();
                //this.listaProdutos = new ListaProduto(modelo);
                arrayListProdutos = modelo.AbrirArquivo();
                this.listaProdutos = new ListaProduto(arrayListProdutos);
                visao.addEstoqueButtonListener(new EstoqueButtonListener());
                visao.addVendaButtonListener(new VendaButtonListener());
                visao.addRegistroButtonListener(new RegistroButtonListener());
                visao.addSairMenuItem(new SairMenuItemListener());
	}
//////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe Visao
        
    private class EstoqueButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
              janelaEstoque = new JanelaEstoque(visao, true, listaProdutos.getLista());
              janelaEstoque.addFinControleButtonListener(new FinControleButtonListener());
              janelaEstoque.addVerificarButtonListener(new VerificarButtonListener());
              janelaEstoque.addModificarButtonListener(new ModificarButtonListener());
              janelaEstoque.setVisible(true);
        }
    }
    
    private class RegistroButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
              janelaRegistro = new JanelaRegistro(visao, true);
              janelaRegistro.addRegistrarButtonListener(new RegistrarButtonListener());
              janelaRegistro.addCancelarRegistroButtonListener(new CancelarRegistroButtonListener());
              janelaRegistro.setVisible(true);            
        }
    }
    private class VendaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
              janelaVenda = new JanelaVenda(visao, true, listaProdutos.getLista());
              janelaVenda.addCarrinhoButtonListener(new CarrinhoButtonListener());
              janelaVenda.addFinalizarButtonListener(new FinalizarButtonListener());
              janelaVenda.addCancelarButtonListener(new CancelarButtonListener());
              janelaVenda.setVisible(true);
              
        }
    }
           
    private class SairMenuItemListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
              modelo.GravarArquivo();
              visao.dispose();
              System.exit(0);
        }
    }
 
    //////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe JanelaRegistro
               
    private class RegistrarButtonListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
           modelo.adicionarProduto(janelaRegistro.getTextNome(), janelaRegistro.getTextDescricao(), Integer.parseInt(janelaRegistro.getTextQnt()), Integer.parseInt(janelaRegistro.getTextValor()));
           janelaRegistro.showRegistro();
           listaProdutos.addLista(janelaRegistro.getTextNome());
           janelaRegistro.dispose();
       }
    }
     
    private class CancelarRegistroButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            janelaRegistro.dispose();
                         
        }
    }
    
    //////////////////////////// Aqui encontram-se todas as InnerClass com os ActionListener da classe JanelaEstoque
    private class FinControleButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            janelaEstoque.dispose();
                         
        }
    }
    
    private class VerificarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = janelaEstoque.getItemSelecionado();
            int qntAtual = modelo.getQntProduto(listaProdutos.getNome(index));
            janelaEstoque.setQntAtual(qntAtual);
        }
    }
    
    private class ModificarButtonListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
           int index = janelaEstoque.getItemSelecionado();
           String nome = listaProdutos.getNome(index);
           int qntNova = janelaEstoque.getQntNova();
           modelo.setQntProduto(nome, qntNova);
        }
    }
    
//////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe JanelaVenda
    private class CarrinhoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = janelaVenda.getItemSelecionado();
            String nome = listaProdutos.getNome(index);
            modelo.addCarrinho(nome);
        }
    }
    
   private class FinalizarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
              ArrayList<Produto> car = modelo.getCarrinho();
              for (int i = 0; i < car.size(); i++){
                  listaCarrinho.addLista(car.get(i).getNome());
              }
              janelaConfirmarCompra = new JanelaConfirmarCompra(new Visao(), true, listaCarrinho.getLista());
              janelaConfirmarCompra.addConcluirComprarButtonListener(new ConcluirCompraButtonListener());
              janelaConfirmarCompra.addCancelarCompraButtonListener(new CancelarCompraButtonListener());
              janelaConfirmarCompra.addRemoverButtonListener(new RemoverButtonListener());
              janelaConfirmarCompra.setVisible(true);
        }
    }
           
    private class CancelarButtonListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
              modelo.limparCarrinho();
              listaCarrinho.clear();
              janelaVenda.dispose();
        }
    }


//////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe JanelaConfirmarCompra
    
    private class RemoverButtonListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
           listaCarrinho.removerItem(janelaConfirmarCompra.getIndex());
       }
    }
    
    private class ConcluirCompraButtonListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
           modelo.concluirCompra();     
           janelaConfirmarCompra.showConcluir();
           janelaConfirmarCompra.dispose();
           modelo.limparCarrinho();
           listaCarrinho.clear();
       }
    }
    
    private class CancelarCompraButtonListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
           modelo.limparCarrinho();
           janelaConfirmarCompra.dispose();
       }
    }
}