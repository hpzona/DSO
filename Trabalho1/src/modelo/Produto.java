package modelo;

public class Produto implements java.io.Serializable {

   private static final long serialVersionUID = 1L;
   protected int quantidade, preco;
   protected String descricao, nome;

   public Produto(String nome, String descricao, int quantidade, int preco) {
      this.nome = nome;
      this.descricao = descricao;
      this.quantidade = quantidade;
      this.preco = preco;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getDescricao() {
      return this.descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public int getQuantidade() {
      return this.quantidade;
   }

   public void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
   }

   public int getPreco() {
      return this.preco;
   }

   public void setPreco(int preco) {
      this.preco = preco;
   }
}
