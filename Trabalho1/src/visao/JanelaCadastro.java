package visao;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class JanelaCadastro extends javax.swing.JDialog {

   public JanelaCadastro(java.awt.Frame parent, boolean modal) {
      super(parent, modal);
      initComponents();
      setLocationRelativeTo(null);
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jLabelQuantidade = new javax.swing.JLabel();
        jButtonCadastrarProduto = new javax.swing.JButton();
        jButtonFecharJanelaCadasrto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(880, 330));

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextAreaDescricao.setRows(5);
        jTextAreaDescricao.setToolTipText("Insira uma descrição para o produto");
        jTextAreaDescricao.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabelDescricao.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelDescricao.setText("Descrição");

        jLabelNome.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelNome.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextFieldNome.setToolTipText("Insira o nome do produto aqui");
        jTextFieldNome.setName(""); // NOI18N
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulo.setText("CADASTRAR PRODUTO:");
        jLabelTitulo.setToolTipText("");

        jTextFieldQuantidade.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextFieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldQuantidade.setToolTipText("Insira a quantidade do produto aqui");
        jTextFieldQuantidade.setName(""); // NOI18N
        jTextFieldQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeActionPerformed(evt);
            }
        });

        jTextFieldPreco.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextFieldPreco.setToolTipText("Insira o valor do produto aqui");
        jTextFieldPreco.setName(""); // NOI18N
        jTextFieldPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecoActionPerformed(evt);
            }
        });

        jLabelPreco.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPreco.setText("Preço (R$)");

        jLabelQuantidade.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelQuantidade.setText("Quantidade");

        jButtonCadastrarProduto.setText("Cadastrar");
        jButtonCadastrarProduto.setPreferredSize(new java.awt.Dimension(95, 23));

        jButtonFecharJanelaCadasrto.setText("Fechar");
        jButtonFecharJanelaCadasrto.setPreferredSize(new java.awt.Dimension(95, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jTextFieldQuantidade)))
                            .addComponent(jTextFieldNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFecharJanelaCadasrto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(291, 291, 291)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFecharJanelaCadasrto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeActionPerformed
    }//GEN-LAST:event_jTextFieldQuantidadeActionPerformed

    private void jTextFieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoActionPerformed
    }//GEN-LAST:event_jTextFieldPrecoActionPerformed

   public void addCadastrarProdutoButtonListener(ActionListener lis) {
      jButtonCadastrarProduto.addActionListener(lis);
   }

   public void addFecharJanelaCadastroButtonListener(ActionListener lis) {
      jButtonFecharJanelaCadasrto.addActionListener(lis);
   }

   public String getTextNome() {
      return jTextFieldNome.getText();
   }

   public String getTextDescricao() {
      return jTextAreaDescricao.getText();
   }

   public String getTextQuantidade() {
      return jTextFieldQuantidade.getText();
   }

   public String getTextPreco() {
      return jTextFieldPreco.getText();
   }

   public void showCadastroEfetuado() {
      JOptionPane.showMessageDialog(null, "Nome: " + this.getTextNome() + "\nDescrição: " + this.getTextDescricao() + "\nQuantidade: " + this.getTextQuantidade() + "\nValor: R$" + this.getTextPreco(), "PRODUTO CADASTRADO", WIDTH);
   }

   public void QuantidadeValorInvalido() {
      JOptionPane.showMessageDialog(null, "O campo Quantidade só aceita números", "VALOR INVÁLIDO", WIDTH);
   }

   public void PreçoValorInvalido() {
      JOptionPane.showMessageDialog(null, "O campo Preço só aceita números", "VALOR INVÁLIDO", WIDTH);
   }

   public void NomeDoProdutoEmBranco() {
      JOptionPane.showMessageDialog(null, "O campo Nome está vázio ou já existe produto com esse nome, tente novamente", "NOME INVÁLIDO", WIDTH);
   }

   public void QuantidadeProdutoEmBranco() {
      JOptionPane.showMessageDialog(null, "O campo Quantidade é Obrigatório", "CAMPO OBRIGATÓRIO", WIDTH);
   }

   public void PreçoProdutoEmBranco() {
      JOptionPane.showMessageDialog(null, "O campo Preço é Obrigatório", "CAMPO OBRIGATÓRIO", WIDTH);
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarProduto;
    private javax.swing.JButton jButtonFecharJanelaCadasrto;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
