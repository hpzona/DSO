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
import visao.Visao;

public class Controladora {

    Modelo modelo;
    Visao visao;
    JanelaVenda janelaVenda;
    JanelaEstoque janelaEstoque;
    JanelaCadastro janelaCadastro;
    ListaProduto listaProdutos, listaCarrinho;
    ArrayList<Produto> arrayListProdutos;

    public Controladora(Visao visao, Modelo modelo) throws IOException {

        this.modelo = modelo;
        this.visao = visao;
        this.arrayListProdutos = modelo.AbrirArquivo();
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
                janelaVenda.addFecharJanelaVendaButtonListener(new FecharJanelaVendaButtonListener());
                janelaVenda.addConfirmarVendaButtonListener(new ConfirmarVendaButtonListener());
                janelaVenda.SetarFocoNoItem(0);
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

    //////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe JanelaRegistro
    private class CadastrarProdutoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            boolean ok = true;
            
            try {
                if (janelaCadastro.getTextNome().isEmpty())
                   throw new IllegalArgumentException();

            } catch (IllegalArgumentException ex)   {   
                janelaCadastro.NomeDoProdutoEmBranco();
                ok = false;
            }
 
            try {
                if (janelaCadastro.getTextQuantidade().isEmpty())
                    throw new IllegalArgumentException();
                else
                    Integer.parseInt(janelaCadastro.getTextQuantidade());
            } catch (NumberFormatException ex) {
                janelaCadastro.QuantidadeValorInvalido();
            } catch (IllegalArgumentException ex) {
                janelaCadastro.QuantidadeProdutoEmBranco();
                ok = false;
            }
            
            try {
               if (janelaCadastro.getTextPreco().isEmpty())
                    throw new IllegalArgumentException();
               else
                   Integer.parseInt(janelaCadastro.getTextPreco());
            }
            catch (NumberFormatException ex) {
                janelaCadastro.PreçoValorInvalido();
            } catch (IllegalArgumentException ex) {
                janelaCadastro.PreçoProdutoEmBranco();
                ok = false;
            }
            
            if (ok) {
                modelo.adicionarProduto(janelaCadastro.getTextNome(), janelaCadastro.getTextDescricao(), Integer.parseInt(janelaCadastro.getTextQuantidade()), Integer.parseInt(janelaCadastro.getTextPreco()));
                arrayListProdutos = modelo.getLista();
                janelaCadastro.showCadastroEfetuado();
                listaProdutos.addLista(janelaCadastro.getTextNome());
                // AtualizarListaProduto
                try {
                    modelo.AtualizarDadosEmArquivo();
                    janelaCadastro.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
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
            int qntAtual = modelo.getQntProduto(listaProdutos.getNome(index));
            janelaEstoque.setQuantidadeAtualEstoque(qntAtual);
        }
    }

    private class ModificarEstoqueButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = janelaEstoque.getItemSelecionado();
            String nome = listaProdutos.getNome(index);
            int qntNova = janelaEstoque.getQuantidadeNovaEstoque();
            modelo.setQntProduto(nome, qntNova);
            try {
                modelo.AtualizarDadosEmArquivo();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

//////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe JanelaVenda
    private class ConfirmarVendaButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int tamanho;
            int index = janelaVenda.getItemSelecionado();
            if (index >= 0) {
                listaProdutos.removerItem(arrayListProdutos, index);
                if (index ==0) {
                    tamanho = listaProdutos.getTamanho();
                    janelaVenda.SetarFocoNoItem(--tamanho);
                }
                else
                    janelaVenda.SetarFocoNoItem(--index);
                try {
                    modelo.AtualizarDadosEmArquivo();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else
                janelaVenda.AlertaLojaSemProdutos();
                
        }
    }

   private class FecharJanelaVendaButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaVenda.dispose();
        }
    }
}