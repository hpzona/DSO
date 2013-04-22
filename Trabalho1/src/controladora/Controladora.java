package controladora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.Produto;
import java.util.ArrayList;
import modelo.Modelo;
import visao.JanelaEstoque;
import visao.JanelaCadastro;
import visao.JanelaVenda;
import modelo.ListaProduto;
import visao.JanelaPrincipal;

public class Controladora {

   Modelo modelo;
   JanelaPrincipal visao;
   JanelaVenda janelaVenda;
   JanelaEstoque janelaEstoque;
   JanelaCadastro janelaCadastro;
   ListaProduto listaProdutos;
   ArrayList<Produto> arrayListProdutos, carrinho;

   public Controladora(JanelaPrincipal visao, Modelo modelo) throws IOException {

      this.modelo = modelo;
      this.visao = visao;
      this.arrayListProdutos = modelo.AbrirArquivo();
      this.carrinho = new ArrayList();
      this.listaProdutos = new ListaProduto();
      if (arrayListProdutos != null) {
         this.listaProdutos = new ListaProduto(arrayListProdutos);
         if (arrayListProdutos.isEmpty()) {
            visao.AlertaLojaSemProdutos();
         }
      } else {
         visao.AlertaLojaSemProdutos();
      }
      visao.addAbrirJanelaCadastroButtonListener(new AbrirJanelaCadastroButtonListener());
      visao.addAbrirJanelaEstoqueButtonListener(new AbrirJanelaEstoqueButtonListener());
      visao.addAbrirJanelaVendaButtonListener(new AbrirJanelaVendaButtonListener());
      visao.addSairMenuItem(new SairMenuItemListener());
   }
//////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe Visao

   private class AbrirJanelaEstoqueButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         if (arrayListProdutos == null || arrayListProdutos.isEmpty()) {
            visao.AlertaLojaSemProdutos();
         } else {
            janelaEstoque = new JanelaEstoque(visao, true, listaProdutos.getLista());
            janelaEstoque.addFecharJanelaEstoqueButtonListener(new FecharJanelaEstoqueButtonListener());
            janelaEstoque.addVerificarEstoqueButtonListener(new VerificarEstoqueButtonListener());
            janelaEstoque.addModificarEstoqueButtonListener(new ModificarEstoqueButtonListener());
            janelaEstoque.SetarFocoNoItem(0);
            janelaEstoque.setVisible(true);
         }
      }
   }

   private class AbrirJanelaCadastroButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         janelaCadastro = new JanelaCadastro(visao, true);
         janelaCadastro.addCadastrarProdutoButtonListener(new CadastrarProdutoButtonListener());
         janelaCadastro.addFecharJanelaCadastroButtonListener(new FecharJanelaCadastroButtonListener());
         janelaCadastro.setVisible(true);
      }
   }

   private class AbrirJanelaVendaButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         if (arrayListProdutos == null || arrayListProdutos.isEmpty()) {
            visao.AlertaLojaSemProdutos();
         } else {
            janelaVenda = new JanelaVenda(visao, true, listaProdutos.getLista());
            janelaVenda.addTerminarVendaButtonListener(new TerminarVendaButtonListener());
            janelaVenda.addConfirmarVendaButtonListener(new ConfirmarVendaButtonListener());
            janelaVenda.setarFocoNoItem(0);
            janelaVenda.setVisible(true);
         }
      }
   }

   private class SairMenuItemListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         visao.dispose();
         System.exit(0);
      }
   }

   //////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe JanelaCadastro
   private class CadastrarProdutoButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {

         boolean ok = true;

         try {
            if (janelaCadastro.getTextNome().isEmpty() || listaProdutos.possuiProduto(janelaCadastro.getTextNome())) {
               throw new IllegalArgumentException();
            }

         } catch (IllegalArgumentException iae) {
            janelaCadastro.NomeDoProdutoEmBranco();
            ok = false;
         }

         try {
            if (janelaCadastro.getTextQuantidade().isEmpty()) {
               throw new IllegalArgumentException();
            } else {
               Integer.parseInt(janelaCadastro.getTextQuantidade());
            }
         } catch (NumberFormatException nfe) {
            janelaCadastro.QuantidadeValorInvalido();
         } catch (IllegalArgumentException iae) {
            janelaCadastro.QuantidadeProdutoEmBranco();
            ok = false;
         }

         try {
            if (janelaCadastro.getTextPreco().isEmpty()) {
               throw new IllegalArgumentException();
            } else {
               Integer.parseInt(janelaCadastro.getTextPreco());
            }
         } catch (NumberFormatException nfe) {
            janelaCadastro.PreçoValorInvalido();
         } catch (IllegalArgumentException iae) {
            janelaCadastro.PreçoProdutoEmBranco();
            ok = false;
         }

         if (ok) {
            modelo.adicionarProduto(janelaCadastro.getTextNome(), janelaCadastro.getTextDescricao(), Integer.parseInt(janelaCadastro.getTextQuantidade()), Integer.parseInt(janelaCadastro.getTextPreco()));
            arrayListProdutos = modelo.getLista();
            janelaCadastro.showCadastroEfetuado();
            listaProdutos.addNomeDoProdutoNaListaModel(janelaCadastro.getTextNome());
            try {
               modelo.AtualizarDadosEmArquivo();
               janelaCadastro.dispose();
            } catch (IOException io) {
               io.printStackTrace();
            }
         }
      }
   }

   private class FecharJanelaCadastroButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         janelaCadastro.dispose();

      }
   }

   //////////////////////////// Aqui encontram-se todas as InnerClass com os ActionListener da classe JanelaEstoque
   private class FecharJanelaEstoqueButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         janelaEstoque.dispose();

      }
   }

   private class VerificarEstoqueButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         int index = janelaEstoque.getItemSelecionado();
         int qntAtual = modelo.getQuantidadeProduto(listaProdutos.getNome(index));
         janelaEstoque.setQuantidadeAtualEstoque(qntAtual);
      }
   }

   private class ModificarEstoqueButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {

         boolean ok = true;

         int index = janelaEstoque.getItemSelecionado();
         String nome = listaProdutos.getNome(index);

         try {
            if (janelaEstoque.getTextQuantidadeNovaEstoque().isEmpty()) {
               throw new IllegalArgumentException();
            } else {
               Integer.parseInt(janelaEstoque.getTextQuantidadeNovaEstoque());
            }
         } catch (NumberFormatException nfe) {
            janelaEstoque.NovaQuantidadeValorInvalido();
            nfe.getMessage();
         } catch (IllegalArgumentException iae) {
            janelaEstoque.NovaQuantidadeProdutoEmBranco();
            ok = false;
         }

         if (ok) {
            int qntNova = janelaEstoque.getQuantidadeNovaEstoque();
            modelo.setQuantidadeProduto(nome, qntNova);
            if (qntNova <= 0){
                listaProdutos.removerItem(arrayListProdutos, index);
            }
            try {
               modelo.AtualizarDadosEmArquivo();
            } catch (IOException io) {
               io.printStackTrace();
            }
         }
      }
   }

//////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe JanelaVenda
   private class ConfirmarVendaButtonListener implements ActionListener {
   
      @Override
      public void actionPerformed(ActionEvent e) {
         int tamanho;
         Produto produto;
         int index = janelaVenda.getItemSelecionado();
         if (index >= 0) {
            produto = arrayListProdutos.get(index);
            carrinho.add(produto);
            listaProdutos.removerItem(arrayListProdutos, index);
            if (index == 0) {
               tamanho = listaProdutos.getTamanho();
               janelaVenda.setarFocoNoItem(--tamanho);
            } else {
               janelaVenda.setarFocoNoItem(--index);
            }
            try {
               modelo.AtualizarDadosEmArquivo();
            } catch (IOException io) {
               io.printStackTrace();
            }
         } else {
            janelaVenda.alertaLojaSemProdutos();
         }

      }
   }

   private class TerminarVendaButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         janelaVenda.showVenda(carrinho);
         carrinho.clear();
         janelaVenda.dispose();
      }
   }
}