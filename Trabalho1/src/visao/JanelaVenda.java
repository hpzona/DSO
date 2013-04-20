package visao;

import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class JanelaVenda extends javax.swing.JDialog {

    private DefaultListModel lista;
    public JanelaVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProdutosAVenda = new javax.swing.JList();
        jButtonAdicionarAoCarrinho = new javax.swing.JButton();
        jButtonFinalizarCompra = new javax.swing.JButton();
        jButtonCancelarCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulo.setText("VENDA DE PRODUTOS:");
        jLabelTitulo.setToolTipText("");

        jScrollPane1.setViewportView(jListProdutosAVenda);

        jButtonAdicionarAoCarrinho.setText("Adicionar ao Carrinho");

        jButtonFinalizarCompra.setText("Finalizar Compra");

        jButtonCancelarCompra.setText("Cancelar Compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAdicionarAoCarrinho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFinalizarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarCompra))
                    .addComponent(jLabelTitulo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionarAoCarrinho)
                    .addComponent(jButtonFinalizarCompra)
                    .addComponent(jButtonCancelarCompra))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addBotaoAdicionarAoCarrinhoListener (ActionListener col) {
	        jButtonAdicionarAoCarrinho.addActionListener(col);
    }
    
    public void addBotaoCancelarCompraListener (ActionListener col) {
	        jButtonCancelarCompra.addActionListener(col);
    }
    
    public void addBotaoFinalizarCompraListener (ActionListener col) {
	        jButtonFinalizarCompra.addActionListener(col);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarAoCarrinho;
    private javax.swing.JButton jButtonCancelarCompra;
    private javax.swing.JButton jButtonFinalizarCompra;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList jListProdutosAVenda;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
