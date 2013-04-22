package controladora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.Produto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Modelo;
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
        visao.addEstoqueButtonListener(new EstoqueButtonListener());
        visao.addVendaButtonListener(new VendaButtonListener());
        visao.addRegistroButtonListener(new RegistroButtonListener());
        visao.addSairMenuItem(new SairMenuItemListener());
    }
//////////////////////////// Aqui encontra-se todas as InnerClass com os ActionListener da classe Visao

    private class EstoqueButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (arrayListProdutos == null || arrayListProdutos.isEmpty()) {
                visao.AlertaLojaSemProdutos();
            } else {
                janelaEstoque = new JanelaEstoque(visao, true, listaProdutos.getLista());
                janelaEstoque.addFinControleButtonListener(new FinControleButtonListener());
                janelaEstoque.addVerificarButtonListener(new VerificarButtonListener());
                janelaEstoque.addModificarButtonListener(new ModificarButtonListener());
                janelaEstoque.SetarFocoNoItem(0);
                janelaEstoque.setVisible(true);
            }
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
    private class RegistrarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            boolean ok = true;
            
            /*try {
                if (janelaRegistro.getTextNome().isEmpty())
                   throw new IllegalArgumentException();

            } catch (IllegalArgumentException ex)   {   
                janelaRegistro.NomeDoProdutoEmBranco();
                ok = false;
            }
 
            try {
                //Integer.parseInt(janelaRegistro.getTextQnt());
                if (janelaRegistro.getTextQnt().isEmpty())
                    throw new IllegalArgumentException();
            } catch (NumberFormatException ex) {
                janelaRegistro.QuantidadeValorInvalido();
            } catch (IllegalArgumentException ex) {
                janelaRegistro.QuantidadeProdutoEmBranco();
                ok = false;
            }
            
            try {
                //Integer.parseInt(janelaRegistro.getTextValor());
                if (janelaRegistro.getTextValor().isEmpty())
                    throw new IllegalArgumentException();
            }
            catch (NumberFormatException ex) {
                janelaRegistro.PreçoValorInvalido();
                ex.getMessage();
            } catch (IllegalArgumentException ex) {
                janelaRegistro.PreçoProdutoEmBranco();
                ok = false;
            }*/
            
            if (ok) {
                modelo.adicionarProduto(janelaRegistro.getTextNome(), janelaRegistro.getTextDescricao(), Integer.parseInt(janelaRegistro.getTextQnt()), Integer.parseInt(janelaRegistro.getTextValor()));
                arrayListProdutos = modelo.getLista();
                janelaRegistro.showRegistro();
                listaProdutos.addLista(janelaRegistro.getTextNome());
                // AtualizarListaProduto
                try {
                    modelo.AtualizarDadosEmArquivo();
                    janelaRegistro.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
             }
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