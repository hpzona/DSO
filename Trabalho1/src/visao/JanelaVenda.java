package visao;

import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaVenda extends javax.swing.JDialog {

   private DefaultListModel lista;

   public JanelaVenda(java.awt.Frame parent, boolean modal, DefaultListModel lista) {
      super(parent, modal);
      initComponents();
      jList1.setModel(lista);
      setLocationRelativeTo(null);
   }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButtonVenderProduto = new javax.swing.JButton();
        jButtonFecharJanelaVenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(880, 330));

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulo.setText("VENDA DE PRODUTOS:");
        jLabelTitulo.setToolTipText("");

        jScrollPane1.setViewportView(jList1);

        jButtonVenderProduto.setText("Vender");

        jButtonFecharJanelaVenda.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVenderProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFecharJanelaVenda))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTitulo)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVenderProduto)
                    .addComponent(jButtonFecharJanelaVenda))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public void addFecharJanelaVendaButtonListener(ActionListener lis) {
      jButtonFecharJanelaVenda.addActionListener(lis);
   }

   public void addConfirmarVendaButtonListener(ActionListener lis) {
      jButtonVenderProduto.addActionListener(lis);
   }

   public int getItemSelecionado() {
      return jList1.getSelectedIndex();
   }

   public void SetarFocoNoItem(int index) {
      jList1.setSelectedIndex(index);
   }

   public void AlertaLojaSemProdutos() {
      JOptionPane.showMessageDialog(null, "A loja não possui nenhum produto cadastrado", "Sem produtos", WIDTH);
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFecharJanelaVenda;
    private javax.swing.JButton jButtonVenderProduto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
