/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaEstoque extends javax.swing.JDialog{ 

    public JanelaEstoque(java.awt.Frame parent, boolean modal, DefaultListModel lista) {
        super(parent, modal);
        initComponents();
        jListProdutosEmEstoque.setModel(lista);
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListProdutosEmEstoque = new javax.swing.JList();
        jLabelNovaQuantidade = new javax.swing.JLabel();
        jLabelQuantidadeAtual = new javax.swing.JLabel();
        jButtonFecharJanelaEstoque = new javax.swing.JButton();
        jTextFieldQuantidadeAtual = new javax.swing.JTextField();
        jTextFieldNovaQuantidade = new javax.swing.JTextField();
        jButtonVerificarEstoque = new javax.swing.JButton();
        jButtonModificarEstoque = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(880, 330));

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulo.setText("CONTROLE DE ESTOQUE:");
        jLabelTitulo.setToolTipText("");

        jListProdutosEmEstoque.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jListProdutosEmEstoque);

        jLabelNovaQuantidade.setText("Nova Quantidade");

        jLabelQuantidadeAtual.setText("Quantidade Atual");

        jButtonFecharJanelaEstoque.setText("Fechar");

        jTextFieldQuantidadeAtual.setEditable(false);
        jTextFieldQuantidadeAtual.setAutoscrolls(false);

        jTextFieldNovaQuantidade.setToolTipText("");

        jButtonVerificarEstoque.setText("Verificar");

        jButtonModificarEstoque.setText("Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFecharJanelaEstoque)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelQuantidadeAtual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNovaQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNovaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonVerificarEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModificarEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelQuantidadeAtual))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVerificarEstoque)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNovaQuantidade)
                            .addComponent(jTextFieldNovaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificarEstoque))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jButtonFecharJanelaEstoque)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
   public void addFecharJanelaEstoqueButtonListener(ActionListener lis){
        jButtonFecharJanelaEstoque.addActionListener(lis);
   }
    
   public void addVerificarEstoqueButtonListener(ActionListener lis){
        jButtonVerificarEstoque.addActionListener(lis);
   }
   
   public void addModificarEstoqueButtonListener(ActionListener lis){
        jButtonModificarEstoque.addActionListener(lis);
   }
   
   public void setQuantidadeAtualEstoque(int qnt){
       jTextFieldQuantidadeAtual.setText("" + qnt);
   }
   
   public int getQuantidadeNovaEstoque(){
       return Integer.parseInt(jTextFieldNovaQuantidade.getText());
   }
   
   public String getTextQuantidadeNovaEstoque() {
       return jTextFieldNovaQuantidade.getText();
   }
     
   public int getItemSelecionado(){
       return jListProdutosEmEstoque.getSelectedIndex();
   }
   
   public void SetarFocoNoItem(int index) {
        jListProdutosEmEstoque.setSelectedIndex(index);
   }
   
   public void NovaQuantidadeProdutoEmBranco() {
        JOptionPane.showMessageDialog(null, "O campo Nova Quantidade é Obrigatório", "CAMPO OBRIGATÓRIO", WIDTH);
   }
   
   public void NovaQuantidadeValorInvalido() {
        JOptionPane.showMessageDialog(null, "O campo Nova Quantidade só aceita números", "VALOR INVÁLIDO", WIDTH);
   }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFecharJanelaEstoque;
    private javax.swing.JButton jButtonModificarEstoque;
    private javax.swing.JButton jButtonVerificarEstoque;
    private javax.swing.JLabel jLabelNovaQuantidade;
    private javax.swing.JLabel jLabelQuantidadeAtual;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList jListProdutosEmEstoque;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldNovaQuantidade;
    private javax.swing.JTextField jTextFieldQuantidadeAtual;
    // End of variables declaration//GEN-END:variables
    private DefaultListModel listModel;
}
