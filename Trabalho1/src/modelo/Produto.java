package modelo;

public class Produto implements java.io.Serializable {

   private static final long serialVersionUID = 1L;
   protected int quantidade, valor;
   protected String descricao, nome;

   public Produto(String nome, String descricao, int quantidade, int valor) {
      this.nome = nome;
      this.descricao = descricao;
      this.quantidade = quantidade;
      this.valor = valor;
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

   public int getValor() {
      return this.valor;
   }

   public void setValor(int valor) {
      this.valor = valor;
   }
}
