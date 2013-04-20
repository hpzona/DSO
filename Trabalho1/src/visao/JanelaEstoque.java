package visao;

import java.awt.event.ActionListener;

public class JanelaEstoque extends javax.swing.JDialog {
    public JanelaEstoque(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListEstoque = new javax.swing.JList();
        jTextQuantidadeAtual = new javax.swing.JTextField();
        jTextNovaQuantidade = new javax.swing.JTextField();
        jLabelNovaQuantidade = new javax.swing.JLabel();
        jLabelQuantidadeAtual = new javax.swing.JLabel();
        jButtonFinalizarControleEstoque = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulo.setText("CONTROLE DE ESTOQUE:");
        jLabelTitulo.setToolTipText("");

        jScrollPane2.setViewportView(jListEstoque);

        jTextQuantidadeAtual.setEditable(false);
        jTextQuantidadeAtual.setAutoscrolls(false);

        jTextNovaQuantidade.setToolTipText("");

        jLabelNovaQuantidade.setText("Nova Quantidade");

        jLabelQuantidadeAtual.setText("Quantidade Atual");

        jButtonFinalizarControleEstoque.setText("Finalizar Controle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQuantidadeAtual)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(jLabelNovaQuantidade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextNovaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jLabelTitulo)
                            .addGap(335, 335, 335)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonFinalizarControleEstoque)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelQuantidadeAtual)
                    .addComponent(jTextQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNovaQuantidade)
                    .addComponent(jTextNovaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFinalizarControleEstoque))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addBotaoFinalizarControleEstoqueListener (ActionListener col) {
	        jButtonFinalizarControleEstoque.addActionListener(col);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFinalizarControleEstoque;
    private javax.swing.JLabel jLabelNovaQuantidade;
    private javax.swing.JLabel jLabelQuantidadeAtual;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList jListEstoque;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextNovaQuantidade;
    private javax.swing.JTextField jTextQuantidadeAtual;
    // End of variables declaration//GEN-END:variables
}
