package modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Modelo {

   Produto produto;
   ArrayList<Produto> arrayListProdutos = new ArrayList<>();
   ArrayList<Produto> arrayListCarrinho = new ArrayList<>();
   File arquivo;
   boolean existeArquivo;

   public Modelo() {
      this.existeArquivo = false;
   }

   public ArrayList<Produto> getLista() {
      return arrayListProdutos;
   }

   public int getQuantidadeProduto(String nome) {
      int qnt = -1;
      for (int i = 0; i < arrayListProdutos.size(); i++) {
         if (arrayListProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
            qnt = arrayListProdutos.get(i).getQuantidade();
         }
      }
      return qnt;
   }
   
   public void setQuantidadeProduto(String nome, int qnt) {
      for (int i = 0; i < arrayListProdutos.size(); i++) {
         if (arrayListProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
            arrayListProdutos.get(i).setQuantidade(qnt);

            break;
         }
      }
   }

   public Produto getProduto(String nome) {
      Produto produto = null;
      for (int i = 0; i < arrayListProdutos.size(); i++) {
         if (arrayListProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
            produto = arrayListProdutos.get(i);
            break;
         }
      }
      return produto;
   }

   public void adicionarProduto(String nome, String descricao, int quantidade, int valor) {
      produto = new Produto(nome, descricao, quantidade, valor);
      arrayListProdutos.add(produto);
   }

   public ArrayList<Produto> AbrirArquivo() throws IOException {
      ArrayList<Produto> listaProdutos = null;

      try {
         this.arquivo = new File("InfoTech.txt");

         if (!this.arquivo.exists()) {
            this.arquivo.createNewFile();
            this.existeArquivo = true;
         } else {
            listaProdutos = LerArquivo();
         }
      } catch (IOException io) {
         io.printStackTrace();
      }

      return listaProdutos;
   }

   public void AtualizarDadosEmArquivo() throws IOException {
      ApagarArquivo();
      AbrirArquivo();
      GravarArquivo();
   }

   private void ApagarArquivo() {
      arquivo.delete();
      this.existeArquivo = false;
   }

   private void CriarArquivo() throws IOException {
      ArrayList<Produto> listaProdutos = null;

      try {
         this.arquivo = new File("InfoTech.txt");
         this.arquivo.createNewFile();
         this.existeArquivo = true;
         listaProdutos = LerArquivo();
      } catch (IOException io) {
         io.printStackTrace();
      }
   }

   private void GravarArquivo() {
      RandomAccessFile raf = null;
      Long posicaoNovoProduto;

      try {
         raf = new RandomAccessFile(arquivo.getAbsolutePath(), "rw");
         raf.seek(0);

         for (int i = 0; i < this.arrayListProdutos.size(); i++) {
            this.produto = this.arrayListProdutos.get(i);
            raf.writeUTF(this.produto.getNome());
            raf.writeUTF(this.produto.getDescricao());
            raf.writeInt(this.produto.getQuantidade());
            raf.writeInt(this.produto.getPreco());
         }
      } catch (IOException io) {
         io.printStackTrace();
      } finally {
         if (raf != null) {
            try {
               raf.close();
            } catch (IOException io) {
               io.printStackTrace();
            }
         }
      }
   }

   private ArrayList<Produto> LerArquivo() {
      produto = null;
      RandomAccessFile raf = null;
      boolean finalDeArquivo = false;
      this.arrayListProdutos = null;

      String nomeDoProduto;
      String descricaoDoProduto;
      int quantidade;
      int valor;

      try {
         raf = new RandomAccessFile(arquivo.getAbsolutePath(), "r");
         this.arrayListProdutos = new ArrayList<Produto>();

         while (!finalDeArquivo) {
            try {
               nomeDoProduto = raf.readUTF();
               descricaoDoProduto = raf.readUTF();
               quantidade = raf.readInt();
               valor = raf.readInt();
               this.produto = new Produto(nomeDoProduto, descricaoDoProduto, quantidade, valor);
               this.arrayListProdutos.add(this.produto);
            } catch (EOFException eof) {
               finalDeArquivo = true;
            } catch (IOException io) {
               io.printStackTrace();
            }
         }

      } catch (FileNotFoundException fnf) {
         fnf.printStackTrace();
      } finally {
         if (raf != null) {
            try {
               raf.close();
            } catch (IOException io) {
               io.printStackTrace();
            }
         }
      }
      return this.arrayListProdutos;
   }
}
