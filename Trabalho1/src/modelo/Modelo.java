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

    public int getQntProduto(String nome) {
        int qnt = -1;
        for (int i = 0; i < arrayListProdutos.size(); i++) {
            if (arrayListProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
                qnt = arrayListProdutos.get(i).getQuantidade();
            }
        }
        return qnt;
    }

    public void setQntProduto(String nome, int qnt) {
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

    public void venderProduto(Produto produto) {

        int quantidadeEmEstoque;

//		quantidadeEmEstoque = estoque.VerificarQuantidadeEmEstoque(produto);
//		quantidadeEmEstoque -= 1;
//		estoque.AlterarQuantidadeEmEstoque(produto,quantidadeEmEstoque);

        // tem que atualizar array list ... listaProdutos.add(produto);

//		this.registrarEmArquivo(listaProdutos);

    }

    public void alterarQuantidadeEmEstoque(String descricao, int quantidade) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return listaProdutos;
    }

    public void GravarArquivo() {
        RandomAccessFile raf = null;
        Long posicaoNovoProduto;

        try {
            raf = new RandomAccessFile(arquivo.getAbsolutePath(), "rw");
            posicaoNovoProduto = raf.length();
            raf.seek(posicaoNovoProduto);

            for (int i = 0; i < this.arrayListProdutos.size(); i++) {
                this.produto = this.arrayListProdutos.get(i);

                raf.writeUTF(this.produto.getNome());
                System.out.println(this.produto.getNome());
                raf.writeUTF(this.produto.getDescricao());
                raf.writeInt(this.produto.getQuantidade());
                raf.writeInt(this.produto.getValor());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
                    

                } catch (EOFException e) {
                    finalDeArquivo = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.arrayListProdutos;
    }
}
